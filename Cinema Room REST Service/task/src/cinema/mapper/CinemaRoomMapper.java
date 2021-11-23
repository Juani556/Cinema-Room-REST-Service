package cinema.mapper;


import cinema.dto.CinemaRoomDTO;
import cinema.dto.SeatDTO;
import cinema.entity.CinemaRoom;
import cinema.entity.Seat;
import cinema.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CinemaRoomMapper {

    @Autowired
    private SeatMapper seatMapper;

    public CinemaRoomDTO map(CinemaRoom cinemaRoom) {
        CinemaRoomDTO dto = new CinemaRoomDTO();
        dto.setTotal_rows(cinemaRoom.getRows());
        dto.setTotal_columns(cinemaRoom.getColumns());
        List<SeatDTO> list = new ArrayList<>();
        for (Seat seat : cinemaRoom.getAvailableSeats()) {
            list.add(seatMapper.map(seat));
        }
        dto.setAvailable_seats(list);
        return dto;
    }

}
