/**
 * 
 */
package edu.formation.agence;

/**
 * @author ajc
 *
 * Cet classe de type enum permet de définir deux états : annulée ou confirmée
 */
 public enum EtatReservation {
	
	Annulee("annulée"), 
	Confirmee("confirmée");
	
	private String etat;
	
	private EtatReservation(String aEtat){
		this.etat=aEtat;
	}
	
	@Override
	public String toString() {
		return this.etat;
	}
}
