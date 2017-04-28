/**
 * 
 */
package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		// TODO Auto-generated method stub
		String op;
		
		op = this.buffer_in.readLine();
		List<Adresse> adresses = new ArrayList<>();
		
		while((op = this.buffer_in.readLine()) != null){
			String tab_op[] = op.split(";");
			Adresse adresse = new Adresse(tab_op[1], tab_op[2], tab_op[3], tab_op[4]);
			adresses.add(adresse);
		}
		this.buffer_in.close();
		return adresses;
	}

	@Override
	public Adresse findById(Integer id) throws IOException {
		// TODO Auto-generated method stub
		String op;
		op = this.buffer_in.readLine();
		Adresse adresse = new Adresse();
		
		while((op = this.buffer_in.readLine()) != null){
			String tab_op[] = op.split(";");
			int id_adresse = Integer.parseInt(tab_op[0]);			
			if(id_adresse == id){
				adresse.setAdresse(tab_op[1]);
				adresse.setCodePostal(tab_op[2]);
				adresse.setVille(tab_op[3]);
				adresse.setPays(tab_op[4]);
			}

		}
		this.buffer_in.close();
		return adresse;
	}

}
