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

    public String convertCol(int seatcol){
        String[] largeCol = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"};
        //String[] smallCol = {"A","B","C","H","J","K"};

        return largeCol[seatcol - 1];
    }
    public void updateSeatid() {
        this.seatid = convertCol(this.seatcol) + " " + this.seatrow;
    }
}
