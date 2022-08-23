package presentation;

import dao.daoImpl;
import metier.Utilisateur;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.dao;

public class Login implements ActionListener, MouseListener, KeyListener {

	JFrame frame = new JFrame();

	JButton InscrButton;
	JButton ConxButton;

	JTextField userIDField;
	JPasswordField userPasswordField;

	JLabel userIDLabel;
	JLabel userPasswordLabel;

	JLabel ouLibel;

	JLabel backGround;
	JLabel backGround1;
	JLabel backGround2;
	JLabel backGround4;
	JLabel backGround5;
	JLabel backGround6;
	public static int id_user = 0;

	public Login() {

		InscrButton = new JButton("S'inscrire");
		ConxButton = new JButton("Connection");

		userIDField = new JTextField();
		userPasswordField = new JPasswordField();

		userIDLabel = new JLabel("nom d'utilisateur");
		userPasswordLabel = new JLabel("mot de passe");
		ouLibel = new JLabel("OU");

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		ImageIcon img2 = new ImageIcon("user1.png");
		backGround4 = new JLabel("", img2, JLabel.CENTER);
		backGround4.setIcon(new ImageIcon("man2.png"));
		backGround4.setBounds(0, 0, 785, 200);

		backGround5 = new JLabel();
		backGround5.setLayout(null);
		backGround5.setVisible(true);
		backGround5.setIcon(new ImageIcon("user2.png"));
		backGround5.setBounds(520, 180, 150, 25);

		backGround6 = new JLabel();
		backGround6.setLayout(null);
		backGround6.setVisible(true);
		backGround6.setIcon(new ImageIcon("padlock.png"));
		backGround6.setBounds(520, 250, 150, 25);

		backGround1 = new JLabel("Si Vous voulez entrer comme un visiteur ");
		backGround1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		backGround1.setForeground(Color.WHITE);
		backGround1.setBounds(250, 50, 400, 700);

		backGround2 = new JLabel("nom d'utilisateur : Guest   |    mot de passe  : guest  ");
		backGround2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		backGround2.setForeground(Color.WHITE);
		backGround2.setBounds(250, 50, 400, 730);

		ImageIcon img = new ImageIcon("ab.jpg");
		backGround = new JLabel("", img, JLabel.CENTER);
		backGround.setLayout(null);
		backGround.setIcon(new ImageIcon("login.jpg"));
		backGround.setBounds(0, 0, 800, 500);

		// user label
		userIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		userIDLabel.setForeground(Color.WHITE);
		userIDLabel.setBounds(250, 170, 130, 17);
		panel.add(userIDLabel);

		ouLibel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ouLibel.setForeground(Color.WHITE);
		ouLibel.setBounds(388, 345, 20, 8);
		panel.add(ouLibel);

		// user password

		userPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		userPasswordLabel.setForeground(Color.WHITE);
		userPasswordLabel.setBounds(250, 241, 150, 17);
		panel.add(userPasswordLabel);

		// user id field
		userIDField.setBounds(250, 190, 290, 20);
		userIDField.setColumns(10);
		userIDField.setOpaque(false);
		userIDField.setForeground(Color.BLACK);
		userIDField.setFont(new Font("", Font.BOLD, 15));
		userIDField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		userIDField.addMouseListener(this);
		userIDField.addKeyListener(this);
		userIDField.setFont(new Font("", Font.BOLD, 15));
		panel.add(userIDField);

		// user password field
		userPasswordField.setBounds(250, 260, 290, 20);
		userPasswordField.setColumns(10);
		userPasswordField.setOpaque(false);
		userPasswordField.setForeground(Color.BLACK);
		userPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));// line Border
		userPasswordField.addMouseListener(this);
		userPasswordField.setFont(new Font("", Font.BOLD, 15));
		userPasswordField.addKeyListener(this);
		panel.add(userPasswordField);

		ConxButton.setBounds(250, 330, 120, 35);
		ConxButton.setBackground(new Color(84, 205, 227));//
		ConxButton.addActionListener(this);
		ConxButton.addMouseListener(this);
		ConxButton.setFocusable(false);
		ConxButton.setOpaque(false);
		ConxButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		ConxButton.setForeground(Color.WHITE);
		panel.add(ConxButton);

		InscrButton.setBounds(423, 330, 120, 35);
		InscrButton.setBackground(new Color(84, 205, 227));
		InscrButton.addActionListener(this);
		InscrButton.setOpaque(false);
		InscrButton.setFocusable(false);
		InscrButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		InscrButton.addMouseListener(this);
		InscrButton.setForeground(Color.WHITE);
		panel.add(InscrButton);

		backGround.add(backGround1);
		backGround.add(backGround2);
		backGround.add(backGround4);
		backGround.add(backGround5);
		backGround.add(backGround6);
		panel.add(backGround);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
  		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == InscrButton) {
			frame.dispose();
			new Authentification();
		}
		if (e.getSource() == ConxButton) {
			String username = userIDField.getText();
			String pass = userPasswordField.getText();
			daoImpl dao1 = new daoImpl();

			if (username.equals("Guest") && pass.equals("guest")) {
				frame.dispose();
				new Guest();

			} else if (username.equals("Admin") && pass.equals("admin")) {
				frame.dispose();
				new AdminCreation();
			}

			else if ((dao1.rechercherUtilisateur(username, pass)) == 0) {

				JOptionPane.showMessageDialog(null, "Mot de pass ou nom d'utulisateur incorrecte", "title",
						JOptionPane.ERROR_MESSAGE);

			} else {
				frame.dispose();
				id_user = dao1.rechercherUtilisateur(username, pass);
				Frame.userLabel.setText(username);
				new Frame();
			}

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() == ConxButton) {
			ConxButton.setForeground(Color.BLACK);
		}
		if (e.getSource() == InscrButton) {

			InscrButton.setForeground(Color.BLACK);
		}

		if (e.getSource() == userIDField) {
			userIDField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

		}
		if (e.getSource() == userPasswordField) {
			userPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == ConxButton) {
			ConxButton.setForeground(Color.WHITE);
		}
		if (e.getSource() == InscrButton) {
			InscrButton.setForeground(Color.WHITE);
		}

		if (e.getSource() == userIDField) {
			userIDField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

		}
		if (e.getSource() == userPasswordField) {
			userPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			String username = userIDField.getText();
			String pass = userPasswordField.getText();
			daoImpl dao1 = new daoImpl();

			if (username.equals("Guest") && pass.equals("guest")) {
				frame.dispose();
				new Guest();
			} else if (username.equals("Admin") && pass.equals("admin")) {
				frame.dispose();
				new Admin();
			}

			else if ((dao1.rechercherUtilisateur(username, pass)) == 0) {

				JOptionPane.showMessageDialog(null, "Mot de pass ou nom d'utulisateur incorrecte", "title",
						JOptionPane.ERROR_MESSAGE);

			}

			else {
				frame.dispose();
				id_user = dao1.rechercherUtilisateur(username, pass);
				Frame.userLabel.setText(username);
				new Frame();
			}

		}

	}

}
