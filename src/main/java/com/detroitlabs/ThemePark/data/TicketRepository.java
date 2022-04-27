package com.detroitlabs.ThemePark.data;


import com.detroitlabs.ThemePark.model.Tickets;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TicketRepository {

    private static final List<Tickets> ALL_TICKETS = Arrays.asList(
            new Tickets("Infant", 1, 0.00, 1),     //    price for multi days is price/day.
            new Tickets("Infant", 2, 0.00, 2),
            new Tickets("Infant", 3, 0.00, 3),
            new Tickets("Child", 1, 84.00, 4),
            new Tickets("Child", 2, 70.00, 5),
            new Tickets("Child", 3, 56.00, 6),
            new Tickets("Adult", 1, 104.00, 7),
            new Tickets("Adult", 2, 90.00, 8),
            new Tickets("Adult", 3, 76.00, 9),
            new Tickets("Senior", 1, 94.00, 10),
            new Tickets("Senior", 2, 80.00, 11),
            new Tickets("Senior", 3, 66.00, 12));



    public List<Tickets> getAllTickets() {
        return ALL_TICKETS;
    }

    //find by ticket type
    public Tickets findByTicketType(String ticketType) {
        for (Tickets tickets : ALL_TICKETS) {
            if (tickets.getTicketType().equals(ticketType)) {
                return tickets;
            }
        }
        return null;
    }

    //method to search by numofdays
    public Tickets findByNumOfDays(int numOfDays) {
        for (Tickets tickets : ALL_TICKETS) {
            if (tickets.getNumOfDays() == numOfDays) {
                return tickets;
            }
        }
        return null;
    }


    //    need to make method to calc total price for multi days.
    public double findTotalPrice(String ticketType, int numOfDays, double price) {
        double totalPrice = 0;
        for (Tickets tickets: ALL_TICKETS) {
            if (tickets.getTicketType().equals(ticketType) && tickets.getNumOfDays() == numOfDays) {
                totalPrice = tickets.getPrice() * numOfDays;
            }
        }
        return totalPrice;
    }


}
