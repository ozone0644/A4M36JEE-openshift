package cz.cvut.fel.exception;

import javax.xml.ws.WebFault;

/**
 * <p>Reservation is not canceled, required operation is not allowed.</p>
 *
 * @author Karel Cemus
 */
@WebFault( name = "ReservationNotCanceledExceptionFault" )
public class ReservationNotCanceledException extends Exception {

    public ReservationNotCanceledException() {
    }

    public ReservationNotCanceledException( final String message ) {
        super( message );
    }

    public ReservationNotCanceledException( final String message, final Throwable cause ) {
        super( message, cause );
    }
}
