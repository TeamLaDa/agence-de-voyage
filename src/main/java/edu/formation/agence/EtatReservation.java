/**
 * 
 */
package edu.formation.agence;

/**
 * @author ajc
 *
 *Cet classe de type enum permet de d�finir deux �tats : annul�e ou confirm�e
 */
public enum EtatReservation {
	
	Annulee("annul�e"), 
	Confirmee("confirm�e");
	
	private String etat;
	
	private EtatReservation(String aEtat){
		this.etat=aEtat;
	}

	public String toString(){
		return this.etat;
	}
}