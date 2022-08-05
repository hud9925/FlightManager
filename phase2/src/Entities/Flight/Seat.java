package Entities.Flight;


/**
 * Entity class representing a seat in a flight
 */
public class Seat {

    /**
     * This seat's ID number, constructed from its column and its row
     */
    private final String seatID;

    /**
     * Boolean representing if this seat is "filled" --> a user has purchased this seat.
     */
    private boolean isFilled;

    /**
     * Constructor that creates a seat object from parameters.
     * @param seatRow This seat's row
     * @param seatCol This seat's column
     */
    public Seat(int seatRow, int seatCol){
        this.seatID = convertCol(seatCol) + " " + seatRow;
        this.isFilled = false;
    }

    /**
     * @return True if the seat is filled, False if not filled.
     */
    public boolean isFilled(){
        return this.isFilled;
    }

    /**
     * Fill the seat --> used when a user has purchased this seat
     */
    public void fill(){
        this.isFilled = true;
    }

    /**
     * Getter for the seat ID
     * @return Seat ID
     */
    public String getSeatID(){
        return this.seatID;
    }

    /**
     * Method that converts the seat's column into alphabetical characters
     * @param seatCol This seat's column
     * @return an alphabetical character representing this seat's column
     */
    public String convertCol(int seatCol){
        String[] largeCol = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"};
        //String[] smallCol = {"A","B","C","H","J","K"};

        return largeCol[seatCol];
    }
    public void empty() {this.isFilled = false;}
}
