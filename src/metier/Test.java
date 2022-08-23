package metier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Vector;

import dao.daoImpl;
import presentation.Admin;
import presentation.Agenda;
import presentation.Frame;
import presentation.Guest;
import presentation.Login;
import presentation.NouveauProjet;
import presentation.Projects;
import presentation.Ressources;
import presentation.SupprimerProjet;

public class Test implements MouseListener {

	public static void main(String[] args) {
          daoImpl test = new daoImpl();
		// System.out.println(test.estExistProjet("telecom"));
		// new Login();
         // new SupprimerProjet();
		// new Frame();
		// new Authentification();
		// new Frame();
		// new ProjectsLabels();
		// new AgendaLabels();
		 //new Guest();
		// System.out.println(test.rechercherUtilisateur("s", "s"));
		// NouveauProjet();
        // new Projects();
       //  new SupprimerProjet(); 
        //  new SupprimerProjet();
          new Login();
        //  new Login();
		// new AdminCréation();
		// new AdminSupression();
		// System.out.println("Lojsh");

		// new DemandeLabels();
		//
		// Iterator<Projets> iter = listt.iterator();
		// while(iter.hasNext()) {
		// Projets prt = iter.next();
		// System.out.println(prt.toString());
		// }
		// //test.demender("a", "a", "a"," a", "a", "a");
		// boolean b = test.authentifier("o", "o", "o","o", "o");
		// System.out.println(b);
		// new Guest();
		// new Guest();
        //test.supprimerdeAppartenir(116);
        //  Iterator<Integer> intt =test.retourneIdGroupe("houawei").iterator();
//          while(intt.hasNext()) {
//        	  int n = intt.next();
//        	 System.out.println(n);
//          }
           
         // test.supprimerDeGroupe("houawei");
//         int n = test. retournIdProjet("houawei");
//         test.supprimerdeAppartenir(n);
         
   // System.out.println(test.retournIdProjet("houawei")  );
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
