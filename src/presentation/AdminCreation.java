package presentation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
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

public class AdminCreation extends JFrame implements MouseListener, ActionListener,KeyListener {

    // les Images
    ImageIcon img3 = new ImageIcon("check.png");
    ImageIcon img4 = new ImageIcon("refuser.png");
    ImageIcon img5 = new ImageIcon("logouts.png");
    ImageIcon img6 = new ImageIcon("search.png");
    ImageIcon img7 = new ImageIcon("user.png");
    ImageIcon img8 = new ImageIcon("home.png");

    // TextField
    JTextField textField = new JTextField();

    // Les pannels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    // lES labelss
    JLabel searchLabel = new JLabel();
    JLabel searchLabel1 = new JLabel();

    // Buttons
    JButton button1 = new JButton(img5);
    JButton button2 = new JButton(img3);
    JButton button3 = new JButton(img8);
    JButton button4 = new JButton(img4);

    JScrollPane sp;
    daoImpl dai = new daoImpl();
    JTable table;
    AdminCreation() {

        String header[] = { "IdDemande", "NomCourt", "NomLong", "Description", "Theme", "Type", "License", "Visibilité",
                "TypeDemande", "IdUtilisateur", "estAccepte", "traitement" };

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(header);

        table = new JTable();
        table.setModel(model);
        table.setFont(new Font("", Font.ITALIC, 12));
        table.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        table.setBounds(10, 100, 600, 400);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);

        try {
            ResultSet rs = dai.retournerListeDemandeSelonTypeDemande("creation");
            while (rs.next()) {
            	 model.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                         rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                         rs.getInt(12), rs.getInt(10), rs.getInt(11) });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sp = new JScrollPane(table);
        sp.setBounds(10, 150, 650, 350);
        sp.setPreferredSize(new Dimension(500, 150));
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //field de recherche 
        textField.setBounds(200, 80, 300, 20);
        textField.setOpaque(false);
        textField.setForeground(new Color(0x006666));
        textField.setFont(new Font(" ", Font.BOLD, 20));
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        textField.addKeyListener(this);

        // Label
        searchLabel.setText("Recherche");
        searchLabel.setBounds(80, 80, 300, 20);
        searchLabel.setFont(new Font(" ", Font.BOLD, 20));
        searchLabel.setForeground(Color.WHITE);

        searchLabel1.setBounds(470, 65, 30, 30);
        searchLabel1.setFont(new Font(" ", Font.BOLD, 15));
        searchLabel1.setIcon(img6);

        button1.setText("Déconnexion");
        button1.setHorizontalTextPosition(JButton.RIGHT);
        button1.setVerticalTextPosition(JButton.BOTTOM);
        button1.setFont(new Font(" ", Font.BOLD, 20));
        button1.setForeground(Color.WHITE);
        button1.setIconTextGap(0);
        button1.setBounds(20, 360, 250, 50);
        button1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button1.setFocusable(false);

        button2.setText("Accepter");
        button2.setHorizontalTextPosition(JButton.RIGHT);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font("Refuser    ", Font.BOLD, 20));
        button2.setForeground(Color.WHITE);
        button2.setIconTextGap(10);
        button2.setBounds(20, 200, 250, 50);
        button2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button2.setFocusable(false);

        button3.setText("Home    ");
        button3.setHorizontalTextPosition(JButton.RIGHT);
        button3.setVerticalTextPosition(JButton.BOTTOM);
        button3.setFont(new Font(" ", Font.BOLD, 20));
        button3.setForeground(Color.WHITE);
        button3.setIconTextGap(5);
        button3.setBounds(20, 280, 250, 50);
        button3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button3.setFocusable(false);

        button4.setText("Refuser");
        button4.setHorizontalTextPosition(JButton.RIGHT);
        button4.setVerticalTextPosition(JButton.BOTTOM);
        button4.setFont(new Font(" ", Font.BOLD, 20));
        button4.setForeground(Color.WHITE);
        button4.setIconTextGap(5);
        button4.setBounds(20, 120, 250, 50);
        button4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button4.setFocusable(false);

        button1.setBackground(new Color(0x006666));
        button2.setBackground(new Color(0x006666));
        button3.setBackground(new Color(0x006666));
        button4.setBackground(new Color(0x006666));

        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);

        // Pannel1
        panel1.setPreferredSize(new Dimension(300, 150));
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        panel1.setBackground(new Color(0x006666));

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

        // Pannel2
        panel2.setPreferredSize(new Dimension(200, 150));
        panel2.setLayout(null);
        panel2.setBackground(new Color(0x009999));
        panel2.add(sp); //scroll
        panel2.add(textField);//research 
        panel2.add(searchLabel);//label1
        panel2.add(searchLabel1);//label2

        //accepter la demande
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                daoImpl dai = new daoImpl();

                DefaultTableModel model = (DefaultTableModel) table.getModel();

                if (table.getSelectedRowCount() > 0) {
            //        ArrayList<Integer> liste = new ArrayList<Integer>();
                	
                	//pour l'afficher a nouveau.
                    int[] rs = table.getSelectedRows();

                    for (Integer x : rs) {
                        model.setValueAt(1, x, 11);
                        model.setValueAt(1, x, 10);
                    }

                    // model.setValueAt(1, table.getSelectedRow(), 10);
                    int i = table.getSelectedRow();
                    String nomCourt = (String) model.getValueAt(i, 1);
                    String typeDemande = (String) model.getValueAt(i, 8);
                    dai.creeProjet(nomCourt, typeDemande);

                    JOptionPane.showMessageDialog(table, "la demande est acceptée !");
                	} else {
                    if (table.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(table, "Tableau des demandes  est vide !");
                    } else {
                        JOptionPane.showMessageDialog(table, "Sélectionnez une ligne pour Accepter ou refuser la demand !");
                    }
                }

            }

        });
        //refuser la demande
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) table.getModel();

                if (table.getSelectedRowCount() > 0) {
              //      ArrayList<Integer> liste = new ArrayList<Integer>();

                    int[] rs = table.getSelectedRows();

                    for (Integer x : rs) {
                        model.setValueAt(1, x, 11);
                        model.setValueAt(0, x, 10);
                    }
                    int i = table.getSelectedRow();
                    String nomCourt = (String) model.getValueAt(i, 1);
                    String typeDemande = (String) model.getValueAt(i, 8);
                    dai.refuserDemande(nomCourt, typeDemande);

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
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == button3) {
            this.dispose();
            new Admin();//qui contien demande creation demande supprision. 
        }
        if (e.getSource() == button1) {
            this.setVisible(false);
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

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == button1) {
            button1.setBackground(new Color(0x006666));

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
		
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		tr.setRowFilter(RowFilter.regexFilter(textField.getText().trim()));
		table.setRowSorter(tr);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
