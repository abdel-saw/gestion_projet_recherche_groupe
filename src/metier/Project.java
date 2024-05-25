package metier;

import java.util.*;
//import metier.*;


public class Project {
    
    private int IdProjet;
    private String nom_court;
    private String nom_long;
    private String description;
    private String theme;
    private Typep type;
    private boolean isPublic;
    private Etat etat;
    private Date date_creation;
    public Project(int id, String n_court, String n_long, String descp, String theme, Typep type, boolean isPublic, Etat etat, Date date){
        this.IdProjet = id;
        this.nom_court = n_court;
        this.nom_long = n_long;
        this.description = descp;
        this.theme = theme;
        this.type = type;
        this.etat = etat;
        this.isPublic = isPublic;
        this.date_creation = date;
    }

    public int getIdProjet() {
        return IdProjet;
    }

    public void setIdProjet(int IdProjet) {
        this.IdProjet = IdProjet;
    }

    public String getNom_court() {
        return nom_court;
    }

    public void setNom_court(String nom_court) {
        this.nom_court = nom_court;
    }

    public String getNom_long() {
        return nom_long;
    }

    public void setNom_long(String nom_long) {
        this.nom_long = nom_long;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Typep getType() {
        return type;
    }

    public void setType(Typep type) {
        this.type = type;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }
    

    
    
   
}



