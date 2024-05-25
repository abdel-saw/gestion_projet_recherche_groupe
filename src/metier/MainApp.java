package metier;
//import metier.*;

import java.util.Iterator;
import java.util.Scanner;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;


public class MainApp {
    
	public static void display(){
            Iterator<Utilisateur> iterateur;
            System.out.println("**************************************************");
		//idUser +" \t "+ username +" \t " + " \t " + email + " \t " + name + " \t " + prenom
		System.out.println("**ID_Utilisateur\t UserName\t EMAIL\t FullName**\n");
		System.out.println("**************************************************");
                Utilisateur user = new Utilisateur();
		iterateur =  user.displayUsers().iterator();
		while(iterateur.hasNext()) {
			Utilisateur u = iterateur.next();
			u.affiche();
		}
        }
	/*public static void main(String[] args) {
		//Operateur o = new Operateur();
		
		
		//System.out.println("Entrer un mot clé : ");
		//Scanner input = new Scanner(System.in);
		//String mot = input.nextLine();
		
		
		//o.ajouterUser("zakariae1", "fhdjrkhj4", "zemat@gmail.com", "Zemat", "Zakariae");
                /*if (!o.userExists("zakariae1")) {
                // User doesn't exist, add them to the database
                    o.ajouterUser("zakariae1", "fhdjrkhj4", "zemat@gmail.com", "Zemat", "Zakariae");
                    System.out.println("User added successfully!");
                } else {
                    System.out.println("User already exists!");
                }*/
                


		//o.ajouterClient(80, "Ali", "Ali@gmail.com", "7894561", "Casablanca");
		//o.reglerFact(1);
                
                //LoginForm frame = new LoginForm();
                //frame.setVisible(true);
                //display();
	//}

}
