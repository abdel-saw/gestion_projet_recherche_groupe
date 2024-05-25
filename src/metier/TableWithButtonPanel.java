package metier;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class TableWithButtonPanel extends JPanel {
	private JFrame parent;
    private JTable table;
    Connection conn = Utilitaire.getConnection();
//--------------------------------------------------------------------fetchDemandes---------------------//
    Vector<Object[]> fetchDemandes(){
    	Vector<Object[]> demandes = new Vector<Object[]>(); 
    	
    	try {
    		
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT IdDemande, username, nom_court_projet, theme_projet, date_demande, type, etat, IdUtilisateur FROM DEMANDE");

            
            while (rs.next()) {
            	/*String etatValue = rs.getString(6); // Assuming the enum value is stored as a string in the database
                Etat etat;
                if ("creation".equalsIgnoreCase(etatValue)) {
                    etat = Etat.CREATION;
                } else if ("ouvert".equalsIgnoreCase(etatValue)) {
                    etat = Etat.CLOSURE;
                } else {
                    // Handle unknown enum values or error cases
                    etat = null; // Or throw an exception
                }*/
            	
            	//Etat etatValue = Etat.PENDING;
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
    public Vector<Object[]> fetchDemandesAccepeted(){
    	Vector<Object[]> demandes = new Vector<Object[]>(); 
    	
    	try {
    		
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT IdDemande, username, nom_court_projet, theme_projet, date_demande, type, etat FROM DEMANDE");

            
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
    public TableWithButtonPanel(JFrame parent) {
    	this.parent = parent;
        setLayout(new BorderLayout());

        // Create sample data for the table
        
        // Column names
        String[] columns = {"Id_demande", "username", "nom_project", "theme", "Date", "Type", "Actions"};

        // Create a table model with button column
        Object[][] data = {
            };
        Vector<Object[]> demandes = fetchDemandes();
        
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
        table.getColumnModel().getColumn(6).setPreferredWidth(30);////////////////////////////////////////////////////!!!!!!!!!/////////////////

        // Add action listener to button column
        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        //table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(this.parent));
        
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

    // Button renderer class
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setBorder(new EmptyBorder(5, 10, 5, 10)); // Add padding to the button
            
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        	setIcon(new ImageIcon(getClass().getResource("assets/view.png")));
        	setText((value == null) ? "" : value.toString());
            //setForeground(Color.BLACK);
            setBackground(Color.WHITE);
            return this;
        }
    }

    // Button editor class

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JButton button;
        private String label;
        private boolean isPushed;
        private JFrame parent;

        public ButtonEditor(JFrame parent) {
        	this.parent = parent;
            button = new JButton();
            button.setOpaque(true);
            button.setBorder(new EmptyBorder(5, 10, 5, 10)); // Add padding to the button
            button.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Open a new JFrame when button is clicked
            	int row = table.getEditingRow(); // Get the index of the editing row
                int value = (int) table.getValueAt(row, 0); // Get the value of the first column in the editing row
                String type = (String) table.getValueAt(row, 5);
                JFrame frame = new DemandeOverview(value, type, true);
                frame.setLocationRelativeTo(null);
                frame.setSize(520,400);
                
                parent.setEnabled(false);

                // Show popup frame
                frame.setVisible(true);

                // When the popup frame is closed
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Enable input events of the parent frame
                    	parent.setVisible(true);
                        parent.setEnabled(true);
                    }
                });
                 
                
                
                
            }
            isPushed = false;
            return label;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
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
