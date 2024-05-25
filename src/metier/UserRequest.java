package metier;
import java.sql.Date;

public class UserRequest 
{
	protected String nom_long ;
	protected String description ;
	protected boolean is_public ;
	protected Date date ;
	protected String type ;
	public UserRequest(String nom_long, String description, boolean is_public, Date date, String type, String etat) {
		super();
		this.nom_long = nom_long;
		this.description = description;
		this.is_public = is_public;
		this.date = date;
		this.type = type;
		this.etat = etat;
	}
	protected String etat ;
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
	public boolean isIs_public() {
		return is_public;
	}
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}