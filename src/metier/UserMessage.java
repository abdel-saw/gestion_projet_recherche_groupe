package metier;
import java.sql.*;;

public class UserMessage 
{
	protected String sender ;
	protected java.util.Date date_envoi ;
	protected Time heure_envoie ;
	protected String content ;
	protected String project_name ;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public java.util.Date getDate_envoi() {
		return date_envoi;
	}
	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}
	public Time getHeure_envoie() {
		return heure_envoie;
	}
	public void setHeure_envoie(Time heure_envoie) {
		this.heure_envoie = heure_envoie;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGroupe_name() {
		return project_name;
	}
	public void setGroupe_name(String groupe_name) {
		this.project_name = groupe_name;
	}
	public UserMessage(String sender, java.util.Date dateEnvoi, Time heure_envoie, String content, String groupe_name) {
		super();
		this.sender = sender;
		this.date_envoi = dateEnvoi;
		this.heure_envoie = heure_envoie;
		this.content = content;
		this.project_name = groupe_name;
	}

}