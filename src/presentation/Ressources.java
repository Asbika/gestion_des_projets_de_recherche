
package presentation;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dao.daoImpl;
import metier.Projets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dao.daoImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ressources extends JFrame implements MouseListener, ActionListener {

    // Les pannels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    // les Images
    // Images Icons
    static ImageIcon img1 = new ImageIcon("color.png");
    ImageIcon img2 = new ImageIcon("color.png");
    ImageIcon img3 = new ImageIcon("check.png");
    ImageIcon img4 = new ImageIcon("home.png");
    ImageIcon img5 = new ImageIcon("logouts.png");
    ImageIcon img6 = new ImageIcon("search.png");
    ImageIcon img7 = new ImageIcon("user.png");
    ImageIcon img8 = new ImageIcon("power.png");

    // les Buttons
    // Buttons
    JButton button1 = new JButton(img1);
    JButton button2 = new JButton(img2);
    JButton button3 = new JButton(img3);
    JButton button4 = new JButton(img4);
    JButton button5 = new JButton(img5);
    JButton button6 = new JButton(img6);

    JButton save = new JButton("Save");
    JTextArea textAreaList;
    JTextArea textAreaAgenda;
    JScrollPane sp, sp1;
    JComboBox comBoFont;
    JComboBox comboProjets;
    JSpinner fontSizeSpinner;
    JButton fontColorButton;
    JLabel labelList = new JLabel();
    JLabel labelAgenda = new JLabel();
    ImageIcon icon = new ImageIcon("image.jpg");

    JFrame frame = new JFrame();
    daoImpl daoi = new daoImpl();
    String item;

    public Ressources() {

        // textArea List
        textAreaList = new JTextArea();
        textAreaList.setLineWrap(true);
        textAreaList.setWrapStyleWord(true);
        textAreaList.setFont(new Font("", Font.BOLD, 25));
        textAreaList.setBackground(Color.white);
        textAreaList.setForeground(Color.blue);

        // textArea Agenda
        textAreaAgenda = new JTextArea();
        textAreaAgenda.setLineWrap(true);
        textAreaAgenda.setWrapStyleWord(true);
        textAreaAgenda.setFont(new Font("", Font.BOLD, 25));
        textAreaAgenda.setBackground(Color.white);
        textAreaAgenda.setForeground(Color.blue);

        // ScrollPane textAreaList
        sp = new JScrollPane(textAreaList);
        sp.setBounds(50, 200, 250, 300);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setBackground(Color.gray);

        // ScrollPane textAreaAgenda

        sp1 = new JScrollPane(textAreaAgenda);
        sp1.setBounds(400, 200, 250, 300);
        sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp1.setBackground(Color.gray);

        // LabelList
        labelList.setText("Liste");
        labelList.setBounds(150, 170, 120, 25);
        labelList.setFont(new Font("", Font.BOLD, 15));
        labelList.setForeground(Color.WHITE);

        // LabelAgenda
        labelAgenda.setText("Agenda");
        labelAgenda.setBounds(500, 170, 120, 25);
        labelAgenda.setFont(new Font("", Font.BOLD, 15));
        labelAgenda.setForeground(Color.WHITE);

        // fontSpinner
        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setBounds(520, 80, 90, 25);
        fontSizeSpinner.setValue(15);
        fontSizeSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent arg0) {
                textAreaList.setFont(
                        new Font(textAreaList.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
                textAreaAgenda.setFont(
                        new Font(textAreaAgenda.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));

            }

        });

        // Color Chooser
        fontColorButton = new JButton("Color");
        fontColorButton.setBounds(386, 80, 100, 25);
        fontColorButton.addActionListener(this);

        // ComboFont
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        comBoFont = new JComboBox<String>(fonts);
        comBoFont.addActionListener(this);
        comBoFont.setSelectedItem("Papyrus");
        comBoFont.setBounds(50, 80, 135, 25);

        String[] nomCourt = daoi.retournerNomCourtProjet(Login.id_user)
                .toArray(new String[daoi.retournerNomCourtProjet(Login.id_user).size()]);
        comboProjets = new JComboBox<String>(nomCourt);
        comboProjets.addActionListener(this);
        comboProjets.setBounds(250, 80, 200, 25);
        comboProjets.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                item = (String) comboProjets.getSelectedItem();
                String s = daoi.retournerListe(item);
                String a = daoi.retournerAjenda(item);
                textAreaList.setText(s);
                textAreaAgenda.setText(a);

            }
        });

        save.setBounds(300, 385, 100, 30);
        save.setBackground(Color.blue);
        save.setForeground(Color.yellow);
        save.addActionListener(this);

        button2.setText("Couleur        ");
        button2.setHorizontalTextPosition(JButton.RIGHT);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font(" ", Font.BOLD, 20));
        button2.setForeground(Color.WHITE);
        button2.setIconTextGap(10);
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
        button4.setIconTextGap(10);
        button4.setBounds(20, 260, 250, 50);
        button4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button4.setFocusable(false);

        button5.setText("Déconnexion       ");
        button5.setHorizontalTextPosition(JButton.RIGHT);
        button5.setVerticalTextPosition(JButton.BOTTOM);
        button5.setFont(new Font(" ", Font.BOLD, 20));
        button5.setForeground(Color.WHITE);
        button5.setIconTextGap(10);
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
        comBoFont.addMouseListener(this);

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

        panel2.setLayout(null);
        panel2.add(labelList);
        panel2.add(labelAgenda);
        panel2.add(fontSizeSpinner);
        panel2.add(comBoFont);
        panel2.add(comboProjets);
        panel2.add(sp);
        panel2.add(sp1);

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
    public void mousePressed(MouseEvent arg0) {

        if (arg0.getSource() == button2) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "choose  a color", Color.BLACK);
            textAreaList.setForeground(color);
            textAreaAgenda.setForeground(color);
            System.out.println("List has modified successfully" + textAreaList.getText());
        }

        if (arg0.getSource() == comBoFont) {
            textAreaList.setFont(
                    new Font((String) comBoFont.getSelectedItem(), Font.PLAIN, textAreaList.getFont().getSize()));
            textAreaAgenda.setFont(
                    new Font((String) comBoFont.getSelectedItem(), Font.PLAIN, textAreaAgenda.getFont().getSize()));
        }

        if (arg0.getSource() == button3) {

            daoi.modifierListe(item, textAreaList.getText());
            daoi.modifierAjenda(item, textAreaAgenda.getText());
            JOptionPane.showMessageDialog(null, "List and Agenda has modified successfully", "title",
                    JOptionPane.INFORMATION_MESSAGE);
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
            textAreaList.setForeground(color);
            textAreaAgenda.setForeground(color);
            System.out.println("List has modified successfully" + textAreaList.getText());

        }
        if (e.getSource() == comBoFont) {
            textAreaList.setFont(
                    new Font((String) comBoFont.getSelectedItem(), Font.PLAIN, textAreaList.getFont().getSize()));
            textAreaAgenda.setFont(
                    new Font((String) comBoFont.getSelectedItem(), Font.PLAIN, textAreaAgenda.getFont().getSize()));
        }

        if (e.getSource() == button3) {

            daoi.modifierListe(item, textAreaList.getText());
            daoi.modifierAjenda(item, textAreaAgenda.getText());
            JOptionPane.showMessageDialog(null, "List and Agenda has modified successfully", "title",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
