package cinema.mapper;


import cinema.dto.SeatDTO;
import cinema.entity.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {

    public SeatDTO map(Seat seat) {
        return new SeatDTO(seat.getRow(), seat.getColumn());
    }

}
