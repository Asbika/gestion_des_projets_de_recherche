package metier;

public class Demande {
	
	private String nomCourt;
	private String nomLong;
	private String descreption;
	private String theme;
	private String type;
	private String visibilite;	  // true: Visibilite publique 	 false: Visibilité privé
	private boolean estAccepte=false;
	
	
	public Demande( String nomCourt, String nomLong, String descreption, String theme, String type,
			String visibilite) {
		
		this.nomCourt = nomCourt;
		this.setNomLong(nomLong);
		this.descreption = descreption;
		this.theme = theme;
		this.type = type;
		this.visibilite = visibilite;
		
		
	}



	public String getNomCourt() {
		return nomCourt;
	}


	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
	}


	public String getDescreption() {
		return descreption;
	}


	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}


	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getVisibilite() {
		return visibilite;
	}


	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}
	
	public boolean getEstAccepte() {
		return estAccepte;
	}


	public void setEstAccepte(boolean estAccepte) {
		this.estAccepte = estAccepte;
	}

	public String getNomLong() {
		return nomLong;
	}



	public void setNomLong(String nomLong) {
		this.nomLong = nomLong;
	}

	@Override
	public String toString() {
		return " NomCourt=" + nomCourt + ", NomLong=" + nomLong + ", Descreption="
				+ descreption + ", Theme=" + theme + ", Type=" + type + ", Visibilite=" + visibilite + "]";
	}

}
