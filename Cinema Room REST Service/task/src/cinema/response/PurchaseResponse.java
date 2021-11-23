package cinema.response;

import cinema.entity.Ticket;

public class PurchaseResponse {

    private String token;
    private Ticket ticket;

    public PurchaseResponse(String token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public PurchaseResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
