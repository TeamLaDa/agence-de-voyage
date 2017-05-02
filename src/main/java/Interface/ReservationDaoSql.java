/**
 * 
 */
package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.formation.agence.Adresse;
import edu.formation.agence.EtatReservation;
import edu.formation.agence.Passager;
import edu.formation.agence.Reservation;

/**
 * @author ajc
 *
 */
public class ReservationDaoSql implements ReservationDao {

	/* (non-Javadoc)
	 * @see Interface.Dao#findAll()
	 */
	@Override
	public List<Reservation> findAll() {
		// Initialiser ma liste d'adresses
		List<Reservation> ListeReservation = new ArrayList<Reservation>();
		
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM reservation");

			/*
			 * Etape 4 : Parcours des reusltats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peur être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				// Je crée l'objet adresse
				Reservation reservation = new Reservation(resultSet.getInt("idResa"));

				// Appel des mutateurs
				reservation.setIdRes(resultSet.getInt("idResa"));
				reservation.setDate(resultSet.getDate("dateReservation"));
				reservation.setNumero(resultSet.getString("numero"));
				if (resultSet.getString("etat").equals(EtatReservation.ANNULEE.getLabel())) {
                    reservation.setEtat(EtatReservation.ANNULEE);
                }
                else
                {
                    reservation.setEtat(EtatReservation.CONFIRMEE);
                }
				// J'ajoute l'objet adresse ainsi muté à la liste des adresses
				ListeReservation.add(reservation);
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
		return ListeReservation;
		
	}

	
	
	
	
	
	/* (non-Javadoc)
	 * @see Interface.Dao#findById(java.lang.Object)
	 */
	@Override
	public Reservation findById(Integer id) {
		// Initialisation de mon objet resservation de type Reservation
        Reservation resservation = null;
        // Initialisation de ma connexion
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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM reservation");

			/*
			 * Etape 4 : Parcours des reusltats
			 */
			while (resultSet.next()) {
				// Chaque ligne du tableau de résultat peur être exploitée
				// cad, on va récupérer chaque valeur de chaque colonne
				if (resultSet.getInt("idResa") == id){
					// Appel des mutateurs
					resservation = new Reservation(id);
					resservation.setDate(resultSet.getDate("dateReservation"));
					resservation.setNumero(resultSet.getString("numero"));
					if (resultSet.getString("etat").equals(EtatReservation.ANNULEE.getLabel())) {
						resservation.setEtat(EtatReservation.ANNULEE);
	                }
	                else
	                {
	                	resservation.setEtat(EtatReservation.CONFIRMEE);
	                }
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
		
		
		// Je retourne l'objet resservation de type Reservation
		return resservation;


	}

	
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see Interface.ReservationDao#findByPassager(edu.formation.agence.Passager)
	 */
	@Override
	public List<Reservation> findByPassager(Passager passager) {
		return null;
	}

}
