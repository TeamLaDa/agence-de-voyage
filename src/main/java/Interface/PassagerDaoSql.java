package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import edu.formation.agence.Passager;

public class PassagerDaoSql implements PassagerDao {

	@Override
	public List<Passager> findAll() {
		
		List<Passager> listePassagers = new ArrayList<>();
		AdresseDao adresseDao = new AdresseDaoSql();
		Connection connection = null;
			
		try {
			/*
			 * Etape 0 : Chargement du pilode
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * Etape 1 : on crée la connexion
			 */
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence_voyage", "user", "password");
			
			/*
			 * Etape 2 : Creation du Statement
			 */
			
			//Un statement est un objet permettant de déclarer une requete SQL (au depart c'est une chaine de caractère)
			java.sql.Statement statement = connection.createStatement();
			
			/*
			 * Etape 3 : execution de la requete
			 */
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM passager");
			
			/*
			 * Etape 4 : parcours des resultats
			 */
			
			
			while (resultSet.next()) {
				
				Passager passager = new Passager(resultSet.getInt("idPassager"));
				passager.setNom(resultSet.getString("nom"));
				passager.setPrenom(resultSet.getString("prenom"));		
				
				passager.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));
				
				listePassagers.add(passager);				
			}
			
			connection.close();
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Impossible de se connnecter à la BDD.");
			e.printStackTrace();
		}
				
		return listePassagers;
		
	}

	@Override
	public Passager findById(Integer id) {
		
		AdresseDao adresseDao = new AdresseDaoSql();
		Connection connection = null;
		Passager passager = null;
			
		try {
			
			/*
			 * Etape 0 : Chargement du pilode
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * Etape 1 : on crée la connexion
			 */
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agence_voyage", "user", "password");
			
			/*
			 * Etape 2 : Creation du Statement
			 */
			
			//Un statement est un objet permettant de déclarer une requete SQL (au depart c'est une chaine de caractère)
			java.sql.Statement statement = connection.createStatement();
			
			/*
			 * Etape 3 : execution de la requete
			 */
			
			//On convertit l'identifiant rentré en argument en String, pour passer dans la requete SQL
			String id_Passager = String.valueOf(id);
			
			//La requete permet de récuperer les informations au numéro de ligne demandé
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `passager` WHERE idPassager="+id_Passager);
			
			/*
			 * Etape 4 : on récupere les informations associées à l'identifiant donné
			 */
			
				
			while (resultSet.next()) {
				passager = new Passager(id);
				passager.setNom(resultSet.getString("nom"));
				passager.setPrenom(resultSet.getString("prenom"));		
				
				passager.setAdresse(adresseDao.findById(resultSet.getInt("idAdd")));	
			}	
			
			connection.close();
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Impossible de charger le pilote JDBC.");
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Impossible de se connnecter à la BDD.");
			e.printStackTrace();
		}
		
		return passager;
	}

}
