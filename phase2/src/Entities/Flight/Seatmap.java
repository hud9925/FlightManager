package Entities.Flight;


/**
 * Entity class representing a flight's seatmap
 * Effectively a collection of the flight's seats, ordered and recorded.
 */
public class Seatmap {

    /**
     * 2D array of seats contained in this seatmap
     */
    private final Seat[][] seats;

    /**
     * Constructor that builds a new seatmap with non-filled seats
     * @param rows number of rows in this seatmap
     * @param columns number of columns in this seatmap
     */
    public Seatmap(int rows, int columns) {
        this.seats = new Seat[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                seats[i][j] = new Seat(i, j);
            }
        }
    }

    /**
     * Getter for the number of rows in this seatmap
     * @return the length of the 2D seat array --> number of rows
     */
    public int getRows() {return seats.length;}

    /**
     * Getter for the number of columns in this seatmap
     * @return 0 if no rows exist in this seatmap, length of the first row otherwise
     */
    public int getColumns() {
        if(this.seats[0] == null){
            return 0;
        } else {
            return this.seats[0].length;
        }
    }

    /**
     * Method for printing the seatmap, returns a string representation of the seatmap
     * O's for when the seat is filled, X's when it is not.
     * @return String representing the seatmap.
     */
    public String toString() {
        StringBuilder rtrnstr = new StringBuilder();
        for(Seat[] sarray : this.seats){
            for(Seat s: sarray){
                if(s.isFilled()){
                    rtrnstr.append('O');
                }else{
                    rtrnstr.append('X');
                }
            }
            rtrnstr.append(" ");
        }
        return rtrnstr.toString();
    }

    /**
     * Getter for a specific seat in the seatmap
     * @param row the seat's row
     * @param column the seat's column
     * @return the target seat
     */
    public Seat getSeat(int row, int column){
        return this.seats[row][column];

    }
}

