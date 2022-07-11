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

    public String toString() {
        String rtrnstr = "";
        for(Seat[] sarray : this.seats){
            for(Seat s: sarray){
                if(s.isFilled()){
                    rtrnstr += 'O';
                }else{
                    rtrnstr += 'X';
                }
            }
            rtrnstr += "n";
        }
        return rtrnstr;
    }
}
