package cz.cvut.fel.aos.service.reservation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.3.1
 * Wed Oct 24 21:34:41 CEST 2012
 * Generated source version: 2.3.1
 * 
 */
 
@WebService(targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", name = "ReservationService")
@XmlSeeAlso({ObjectFactory.class})
public interface ReservationService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "cancel", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.Cancel")
    @WebMethod
    @ResponseWrapper(localName = "cancelResponse", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.CancelResponse")
    public boolean cancel(
        @WebParam(name = "reservation", targetNamespace = "")
        long reservation,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    ) throws SecurityException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "pay", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.Pay")
    @WebMethod
    @ResponseWrapper(localName = "payResponse", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.PayResponse")
    public cz.cvut.fel.aos.service.reservation.Reservation pay(
        @WebParam(name = "reservation", targetNamespace = "")
        long reservation,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "amount", targetNamespace = "")
        int amount
    ) throws SecurityException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "withdrawCredit", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.WithdrawCredit")
    @WebMethod
    @ResponseWrapper(localName = "withdrawCreditResponse", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.WithdrawCreditResponse")
    public int withdrawCredit(
        @WebParam(name = "reservation", targetNamespace = "")
        long reservation,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "amount", targetNamespace = "")
        int amount
    ) throws SecurityException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "create", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.Create")
    @WebMethod
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.CreateResponse")
    public cz.cvut.fel.aos.service.reservation.Reservation create(
        @WebParam(name = "flightNumber", targetNamespace = "")
        java.lang.String flightNumber,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password,
        @WebParam(name = "count", targetNamespace = "")
        int count
    ) throws FullFlightException;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "find", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.Find")
    @WebMethod
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://reservation.service.booking.aos.fel.cvut.cz/", className = "cz.cvut.fel.aos.service.reservation.FindResponse")
    public cz.cvut.fel.aos.service.reservation.Reservation find(
        @WebParam(name = "reservation", targetNamespace = "")
        long reservation,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    ) throws SecurityException;
}
