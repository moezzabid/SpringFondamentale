package service;

import entity.Application;
import entity.Release;
import entity.Ticket;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ReleaseRepository;
import repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;




    public List<Ticket> listTicket(){
        List <Ticket> tickets=new ArrayList<>();
        ticketRepository.findAll().forEach(ticket -> tickets.add(ticket));
        return tickets ;

    }
    public Ticket findTicket(long id){
        Optional<Ticket> ticket= Optional.of(ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("dddd")
        ));

        return ticket.get();
    }

}
