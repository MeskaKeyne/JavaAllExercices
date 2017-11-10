package be.steformations.pc.javaweb.calcul.controleur;

import be.steformations.pc.javaweb.calcul.modele.Calcul;
import be.steformations.pc.javaweb.calcul.modele.GestionnaireCalcul;

public class Controleur extends javax.servlet.http.HttpServlet {

	private GestionnaireCalcul gestionnaire;
	
	// appelée 1 seule fois, juste après l'instanciation de la classe par le serveur
	public void init(javax.servlet.ServletConfig config) 
		throws javax.servlet.ServletException{
		System.out.println("Controleur.init()");
		
		super.init(config);
		int niveau = Integer.parseInt( config.getInitParameter("niveau") );
		this.gestionnaire = new GestionnaireCalcul(niveau);
	}

	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req, 
			javax.servlet.http.HttpServletResponse resp) 
					throws javax.servlet.ServletException, java.io.IOException {
		/* faire travailler le modèle */
		Calcul c = this.gestionnaire.genererCalcul();
		System.out.println("Controleur.doGet() => " + c);
		
		/* insérer le Calcul dans le contexte */
		req.setAttribute("nouveauCalcul", c); // dans l'objet request pour le jsp
		req.getSession().setAttribute("sessionCalcul", c); // en session pour l'utiliser plus tard dans le doPost
				
		/* invoquer une page JSP */
		req.getRequestDispatcher("/nouveau.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req, 
			javax.servlet.http.HttpServletResponse resp) 
					throws javax.servlet.ServletException, java.io.IOException {
		System.out.println("Controleur.doPost()");
		
		/* analyse et validation de la requete */
		String parametre = req.getParameter("proposition"); // nom de l'input dans le form
		int proposition = -1;
		try {
			proposition = Integer.parseInt(parametre);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Calcul c = (Calcul) req.getSession().getAttribute("sessionCalcul");
		
		@SuppressWarnings("unchecked")
		java.util.List<Calcul> anciens 
			= (java.util.List<Calcul>) req.getSession().getAttribute("anciensCalculs"); 
		if (anciens == null) {
			anciens = new java.util.ArrayList<Calcul>();
			req.getSession().setAttribute("anciensCalculs", anciens);
		}
		anciens.add(c);
		
		if (c != null) {
			/* faire travailler le modèle */
			this.gestionnaire.verifierSolution(c, proposition);
			/* insérer le Calcul dans le contexte */
			req.setAttribute("nouveauCalcul", c); // dans l'objet request pour le jsp
			req.setAttribute("anciensCalculs", anciens);
			/* invoquer une page JSP */
			req.getRequestDispatcher("/resultat.jsp").forward(req, resp);
		} else {
			this.doGet(req, resp);
		}
		
	}
	
}
