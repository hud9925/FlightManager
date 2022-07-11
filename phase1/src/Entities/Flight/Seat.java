package Entities.Flight;

public class Seat {

    private String seatid;
    private int seatrow;
    private int seatcol;
    private boolean isfilled;

    public Seat(int seatrow, int seatcol){
        this.seatrow = seatrow;
        this.seatcol = seatcol;
        this.updateSeatid();
        this.isfilled = false;
    }

    public boolean isFilled(){
        return this.isfilled;
    }

    public void fill(){
        this.isfilled = true;
    }

    public String getSeatid(){
        return this.seatid;
    }

    public void setSeatrow(int seatrow){
        this.seatrow = seatrow;
        this.updateSeatid();
    }
    public void setSeatcol(int seatcol){
        this.seatcol = seatcol;
        this.updateSeatid();
    }
    public void updateSeatid() {
        this.seatid = String.valueOf(this.seatcol) + this.seatrow;
    }
}
