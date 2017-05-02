package Interface;

import java.util.List;

import Interface.Dao;
import edu.formation.agence.Passager;
import edu.formation.agence.Reservation;

public interface ReservationDao extends Dao<Reservation, Integer>
{
    /**
     * Retourne la liste des réservations en fonction d'un passager
     * 
     * @param passager
     *            Le passager
     * @return Liste des réservations en fonction du passager passé en paramètre
     */
    public List<Reservation> findByPassager(Passager passager);
}
