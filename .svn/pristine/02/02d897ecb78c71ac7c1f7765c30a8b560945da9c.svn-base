package be.steformations.pc.javaweb.jsf.biblio.i18n;

@javax.faces.bean.ManagedBean
@javax.faces.bean.SessionScoped
public class LanguageChoice {

	private java.util.Map<String, java.util.Locale> supportedLocales;
	private java.util.Locale locale;
	
	public LanguageChoice() {
		super();
		this.locale = javax.faces.context.FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
		
		this.supportedLocales = new java.util.HashMap<String, java.util.Locale>();
		this.supportedLocales.put(this.locale.getLanguage(), this.locale);
		java.util.Iterator<java.util.Locale> iterator
			= javax.faces.context.FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
		while(iterator.hasNext()) {
			java.util.Locale l = iterator.next();
			this.supportedLocales.put(l.getLanguage(), l);
		}
		
		java.util.Locale preferenceBrowser
			= javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		if ( this.supportedLocales.containsKey(preferenceBrowser.getLanguage()) ) {
			this.locale = preferenceBrowser;
		} 
	}
	
	// getter
	// voir <f:view locale="#{languageChoice.locale}"> dans modele.xhtml
	public String getLocale() {
		return this.locale.getLanguage();
	}
	
	// getter
	// voir <f:selectItems value="#{languageChoice.availableLocales}"/> dans modele.xhtml
	public java.util.Set<String> getAvailableLocales() {
		return this.supportedLocales.keySet();
	}
	
	// setter lors de la soumission du formulaire de changement de langue
	// voir <h:selectOneRadio value="#{languageChoice.locale}" onchange="submit()"> dans modele.xhtml
	public void setLocale(String langage) {
		if ( this.supportedLocales.containsKey(langage) ) {
			this.locale = this.supportedLocales.get(langage);
		}
	}
}
