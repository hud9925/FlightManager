package Entities.Flight;

public class Seat {

    private String seatnumber;
    private boolean isfilled;

    public Seat(String seatnumber){
        this.seatnumber = seatnumber;
        this.isfilled = false;
    }

    public boolean isFilled(){
        return this.isfilled;
    }

    public void fill(){
        this.isfilled = true;
    }

    public String getSeatnumber(){
        return this.seatnumber;
    }
}
