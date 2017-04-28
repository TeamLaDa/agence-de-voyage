/**
 * 
 */
package edu.formation.agence;

import java.util.List;

/**
 * @author ajc
 *
 */
public class Passager {

	private Integer id;
	private String nom;
	private String prenom;
	private Adresse adresse; // code permettant l'association entre la classe
								// Adresse et Passager
	private List<Reservation> reservationList;

	public static Integer nbPassagers = 0;

	/**
	 * Constructeur par défaut
	 */
	public Passager() {
		this.id = ++nbPassagers;
	}

	/**
	 * Constructeur incluant le nom et le prénom
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public Passager(String nom, String prenom) {
		this.id = ++nbPassagers;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	

	public void afficherInfos(){
		System.out.println("Les informations du passager est : ");
		System.out.println("\t - identification : " + id);
		System.out.println("\t - nom : " + nom);
		System.out.println("\t - prenom : " + prenom);
	}
	
	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the reservationList
	 */
	public List<Reservation> getReservationList() {
		return reservationList;
	}


	/**
	 * @return the nbPassagers
	 */
	public static Integer getNbPassagers() {
		return nbPassagers;
	}

}
