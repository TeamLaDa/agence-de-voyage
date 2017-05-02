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
		
		// Initialiser ma liste d'adresses
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
			System.out.println(resultSet);
			
			/*
			 * Etape 4 : Parcours des reusltats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peur être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// Je crée l'objet adresse
				Adresse adresse = new Adresse();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erreur lors de la connexion à la BDD !");
			e.printStackTrace();
		}

		return null;
		
	}

	/* (non-Javadoc)
	 * @see agence.dao.Dao#findById(java.lang.Object)
	 */
	@Override
	public Adresse findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
