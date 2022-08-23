package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import metier.Projets;

public interface dao {

	public int rechercherUtilisateur(String User, String Pass);

	public boolean authentifier(String nom, String prenom, String email, String nomDUtilisateur, String motDePasse);

	public Vector<Projets> retournerProjet(int Id_Utilisateur);

	public void demender(int idUtilisateur, String nomCourt, String nomLong, String descreption, String theme,
			String type, String Licence,
			String visibilite, String TypeDemande);

	public boolean estExistProjet(String NomCourt);

	public boolean estExistUser(String NomDUtilisateur);

	public boolean estExistGroupe(int Id_Groupe);

	public void ajouterAdminAuGroupeProjet(int Id_Utilisateur, int idGroupe);

	public void accepterDemande(String NomCourt, String typDemande);

	public void refuserDemande(String NomCourt, String typDemande);

	public boolean estExisteDemande(String NomCourt, String typDemande);

	public void creeProjet(String nomCourt, String TypeDemande);

	public void ajouterAuAppartenir(int idUtilisateur, int idprojet);

	public void closeProjet(String nomCourt, String TypeDemande);

	public void ajouterMemberAuProjet(int idAdmin, int idUser, String nomcourt);

	public boolean verifierAdmin(int idAdmin, String nomCourt);

	public void modifierAjenda(String NomCourt, String text);

	public String retournerAjenda(String NomCourt);

	public String retournerAjenda(int Id_Utilisateur);

	public String retournerAjendaUtilisateur(int Id_Utilisateur);

	public int retournerIdUtilisateur(String nomUtilisateur);

	public void adminAjouteUnAutreAdmin(int idAdm, int idUtilisateur, String nomCourt);

	public void retirerMembreFromGroupeAndAppartenir(int idAdm, int idUtilisateur, String nomCourt);

	public ArrayList<Projets> retournerToutLesProjetsPublic();

	public String retournResponsabilite(int Id_Utilisateur);

	public ResultSet retournerListeDemandeSelonTypeDemande(String typeDemande);

	public void modifierListe(String NomCourt, String text);

	public List<String> retournerNomCourtProjet(int idUser);

	public String retournerListe(String NomCourt);

	public List<String> retournerNomProjetUserAdmin(int idUser);

	public List<Projets> retournerProjetParNomCourt(String nomCourt);

	public boolean estClos(String nomCourt);

	String retournResponsabilite(int id_Utilisateur, int id_Groupe);

	public Vector<Integer> retourneIdGroupe(String nomCourt);
	
	public int retournIdProjet(String nomCourt);
	

	void supprimerDeGroupe(String nomCourt);

	void supprimerdeAppartenir(String nomCourt);
}
