/**
 * 
 */
package Main;

import java.util.List;

import Interface.AdresseDao;
import Interface.AdresseDaoSql;
import Interface.PassagerDao;
import Interface.PassagerDaoSql;
import Interface.ReservationDao;
import Interface.ReservationDaoSql;
import edu.formation.agence.Adresse;
import edu.formation.agence.Passager;
import edu.formation.agence.Reservation;

/**
 * @author ajc
 *
 */
public class MainDB {

	/**
	 * Méthode principale quie va faire appel à toutes les méthodes
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			/*
			 * Série de tests pour l'adresse
			 */
			// J'initialise le dao SQL adresses
			AdresseDao adresseDao = new AdresseDaoSql();
			// J'appelle la methode findAll pour récupérer toutes les adresses stockées
			List<Adresse> listeAdresses = adresseDao.findAll();
			// Affiche un exemple
			listeAdresses.get(3).afficherInfos();
			
			// j'appelle la méthode findById pour récupérer l'adresse du passager sélectionné
			Adresse adresse = adresseDao.findById(1);
			// Affiche un exemple
			adresse.afficherInfos();
			
			
			/*
			 * Série de tests pour la réservation
			 */
			// J'initialise le dao SQL reservation
			ReservationDao reservationDao = new ReservationDaoSql();
			// J'appelle la methode findAll pour récupérer toutes les adresses stockées
			List<Reservation> listeReservation = reservationDao.findAll();
			// Affiche un exemple
			listeReservation.get(3).afficherInfos();
			
			// j'appelle la méthode findById pour récupérer l'adresse du passager sélectionné
			Reservation reservation = reservationDao.findById(40);
			// Affiche un exemple
			reservation.afficherInfos();
			
			
			
			/*
			 * Série de tests pour les passagers
			 */
			
			PassagerDao passagerDao = new PassagerDaoSql();
			
			List<Passager> listePassagers = passagerDao.findAll();
			listePassagers.get(2).afficherInfos();
			listePassagers.get(3).afficherInfos();
			
			System.out.println("Adresse du passager :");
			listePassagers.get(3).getAdresse().afficherInfos();
			
			Passager passager = passagerDao.findById(22);
			passager.afficherInfos();
			
			//Test pour un mauvais id
			passager = passagerDao.findById(2);
			passager.afficherInfos();
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.err.println("Erreur dans la lecture des données. Verifiez que vous avez bien entré les bons identifiants");
		}
	}

}
