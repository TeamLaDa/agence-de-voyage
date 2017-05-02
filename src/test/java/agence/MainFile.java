package agence;

import java.util.List;

import Interface.AdresseDao;
import Interface.AdresseDaoFile;
import Interface.PassagerDao;
import Interface.PassagerDaoFile;
import Interface.ReservationDao;
import Interface.ReservationDaoFile;
import edu.formation.agence.Adresse;
import edu.formation.agence.Passager;
import edu.formation.agence.Reservation;

public class MainFile
{

    public static void main(String[] args)
    {
        AdresseDao adresseDao = new AdresseDaoFile();
        List<Adresse> adresses = adresseDao.findAll();
        Adresse adresse = adresseDao.findById(2);

        PassagerDao passagerDao = new PassagerDaoFile();
        List<Passager> passagers = passagerDao.findAll();
        Passager passager = passagerDao.findById(1);

        ReservationDao reservationDao = new ReservationDaoFile();
        List<Reservation> reservations = reservationDao.findAll();
        Reservation reservation = reservationDao.findById(2);
        // Recherche par passager
        List<Reservation> reservationsPassager = reservationDao.findByPassager(passager);
    }

}
