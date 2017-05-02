/**
 * 
 */
package agence;

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
		
		// J'initialise le dao SQL adresses
		AdresseDao adresseDao = new AdresseDaoSql();
		
		// J'appelle la methode findAll pour récupérer toutes les adresses stockées
		List<Adresse> listeAdresses = adresseDao.findAll();
	}

}
