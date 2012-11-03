package cz.cvut.fel.aos.service.payment;

import javax.xml.ws.WebFault;


/** This class was generated by Apache CXF 2.3.1 Sat Nov 03 16:20:34 CET 2012 Generated source version: 2.3.1 */

@WebFault( name = "NoSuchReservationFault", targetNamespace = "http://payment.service.aos.fel.cvut.cz/" )
public class NoSuchReservationException extends Exception {

    public static final long serialVersionUID = 20121103162034L;

    private cz.cvut.fel.aos.service.payment.NoSuchReservationFault noSuchReservationFault;

    public NoSuchReservationException() {
        super();
    }

    public NoSuchReservationException( String message ) {
        super( message );
    }

    public NoSuchReservationException( String message, Throwable cause ) {
        super( message, cause );
    }

    public NoSuchReservationException( String message, cz.cvut.fel.aos.service.payment.NoSuchReservationFault noSuchReservationFault ) {
        super( message );
        this.noSuchReservationFault = noSuchReservationFault;
    }

    public NoSuchReservationException( String message, cz.cvut.fel.aos.service.payment.NoSuchReservationFault noSuchReservationFault, Throwable cause ) {
        super( message, cause );
        this.noSuchReservationFault = noSuchReservationFault;
    }

    public cz.cvut.fel.aos.service.payment.NoSuchReservationFault getFaultInfo() {
        return this.noSuchReservationFault;
    }
}