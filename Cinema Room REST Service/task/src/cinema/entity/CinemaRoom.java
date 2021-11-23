package cinema.entity;

import cinema.entity.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CinemaRoom {

    private int rows;
    private int columns;

    private List<List<Seat>> seats;

    public CinemaRoom(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<List<Seat>>();

        for (int i = 0; i < rows; i++) {
            List<Seat> list = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                list.add(new Seat(i + 1, j + 1));
            }
            this.seats.add(list);
        }
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> list = this.seats.stream().flatMap(List::stream).filter(Seat::isAvailable).collect(Collectors.toList());
        return list;
    }

    public Seat getSeat(int row, int column) {
        return this.seats.get(row - 1).get(column - 1);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<List<Seat>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Seat>> seats) {
        this.seats = seats;
    }

}
