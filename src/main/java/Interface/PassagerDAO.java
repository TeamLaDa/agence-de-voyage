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

import edu.formation.agence.Passager;

/**
 * @author ajc
 *
 */
public class PassagerDAO implements ILectureFichiers<Passager>{
	
	private BufferedReader buffer_in;
	private AdresseDAO adresseDAO;
	
	public PassagerDAO(String path) throws FileNotFoundException {
		File fichier_entree = new File(path);
		FileReader fileReader_entree = new FileReader(fichier_entree);
		this.buffer_in = new BufferedReader(fileReader_entree);
	}
	
	@Override
	public List<Passager> findAll() throws IOException{
		String op;
		List<Passager> liste_passager = new ArrayList<>();
		
		while((op = this.buffer_in.readLine()) != null){
			String tab_op[] = op.split(";");
			Passager passager = new Passager(tab_op[1], tab_op[2]);
			
			int id_adresse = Integer.parseInt(tab_op[3]);
			passager.setAdresse(adresseDAO.findById(id_adresse));
			
			liste_passager.add(passager);
		}
		this.buffer_in.close();
		return liste_passager;
	}

	@Override
	//Il faut rajouter des exceptions si l'id depasse le nombre de lignes
	public Passager findById(Integer id) throws IOException {
		// TODO Auto-generated method stub
		String op;
		op = this.buffer_in.readLine();
		Passager passager = new Passager();
		
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
	
	
	public void setAdresseDAO(AdresseDAO adresseDAO){
		this.adresseDAO = adresseDAO;
	}

}
