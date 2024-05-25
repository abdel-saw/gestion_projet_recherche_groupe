package metier;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author IDIR
 */

public class ProjectPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel descriptionLabel;

    public ProjectPanel(String name, String description) {
        this.nameLabel = new JLabel("Name: " + name);
        this.descriptionLabel = new JLabel("Description: " + description);

        this.setLayout(new GridLayout(2, 1));
        this.add(nameLabel);
        this.add(descriptionLabel);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}