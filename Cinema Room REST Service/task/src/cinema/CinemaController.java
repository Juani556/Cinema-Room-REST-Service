package cinema;

import cinema.dto.CinemaRoomDTO;
import cinema.entity.Ticket;
import cinema.exception.InvalidSeatException;
import cinema.exception.SeatOccupiedException;
import cinema.exception.WrongPasswordException;
import cinema.exception.WrongTokenException;
import cinema.request.PurchaseRequest;
import cinema.request.ReturnRequest;
import cinema.response.PurchaseResponse;
import cinema.response.ReturnResponse;
import cinema.response.StatsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/seats")
    public CinemaRoomDTO getSeats() {
        return cinemaService.findSeats();
    }

    @PostMapping(path = "/purchase", consumes = "application/json")
    public PurchaseResponse purchase(@RequestBody PurchaseRequest purchaseRequest) throws InvalidSeatException, SeatOccupiedException {

        PurchaseResponse response = new PurchaseResponse();

        Ticket ticket = new Ticket(purchaseRequest.getRow(), purchaseRequest.getColumn());

        String token = cinemaService.bookSeat(purchaseRequest.getRow(), purchaseRequest.getColumn());

        response.setTicket(ticket);
        response.setToken(token);

        return response;

    }

    @PostMapping(path = "/return", consumes = "application/json")
    public ReturnResponse returnTicket(@RequestBody ReturnRequest returnRequest) throws WrongTokenException {

        ReturnResponse response = new ReturnResponse();

        response.setReturnedTicket(cinemaService.returnTicket(returnRequest.getToken()));

        return response;

    }

    @PostMapping(path = "/stats")
    public StatsResponse getStats(@RequestParam(required = false) String password) throws WrongPasswordException {
        cinemaService.checkPassword(password);

        StatsResponse statsResponse = new StatsResponse();
        statsResponse.setIncome(cinemaService.getIncome());
        statsResponse.setSeats(cinemaService.getNumberSeats());
        statsResponse.setTickets(cinemaService.getSoldTickets());

        return statsResponse;
    }

}
