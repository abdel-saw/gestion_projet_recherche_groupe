
package metier;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author IDIR
 */



public class ProjectViewer extends JFrame {
    private JPanel mainPanel;

    public ProjectViewer(Vector<Project> projects) {
    setTitle("Project Viewer");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 400);

    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    JScrollPane scrollPane = new JScrollPane(mainPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    JPanel projectGrid = new JPanel();
    projectGrid.setLayout(new GridLayout(0, 2)); // 2 columns, variable number of rows

    for (Project project : projects) {
        projectGrid.add(new ProjectPanel(project.getNom_long(), project.getDescription()));
    }

    mainPanel.add(projectGrid, BorderLayout.CENTER);

    add(scrollPane);
    pack();
    this.setVisible(true);
}


    public static void main(String[] args) {
        // Retrieve projects from the database
        Vector<Project> projects = fetchProjectsFromDatabase();

        SwingUtilities.invokeLater(() -> new ProjectViewer(projects));
        
    }
    public static Vector<Project> fetchProjectsFromDatabase(){
        
        Vector<Project> projects = new Vector<Project>();
        Connection conn = Utilitaire.getConnection();
        try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PROJET");
                while (rs.next()) {
                    String typeValue = rs.getString(8); // Assuming the enum value is stored as a string in the database
                    Typep type;
                    if ("clos".equalsIgnoreCase(typeValue)) {
                        type = Typep.CLOSURE;
                    } else if ("ouvert".equalsIgnoreCase(typeValue)) {
                        type = Typep.CREATION;
                    } else {
                        // Handle unknown enum values or error cases
                        type = null; // Or throw an exception
                    }
                    //projects.add(new Project(rs.getByte(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), type, rs.getBoolean(7), etat, rs.getDate(9)));
                } 
            } catch (Exception e) {
                            System.out.println("Exception : "+ e);
            }
            return projects;
    
    }
}