/**
 * 
 */
package Main;

import java.util.List;

import Interface.AdresseDao;
import Interface.AdresseDaoSql;
import Interface.ReservationDao;
import Interface.ReservationDaoSql;
import edu.formation.agence.Adresse;
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
		Reservation reservation = reservationDao.findById(10);
		// Affiche un exemple
		reservation.afficherInfos();
	}

}
