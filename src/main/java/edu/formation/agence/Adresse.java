/**
 * 
 */
package edu.formation.agence;

/**
 * @author ajc
 *
 */
public class Adresse {
	
	public String adresse;
	public String codePostal;
	public String ville;
	public String pays;
	
	
	/**
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param pays
	 */
	public Adresse(String adresse, String codePostal, String ville, String pays) {
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}
	
	
	
	public void afficherInfos(){
		System.out.println("L'adresse du passager est : ");
		System.out.println("\t - adresse : " + adresse);
		System.out.println("\t - code postal : " + codePostal);
		System.out.println("\t - ville : " + ville);
		System.out.println("\t - pays : " + pays);
	}


	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}


	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}


	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}


	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

}
