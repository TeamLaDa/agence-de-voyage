/**
 * 
 */
package edu.formation.agence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Interface.AdresseDAO;
import Interface.PassagerDAO;

/**
 * @author ajc
 *
 */
public class MainAgence {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String pathpassager = "fichiers/passagers.csv";
		PassagerDAO passagerfile = new PassagerDAO(pathpassager);
		
		
		String pathadresse = "fichiers/adresses.csv";;
		AdresseDAO  adresseDAO = new AdresseDAO(pathadresse);
		
		passagerfile.setAdresseDAO(adresseDAO);
		
		List<Passager> passagerTest = passagerfile.findAll();

		for (Passager passager : passagerTest) {
			passager.afficherInfos();
		}
		
		
//		FileReader fr = new FileReader(f1);
//		BufferedReader br = new BufferedReader(fr);
//		
//		String c;
		
		
//				List<Passager> passagerTest = passagerfile.findAll();

		
		
//		while ((c=adressefile.readLine() != null) {
//			System.out.println(c);
//		}
//		
//		br.close();
//		fr.close();
		
	}

}
