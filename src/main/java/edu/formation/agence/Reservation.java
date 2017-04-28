/**
 * 
 */
package edu.formation.agence;

import java.sql.Date;

/**
 * @author ajc
 *
 */
public class Reservation {
	
	Integer id;
	Date date;
	Integer numero;
	EtatReservation etat;
	
	
	
	/**
	 * @param id
	 * @param date
	 * @param numero
	 * @param etat
	 */
	public Reservation(Integer id, Date date, Integer numero, EtatReservation etat) {
		this.id = id;
		this.date = date;
		this.numero = numero;
		this.etat = etat;
	}
	
	
	public void afficherInfos() {
		System.out.println("Les informations de la réservations sont : ");
		System.out.println("\t - identifiant : " + id);
		System.out.println("\t - date : " + date);
		System.out.println("\t - numero " + numero);
		System.out.println("\t - etat : " + etat);
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}



	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}



	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	/**
	 * @return the etat
	 */
	public EtatReservation getEtat() {
		return etat;
	}



	/**
	 * @param etat the etat to set
	 */
	public void setEtat(EtatReservation etat) {
		this.etat = etat;
	}
	
	
	
	
	

}
