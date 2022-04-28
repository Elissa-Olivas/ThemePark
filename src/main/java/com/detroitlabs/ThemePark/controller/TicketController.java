package com.detroitlabs.ThemePark.controller;


import com.detroitlabs.ThemePark.data.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;


    @RequestMapping("/tickets")
    public String displayTickets(ModelMap modelMap) {
        modelMap.put("infantTicket1", ticketRepository.getAllTickets().get(0));
        modelMap.put("infantTicket2", ticketRepository.getAllTickets().get(1));
        modelMap.put("infantTicket3", ticketRepository.getAllTickets().get(2));
        modelMap.put("childTicket1", ticketRepository.getAllTickets().get(3));
        modelMap.put("childTicket2", ticketRepository.getAllTickets().get(4));
        modelMap.put("childTicket3", ticketRepository.getAllTickets().get(5));
        modelMap.put("adultTicket1", ticketRepository.getAllTickets().get(6));
        modelMap.put("adultTicket2", ticketRepository.getAllTickets().get(7));
        modelMap.put("adultTicket3", ticketRepository.getAllTickets().get(8));
        modelMap.put("seniorTicket1", ticketRepository.getAllTickets().get(9));
        modelMap.put("seniorTicket2", ticketRepository.getAllTickets().get(10));
        modelMap.put("seniorTicket3", ticketRepository.getAllTickets().get(11));
        modelMap.put("tickets", ticketRepository.getAllTickets());
        return "tickets";
    }

}
