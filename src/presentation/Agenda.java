
package presentation;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import dao.daoImpl;

public class Agenda extends JFrame implements MouseListener, ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//panels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    
    // Images & Icons
    static ImageIcon img1 = new ImageIcon("color.png");
    ImageIcon img2 = new ImageIcon("color.png");
    ImageIcon img3 = new ImageIcon("check.png");
    ImageIcon img4 = new ImageIcon("home.png");
    ImageIcon img5 = new ImageIcon("logouts.png");
    ImageIcon img6 = new ImageIcon("search.png");
    ImageIcon img7 = new ImageIcon("user.png");
    ImageIcon img8 = new ImageIcon("power.png");

    
    // Buttons
    JButton button1 = new JButton(img1);
    JButton button2 = new JButton(img2);
    JButton button3 = new JButton(img3);
    JButton button4 = new JButton(img4);
    JButton button5 = new JButton(img5);
    JButton button6 = new JButton(img6);

    // images
    ImageIcon icon = new ImageIcon("image.jpg");

    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner fontSizeSpinner;
    JLabel fontLabel = new JLabel();
    JButton fontColorButton;
    JButton saveButton = new JButton("Save");
    JComboBox comBoFont;
    
    // labels
    JLabel label1 = new JLabel();

    daoImpl dao1 = new daoImpl();

    public Agenda() {

        String str = dao1.retournerAjenda(Login.id_user);
        // TextArea
        textArea = new JTextArea(str);
        textArea.setBounds(10, 100, 400, 250);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("", Font.BOLD, 25));
        textArea.setBackground(new Color(0x006666));
        textArea.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        textArea.setForeground(Color.BLACK);

        // ScrollPane
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(100, 200, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(Color.BLACK);

        // FontLabel
        fontLabel.setText("Font :");
        fontLabel.setBounds(220, 80, 20, 25);
        fontLabel.setFont(new Font("", Font.BOLD, 15));
        fontLabel.setForeground(Color.WHITE);

        // fontSpinner
        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setBounds(260, 50, 40, 25);
        fontSizeSpinner.setValue(15);
        fontSizeSpinner.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        fontSizeSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent arg0) {
                textArea.setFont(
                        new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));

            }

        });

        // ComboFont
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        comBoFont = new JComboBox<String>(fonts);
        comBoFont.addActionListener(this);
        comBoFont.setSelectedItem("Papyrus");
        comBoFont.setBounds(10, 50, 250, 25);

        panel2.setLayout(null);
        panel2.add(label1);
        panel2.add(fontSizeSpinner);
        panel2.add(comBoFont);
        panel2.add(scrollPane);

        button2.setText("Couleur        ");
        button2.setHorizontalTextPosition(JButton.RIGHT);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font(" ", Font.BOLD, 20));
        button2.setForeground(Color.WHITE);
        button2.setIconTextGap(0);
        button2.setBounds(20, 100, 250, 50);
        button2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button2.setFocusable(false);

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

        button2.setBackground(new Color(0x006666));
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

        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);

        // Pannel2
        panel2.setPreferredSize(new Dimension(200, 150));
        panel2.setLayout(null);
        panel2.setBackground(new Color(0x009999));
        panel2.setLayout(null);
        
        
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

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == button2) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "choose  a color", Color.BLACK);
            textArea.setForeground(color);
        }
        if (e.getSource() == comBoFont) { //Font.
            textArea.setFont(new Font((String) comBoFont.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }
        if (e.getSource() == button3) { //Agenda modifie
            dao1.modifierAjendaPersonnel(Login.id_user, textArea.getText());
            JOptionPane.showMessageDialog(null, "Agenda has modified successfully", "title",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == button4) {
            this.dispose();
            new Frame();
        }
        if (e.getSource() == button5) {
            this.dispose();
            new Login();
        }

        if (e.getSource() == button6) {

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

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "choose  a color", Color.BLACK);
            textArea.setForeground(color);
        }
        if (e.getSource() == comBoFont) {
            textArea.setFont(new Font((String) comBoFont.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }

    }

}
