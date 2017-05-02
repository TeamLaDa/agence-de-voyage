/**
 * 
 */
package Interface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import edu.formation.agence.Adresse;

/**
 * @author ajc
 *
 */
public class AdresseDaoSql implements AdresseDao {

	/* (non-Javadoc)
	 * @see agence.dao.Dao#findAll()
	 */
	@Override
	public List<Adresse> findAll() {
		
		// Initialisation de ma liste ListeAdresse de type Adresse
		List<Adresse> ListeAdresse = new ArrayList<Adresse>();
		
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * Etape 1 : se connecter à la BDD 
			 */
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencedevoyage", "user", "password");
			
			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();
			
			/*
			 * Etape 3 : Execution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM adresse");
			
			/*
			 * Etape 4 : Parcours des reusltats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peur être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// Je crée l'objet adresse
				Adresse adresse = new Adresse();
				// Appel des mutateurs
				adresse.setIdAdd(resultSet.getInt("idAdd"));
				adresse.setAdresse(resultSet.getString("adresse"));
				adresse.setCodePostal(resultSet.getString("codePostal"));
				adresse.setVille(resultSet.getString("ville"));
				adresse.setPays(resultSet.getString("pays"));
				// J'ajoute l'objet adresse ainsi muté à la liste des adresses
				ListeAdresse.add(adresse);
			}
			
			connexion.close();
			
			
			
		} catch (ClassNotFoundException e) {
			System.err.println("La classe de l'objet est introuvable.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur lors de la connexion à la BDD !");
			e.printStackTrace();
		} 

		// Je retourne la liste des adresses de la BDDonnées
		return ListeAdresse;
		
	}

	/* (non-Javadoc)
	 * @see agence.dao.Dao#findById(java.lang.Object)
	 */
	@Override
	public Adresse findById(Integer id) {
		// Initialisation de mon objet adresse de type Adresse
		Adresse adresse = new Adresse();
		// Initialisation de l'objet connexion de type Connection
		Connection connexion = null;
		
		
		try {
			/*
			 * Etape 0 : chargement du pilote
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * Etape 1 : se connecter à la BDD 
			 */
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencedevoyage", "user", "password");
			
			/*
			 * Etape 2 : Création du statement
			 */
			Statement statement = connexion.createStatement();
			
			/*
			 * Etape 3 : Execution de la requête SQL
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM adresse");
			
			/*
			 * Etape 4 : Parcours des reusltats
			 */
			
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peur être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne

				
				if (resultSet.getInt("idAdd") == id){
					// Appel des mutateurs
					adresse.setIdAdd(resultSet.getInt("idAdd"));
					adresse.setAdresse(resultSet.getString("adresse"));
					adresse.setCodePostal(resultSet.getString("codePostal"));
					adresse.setVille(resultSet.getString("ville"));
					adresse.setPays(resultSet.getString("pays"));
					// J'ajoute l'objet adresse ainsi muté à la liste des adresses
					// Adressespecifique.add(adresse);
				}
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.err.println("La classe de l'objet est introuvable.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur lors de la connexion à la BDD !");
			e.printStackTrace();
		} finally {
			if (connexion != null) {
				
			}try {
				connexion.close();
			} catch (Exception e2) {
				System.err.println("Le fichier ne peut pas être fermé !");
				e2.printStackTrace();
			}
		}

		// Je retourne la liste des adresses de la BDDonnées
		return adresse;
		
	
	}

}
