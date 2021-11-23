package cinema.response;

import cinema.entity.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnResponse {

    @JsonProperty("returned_ticket")
    private Ticket returnedTicket;

    public Ticket getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(Ticket returnedTicket) {
        this.returnedTicket = returnedTicket;
    }
}
