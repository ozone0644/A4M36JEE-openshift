package cz.cvut.fel.service.flight;

import cz.cvut.fel.model.Flight;

import javax.jws.WebParam;
import java.util.Collection;
import java.util.Date;

/**
 * API poskytující seznamy letů
 *
 * @author Karel Cemus
 */
public interface FlightService {

    /** najde let s daným číslem */
    Flight find(
            @WebParam( name = "flightNumber" ) String flightNumber
    );

    /** Vrací všechny lety, které jsou zavedené v systému společnosti */
    Collection<Flight> findAllFlights();

    /** všechny lety z dané oblasti v daném rozsahu dní */
    Collection<Flight> findFlightsFrom(
            @WebParam( name = "intervalFrom" ) Date intervalFrom,
            @WebParam( name = "intervalTo" ) Date intervalTo,
            @WebParam( name = "codeFrom" ) String codeFrom
    );

    /** všechny lety do dané oblasti v daném rozsahu dní */
    Collection<Flight> findFlightsTo(
            @WebParam( name = "intervalFrom" ) Date intervalFrom,
            @WebParam( name = "intervalTo" ) Date intervalTo,
            @WebParam( name = "codeTo" ) String codeTo
    );

    /** všechny lety mezi destinacemi v daném rozsahu dní */
    Collection<Flight> findFlights(
            @WebParam( name = "intervalFrom" ) Date intervalFrom,
            @WebParam( name = "intervalTo" ) Date intervalTo,
            @WebParam( name = "codeFrom" ) String codeFrom,
            @WebParam( name = "codeTo" ) String codeTo
    );
}