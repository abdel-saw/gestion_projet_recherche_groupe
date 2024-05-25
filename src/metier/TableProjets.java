package metier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class TableProjets extends JPanel {
    private JTable table;
    Connection conn = Utilitaire.getConnection();

    Vector<Object[]> fetchProjects(int id) {
        Vector<Object[]> projets = new Vector<>(); 

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT p.IdProjet AS idp, p.nom_court AS npc, p.theme AS tm,"
            		+ " p.type AS tp, p.etat AS et, isPublic AS isp, g.IdGroupe AS idg, g.nom_groupe AS ng ,IF(g.nom_groupe LIKE '%-adm', 'Admin', 'Member') AS role FROM projet AS p,"
            		+ " groupe AS g, utilisateur AS u, utilisateur_groupe AS ug WHERE u.IdUtilisateur = ? AND ug.IdUtilisateur = u.IdUtilisateur "
            		+ "AND g.IdGroupe = ug.IdGroupe AND (g.nom_groupe IN (p.nom_court , CONCAT(p.nom_court,'-adm') ))");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String isPublicValue = rs.getBoolean("isp") ? "public" : "privé"; // Convert boolean to "public" or "privé"
                Object[] row = {
                    rs.getInt("idp"),
                    rs.getString("npc"),
                    rs.getString("tm"),
                    rs.getString("tp"),
                    rs.getString("et"),
                    isPublicValue, // Use the converted value
                    rs.getString("role")
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
            column.setMinWidth(getPreferredColumnWidth(i) + 10); // 20 pixels padding on each side
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

    public TableProjets(int id) {
        setLayout(new BorderLayout());

        String[] columns = {"IdProject", "nom_long", "theme", "type", "etat", "visibility","role", "actions"};

        Vector<Object[]> projet = fetchProjects(id);

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 7) {
                    return JButton.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };

        for (Object[] o : projet) {
            model.addRow(o);
        }

        table = new JTable(model);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));

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

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            //setOpaque(true);
            setBorder(new EmptyBorder(5, 10, 5, 10));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setIcon(new ImageIcon(getClass().getResource("assets/view.png")));
            setText((value == null) ? "" : value.toString());
            setBackground(Color.WHITE);
            return this;
        }
    }

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
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
                int row = table.getEditingRow();
                int value = (int) table.getValueAt(row, 0);
                String type = (String) table.getValueAt(row, 5);
                JFrame frame = new JFrame();
                frame.setLocationRelativeTo(null);
                frame.setSize(520, 400);
                frame.setVisible(true);

                
            }
            isPushed = false;
            return label;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
        }
    }
}
