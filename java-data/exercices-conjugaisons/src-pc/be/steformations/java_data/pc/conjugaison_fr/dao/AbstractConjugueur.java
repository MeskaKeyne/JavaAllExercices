package be.steformations.java_data.pc.conjugaison_fr.dao;

import be.steformations.java_data.conjugaison_fr.interfaces.Conjugueur;
import be.steformations.java_data.conjugaison_fr.interfaces.Mode;
import be.steformations.java_data.conjugaison_fr.interfaces.Temps;

public abstract class AbstractConjugueur implements Conjugueur{

	protected boolean isComposed(Mode mode, Temps temps) {
		if (    mode == Mode.INDICATIF    && temps == Temps.PASSE_COMPOSE
			 || mode == Mode.INDICATIF    && temps == Temps.PLUS_QUE_PARFAIT 
			 || mode == Mode.CONDITIONNEL && temps == Temps.PASSE 
			 || mode == Mode.SUBJONCTIF   && temps == Temps.PASSE 
			 || mode == Mode.SUBJONCTIF   && temps == Temps.PLUS_QUE_PARFAIT
			 || mode == Mode.IMPERATIF    && temps == Temps.PASSE ) {
			return true;
		}
		return false;
	}
	
	protected Temps getComposedTense(Mode mode, Temps temps) {
		Temps tense = null;
		switch (temps) {
		case PASSE_COMPOSE:
		case PASSE:
			tense = Temps.PRESENT; 
			break;
		case PLUS_QUE_PARFAIT:
			tense = Temps.IMPARFAIT;
			break;
		default:
			break;
		}
		return tense;
	}
}
