package cz.cvut.fel.service;

import cz.cvut.fel.exception.InvalidPaymentException;
import cz.cvut.fel.model.Payment;
import cz.cvut.fel.model.Reservation;
import cz.cvut.fel.util.ArquillianTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.ejb.EJBException;
import javax.inject.Inject;

import static cz.cvut.fel.utils.DateUtils.date;
import static org.testng.Assert.*;

/** @author Karel Cemus */
@Slf4j
@Test( groups = "services" )
public class PaymentServiceTest extends ArquillianTest {

    private static final String PASSWORD = "heslo12345";

    @Inject
    private PaymentService service;

    @Inject
    private ReservationService reservationService;

    private long reservationId;

    @BeforeMethod
    public void setUpMethod() throws Exception {
        if ( isInContainer() ) {
            // data initialization
            Reservation reservation = reservationService.create( "F987545", PASSWORD, 5 );

            assertEquals( reservation.getCount(), 5 );
            reservationId = reservation.getId();
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if ( isInContainer() ) {
            reservationService.cancel( reservationId, PASSWORD );
        }
    }

    @Test
    public void testPayVisa() throws Exception {

        // verify assumptions - unpaid
        Reservation reservation = reservationService.find( reservationId, PASSWORD );
        assertEquals( reservation.getPaid(), 0 );

        // perform test
        Payment payment = service.payVisa( reservationId, "John Scott", 123654789, date( 1, 1, 2014 ), 789 );

        // verify
        assertTrue( payment.getId() > 0 );
        assertEquals( payment.getCreditCardNumber(), 4789 );
        assertEquals( payment.getCreditCardName(), "John Scott" );
        assertEquals( payment.getReservation().getId(), reservationId );
        assertEquals( payment.getAmount(), 5 * 5000 ); // price per seat is 5000, ordered 5 seats

        reservation = reservationService.find( reservationId, PASSWORD );
        assertEquals( reservation.getPaid(), reservation.getCost() );
    }

    @Test( expectedExceptions = { EJBException.class, InvalidPaymentException.class } )
    public void testPayVisaWrongVerification() throws Exception {

        // perform test
        service.payVisa( reservationId, "John Scott", 123654789, date( 1, 1, 2014 ), 123 );
    }

    @Test( expectedExceptions = { EJBException.class, InvalidPaymentException.class } )
    public void testPayVisaExpired() throws Exception {

        // perform test
        service.payVisa( reservationId, "John Scott", 123654789, date( 1, 1, 2010 ), 789 );
    }

    @Test( expectedExceptions = { EJBException.class, InvalidPaymentException.class } )
    public void testPayVisaCanceled() throws Exception {

        // assumptions
        reservationService.cancel( reservationId, PASSWORD );
        Reservation reservation = reservationService.find( reservationId, PASSWORD );
        assertTrue( reservation.isCancelled() );

        // perform test
        service.payVisa( reservationId, "John Scott", 123654789, date( 1, 1, 2014 ), 789 );
    }

    @Test
    public void testReturnMoney() throws Exception {

        // make assumption
        service.payVisa( reservationId, "John Scott", 123654789, date( 1, 1, 2014 ), 789 );
        reservationService.cancel( reservationId, PASSWORD );
        Reservation reservation = reservationService.find( reservationId, PASSWORD );

        // verify assumption - paid and cancelled
        assertEquals( reservation.getPaid(), reservation.getCost() );
        assertTrue( reservation.isCancelled() );

        // perform test
        Payment payment = service.returnMoney( reservationId, PASSWORD, 123654789 );

        // verify
        assertTrue( payment.getId() > 0 );
        assertEquals( payment.getCreditCardNumber(), 4789 );
        assertEquals( payment.getReservation().getId(), reservationId );
        assertEquals( payment.getAmount(), -5 * 5000 ); // price per seat is 5000, ordered 5 seats, negative, money sent back

        reservation = reservationService.find( reservationId, PASSWORD );
        assertEquals( reservation.getPaid(), 0 ); // all money returned
    }

    @Test( expectedExceptions = { EJBException.class, InvalidPaymentException.class } )
    public void testReturnMoney_NotPaid() throws Exception {

        // make assumption
        reservationService.cancel( reservationId, PASSWORD );
        Reservation reservation = reservationService.find( reservationId, PASSWORD );

        // verify assumption - not paid and cancelled
        assertEquals( reservation.getPaid(), 0 );
        assertTrue( reservation.isCancelled() );

        // perform test
        service.returnMoney( reservationId, PASSWORD, 123654789 );
    }

    @Test( expectedExceptions = { EJBException.class, InvalidPaymentException.class } )
    public void testReturnMoney_NotCancelled() throws Exception {

        // make assumption
        service.payVisa( reservationId, "John Scott", 123654789, date( 1, 1, 2014 ), 789 );
        Reservation reservation = reservationService.find( reservationId, PASSWORD );

        // verify assumption - paid and not cancelled
        assertEquals( reservation.getPaid(), reservation.getCost() );
        assertFalse( reservation.isCancelled() );

        // perform test
        service.returnMoney( reservationId, PASSWORD, 123654789 );
    }
}