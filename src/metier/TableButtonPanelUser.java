package metier;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import metier.TableProjetList.RoundedButton;

import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class TableButtonPanelUser extends JPanel {
	private JFrame parent;
    private JTable table;
    public int id;
    Connection conn = Utilitaire.getConnection();
//--------------------------------------------------------------------fetchDemandes---------------------//
    Vector<Object[]> fetchDemandesUser(){
    	Vector<Object[]> demandes = new Vector<Object[]>(); 
    	
    	try {
    		PreparedStatement pstm = conn.prepareStatement("SELECT IdDemande, username, nom_court_projet, theme_projet, date_demande, type, etat FROM DEMANDE WHERE IdUtilisateur = ?");
    		pstm.setInt(1, id);
    		ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
            	
            	if(rs.getString(7).equalsIgnoreCase("pending")) {
                Object[] row = {
                	rs.getInt(1),
                	rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDate(5),
                    rs.getString(6),
                };
                demandes.add(row);
            	}
            }
        } catch (Exception e) {
                        System.out.println("Exception : "+ e);
        }
        return demandes;
    }
    public Vector<Object[]> fetchDemandesReviewdUser(){
    	Vector<Object[]> demandes = new Vector<Object[]>(); 
    	
    	try {
    		
    		PreparedStatement pstm = conn.prepareStatement("SELECT IdDemande, username, nom_court_projet, theme_projet, date_demande, type, etat FROM DEMANDE WHERE IdUtilisateur = ?");
    		pstm.setInt(1, id);
    		ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
            	if(rs.getString(7).equalsIgnoreCase("accepted") || rs.getString(7).equalsIgnoreCase("refused")) {
                Object[] row = {
                	rs.getInt(1),
                	rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDate(5),
                    rs.getString(6),
                    rs.getString(7)
                };
                demandes.add(row);
            	}
            }
        } catch (Exception e) {
                        System.out.println("Exception : "+ e);
        }
        return demandes;
    }
 // Methods to calculate the minimum width of a column--------------------------------------------
    
    private void setColumnWidths() {
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setMinWidth(getPreferredColumnWidth(i) +10); // 20 pixels padding on each side
        }
    }

    private int getPreferredColumnWidth(int columnIndex) {
        int maxWidth = 0;
        TableCellRenderer renderer = table.getCellRenderer(0, columnIndex);
        for (int row = 0; row < table.getRowCount(); row++) {
            Component comp = renderer.getTableCellRendererComponent(table, table.getValueAt(row, columnIndex), false, false, row, columnIndex);
            maxWidth = Math.max(comp.getPreferredSize().width, maxWidth);
        }
        return maxWidth;
    }
    
//-------------------------------------------------Constructor-------------------------------------------//
    public TableButtonPanelUser(JFrame parent, int id) {
    	this.id = id;
    	this.parent = parent;
        setLayout(new BorderLayout());

        // Create sample data for the table
        
        // Column names
        String[] columns = {"Id_demande", "username", "nom_project", "theme", "Date", "Type", "Actions"};

        // Create a table model with button column
        Object[][] data = {
            };
        Vector<Object[]> demandes = fetchDemandesUser();
        
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Make only the button column editable/////////////////////////////////////////////////////-!!!!!!!!!!!!!!!!!!!!!!///
            }
            

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) { // Assuming the "Actions" column is at index 5////////////////////////////////////!!!!!!////////////////
                    return JButton.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        for(Object[] o : demandes) {
    	model.addRow(o);
    	}
        

        // Create a table with the model
        table = new JTable(model);

        // Set button column size
        table.getColumnModel().getColumn(6).setPreferredWidth(28);////////////////////////////////////////////////////!!!!!!!!!/////////////////
        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(parent));
        
     // Adjust column widths
        /*for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int minWidth = getColumnMinWidth(i); // Minimum width plus additional space
            column.setMinWidth(minWidth);
            column.setWidth(minWidth);
        }*/
        setColumnWidths();        

        //call the action after clicking the button
        

        JScrollPane scrollPane = new JScrollPane(table);
        table.setGridColor(Color.WHITE);
        table.setRowHeight(40);
        table.setSelectionBackground(new Color(153, 204, 0));
        table.setSelectionForeground(new Color(255, 255, 255));
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrollPane.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(scrollPane, BorderLayout.CENTER);
    }

    //RoundedButton class
    class RoundedButton extends JButton {
        public RoundedButton(Icon icon) {
            super(icon);
            setOpaque(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int diameter = Math.min(getWidth(), getHeight());
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;
            g2.setColor(getBackground());
            g2.fillOval(x, y, diameter, diameter);
            super.paintComponent(g2);
            g2.dispose();
            
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(36, 36);
        }
    }
    // Button renderer class
    class ButtonRenderer extends JButton implements TableCellRenderer {
    	private RoundedButton button1;
        private RoundedButton button2;

        public ButtonRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
            button1 = new RoundedButton(new ImageIcon(getClass().getResource("assets/view.png")));
            button1.setBackground(Color.white);
            button2 = new RoundedButton(new ImageIcon(getClass().getResource("assets/delete.png")));
            button2.setBackground(Color.white);
            add(button1);
            add(button2);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Button editor class

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    	private JPanel panel;
        private JButton button1;
        private JButton button2;
        private JFrame parent;
        private int selectedRow;

        public ButtonEditor(JFrame parent) {
        	this.parent = parent;
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            button1 = new RoundedButton(new ImageIcon(getClass().getResource("assets/view.png")));
            button2 = new RoundedButton(new ImageIcon(getClass().getResource("assets/delete.png")));
            panel.add(button1);
            panel.add(button2);
            button1.addActionListener(this);
            button2.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        	selectedRow = row;
            return panel;
        }
        /*
int row = table.getEditingRow(); // Get the index of the editing row
                int value = (int) table.getValueAt(row, 0); // Get the value of the first column in the editing row
                String type = (String) table.getValueAt(row, 5);
                JFrame frame = new DemandeOverview(value, type, false);
                frame.setLocationRelativeTo(null);
                frame.setSize(520,400);*/
        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {//About the project
            	// Open a new JFrame when button is clicked
            	int row = table.getEditingRow(); // Get the index of the editing row
                int value = (int) table.getValueAt(row, 0); // Get the value of the first column in the editing row
                String type = (String) table.getValueAt(row, 5);
                JFrame frame = new DemandeOverview(value, type, false);
                frame.setLocationRelativeTo(null);
                frame.setSize(520,400);
                frame.setVisible(true);
                
            } else if (e.getSource() == button2) {//Verification before deleting the demande
                int value = (int) table.getValueAt(selectedRow, 0);
                VerifierSupprimeDemande popUp = new VerifierSupprimeDemande(value);
                popUp.setLocationRelativeTo(null);
                popUp.setSize(520, 400);
                popUp.setVisible(true);
                
                parent.setEnabled(false);

                // Show popup frame
                popUp.setVisible(true);

                // When the popup frame is closed
                popUp.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Enable input events of the parent frame
                    	parent.setVisible(true);
                        parent.setEnabled(true);
                    }
                });
            }
            fireEditingStopped();
        }
    }
    

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}


}
