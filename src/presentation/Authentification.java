package presentation;

import dao.daoImpl;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Authentification extends JFrame implements MouseListener {

    // JButton
    JButton inscrip = new JButton("S'inscrire");

    // Panels
    JPanel panel1 = new JPanel();
    
    // Labels
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel("First Name");
    JLabel label4 = new JLabel("Last Name");
    JLabel label5 = new JLabel("Email");
    JLabel label6 = new JLabel("Username");
    JLabel label7 = new JLabel("Password");
    JLabel label8 = new JLabel("Confirm Password");
    JLabel label9 = new JLabel();
    JLabel label10 = new JLabel();
    JLabel label11 = new JLabel();
    JLabel label12 = new JLabel();
    JLabel label13 = new JLabel();
    JLabel label14 = new JLabel();
    JLabel label15 = new JLabel();

    // JTextFild
    JTextField nomField = new JTextField();
    JTextField prenomField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField usernameField = new JTextField();
    JTextField passField = new JPasswordField();
    JTextField passField2 = new JPasswordField();

    // images
    ImageIcon img = new ImageIcon("login1.jpg");

    //object from daoImpl
    daoImpl dao = new daoImpl();

    public Authentification() {
        // the text on the top of the TextField

        label3.setLayout(null);
        label3.setVisible(true);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label3.setForeground(Color.WHITE);
        label3.setBounds(80, 60, 150, 17);

        label4.setLayout(null);
        label4.setVisible(true);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label4.setForeground(Color.WHITE);
        label4.setBounds(80, 180, 150, 17);

        label5.setLayout(null);
        label5.setVisible(true);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label5.setForeground(Color.WHITE);
        label5.setBounds(80, 300, 150, 17);

        label6.setLayout(null);
        label6.setVisible(true);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label6.setForeground(Color.WHITE);
        label6.setBounds(450, 60, 150, 17);

        label7.setLayout(null);
        label7.setVisible(true);
        label7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label7.setForeground(Color.WHITE);
        label7.setBounds(450, 180, 150, 17);

        label8.setLayout(null);
        label8.setVisible(true);
        label8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label8.setForeground(Color.WHITE);
        label8.setBounds(450, 300, 150, 17);

        label9.setLayout(null);
        label9.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label9.setIcon(new ImageIcon("user2.png"));
        label9.setBounds(340, 70, 150, 25);

        label10.setLayout(null);
        label10.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label10.setIcon(new ImageIcon("user2.png"));
        label10.setBounds(340, 190, 150, 25);

        label11.setLayout(null);
        label11.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label11.setIcon(new ImageIcon("mail.png"));
        label11.setBounds(340, 310, 150, 25);

        label12.setLayout(null);
        label12.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label12.setIcon(new ImageIcon("user2.png"));
        label12.setBounds(710, 70, 150, 25);

        label13.setLayout(null);
        label13.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label13.setIcon(new ImageIcon("padlock.png"));
        label13.setBounds(710, 190, 150, 25);

        label14.setLayout(null);
        label14.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label14.setIcon(new ImageIcon("padlock.png"));
        label14.setBounds(710, 310, 150, 25);

        label15.setLayout(null);
        label15.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label15.setIcon(new ImageIcon("arrow1.png"));
        label15.setBounds(10, 10, 50, 25);

        // TextFild
        nomField.setBounds(80, 80, 290, 20);
        nomField.setOpaque(false);
        nomField.setForeground(Color.BLACK);
        nomField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        nomField.setFont(new Font("", Font.BOLD, 15));

        prenomField.setBounds(80, 200, 290, 20);
        prenomField.setOpaque(false);
        prenomField.setForeground(Color.BLACK);
        prenomField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        prenomField.setFont(new Font("", Font.BOLD, 15));

        emailField.setBounds(80, 320, 290, 20);
        emailField.setOpaque(false);
        emailField.setForeground(Color.BLACK);
        emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        emailField.setFont(new Font("", Font.BOLD, 15));

        usernameField.setBounds(450, 80, 290, 20);
        usernameField.setOpaque(false);
        usernameField.setForeground(Color.BLACK);
        usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        usernameField.setFont(new Font("", Font.BOLD, 15));

        passField.setBounds(450, 200, 290, 20);
        passField.setOpaque(false);
        passField.setForeground(Color.BLACK);
        passField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        passField.setFont(new Font("", Font.BOLD, 15));

        passField2.setBounds(450, 320, 290, 20);
        passField2.setOpaque(false);
        passField2.setForeground(Color.BLACK);
        passField2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        passField2.setFont(new Font("", Font.BOLD, 15));

        // Panels
        panel1.setLayout(new BorderLayout());
        panel1.add(label1);

        // Labels
        label1.setLayout(null);
        label1.setIcon(img);
        label1.add(nomField);
        label1.add(prenomField);
        label1.add(emailField);
        label1.add(usernameField);
        label1.add(passField);
        label1.add(passField2);
        label1.add(inscrip);
        label1.add(label3);
        label1.add(label4);
        label1.add(label5);
        label1.add(label6);
        label1.add(label7);
        label1.add(label8);
        label1.add(label9);
        label1.add(label10);
        label1.add(label11);
        label1.add(label12);
        label1.add(label13);
        label1.add(label14);
        label1.add(label15);

        // MouseListner
        nomField.addMouseListener(this);
        prenomField.addMouseListener(this);
        emailField.addMouseListener(this);
        usernameField.addMouseListener(this);
        passField.addMouseListener(this);
        passField2.addMouseListener(this);
        inscrip.addMouseListener(this);
        label15.addMouseListener(this);

        // JButton
        inscrip.setBounds(350, 370, 127, 38);
        inscrip.setOpaque(false);
        inscrip.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        inscrip.setForeground(Color.WHITE);
        inscrip.setFocusable(false);
        inscrip.setFont(new Font("", Font.BOLD, 20));
        inscrip.setBackground(new Color(84, 205, 227));

        this.add(panel1);
        this.setTitle("frame");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0x00ff00));
        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == inscrip) {
            inscrip.setForeground(Color.BLACK);
        }
        if (arg0.getSource() == prenomField) {
            prenomField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        }
        if (arg0.getSource() == nomField) {
            nomField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        }
        if (arg0.getSource() == emailField) {
            emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        }
        if (arg0.getSource() == usernameField) {
            usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        }
        if (arg0.getSource() == passField) {
            passField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        }
        if (arg0.getSource() == passField2) {
            passField2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        }

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == inscrip) {
            inscrip.setForeground(Color.WHITE);
        }
        if (arg0.getSource() == prenomField) {
            prenomField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        }
        if (arg0.getSource() == nomField) {
            nomField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        }
        if (arg0.getSource() == emailField) {
            emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        }
        if (arg0.getSource() == usernameField) {
            usernameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        }
        if (arg0.getSource() == passField) {
            passField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        }
        if (arg0.getSource() == passField2) {
            passField2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == nomField) {
            nomField.setText("");
        }
        if (arg0.getSource() == prenomField) {
            prenomField.setText("");
        }
        if (arg0.getSource() == emailField) {
            emailField.setText("");
        }
        if (arg0.getSource() == usernameField) {
            usernameField.setText("");
        }
        if (arg0.getSource() == passField) {
            passField.setText("");
        }
        if (arg0.getSource() == passField2) {
            passField2.setText("");
        }
        if (arg0.getSource() == inscrip) {
            if (dao.estExistUser(usernameField.getText())) {
                JOptionPane.showMessageDialog(null, "Nom d'utilisateur est deja existe", "title",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (passField.getText().equals(passField2.getText())) {
                dao.authentifier(nomField.getText(), prenomField.getText(), emailField.getText(),
                        usernameField.getText(), passField.getText());
                JOptionPane.showMessageDialog(null, "Vous avez bien inscrit", "title",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new Login();
            } else {
                JOptionPane.showMessageDialog(null, "Mot de passe incompatible", "title",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }
        if (arg0.getSource() == label15) {
            this.dispose();
            new Login();
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

}
