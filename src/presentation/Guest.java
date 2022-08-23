
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class Guest extends JFrame implements MouseListener,KeyListener {

	    // images
	    ImageIcon img5 = new ImageIcon("logouts.png");
	    ImageIcon img6 = new ImageIcon("search.png");
	    ImageIcon img7 = new ImageIcon("user.png");
	
	    // TextField
	    JTextField textField = new JTextField();
	
	    // panels
	    JPanel panel1 = new JPanel();
	    JPanel panel2 = new JPanel();
	
	    // lES labels
	    JLabel searchLabel = new JLabel();//righting.
	    JLabel searchLabel1 = new JLabel();//icon.
	
	    // Buttons
	    JButton button1 = new JButton(img5);
	
	    daoImpl dao2 = new daoImpl();
	
	    static JLabel userLabel = new JLabel();
	    JTable table;
	    public Guest() {
	    	
	    //research field
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
        button1.setBounds(20, 400, 250, 50);
        button1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        button1.setFocusable(false);

        button1.setBackground(new Color(0x006666));

        button1.addMouseListener(this);

        // Pannel1
        panel1.setPreferredSize(new Dimension(300, 150));
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        panel1.setBackground(new Color(0x006666));

        panel1.add(button1);

        String[] colums = { "Nom court", "nom long", "Description", "theme", "type", "licence" };
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(colums);

        Object[] data = new Object[6];

        Iterator<Projets> iter = dao2.retournerToutLesProjetsPublic().iterator();
        for (int i = 0; i < dao2.retournerToutLesProjetsPublic().size(); i++) {

            while (iter.hasNext()) {

                Projets etu = new Projets();
                etu = iter.next();
                data[0] = etu.getNomCourt();
                data[1] = etu.getNomLong();
                data[2] = etu.getDescreption();
                data[3] = etu.getTheme();
                data[4] = etu.getType();
                data[5] = etu.getLicence();

                tableModel.addRow(data);

            }

        }

         table = new JTable(tableModel);

        // table.setForeground(Color.BLACK);
        table.setFont(new Font("", Font.PLAIN, 11));
        table.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        table.setBounds(10, 100, 400, 350);
        // button1.setBounds(100, 10, 320, 50);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 150, 650, 350);
        scrollPane.setPreferredSize(new Dimension(500, 150));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // user Label
        userLabel.setBounds(5, 0, 300, 150);
        userLabel.setIcon(img7);
        userLabel.setText("Guest");
        userLabel.setFont(new Font("", Font.BOLD, 20));

        panel1.add(userLabel);
        // Pannel2
        panel2.add(scrollPane);
        panel2.setPreferredSize(new Dimension(200, 150));
        panel2.setLayout(null);
        panel2.setBackground(new Color(0x009999));
        panel2.add(textField);
        panel2.add(searchLabel);
        panel2.add(searchLabel1);

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
        if (e.getSource() == button1) {
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