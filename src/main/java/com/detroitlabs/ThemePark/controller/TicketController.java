package com.detroitlabs.ThemePark.controller;


import com.detroitlabs.ThemePark.data.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;


    @RequestMapping("/tickets")
    public String displayTickets(ModelMap modelMap) {
        modelMap.put("tickets", ticketRepository.getAllTickets());
        return "tickets";
    }
}
