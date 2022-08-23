
package presentation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import dao.daoImpl;
import metier.Projets;
import java.util.ArrayList;

public class SupprimerProjet extends JFrame implements MouseListener, ActionListener, KeyListener {

    // panels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JLabel searchLabel = new JLabel();
    JLabel searchLabel1 = new JLabel();//icon content.
    

    // Images Icons
    
    ImageIcon img3 = new ImageIcon("check.png");
    ImageIcon img4 = new ImageIcon("home.png");
    ImageIcon img5 = new ImageIcon("logouts.png");
    ImageIcon img6 = new ImageIcon("search.png");
    ImageIcon img7 = new ImageIcon("user.png");
    ImageIcon img8 = new ImageIcon("power.png");


    // Buttons
   
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
    daoImpl dai = new daoImpl();
    String item;

    JTextField textField = new JTextField();
    JTable table = new JTable();

    
    public SupprimerProjet() {
    	
    	//research field
        textField.setBounds(200, 80, 300, 20);
        textField.setOpaque(false);
        textField.setForeground(new Color(0x006666));
        textField.setFont(new Font(" ", Font.BOLD, 20));
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        textField.addKeyListener(this);
        
        //search icon.
        searchLabel1.setBounds(470, 65, 30, 30);
        searchLabel1.setFont(new Font(" ", Font.BOLD, 15));
        searchLabel1.setIcon(img6);

        searchLabel.setText("Recherche");
        searchLabel.setBounds(80, 80, 300, 20);
        searchLabel.setFont(new Font(" ", Font.BOLD, 20));
        searchLabel.setForeground(Color.WHITE);

        button3.setText("Sauvgarder");
        button3.setHorizontalTextPosition(JButton.RIGHT);
        button3.setVerticalTextPosition(JButton.BOTTOM);
        button3.setFont(new Font(" ", Font.BOLD, 20));
        button3.setForeground(Color.WHITE);  //khet
        button3.setIconTextGap(10);//Space between icon and righting
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

        
        button3.setBackground(new Color(0x006666));
        button4.setBackground(new Color(0x006666));
        button5.setBackground(new Color(0x006666));

       
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

        String header[] = { "IdProjet", "NomCourt", "NomLong", "Description", "Theme", "Type", "License", "Visibilité",
                "Etat" };

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(header);

        table.setModel(model);
        table.setFont(new Font("", Font.ITALIC, 12));
        table.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        table.setBounds(10, 100, 600, 400);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);

        Object[] data = new Object[9];

        for (String c : dai.retournerNomCourtProjet(Login.id_user)) {
            String s = c;
            
            for (Projets p : dai.retournerProjetParNomCourt(s)) {
                if (!dai.estClos(p.getNomCourt())) {
                    Projets proj = new Projets();
                
                    data[0] = p.getIdProjet();
                    data[1] = p.getNomCourt();
                    data[2] = p.getNomLong();
                    data[3] = p.getDescreption();
                    data[4] = p.getTheme();
                    data[5] = p.getType();
                    data[6] = p.getLicence();
                    data[7] = p.getVisibilite();
                    data[8] = p.getEtat();

                    model.addRow(data);
                }

            }

        }

        sp = new JScrollPane(table);
        sp.setBounds(10, 150, 650, 350);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                daoImpl dai = new daoImpl();

                DefaultTableModel model = (DefaultTableModel) table.getModel();

                if (table.getSelectedRowCount() > 0) {

                    int[] rs = table.getSelectedRows();

                    for (Integer x : rs) {
                        String nCourt = (String) model.getValueAt(x, 1);
                        String nLong = (String) model.getValueAt(x, 2);
                        String desC = (String) model.getValueAt(x, 3);
                        String theme = (String) model.getValueAt(x, 4);
                        String type = (String) model.getValueAt(x, 5);
                        String license = (String) model.getValueAt(x, 6);
                        String visibilite = (String) model.getValueAt(x, 7);
                        System.out.println((String) model.getValueAt(x, 7));
                        String typeDemande = "suppression";
                        dai.demender(Login.id_user, nCourt, nLong, desC, theme, type, license, visibilite, typeDemande);
                    }

//                    int i = table.getSelectedRow();
//                    String nomCourt = (String) model.getValueAt(i, 1);
//                    String typeDemande = (String) model.getValueAt(i, 8);
//                    dai.creeProjet(nomCourt, typeDemande);

                    JOptionPane.showMessageDialog(table, "la refus de demande est réussi !");
                } else {
                    if (table.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(table, "Tableau des demandes  est vide !");
                    } else {
                        JOptionPane.showMessageDialog(table, "Sélectionnez une ligne pour Accepter ou refuser la demand !");
                    }
                }

            }

        });

        panel2.add(sp);
        panel2.setLayout(null);
        panel2.add(searchLabel);
        panel2.add(textField);
        panel2.add(searchLabel1);

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

        if (arg0.getSource() == button3) {

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
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tr.setRowFilter(RowFilter.regexFilter(textField.getText().trim()));
        table.setRowSorter(tr);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
