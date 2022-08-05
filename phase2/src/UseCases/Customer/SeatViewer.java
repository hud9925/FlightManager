package UseCases.Customer;

import Entities.Flight.Flight;
import Entities.Flight.Seat;

import java.util.Arrays;

/**
 * A use Case that Provides a String Representation of a Flight's SeatMap and the accessing of individual seats
 */
public class SeatViewer {

    /**
     * Returns a Static String Representation of the Seatmap
     */

    public static String stringRepresentation(Flight flight) {
        String[] Columns = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"};
        StringBuilder StringRep = new StringBuilder();
        for (int row = 0; row <flight.getSeats().getRows(); row++) {
            for (int col = 0; col < flight.getSeats().getColumns(); col++) {
                if (flight.getSeats().getSeat(row, col).isFilled()){
                    StringRep.append(" - ");
                } else{
                    String SeatID = row + Columns[col]+ " ";
                    StringRep.append(SeatID);
                }
            }
            StringRep.append("\n");
        }
        return StringRep.toString();
    }
        /**
        * Returns the seat on the inputted flight based upon the row and column
        */
        public static Seat getSeat(Flight flight, Integer row, Integer column){
            if (row <=flight.getSeats().getRows() && column <= flight.getSeats().getColumns()){
                return flight.getSeats().getSeat(row, column);
        }
            else{
                return null;
            }
        }

        /**
        * Returns the seat on the inputted flight based upon the seat's ID
        */
        public static Seat getSeat(Flight flight, String seatID){
            String[] seatData = seatID.split(" ");
            String[] largeCol = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K"};
            for(String letter: largeCol){
                if(seatData[0].equals(letter)){
                    return flight.getSeats().getSeat(Arrays.asList(largeCol).indexOf(letter),
                            Integer.parseInt(seatData[1]));
                }
            }
            return null;
        }
        /**
        * Updates the seat be now be occupied
        */
        public static void fillSeat(Flight flight, Integer row, Integer column){
            flight.getSeats().getSeat(row, column).fill();
        }
}



