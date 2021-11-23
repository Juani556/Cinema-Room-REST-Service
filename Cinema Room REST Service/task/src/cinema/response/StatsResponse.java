package cinema.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsResponse {

    @JsonProperty("current_income")
    private int income;

    @JsonProperty("number_of_available_seats")
    private int seats;

    @JsonProperty("number_of_purchased_tickets")
    private int tickets;

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}
