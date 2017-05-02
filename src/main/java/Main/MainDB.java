/**
 * 
 */
package Main;

import java.util.List;

import Interface.AdresseDao;
import Interface.AdresseDaoSql;
import edu.formation.agence.Adresse;

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
		System.out.println(listeAdresses.get(3));
		
		// j'appelle la méthode findById pour récupérer l'adresse du passager sélectionné
		Adresse adresse = adresseDao.findById(1);
		// Affiche l'exemple
		System.out.println(adresse);
	}

}
