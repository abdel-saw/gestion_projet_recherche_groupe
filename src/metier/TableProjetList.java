package metier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class TableProjetList extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JFrame parent;
    private Info info;
    Connection conn = Utilitaire.getConnection();

    Vector<Object[]> fetchProjects(String searchQuery) {
        Vector<Object[]> projets = new Vector<>();
        Vector<Info> infos = new Vector<Info>();
        try {
            String query = "SELECT * FROM projet";
            if (searchQuery != null && !searchQuery.isEmpty()) {
                query += " WHERE nom_court LIKE ?";
            }
            PreparedStatement ps = conn.prepareStatement(query);

            if (searchQuery != null && !searchQuery.isEmpty()) {
                String searchPattern = "%" + searchQuery + "%";
                ps.setString(1, searchPattern);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String isPublicValue = rs.getBoolean("ispublic") ? "public" : "privé";
                Object[] row = {
                    rs.getInt("IdProjet"),
                    rs.getString("nom_court"),
                    rs.getString("theme"),
                    rs.getString("type"),
                    rs.getString("etat"),
                    isPublicValue
                };
                
                
                projets.add(row);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return projets;
    }

    private void setColumnWidths() {
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setMinWidth(getPreferredColumnWidth(i) + 10);
        }
    }

    private int getPreferredColumnWidth(int columnIndex) {
        int maxWidth = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, columnIndex);
            Component comp = renderer.getTableCellRendererComponent(table, table.getValueAt(row, columnIndex), false, false, row, columnIndex);
            maxWidth = Math.max(comp.getPreferredSize().width, maxWidth);
        }
        return maxWidth;
    }

    public TableProjetList(JFrame parent) {
    	this.parent = parent;
        setLayout(new BorderLayout());

        String[] columns = {"IdProject", "Project name", "theme", "type", "state", "visibility", "actions"};

        Vector<Object[]> projet = fetchProjects(null);

        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) {
                    return JPanel.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };

        for (Object[] o : projet) {
            model.addRow(o);
        }

        table = new JTable(model);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setCellRenderer(new ButtonPanelRenderer());
        table.getColumnModel().getColumn(6).setCellEditor(new ButtonPanelEditor(parent));

        setColumnWidths();

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
            return new Dimension(40, 40);
        }
    }
    class ButtonPanelRenderer extends JPanel implements TableCellRenderer {
        private RoundedButton button1;
        private RoundedButton button2;

        public ButtonPanelRenderer() {
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

    class ButtonPanelEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JPanel panel;
        private JButton button1;
        private JButton button2;
        private JFrame parent;
        private int selectedRow;

        public ButtonPanelEditor(JFrame parent) {
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

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {//About the project
                
                try {
                int idDemande = (int) table.getValueAt(selectedRow, 0);
                PreparedStatement pstm = conn.prepareStatement("SELECT * FROM DEMANDE WHERE iddemande = ?");
                pstm.setInt(1, idDemande);
                ResultSet rs = pstm.executeQuery(); 
                //(int iduser, String nom_long, String description, String date, int idprojetAboutPage, String nom_court, String username)
                Info info;
				if (rs.next()) {
					info = new Info(0, rs.getString("nom_long_projet"), rs.getString("description_projet"), "18/05/2024",
							rs.getInt("IdProjet"), rs.getString("nom_court_projet"), "Guest");
					AboutPage frame = new AboutPage(info);frame.setLocationRelativeTo(null);
	                frame.setSize(950, 550);
	                frame.setLocationRelativeTo(null);
	                frame.setVisible(true);
                
				}

                
                
            } catch(SQLException t) {
            	t.printStackTrace();
            }
            } else if (e.getSource() == button2) {//Verification before deleting the project
                int value = (int) table.getValueAt(selectedRow, 0);
                VerifierSupprimeProjet popUp = new VerifierSupprimeProjet(value);
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

    public void updateTableModel(String searchQuery) {
        Vector<Object[]> projets = fetchProjects(searchQuery);
        model.setRowCount(0); // Clear existing rows
        for (Object[] row : projets) {
            model.addRow(row);
        }
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
