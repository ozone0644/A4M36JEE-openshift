package cz.cvut.fel.aos.bookingserver.service.destination;

import cz.cvut.fel.aos.bookingserver.model.Destination;

import javax.jws.WebService;
import java.util.Collection;

/**
 * API poskytující přístup k možným destinacím letů
 *
 * @author Karel Cemus
 */
@WebService
public interface DestinationService {

    /** Vrací všechny destinace, do kterých společnost létá */
    Collection<Destination> findAll();
}