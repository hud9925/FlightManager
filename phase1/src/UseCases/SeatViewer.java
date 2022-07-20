package UseCases;

import Entities.Flight.Flight;
import Entities.Flight.Seat;

/**
 * A use Case that Provides a String Representation of a Flight's SeatMap and the accessing of individual seats
 */
public class SeatViewer {

    /**
     * Returns a Static String Representation of the Seatmap
     * Will Adjust Later --> Right Now, only returns a string Rep of 'X' and 'O'
     */

    public static String StringRepresenation(Flight flight) {
//        char[][] seats = new char[flight.getSeats().getRows()][flight.getSeats().getColumns()];
//        for (int i = 0; i < rows; i++) {
//            seats[i][0] = (char) (i + 'A');
//            seats[i][1] = (char) (i + 'B');
//            seats[i][2] = (char) (i + 'C');
//            seats[i][3] = (char) (i + 'D');
//            seats[i][4] = (char) (i + 'E');
//            seats[i][5] = (char) (i + 'F');
//            seats[i][6] = (char) (i + 'G');
//            seats[i][7] = (char) (i + 'H');
//
//        }
//        StringBuilder StringRep = new StringBuilder();
//        for (int row = 0; row < seats.length; row++) {
//            for (int col = 0; col < seats[row].length; col++) {
//                if (flight.getSeats().isfilled()) {
//                    StringRep.append('-');
//                } else {
//                    StringRep.append(seats[row][col]);
//
//                }
//            }
        return flight.getSeats().toString();
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
        * Updates the seat be now be occupied
        */
        public static void fillSeat(Flight flight, Integer row, Integer column){
            flight.getSeats().getSeat(row, column).setIsfilled();
        }
}



