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
import edu.formation.agence.Passager;

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
	public Adresse findById(Integer id) {
		// TODO Auto-generated method stub
		String op;
		op = this.buffer_in.readLine();
		Adresse adresse = new Adresse();
		
		while((op = this.buffer_in.readLine()) != null){
			String tab_op[] = op.split(";");
			int id_passager = Integer.parseInt(tab_op[0]);
			
			if(id_passager == id){
				int id_adresse = Integer.parseInt(tab_op[3]);
				passager.setAdresse(adresseDAO.findById(id_adresse));
				passager.setNom(tab_op[1]);
				passager.setPrenom(tab_op[2]);
			}

		}
		this.buffer_in.close();
		return passager;
	}

}
