/**
 * 
 */
package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import edu.formation.agence.Adresse;

/**
 * @author ajc
 *
 */
public class AdresseDAO implements ILectureFichiers<Adresse>{
	
	private BufferedReader buffer_in;
	
	public AdresseDAO(String path) throws FileNotFoundException {
		File fichier_entree = new File(path);
		FileReader fileReader_entree = new FileReader(fichier_entree);
		this.buffer_in = new BufferedReader(fileReader_entree);
	}
	
	@Override
	public List<Adresse> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
