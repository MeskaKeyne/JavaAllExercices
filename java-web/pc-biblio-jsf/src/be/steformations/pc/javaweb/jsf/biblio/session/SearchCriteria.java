package be.steformations.pc.javaweb.jsf.biblio.session;

@javax.faces.bean.ManagedBean
@javax.faces.bean.SessionScoped
public class SearchCriteria {
	
	private int authorId;
	private int editorId;
	private String pattern;
	
	public SearchCriteria() {
		super();
	}
	
	public int getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public int getEditorId() {
		return editorId;
	}
	
	public void setEditorId(int editorId) {
		this.editorId = editorId;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}