package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.Seat;

import java.util.Arrays;

/**
 * A use Case that Provides a String Representation of a Flight's SeatMap and the accessing of individual seats
 */
public class SeatViewer {

    /**
     * Returns a Static String Representation of the Seatmap
     * Will Adjust Later --> Right Now, only returns a string Rep of 'X' and 'O'
     */

    public static String StringRepresentation(Flight flight) {
        String[] Columns = new String[6];
        Columns[0] = "A";
        Columns[1] = "B";
        Columns[2] = "C";
        Columns[3] = "D";
        Columns[4] = "E";
        Columns[5] = "F";

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
            }
         // return flight.getSeats().toString();
//        }
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



