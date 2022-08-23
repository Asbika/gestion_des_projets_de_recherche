package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import metier.Projets;
import metier.Utilisateur;

public class daoImpl implements dao {
	Utilisateur utilisateur;

	// methode d'ajouter les membres au groupe-et membre

	@Override
	public int rechercherUtilisateur(String User, String Pass) {

		try {

			Connection con = singletonConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("SELECT *FROM utilisateurs WHERE NomDUtilisateur = ? AND  MotDePasse =? ");
			ps.setString(1, User);
			ps.setString(2, Pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				return rs.getInt(1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean authentifier(String nom, String prenom, String email, String nomDUtilisateur, String motDePasse) {
		Connection con = singletonConnection.getConnection();
		if (!estExistUser(nomDUtilisateur)) {
			try {

				PreparedStatement ps1 = con.prepareStatement(
						"INSERT INTO UTILISATEURS (NOM,PRENOM,EMAIL,NOMDUTILISATEUR,MOTDEPASSE) VALUES (?,?,?,?,?)");
				ps1.setString(1, nom);
				ps1.setString(2, prenom);
				ps1.setString(3, email);
				ps1.setString(4, nomDUtilisateur);
				ps1.setString(5, motDePasse);
				System.out.println("Mouad");
				ps1.executeUpdate();

				return true;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean estExistUser(String NomDUtilisateur) {

		Connection con = singletonConnection.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement("SELECT Nom FROM utilisateurs WHERE NomDUtilisateur = ?");
			ps.setString(1, NomDUtilisateur);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Vector<Projets> retournerProjet(int Id_Utilisateur) {
		Vector<Projets> listeProjets = new Vector<Projets>();
		Connection con = singletonConnection.getConnection();
		PreparedStatement ps2, ps3;

		try {
			ps2 = con.prepareStatement("SELECT * FROM appartenir WHERE Id_Utilisateur = ?");
			ps2.setInt(1, Id_Utilisateur);
			ResultSet rs1 = ps2.executeQuery();

			while (rs1.next()) {

				ps3 = con.prepareStatement("Select *FROM projets WHERE Id_Projet = ?");
				ps3.setInt(1, rs1.getInt(3));
				ResultSet rs2 = ps3.executeQuery();
				while (rs2.next()) {
					listeProjets.addElement(new Projets(rs2.getInt(1), rs2.getString(2), rs2.getString(3),
							rs2.getString(4), rs2.getString(5), rs2.getString(6), null, null));
					// System.out.println("Mouad");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeProjets;
	}

	@Override
	public void demender(int idUtilisateur, String nomCourt, String nomLong, String descreption, String theme,
			String type, String Licence,
			String visibilite, String TypeDemande) {

		Connection con = singletonConnection.getConnection();

		if (!estExisteDemande(nomCourt,TypeDemande)) {
			try {
				PreparedStatement ps1 = con.prepareStatement(
						"INSERT INTO demande (NomCourt,NomLong,Description,Theme,Type,Licence, Visibilite, TypeDemande,Id_Utilisateur) VALUES (?,?,?,?,?,?,?,?,?)");
				ps1.setString(1, nomCourt);
				ps1.setString(2, nomLong);
				ps1.setString(3, descreption);
				ps1.setString(4, theme);
				ps1.setString(5, type);
				ps1.setString(6, Licence);
				ps1.setString(7, visibilite);
				ps1.setString(8, TypeDemande);
				ps1.setInt(9, idUtilisateur);
				ps1.executeUpdate();

				// PreparedStatement ps2 = con.prepareStatement("UPDATE demande SET
				// Id_Utilisateur=? WHERE NomCourt = ?");
				// ps2.setInt(1,idUtilisateur );
				// ps2.setString(2, nomCourt);
				// ps2.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Le projet " + nomCourt + " est existe !");
		}

	}

	public boolean estExistProjet(String NomCourt) {
		Connection con = singletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT NomCourt FROM projets WHERE NomCourt=?");
			ps.setString(1, NomCourt);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("hi Mouad");
				return true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean estExistUser(int Id_Utilisateur) {
		Connection con = singletonConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("SELECT Nom FROM Utilisateurs WHERE Id_Utilisateur=?");
			ps.setInt(1, Id_Utilisateur);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean estExistGroupe(int Id_Groupe) {
		Connection con = singletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Nom FROM groupes WHERE Id_Groupe=?");
			ps.setInt(1, Id_Groupe);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void ajouterAdminAuGroupeProjet(int Id_Utilisateur, int idGroupe) {
		Connection con = singletonConnection.getConnection();
		int i = 0;

		if (estExistUser(Id_Utilisateur)) { //
			try {
				PreparedStatement ps2 = con.prepareStatement("SELECT Id_Utilisateur , Id_Groupe FROM integrer ");
				ResultSet rs1 = ps2.executeQuery();

				while (rs1.next()) {
					if (rs1.getInt(1) == Id_Utilisateur && rs1.getInt(2) == idGroupe) {
						i++;
					}
				}
				if (i == 0) {

					PreparedStatement ps1 = con.prepareStatement(
							"INSERT INTO integrer (Id_Utilisateur,Id_Groupe,Responsabilite) VALUES (?,?,?) ");
					ps1.setInt(1, Id_Utilisateur);
					ps1.setInt(2, idGroupe);
					ps1.setString(3, "admin");
					ps1.executeUpdate();

				} else {
					System.out.println("Desole! Se couple est deja existe ");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void accepterDemande(String NomCourt, String typDemande) {
		Connection con = singletonConnection.getConnection();

		if (estExisteDemande(NomCourt, typDemande)) {
			try {
				PreparedStatement ps = con.prepareStatement(
						"UPDATE DEMANDE SET estAccepte=? , traitement = ? WHERE NomCourt = ? AND typeDemande = ?");
				ps.setInt(1, 1);
				ps.setInt(2, 1);
				ps.setString(3, NomCourt);
				ps.setString(4, typDemande);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void refuserDemande(String NomCourt, String typDemande) {
		Connection con = singletonConnection.getConnection();

		if (estExisteDemande(NomCourt, typDemande)) {
			try {
				PreparedStatement ps = con.prepareStatement(
						"UPDATE DEMANDE SET estAccepte = ? ,traitement = ? WHERE NomCourt=? AND TypeDemande = ? ");
				ps.setInt(1, 0);
				ps.setInt(2, 1);
				ps.setString(3, NomCourt);
				ps.setString(4, typDemande);
				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean estExisteDemande(String NomCourt, String typDemande) {

		Connection con = singletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Demande WHERE NomCourt =? AND TypeDemande = ? ");
			ps.setString(1, NomCourt);
			ps.setString(2, typDemande);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public void creeProjet(String nomCourt, String TypeDemande) {
		int idGroupe = 0;
		int idProjet = 0;

		Connection con = singletonConnection.getConnection();
		if (estExisteDemande(nomCourt, TypeDemande)) {
			accepterDemande(nomCourt, TypeDemande);

			try {

				PreparedStatement ps = con.prepareStatement("SELECT *FROM DEMANDE WHERE NomCourt=? and TypeDemande=?");
				ps.setString(1, nomCourt);
				ps.setString(2, TypeDemande);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {

					PreparedStatement ps1 = con.prepareStatement(
							"INSERT INTO projets (NomCourt,NomLong,Description,Theme,Type,Licence,Visibilite,Etat) VALUES (?,?,?,?,?,?,?,?)");
					ps1.setString(1, rs.getString(2));
					ps1.setString(2, rs.getString(3));
					ps1.setString(3, rs.getString(4));
					ps1.setString(4, rs.getString(5));
					ps1.setString(5, rs.getString(6));
					ps1.setString(6, rs.getString(7));
					ps1.setString(7, rs.getString(8));
					ps1.setString(8, "Actif");
					ps1.executeUpdate();

					PreparedStatement ps2 = con.prepareStatement(" INSERT INTO groupes(Nom) VALUES (?) ");
					ps2.setString(1, rs.getString(2));
					ps2.executeUpdate();

					PreparedStatement ps3 = con.prepareStatement("INSERT INTO groupes (Nom) VALUES (?)");
					ps3.setString(1, (rs.getString(2)) + "-adm");
					ps3.executeUpdate();

					PreparedStatement ps5 = con.prepareStatement("SELECT Id_Groupe  FROM groupes WHERE Nom=?");
					ps5.setString(1, rs.getString(2) + "-adm");
					ResultSet rs2 = ps5.executeQuery();
					if (rs2.next()) {
						idGroupe = rs2.getInt(1);
					}

					PreparedStatement ps4 = con.prepareStatement(
							"SELECT Id_Utilisateur  FROM demande WHERE NomCourt  =? and TypeDemande=?");
					ps4.setString(1, nomCourt);
					ps4.setString(2, TypeDemande);
					ResultSet rs1 = ps4.executeQuery();

					if (rs1.next()) {
						ajouterAdminAuGroupeProjet(rs1.getInt(1), idGroupe);
					}
					PreparedStatement ps6 = con.prepareStatement("SELECT Id_Projet FROM projets WHERE  NomCourt =?");
					ps6.setString(1, rs.getString(2));
					ResultSet rs3 = ps6.executeQuery();
					if (rs3.next()) {
						idProjet = rs3.getInt(1);
					}
					System.out.println(rs1.getInt(1));
					System.out.println("--" + idProjet);
					ajouterAuAppartenir(rs1.getInt(1), idProjet);

					PreparedStatement ps7 = con
							.prepareStatement("insert INTO RESSOURCES (Id_Projet,TYPE) VALUES (?,?)");
					ps7.setInt(1, idProjet);
					ps7.setString(2, "ajenda-" + rs.getString(2));
					ps7.executeUpdate();
						
					PreparedStatement ps8 = con
							.prepareStatement("INSERT INTO RESSOURCES (Id_Projet,TYPE) VALUES (?,?)");
					ps8.setInt(1, idProjet);
					ps8.setString(2, "liste-" + rs.getString(2));
					
					ps8.executeUpdate();

					PreparedStatement ps9 = con
							.prepareStatement("INSERT INTO  RESSOURCES (Id_Projet,TYPE) VALUES (?,?)");
					ps9.setInt(1, idProjet);
					ps9.setString(2, "Src-" + rs.getString(2));
					ps9.executeUpdate();

					PreparedStatement ps10 = con
							.prepareStatement("INSERT INTO RESSOURCES (Id_Projet,TYPE) VALUES (?,?)");
					ps10.setInt(1, idProjet);
					ps10.setString(2, "Web-" + rs.getString(2));
					ps10.executeUpdate();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Desole! la demande n'existe pas ");
		}
	}

	public void ajouterAuAppartenir(int idUtilisateur, int idprojet) {

		Connection con = singletonConnection.getConnection();

		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO appartenir (Id_Utilisateur,Id_Projet ) VALUES (?,?)");
			ps.setInt(1, idUtilisateur);
			ps.setInt(2, idprojet);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeProjet(String nomCourt, String TypeDemande) {
		Connection con = singletonConnection.getConnection();
		accepterDemande(nomCourt, TypeDemande);
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE PROJETS SET ETAT = ? WHERE NomCourt=?");
			ps.setString(1, "clos");
			ps.setString(2, nomCourt);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ajouterMemberAuProjet(int idAdmin, int idUser, String nomcourt) {
		int idGroupe = 0;
		Connection con = singletonConnection.getConnection();

		if (estExistUser(idUser) && verifierAdmin(idAdmin, nomcourt)) {
			try {

				PreparedStatement ps = con.prepareStatement("SELECT Id_Groupe FROM groupes WHERE Nom =? ");
				ps.setString(1, nomcourt);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					idGroupe = rs.getInt(1);
				}
				PreparedStatement ps1 = con.prepareStatement(
						"INSERT INTO integrer (Id_Utilisateur,Id_Groupe,Responsabilite) VALUES(?,?,?)");
				ps1.setInt(1, idUser);
				ps1.setInt(2, idGroupe);
				ps1.setString(3, "member");
				ps1.executeUpdate();

				PreparedStatement ps2 = con.prepareStatement("SELECT Id_Projet FROM projets WHERE NomCourt =?");
				ps2.setString(1, nomcourt);
				ResultSet rs1 = ps2.executeQuery();
				if (rs1.next()) {
					ajouterAuAppartenir(idUser, rs1.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Desole! l'");
		}
	}

	public boolean verifierAdmin(int idAdmin, String nomCourt) {
		Connection con = singletonConnection.getConnection();
		if (estExistUser(idAdmin)) {
			try {

				PreparedStatement ps = con.prepareStatement("SELECT Id_Groupe FROM  groupes WHERE Nom = ?");
				ps.setString(1, nomCourt + "-adm");
				ps.executeQuery();
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {

					PreparedStatement ps1 = con.prepareStatement(
							"SELECT Id_Utilisateur FROM  integrer WHERE Id_Utilisateur=? and Id_Groupe = ?");
					ps1.setInt(1, idAdmin);
					ps1.setInt(2, rs.getInt(1));

					ResultSet rs2 = ps1.executeQuery();
					if (rs2.next()) {
						return true;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("ce compte n'existe pas ");
		}
		return false;
	}

	public int chercherProjet(String NomCourt) {
		Connection con = singletonConnection.getConnection();
		int idProjet = 0;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Id_Projet FROM projets WHERE NomCourt=?");
			ps.setString(1, NomCourt);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				idProjet = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idProjet;
	}

	public void modifierAjenda(String NomCourt, String text) {
		Connection con = singletonConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("UPDATE ressources SET  contenu = ? WHERE Type =?");
			ps.setString(1, text);
			ps.setString(2, "ajenda-" + NomCourt);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String retournerAjenda(String NomCourt) {
		Connection con = singletonConnection.getConnection();
		String text = null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT contenu FROM ressources WHERE Type = ?");
			ps.setString(1, "ajenda-" + NomCourt);
			ResultSet rs = ps.executeQuery();
			rs.next();
			text = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	@Override
	public String retournerAjenda(int id) {
		Connection con = singletonConnection.getConnection();
		String text = null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Agenda FROM utilisateurs WHERE id_Utilisateur =? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			text = rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public void modifierAjendaPersonnel(int idUser, String text) {
		Connection con = singletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Update utilisateurs SET Agenda = ? WHERE Id_Utilisateur= ?  ");
			ps.setString(1, text);
			ps.setInt(2, idUser);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String retournerAjendaUtilisateur(int Id_Utilisateur) {
		String ajenda = null;
		Connection con = singletonConnection.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement("Select Agenda FROM utilisateurs WHERE Id_Utilisateur = ?");
			ps.setInt(1, Id_Utilisateur);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ajenda = rs.getString(1);
			}
			return ajenda;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ajenda;
	}

	@Override
	public int retournerIdUtilisateur(String NomDUtilisateur) {
		Connection con = singletonConnection.getConnection();
		int idUser = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT Id_Utilisateur  FROM utilisateurs WHERE NomDUtilisateur = ?");
			ps.setString(1, NomDUtilisateur);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				idUser = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idUser;
	}

	public void retirerMembreFromGroupeAndAppartenir(int idAdm, int idUtilisateur, String nomCourt) {

		int idGroupe = 0;
		int idProjet = 0;
		Connection conn = singletonConnection.getConnection();
		if (estExistUser(idUtilisateur)) {

			try {
				PreparedStatement ps = conn.prepareStatement("SELECT Id_Groupe FROM groupes WHERE Nom = ?");
				ps.setString(1, nomCourt);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					idGroupe = rs.getInt(1);

				}

				PreparedStatement ps1 = conn
						.prepareStatement("DELETE FROM integrer WHERE Id_Utilisateur = ? AND Id_Groupe = ?");
				ps1.setInt(1, idUtilisateur);
				ps1.setInt(2, idGroupe);
				ps1.executeUpdate();

				PreparedStatement ps2 = conn.prepareStatement("SELECT Id_Projet FROM projets WHERE NomCourt = ?");
				ps2.setString(1, nomCourt);
				ResultSet rs1 = ps2.executeQuery();
				if (rs1.next()) {
					idProjet = rs1.getInt(1);
				}
				PreparedStatement ps3 = conn
						.prepareStatement("DELETE FROM appartenir WHERE Id_Utilisateur = ? AND Id_Projet = ?");
				ps3.setInt(1, idUtilisateur);
				ps3.setInt(2, idProjet);
				ps3.executeUpdate();

			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("Désolé, l'utilisateur n'existe pas dans la platforme !!!");
		}
	}

	public void retirerMembre(int idAdm, int idUtilisateur, String nomCourt) {

		int idGroupe = 0;
		int idProjet = 0;
		Connection conn = singletonConnection.getConnection();
		if (estExistUser(idUtilisateur)) {

			try {
				PreparedStatement ps = conn.prepareStatement("SELECT Id_Groupe FROM groupes WHERE Nom = ?");
				ps.setString(1, nomCourt);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					idGroupe = rs.getInt(1);

				}

				PreparedStatement ps1 = conn
						.prepareStatement("DELETE FROM integrer WHERE Id_Utilisateur = ? AND Id_Groupe = ?");
				ps1.setInt(1, idUtilisateur);
				ps1.setInt(2, idGroupe);
				ps1.executeUpdate();

				PreparedStatement ps2 = conn.prepareStatement("SELECT Id_Projet FROM projets WHERE NomCourt = ?");
				ps2.setString(1, nomCourt);
				ResultSet rs1 = ps2.executeQuery();
				if (rs1.next()) {
					idProjet = rs1.getInt(1);
				}
				// puisque si l'utilisateur est un admine d'un groupe, on a pas besoin de le
				// retirer de tableau appartenir, il faut cree un autre fonction pour supprimer
				// projet
				// PreparedStatement ps3 = conn.prepareStatement("DELETE FROM appartenir WHERE
				// Id_Utilisateur = ? AND Id_Projet = ?");
				// ps3.setInt(1, idUtilisateur);
				// ps3.setInt(2, idProjet);
				// ps3.executeUpdate();

			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("Désolé, l'utilisateur n'existe pas dans la platforme !!!");
		}
	}

	@Override
	public void adminAjouteUnAutreAdmin(int idAdm, int idUtilisateur, String nomCourt) {

		int idGroupe = 0;
		Connection conn = singletonConnection.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("SELECT Id_Groupe FROM groupes WHERE Nom = ?");
			ps.setString(1, nomCourt + "-adm");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				idGroupe = rs.getInt(1);
			}

			PreparedStatement ps1 = conn.prepareStatement(
					"INSERT INTO integrer (Id_Utilisateur, Id_Groupe, Responsabilite) VALUES (?, ?, ?)");
			ps1.setInt(1, idUtilisateur);
			ps1.setInt(2, idGroupe);
			ps1.setString(3, "admin");
			ps1.executeUpdate();
			retirerMembre(idAdm, idUtilisateur, nomCourt);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Projets> retournerToutLesProjetsPublic() {
		ArrayList<Projets> listeProjets = new ArrayList<Projets>();
		Connection conn = singletonConnection.getConnection();
		try {

			PreparedStatement ps = conn.prepareStatement("SELECT *FROM PROJETS WHERE Visibilite = ?");
			ps.setString(1, "public");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Projets projet = new Projets(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(9));
				listeProjets.add(projet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeProjets;

	}

	public String retournResponsabilite(int Id_Utilisateur) {
		Connection con = singletonConnection.getConnection();
		String str = null;
		try {
			PreparedStatement ps = con.prepareStatement("Select responsabilite from integrer WHERE Id_Utilisateur = ?");
			ps.setInt(1, Id_Utilisateur);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				str = rs.getString(1);
				return str;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

	public ResultSet retournerListeDemandeSelonTypeDemande(String typeDemande) {

		Connection conn = singletonConnection.getConnection();

		try {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM DEMANDE WHERE TypeDemande = ? AND TRAITEMENT = ?");
			ps.setString(1, typeDemande);
			ps.setInt(2, 0);
			ResultSet rs = ps.executeQuery();
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> retournerNomCourtProjet(int idUser) {

		Connection conn = singletonConnection.getConnection();
		List<String> listeNomProjet = new ArrayList<String>();

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT ID_PROJET FROM APPARTENIR WHERE ID_UTILISATEUR = ?");
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PreparedStatement ps1 = conn.prepareStatement("SELECT NOMCOURT FROM PROJETS WHERE ID_PROJET = ?");
				ps1.setInt(1, rs.getInt(1));
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {
					String s = rs1.getString(1);
					// System.out.println(s);
					listeNomProjet.add(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeNomProjet;
	}

	public String retournerListe(String NomCourt) {

		Connection conn = singletonConnection.getConnection();
		String text = "";

		try {

			PreparedStatement ps = conn.prepareStatement("SELECT contenu FROM ressources WHERE Type = ?");
			ps.setString(1, "liste-" + NomCourt);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				text = rs.getString("contenu");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}

	public void modifierListe(String NomCourt, String text) {

		Connection conn = singletonConnection.getConnection();

		try {

			PreparedStatement ps = conn.prepareStatement("UPDATE ressources SET Contenu = ? WHERE Type = ?");
			ps.setString(1, text);
			ps.setString(2, "liste-" + NomCourt);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> retournerNomProjetUserAdmin(int idUser) {

		Connection conn = singletonConnection.getConnection();
		List<String> nomProjets = new ArrayList<String>();

		try {
			PreparedStatement ps = conn
					.prepareStatement("SELECT ID_GROUPE FROM INTEGRER WHERE ID_UTILISATEUR = ? AND RESPONSABILITE = ?");
			ps.setInt(1, idUser);
			ps.setString(2, "Admin");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PreparedStatement ps1 = conn.prepareStatement("SELECT NOM FROM GROUPES WHERE ID_GROUPE = ?");
				ps1.setInt(1, rs.getInt(1));
				ResultSet rs1 = ps1.executeQuery();
				nomProjets.add(rs1.getString(1).replace("-adm", ""));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return nomProjets;
	}

	public List<Projets> retournerProjetParNomCourt(String nomCourt) {

		Connection conn = singletonConnection.getConnection();
		List<Projets> projets = new ArrayList<Projets>();

		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT ID_PROJET, NOMLONG, DESCRIPTION, THEME, TYPE, LICENCE, VISIBILITE, ETAT FROM PROJETS WHERE NOMCOURT = ?");
			ps.setString(1, nomCourt);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				projets.add(new Projets(rs.getInt(1), nomCourt, rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return projets;
	}

	public boolean estClos(String nomCourt) {

		Connection conn = singletonConnection.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJETS WHERE NOMCOURT = ? AND ETAT = ?");
			ps.setString(1, nomCourt);
			ps.setString(2, "clos");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
//retourner id de groupe admin et groupe membre
	
	@Override
	public Vector<Integer> retourneIdGroupe(String nomCourt) {
		Vector<Integer> listeId = new Vector<Integer>();
		int id_groupe = 0;
		Connection conn = singletonConnection.getConnection();
		try {
			//
			PreparedStatement ps = conn.prepareStatement("SELECT Id_Groupe FROM groupes WHERE Nom = ? OR Nom = ? ");
			ps.setString(1, nomCourt);
			ps.setString(2, nomCourt + "-adm");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id_groupe = rs.getInt(1);
				listeId.add(id_groupe);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeId;
	}

	@Override
	public String retournResponsabilite(int id_Utilisateur, int id_Groupe) {
		String str = null;
		Connection conn = singletonConnection.getConnection();

		try {

			PreparedStatement ps = conn
					.prepareStatement("Select Responsabilite From integrer WHERE Id_Utilisateur=? AND Id_Groupe=? ");
			ps.setInt(1, id_Utilisateur);
			ps.setInt(2, id_Groupe);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				str = rs.getString(1);
				;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}

	@Override
	public int retournIdProjet(String nomCourt) {
		Connection conn = singletonConnection.getConnection();
		int n=0;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT Id_Projet FROM  projets WHERE NomCourt =? ");
			ps.setString(1, nomCourt);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				n=rs.getInt(1);
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public void supprimerdeAppartenir(String nomCourt) {
		
		
		
		Connection conn = singletonConnection.getConnection();
		int idprj=retournIdProjet( nomCourt);
		
		try {
			PreparedStatement ps = conn.prepareStatement("Delete from appartenir where Id_Projet = ?");
			ps.setInt(1, idprj);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

//	@Override
//	public void supprimerdeIntegrer(int idutilisateur, int idGroupe) {
//		
//		Connection conn = singletonConnection.getConnection();
//		try {
//			PreparedStatement ps = conn.prepareStatement("DELET FROM integrer WHERE Id_Utilisateur = ? AND Id_Groupe=?");
//			ps.setInt(1, idutilisateur);
//			ps.setInt(2, idGroupe);
//			ps.executeUpdate();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void supprimerdeIntegrer(String nomCourt) {
//		Connection conn = singletonConnection.getConnection();
//		
//		Vector<Integer> listeIdGoup=new Vector<Integer>();
//		listeIdGoup=retourneIdGroupe( nomCourt);
//		try {
//			
//			PreparedStatement ps = conn.prepareStatement("DELETE FROM GROUPES WHERE Id_Groupe = ? OR Id_Groupe=?");
//			ps.setInt(1,listeIdGoup.get(0) );
//			ps.setInt(2,listeIdGoup.get(1));
//			ps.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	@Override
	public void supprimerDeGroupe(String nomCourt) {
		Connection conn = singletonConnection.getConnection();
		
		Vector<Integer> listeIdGoup=new Vector<Integer>();
		listeIdGoup=retourneIdGroupe( nomCourt);
		try {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM GROUPES WHERE Id_Groupe = ? OR Id_Groupe=?");
			ps.setInt(1,listeIdGoup.get(0) );
			ps.setInt(2,listeIdGoup.get(1));
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


	

}
