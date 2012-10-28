package cz.cvut.fel.aos.payment.service.payment;

import javax.xml.ws.WebFault;


/** This class was generated by Apache CXF 2.3.1 Sun Oct 28 21:23:36 CET 2012 Generated source version: 2.3.1 */

@WebFault( name = "InvalidPaymentFault", targetNamespace = "http://payment.service.payment.aos.fel.cvut.cz/" )
public class InvalidPaymentException extends Exception {

    public static final long serialVersionUID = 20121028212336L;

    private cz.cvut.fel.aos.payment.service.payment.InvalidPaymentFault invalidPaymentFault;

    public InvalidPaymentException() {
        super();
    }

    public InvalidPaymentException( String message ) {
        super( message );
    }

    public InvalidPaymentException( String message, Throwable cause ) {
        super( message, cause );
    }

    public InvalidPaymentException( String message, cz.cvut.fel.aos.payment.service.payment.InvalidPaymentFault invalidPaymentFault ) {
        super( message );
        this.invalidPaymentFault = invalidPaymentFault;
    }

    public InvalidPaymentException( String message, cz.cvut.fel.aos.payment.service.payment.InvalidPaymentFault invalidPaymentFault, Throwable cause ) {
        super( message, cause );
        this.invalidPaymentFault = invalidPaymentFault;
    }

    public cz.cvut.fel.aos.payment.service.payment.InvalidPaymentFault getFaultInfo() {
        return this.invalidPaymentFault;
    }
}
