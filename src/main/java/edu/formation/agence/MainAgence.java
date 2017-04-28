/**
 * 
 */
package edu.formation.agence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import Interface.AdresseDAO;

/**
 * @author ajc
 *
 */
public class MainAgence {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		String path = "fichiers/adresses.csv";
		
		AdresseDAO adressefile = new AdresseDAO(path);
		List<Adresse> adresseTest = adressefile.findAll();
		System.out.println(adresseTest);
		
		
//		FileReader fr = new FileReader(f1);
//		BufferedReader br = new BufferedReader(fr);
//		
//		String c;
//		
//		while ((c=adressefile.readLine() != null) {
//			System.out.println(c);
//		}
//		
//		br.close();
//		fr.close();
		
	}

}
