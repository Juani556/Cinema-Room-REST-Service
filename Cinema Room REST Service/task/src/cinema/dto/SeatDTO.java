package cinema.dto;

public class SeatDTO {

    private int row;
    private int column;
    private int price;

    public SeatDTO(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row > 4 ? 8 : 10;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
