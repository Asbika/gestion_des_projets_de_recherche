package metier;



public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String nomDUtilisateur;
	private String motDePasse;
	
	
	public Utilisateur(int id,String nom, String prenom, String email, String nomDUtilisateur, String motDePasse) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.nomDUtilisateur = nomDUtilisateur;
		this.motDePasse = motDePasse;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomDUtilisateur() {
		return nomDUtilisateur;
	}
	public void setNomDUtilisateur(String nomDUtilisateur) {
		this.nomDUtilisateur = nomDUtilisateur;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	@Override
	public String toString() {
		return "id "+id+"nom" + nom + ", prenom=" + prenom + ", email=" + email + ", nomDUtilisateur="
				+ nomDUtilisateur + ", motDePasse=" + motDePasse + "]";
	}
}
