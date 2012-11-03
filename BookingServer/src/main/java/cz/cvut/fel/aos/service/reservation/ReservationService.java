package cz.cvut.fel.aos.service.reservation;

import cz.cvut.fel.aos.model.Reservation;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * API pro přístup k rezervacím. Umožňuje jejich tvorbu a aktualizaci
 *
 * @author Karel Cemus
 */

@WebService
public interface ReservationService {

    /** najde rezervaci s daným číslem. Kontroluje oprávnění přístupu heslem v podobně SHA-1 */
    Reservation find(
            @WebParam( name = "reservation" ) long reservation,
            @WebParam( name = "password" ) String password
    ) throws SecurityException;


    /** vytvoří rezervaci na let pro daný počet míst. Nastaví i heslo pro přístup v podobě SHA-1 */
    Reservation create(
            @WebParam( name = "flightNumber" ) String flightNumber,
            @WebParam( name = "password" ) String password,
            @WebParam( name = "count" ) int count
    ) throws FullFlightException;


    /** zruší rezervaci, pokud má klient oprávnění. Heslo v podobně SHA-1 */
    boolean cancel(
            @WebParam( name = "reservation" ) long reservation,
            @WebParam( name = "password" ) String password
    ) throws SecurityException;
}