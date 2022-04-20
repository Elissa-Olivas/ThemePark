package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Tickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.Ticket;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {


    @Test
    void findByTicketType() {
        TicketRepository ticketRepository = new TicketRepository();
        List<Tickets> testTickets = ticketRepository.getAllTickets();
        Tickets result = ticketRepository.findByTicketType("Adult");
        assertEquals(testTickets.get(6).getTicketType(), result.getTicketType());
    }

    @Test
    void findByNumOfDays() {
        TicketRepository ticketRepository = new TicketRepository();
        List<Tickets> testTickets = ticketRepository.getAllTickets();
        Tickets result = ticketRepository.findByNumOfDays(2);
        assertEquals(testTickets.get(1).getNumOfDays(), result.getNumOfDays());
    }


    @Test
    void findTotalPrice() {
        TicketRepository ticketRepository = new TicketRepository();
        double result = ticketRepository.findTotalPrice("Child", 3, 56.00);
        assertEquals(result, 168.00);
    }
}