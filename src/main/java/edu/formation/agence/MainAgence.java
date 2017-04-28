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
		
		String path = "fichiers/passagers.csv";
		
		PassagerDAO passagerfile = new PassagerDAO(path);
		List<Passager> passagerTest = passagerfile.findAll();
		System.out.println(passagerTest);
		
		
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
