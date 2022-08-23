package presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Admin extends JFrame implements MouseListener {

    // panels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    // labels
    static JLabel userLabel = new JLabel();

    
    // Images & Icons
    static ImageIcon img1 = new ImageIcon("project.png");
    ImageIcon img2 = new ImageIcon("calendar.png");
    ImageIcon img3 = new ImageIcon("newPR.png");
    ImageIcon img4 = new ImageIcon("newPR.png");
    ImageIcon img5 = new ImageIcon("management.png");
    ImageIcon img6 = new ImageIcon("logout.png");
    ImageIcon img7 = new ImageIcon("user.png");
    ImageIcon img8 = new ImageIcon("power.png");
    ImageIcon icon = new ImageIcon("image.jpg");

    // Buttons
    public static JButton button1 = new JButton(img1);
    JButton button2 = new JButton(img4);
    JButton button3 = new JButton(img6);
    JButton button4 = new JButton(img4);
    JButton button5 = new JButton(img5);
    JButton button6 = new JButton(img6);

    public Admin() {

        // Pannel1
        panel1.setPreferredSize(new Dimension(200, 150));
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        panel1.setBackground(new Color(0x006666));

        // Pannel2
        panel2.setPreferredSize(new Dimension(200, 150));
        panel2.setLayout(null);
        panel2.setBackground(new Color(0x009999));

        button1.setText("Demande Création");
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setVerticalTextPosition(JButton.BOTTOM);
        button1.setFont(new Font(" ", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setIconTextGap(0);
        button1.setBounds(100, 150, 200, 120);
        button1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button1.setFocusable(false);

        button2.setText("Demande Suppression");
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font(" ", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setIconTextGap(0);
        button2.setBounds(400, 150, 200, 120);
        button2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button2.setFocusable(false);

        button3.setText("Déconnxion");
        button3.setHorizontalTextPosition(JButton.CENTER);
        button3.setVerticalTextPosition(JButton.BOTTOM);
        button3.setFont(new Font(" ", Font.BOLD, 15));
        button3.setForeground(Color.WHITE);
        button3.setIconTextGap(0);
        button3.setBounds(700, 150, 200, 120);
        button3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button3.setFocusable(false);

        button1.setBackground(new Color(0x006666));
        button2.setBackground(new Color(0x006666));
        button3.setBackground(new Color(0x006666));

        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);

        // user Label
        userLabel.setBounds(5, 0, 300, 150);
        userLabel.setIcon(img7);
        userLabel.setText("Admin");
        userLabel.setFont(new Font("", Font.BOLD, 20));

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);

        panel1.add(userLabel);

        // frame
        this.setSize(1000, 600);
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == button1) {
            this.dispose();
            new AdminCreation();
        }
        if (e.getSource() == button2) {
            this.dispose();
            new AdminSuppression();
        } if (e.getSource() == button3) {
            this.dispose();
            new Login();
        }
        }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

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
            this.dispose();
            new Login();
            
        }

    }

}
