package cinema;


import cinema.dto.CinemaRoomDTO;
import cinema.entity.CinemaRoom;
import cinema.entity.Seat;
import cinema.entity.Ticket;
import cinema.exception.InvalidSeatException;
import cinema.exception.SeatOccupiedException;
import cinema.exception.WrongPasswordException;
import cinema.exception.WrongTokenException;
import cinema.mapper.CinemaRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CinemaService {

    @Autowired
    private CinemaRoom cinemaRoom;

    @Autowired
    private CinemaRoomMapper cinemaRoomMapper;

    private Map<String, Ticket> map;

    private String password = "super_secret";

    public CinemaService() {
        this.map = new HashMap<>();
    }

    public CinemaRoomDTO findSeats() {
        return cinemaRoomMapper.map(cinemaRoom);
    }

    public String bookSeat(int row, int column) throws SeatOccupiedException, InvalidSeatException {
        if ((cinemaRoom.getRows() < row || row < 1) || (cinemaRoom.getColumns() < column || column < 1)) {
            throw new InvalidSeatException("The number of a row or a column is out of bounds!");
        }

        Seat seat = cinemaRoom.getSeat(row, column);

        if (seat.isAvailable()) {
            seat.setAvailable(false);
        } else {
            throw new SeatOccupiedException("The ticket has been already purchased!");
        }

        String uuid = UUID.randomUUID().toString();

        this.map.put(uuid, new Ticket(seat.getRow(), seat.getColumn()));

        return uuid;
    }

    public Ticket returnTicket(String token) throws WrongTokenException {

        if (this.map.containsKey(token)) {
            Ticket ticket = this.map.remove(token);
            this.cinemaRoom.getSeat(ticket.getRow(), ticket.getColumn()).setAvailable(true);
            return ticket;
        } else {
            throw new WrongTokenException("Wrong token!");
        }

    }

    public boolean checkPassword(String password) throws WrongPasswordException {
        if (this.password.equals(password)) {
            return true;
        } else {
            throw new WrongPasswordException("The password is wrong!");
        }
    }

    public int getNumberSeats() {
        return this.cinemaRoom.getAvailableSeats().size();
    }

    public int getSoldTickets() {
        return this.map.size();
    }

    public int getIncome() {
        return this.map.values().stream().map(a -> a.getPrice()).reduce(0, (a, b) -> a + b);
    }



}
