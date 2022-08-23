package metier;

public class Projets {

	private int idProjet;
	private String nomCourt;
	private String nomLong;
	private String Theme;
	private String type;
	private String licence;
	private String Descreption;
	private String visibilite;
	private String Etat;

	public Projets() {

	}

	public Projets(int idProjet, String nomCourt, String nomLong, String theme, String type, String licence,
			String descreption, String etat) {

		this.idProjet = idProjet;
		this.nomCourt = nomCourt;
		this.nomLong = nomLong;
		this.Theme = theme;
		this.type = type;
		this.licence = licence;
		this.Descreption = descreption;
		this.Etat = etat;
	}

	
	
	public Projets(int idProjet, String nomCourt, String nomLong, String descreption, String theme, String type,
			String licence, String visibilite, String etat) {

		this.idProjet = idProjet;
		this.nomCourt = nomCourt;
		this.nomLong = nomLong;
		this.Theme = theme;
		this.type = type;
		this.licence = licence;
		this.Descreption = descreption;
		this.visibilite = visibilite;
		this.Etat = etat;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getNomCourt() {
		return nomCourt;
	}

	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}

	public String getNomLong() {
		return nomLong;
	}

	public void setNomLong(String nomLong) {
		this.nomLong = nomLong;
	}

	public String getTheme() {
		return Theme;
	}

	public void setTheme(String theme) {
		Theme = theme;
	}

	public String getDescreption() {
		return Descreption;
	}

	public void setDescreption(String descreption) {
		Descreption = descreption;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}

	@Override
	public String toString() {
		return "Projets [idProjet=" + idProjet + ", nomCourt=" + nomCourt + ", nomLong=" + nomLong + ", Theme=" + Theme
				+ ", type=" + type + ", licence=" + licence + ", Descreption=" + Descreption + ", visibilite="
				+ visibilite + ", Etat=" + Etat + "]";
	}
}
