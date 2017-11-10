drop view if exists verbe_view;
create view verbe_view as ( 
	select v.id as id, v.infinitif as infinitif, 
		case when v.auxiliaire = 'A' then 0 else 1 end as auxiliaire,
		case when v.infinitif = m.infinitif 
		     then m.radical 
		     else substring(v.infinitif from 1 for char_length(v.infinitif) - (char_length(m.infinitif) - char_length(m.radical))) 
		     end as radical,
		case when v.infinitif = m.infinitif 
		     then m.participe 
		     else substring(v.infinitif from 1 for char_length(v.infinitif) - (char_length(m.infinitif) - char_length(m.radical))) || substring(m.participe from char_length(m.radical) + 1)
		     end as participe,
		case when v.infinitif = m.infinitif then null else (select id from verbes where infinitif = m.infinitif) end as modele,
		m.id as modeleId
	from verbes as v join modeles as m on v.modele = m.id
);

drop view if exists conjugaison_view;
create view conjugaison_view as (
	select  c.id as id,
		case when v.radical is null then c.terminaison else v.radical || c.terminaison end as valeur,
		c.fk_mode - 1 as mode,
		c.fk_temps - 1 as temps,
		c.personne - 1 as personne,
		v.id as verbe 
	from verbe_view as v join conjugaisons as c on v.modeleId = c.fk_modele
			     join modes as m on c.fk_mode = m.id 
			     join temps as t on c.fk_temps = t.id
);
