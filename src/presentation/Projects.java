package presentation;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.daoImpl;
import metier.Projets;

public class Projects extends JFrame implements MouseListener, KeyListener {

    // TextField
    JTextField textField = new JTextField();

    // panels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    // labels
    JLabel searchLabel = new JLabel();//writ
    JLabel searchLabel1 = new JLabel();//icon

    // Images Icons
    static ImageIcon img1 = new ImageIcon("add.png");
    ImageIcon img2 = new ImageIcon("add.png");
    ImageIcon img3 = new ImageIcon("remove.png");
    ImageIcon img4 = new ImageIcon("home.png");
    ImageIcon img5 = new ImageIcon("logouts.png");
    ImageIcon img6 = new ImageIcon("search.png");
    ImageIcon img7 = new ImageIcon("user.png");
    ImageIcon img8 = new ImageIcon("power.png");
    ImageIcon icon = new ImageIcon("image.jpg");

    //icons labels
    JLabel Label1 = new JLabel();
    JLabel Label2 = new JLabel();
    JLabel Label3 = new JLabel();
    JLabel Label4 = new JLabel();
    JLabel Label5 = new JLabel();
    JLabel Label6 = new JLabel();

    
    // Buttons
    JButton button1 = new JButton(img1);
    JButton button2 = new JButton(img2);
    JButton button3 = new JButton(img3);
    JButton button4 = new JButton(img4);
    JButton button5 = new JButton(img5);
    JButton button6 = new JButton(img6);

    JScrollPane scrollPane;
    JTable table;

    public Projects() {

        // search text field
        textField.setBounds(200, 80, 300, 20);
        textField.setOpaque(false);
        textField.setForeground(new Color(0x006666));
        textField.setFont(new Font(" ", Font.BOLD, 20));
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        textField.addKeyListener(this);

        // search label
        searchLabel1.setBounds(470, 65, 30, 30);
        searchLabel1.setFont(new Font(" ", Font.BOLD, 15));
        searchLabel1.setIcon(img6);

        button1.setText("Ajouter Membre");
        button1.setHorizontalTextPosition(JButton.RIGHT);
        button1.setVerticalTextPosition(JButton.BOTTOM);
        button1.setFont(new Font(" ", Font.BOLD, 20));
        button1.setForeground(Color.WHITE);
        button1.setIconTextGap(0);
        button1.setBounds(20, 120, 250, 50);
        button1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button1.setFocusable(false);

        button2.setText("Ajouter Admin");
        button2.setHorizontalTextPosition(JButton.RIGHT);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font(" ", Font.BOLD, 20));
        button2.setForeground(Color.WHITE);
        button2.setIconTextGap(10);
        button2.setBounds(20, 200, 250, 50);
        button2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button2.setFocusable(false);

        button3.setText("Remove Membre ");
        button3.setHorizontalTextPosition(JButton.RIGHT);
        button3.setVerticalTextPosition(JButton.BOTTOM);
        button3.setFont(new Font(" ", Font.BOLD, 20));
        button3.setForeground(Color.WHITE);
        button3.setIconTextGap(-5);
        button3.setBounds(20, 280, 250, 50);
        button3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button3.setFocusable(false);

        button4.setText("Home               ");
        button4.setHorizontalTextPosition(JButton.RIGHT);
        button4.setVerticalTextPosition(JButton.BOTTOM);
        button4.setFont(new Font(" ", Font.BOLD, 20));
        button4.setForeground(Color.WHITE);
        button4.setIconTextGap(0);
        button4.setBounds(20, 360, 250, 50);
        button4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button4.setFocusable(false);

        button5.setText("Déconnexion       ");
        button5.setHorizontalTextPosition(JButton.RIGHT);
        button5.setVerticalTextPosition(JButton.BOTTOM);
        button5.setFont(new Font(" ", Font.BOLD, 20));
        button5.setForeground(Color.WHITE);
        button5.setIconTextGap(0);
        button5.setBounds(20, 440, 250, 50);
        button5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button5.setFocusable(false);

        button6.setText("log out");
        button6.setHorizontalTextPosition(JButton.RIGHT);
        button6.setVerticalTextPosition(JButton.BOTTOM);
        button6.setFont(new Font(" ", Font.BOLD, 20));
        button6.setForeground(Color.WHITE);
        button6.setBackground(new Color(0x202020));
        button6.setIconTextGap(0);
        button6.setBounds(20, 520, 250, 50);
        button6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button6.setFocusable(false);

        button1.setBackground(new Color(0x006666));
        button2.setBackground(new Color(0x006666));
        button3.setBackground(new Color(0x006666));
        button4.setBackground(new Color(0x006666));
        button5.setBackground(new Color(0x006666));
        button6.setBackground(new Color(0x006666));

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

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
       

        // Pannel2
        panel2.setPreferredSize(new Dimension(200, 150));
        panel2.setLayout(null);
        panel2.setBackground(new Color(0x009999));
        panel2.add(textField);
        panel2.add(searchLabel);
        panel2.add(searchLabel1);

        int o = Login.id_user;

        // implement JTabel.

        daoImpl test = new daoImpl();
        String[] colums = { "Nom court", "nom long", "theme", "type", "responsabilité" };
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(colums);
        Object[] data = new Object[5];
        Iterator<Projets> iter = test.retournerProjet(o).iterator();

        while (iter.hasNext()) {

            Projets etu = new Projets();
            etu = iter.next();
            data[0] = etu.getNomCourt();
            data[1] = etu.getNomLong();
            data[2] = etu.getTheme();
            data[3] = etu.getType();

            Iterator<Integer> id_Groupeliste = test.retourneIdGroupe(etu.getNomCourt()).iterator();

            while (id_Groupeliste.hasNext()) {

                int d = id_Groupeliste.next();
                String h = test.retournResponsabilite(o, d);

                if (h != null) {
                    data[4] = h;
                }
            }
            tableModel.addRow(data);
        }

        table = new JTable(tableModel);

        table.setFont(new Font("", Font.PLAIN, 12));
        table.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        table.setBounds(10, 100, 400, 250);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 150, 650, 350);
        scrollPane.setPreferredSize(new Dimension(500, 150));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int idAdmin = o;
                int i = table.getSelectedRow();
                int j = table.getRowCount();

                if (i > -1 && j > 0) {
                    String str2 = (String) tableModel.getValueAt(i, 4);
                    String str = (String) tableModel.getValueAt(i, 0);

                    if (str2.equals("admin")) {

                        String userName = JOptionPane.showInputDialog("Entrez le nome d'utilisateur");

                        if (userName != null) {
                            int idUser = test.retournerIdUtilisateur(userName);
                            if (idUser != 0) {
                                test.ajouterMemberAuProjet(idAdmin, idUser, str);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "l'utilisateur n'existe pas dans la basse de donnees");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Désolé, vous êtes pas Admin");
                    }
                } else {

                    if (j == 0) {
                        JOptionPane.showMessageDialog(null, "La liste des projets est vide !");
                    } else if (i <= -1 && j > 0) {
                        JOptionPane.showMessageDialog(null, "Selectionner un projet s'il vous plaît");
                    }
                }
            }
        });

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int j = table.getRowCount();
                int idAdmin = o;
                int i = table.getSelectedRow();
                if (i > -1 && j > 0) {
                    String str = (String) tableModel.getValueAt(i, 0);
                    String str2 = (String) tableModel.getValueAt(i, 4);

                    if (str2.equals("admin")) {
                        String userName = JOptionPane.showInputDialog("Entrez le nome d'utilisateur");
                        if (userName != null) {
                            int idUser = test.retournerIdUtilisateur(userName);
                            if (idUser != 0) {
                                test.adminAjouteUnAutreAdmin(idAdmin, idUser, str);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "l'utilisateur n'existe pas dans la basse de donnees");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Désolé, vous êtes pas Admin");
                    }
                } else {
                    if (j == 0) {
                        JOptionPane.showMessageDialog(null, "La liste des projets est vide !");
                    } else if (i <= -1 && j > 0) {
                        JOptionPane.showMessageDialog(null, "Selectionner un projet s'il vous plaît");
                    }
                }
            }
        });

        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int j = table.getRowCount();
                int idAdmin = o;
                int i = table.getSelectedRow();
                if (i > -1 && j > 0) {

                    String str = (String) tableModel.getValueAt(i, 0);
                    String str2 = (String) tableModel.getValueAt(i, 4);

                    if (str2.equals("admin")) {
                        String userName = JOptionPane.showInputDialog("Entrez le nome d'utilisateur");
                        if (userName != null) {
                            int idUser = test.retournerIdUtilisateur(userName);
                            if (idUser != 0) {
                                test.adminAjouteUnAutreAdmin(idAdmin, idUser, str);

                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "l'utilisateur n'existe pas dans la basse de donnees");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Désolé, vous êtes pas Admin");
                    }
                } else {
                    if (j == 0) {
                        JOptionPane.showMessageDialog(null, "La liste des projets est vide !");
                    } else if (i <= -1 && j > 0) {
                        JOptionPane.showMessageDialog(null, "Selectionner un projet s'il vous plaît");
                    }
                }
            }
        });

        // Label
        searchLabel.setText("Recherche");
        searchLabel.setBounds(80, 80, 300, 20);
        searchLabel.setFont(new Font(" ", Font.BOLD, 20));
        searchLabel.setForeground(Color.WHITE);

        panel2.add(scrollPane);
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
        if (e.getSource() == button1) {

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == button1) {

        }
        if (e.getSource() == button2) {

        }
        if (e.getSource() == button3) {

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
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyPressed(KeyEvent e) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tr.setRowFilter(RowFilter.regexFilter(textField.getText().trim()));
        table.setRowSorter(tr);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
