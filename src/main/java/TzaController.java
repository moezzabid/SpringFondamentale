import entity.Application;
import entity.Release;
import entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import service.ApplicationService;
import service.ReleaseService;
import service.TicketService;

import java.util.List;

@RestController
public class TzaController {

    private ApplicationService applicationService;
    private TicketService ticketService;
    private ReleaseService releaseService;


    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @Autowired
    public void setReleaseService(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }


    @GetMapping("/applications")
    public ResponseEntity<List<Application>> retriveApplication(Model model){
        List<Application> list=applicationService.listApplication();
        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
    }

    @GetMapping("/application/id")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id ){
        try{
            return  ResponseEntity.ok().body(applicationService.findApplication(id));

        }catch(Exception e ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"application not found");

        }
    }

    @GetMapping("/ticket/id")
    public ResponseEntity<Ticket> getTicket(@PathVariable("id") long id ){
        try{
            return  ResponseEntity.ok().body(ticketService.findTicket(id));

        }catch(Exception e ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ticket not found");

        }
    }

    @GetMapping("/release/id")
    public ResponseEntity<Release> getRelease(@PathVariable("id") long id ){
        try{
            return  ResponseEntity.ok().body(releaseService.findRelease(id));

        }catch(Exception e ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"release not found");

        }
    }
    @GetMapping("/tickets")
    public String retriveTicket(Model model){
        model.addAttribute("applications",ticketService.listTicket());
            return "ticket";
    }
    @GetMapping("/releases")
    public String retriveRelease(Model model){
        model.addAttribute("applications",releaseService.listRelease());
            return "release";
    }



}
