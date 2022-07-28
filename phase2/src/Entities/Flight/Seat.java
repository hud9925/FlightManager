package Entities.Flight;


/**
 * Entity class representing a seat in a flight
 */
public class Seat {

    /**
     * This seat's ID number, constructed from its column and its row
     */
    private final String seatid;

    /**
     * Boolean representing if this seat is "filled" --> a user has purchased this seat.
     */
    private boolean isfilled;

    /**
     * Constructor that creates a seat object from parameters.
     * @param seatrow This seat's row
     * @param seatcol This seat's column
     */
    public Seat(int seatrow, int seatcol){
        this.seatid = convertCol(seatcol) + " " + seatrow;
        this.isfilled = false;
    }

    /**
     * @return True if the seat is filled, False if not filled.
     */
    public boolean isFilled(){
        return this.isfilled;
    }

    /**
     * Fill the seat --> used when a user has purchased this seat
     */
    public void fill(){
        this.isfilled = true;
    }

    /**
     * Getter for the seat ID
     * @return Seat ID
     */
    public String getSeatid(){
        return this.seatid;
    }

    /**
     * Method that converts the seat's column into alphabetical characters
     * @param seatcol This seat's column
     * @return an alphabetical character representing this seat's column
     */
    public String convertCol(int seatcol){
        String[] largeCol = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"};
        //String[] smallCol = {"A","B","C","H","J","K"};

        return largeCol[seatcol];
    }
    public void empty() {this.isfilled = false;}
}
