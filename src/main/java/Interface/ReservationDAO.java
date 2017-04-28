/**
 * 
 */
package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import edu.formation.agence.Reservation;

/**
 * @author ajc
 *
 */
public class ReservationDAO implements ILectureFichiers<Reservation>{
	
	private BufferedReader buffer_in;
	
	public ReservationDAO(String path) throws FileNotFoundException {
		File fichier_entree = new File(path);
		FileReader fileReader_entree = new FileReader(fichier_entree);
		this.buffer_in = new BufferedReader(fileReader_entree);
	}
	
	@Override
	public List<Reservation> findAll() {
		
		return null;
	}

	@Override
	public Reservation findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
