
package presentation;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import dao.daoImpl;

public class NouveauProjet extends JFrame implements MouseListener, ActionListener {

   
    JTextField textField = new JTextField();

   
    JPanel panel1 = new JPanel();//west
    JPanel panel2 = new JPanel();//East
    
    
    static ImageIcon img1 = new ImageIcon("add.png");
    ImageIcon img2 = new ImageIcon("add.png");
    ImageIcon img3 = new ImageIcon("check.png");
    ImageIcon img4 = new ImageIcon("home.png");
    ImageIcon img5 = new ImageIcon("logouts.png");
    ImageIcon img6 = new ImageIcon("search.png");
    ImageIcon img7 = new ImageIcon("user.png");
    ImageIcon img8 = new ImageIcon("power.png");
    ImageIcon icon = new ImageIcon("image.jpg");

    // les icones labels

    JLabel Label3 = new JLabel();
    JLabel Label4 = new JLabel();
    JLabel Label5 = new JLabel();

    // les Buttons
    // Buttons
    JButton button1 = new JButton();
    JButton button2 = new JButton(img2);
    JButton button3 = new JButton(img3);
    JButton button4 = new JButton(img4);
    JButton button5 = new JButton(img5);
    JButton button6 = new JButton(img6);

    JTextArea textArea;

    // scrollPane
    JScrollPane scrollPane;
    
    // ComboType
    JComboBox comBoType;

    daoImpl test = new daoImpl();

    // JLabel
    JLabel label15 = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    

    JTextField nomField = new JTextField();
    JTextField prenomField = new JTextField();//theme
    JTextField emailField = new JTextField();
    JTextField licenceField = new JTextField();

    public NouveauProjet() {
    	//searche
        textField.setBounds(300, 80, 300, 20);
        textField.setOpaque(false);
        textField.setForeground(new Color(0x006666));
        textField.setFont(new Font(" ", Font.BOLD, 20));
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        button3.setText("Sauvegarder");
        button3.setHorizontalTextPosition(JButton.RIGHT);
        button3.setVerticalTextPosition(JButton.BOTTOM);
        button3.setFont(new Font(" ", Font.BOLD, 20));
        button3.setForeground(Color.WHITE);
        button3.setIconTextGap(10);
        button3.setBounds(20, 180, 250, 50);
        button3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button3.setFocusable(false);

        button4.setText("Home               ");
        button4.setHorizontalTextPosition(JButton.RIGHT);
        button4.setVerticalTextPosition(JButton.BOTTOM);
        button4.setFont(new Font(" ", Font.BOLD, 20));
        button4.setForeground(Color.WHITE);
        button4.setIconTextGap(0);
        button4.setBounds(20, 260, 250, 50);
        button4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button4.setFocusable(false);

        button5.setText("Déconnexion       ");
        button5.setHorizontalTextPosition(JButton.RIGHT);
        button5.setVerticalTextPosition(JButton.BOTTOM);
        button5.setFont(new Font(" ", Font.BOLD, 20));
        button5.setForeground(Color.WHITE);
        button5.setIconTextGap(0);
        button5.setBounds(20, 340, 250, 50);
        button5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button5.setFocusable(false);

        button3.setBackground(new Color(0x006666));
        button4.setBackground(new Color(0x006666));
        button5.setBackground(new Color(0x006666));

        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);

        // Pannel1
        panel1.setPreferredSize(new Dimension(300, 150));
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        panel1.setBackground(new Color(0x006666));

        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);

        // Pannel2
        panel2.setPreferredSize(new Dimension(200, 150));
        panel2.setLayout(null);
        panel2.setBackground(new Color(0x009999));
        panel2.setLayout(null);

        // TextField
        nomField.setBounds(150, 45, 200, 20);
        nomField.setOpaque(false);
        nomField.setForeground(Color.white);
        nomField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        nomField.setFont(new Font("", Font.BOLD, 15));

        prenomField.setBounds(150, 120, 200, 20);
        prenomField.setOpaque(false);
        prenomField.setForeground(Color.white);
        prenomField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        prenomField.setFont(new Font("", Font.BOLD, 15));

        emailField.setBounds(150, 200, 200, 20);
        emailField.setOpaque(false);
        emailField.setForeground(Color.white);
        emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        emailField.setFont(new Font("", Font.BOLD, 15));
        
        licenceField.setBounds(150, 280, 200, 20);
        licenceField.setOpaque(false);
        licenceField.setForeground(Color.white);
        licenceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        licenceField.setFont(new Font("", Font.BOLD, 15));

        // TextArea
        textArea = new JTextArea(" Entrez une description ");
        textArea.setBounds(150, 295, 200, 100);
        textArea.setOpaque(false);
        textArea.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("", Font.BOLD, 15));
        textArea.setBackground(new Color(0x006666));
        textArea.setForeground(Color.BLACK);

        // ScrollPane
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(150, 350, 300, 70);
        scrollPane.setOpaque(true);
        scrollPane.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        String[] type = { "public", "privé" };
        comBoType = new JComboBox<String>(type);
        comBoType.addActionListener(this);
        comBoType.setSelectedItem("public");
        comBoType.setBounds(150, 460, 100, 20);
        comBoType.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        comBoType.setFocusable(false);
        comBoType.setBackground(new Color(0x009999));
        
        // MouseListner
        nomField.addMouseListener(this);
        prenomField.addMouseListener(this);
        emailField.addMouseListener(this);
        textArea.addMouseListener(this);

        // JButton
        button1 = new JButton("Save");
        button1.setBounds(350, 200, 127, 38);
        button1.setOpaque(false);
        button1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        button1.setFocusable(false);
        button1.setFont(new Font("", Font.BOLD, 20));
        button1.addMouseListener(this);

        label1.setBounds(40, 45, 200, 20);
        label1.setText("Nom court");
        label1.setForeground(Color.white);
        label1.setFont(new Font("", Font.BOLD, 15));

        label2.setBounds(40, 125, 200, 20);
        label2.setText("Nom Long");
        label2.setForeground(Color.white);
        label2.setFont(new Font("", Font.BOLD, 15));

        label3.setBounds(40, 205, 200, 20);
        label3.setText("Theme ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("", Font.BOLD, 15));
        
        label4.setBounds(40, 285, 200, 20);
        label4.setText("Licence ");
        label4.setForeground(Color.white);
        label4.setFont(new Font("", Font.BOLD, 15));

        
        panel2.add(label1);
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(label4);
        
        panel2.add(comBoType);
        panel2.add(scrollPane);
        panel2.add(nomField);
        panel2.add(prenomField);
        panel2.add(emailField);
        panel2.add(licenceField);							

        // frame
        this.setSize(1000, 600);
        this.add(panel1, BorderLayout.WEST);
        this.add(panel2, BorderLayout.CENTER);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == button1) {

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
        if (arg0.getSource() == textArea) {
            textArea.setText("");
        }
        if (arg0.getSource() == button3) {
            if (test.estExistProjet(nomField.getText())) {

                JOptionPane.showMessageDialog(null, "Nom court de projet est déja existe", "title",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                test.demender(Login.id_user, nomField.getText(), prenomField.getText(),
                        textArea.getText(), emailField.getText(), "logiciel",licenceField.getText(),(String) comBoType.getSelectedItem(),
                        "creation");
                JOptionPane.showMessageDialog(null, "demande envoyé", "title",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }
        if (arg0.getSource() == label15) {
            this.setVisible(false);

        }
        if (arg0.getSource() == button4) {
            this.dispose();
            new Frame();
        }
        if (arg0.getSource() == button5) {
            this.dispose();
            new Login();
        }

        if (arg0.getSource() == button6) {

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == button1) {
            button1.setBackground(new Color(0x004C99));

        }
        if (e.getSource() == button2) {
            button2.setBackground(new Color(0x004C99));

        }
        if (e.getSource() == button3) {
            button3.setBackground(new Color(0x004C99));

        }
        if (e.getSource() == button4) {
            button4.setBackground(new Color(0x004C99));

        }
        if (e.getSource() == button5) {
            button5.setBackground(new Color(0x004C99));
        }
        if (e.getSource() == button6) {
            button6.setBackground(new Color(0x004C99));
        }if (e.getSource() == nomField) {
            nomField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x003319)));
        }
        if (e.getSource() == prenomField) {
            prenomField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x003319)));
        }
        if (e.getSource() == emailField) {
            emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0x003319)));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == button1) {
            button1.setBackground(new Color(0x006666));

        }
        if (e.getSource() == button2) {
            button2.setBackground(new Color(0x006666));

        }
        if (e.getSource() == button3) {
            button3.setBackground(new Color(0x006666));

        }
        if (e.getSource() == button4) {
            button4.setBackground(new Color(0x006666));

        }
        if (e.getSource() == button5) {
            button5.setBackground(new Color(0x006666));

        }
        if (e.getSource() == button6) {
            button6.setBackground(new Color(0x006666));

        } if (e.getSource() == nomField) {
            nomField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        }
        if (e.getSource() == prenomField) {
            prenomField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        }
        if (e.getSource() == emailField) {
            emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
