package Entities.Flight;

public class Seatmap {

    private final Seat[][] seats;
    public Seatmap(int rows, int columns) {
        this.seats = new Seat[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                seats[i][j] = new Seat(i, j);
            }
        }
    }

    public int getColumns() {return seats.length;}

    public int getRows() {
        if(this.seats[0] == null){
            return 0;
        } else {
            return this.seats[0].length;
        }
    }

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

}
