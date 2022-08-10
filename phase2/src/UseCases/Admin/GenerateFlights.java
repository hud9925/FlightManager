package UseCases.Admin;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static UseCases.Admin.AddFlight.newFlight;

    /**
     * A Use Case that Generates random parameters for new flights
     */
    public class GenerateFlights {
        /**
         * Adds a new Flight to Flight Tracker with a RandomID, columns, and rows
         * @return the Flight's ID
         */
        public static String RandomFlight()  {
            Random rand = new Random();
            int upperBound = 10;
            int randomCol = rand.nextInt(upperBound)+1;
            int randomRow = rand.nextInt(upperBound)+1;
            String randomid = GenerateFlights.RandomID();
            newFlight(randomid, randomCol, randomRow);
            return randomid;
        }
        /**
         * Generates a Random AlphaNumeric FlightID in the format (AA111)
         * @return generated FlightId
         */
        public static String RandomID(){
            Random rand = new Random();
            StringBuilder s = new StringBuilder();
            int upperBound = 10;
            int charNumber = 65 + (int)(Math.random()*(91-65));
            int charNumber2 = 65 + (int)(Math.random()*(91-65));

            char char1 = (char) charNumber;
            char char2 = (char) charNumber2;

            String randomInt = Integer.toString(rand.nextInt(upperBound));
            String randomInt2 = Integer.toString(rand.nextInt(upperBound));
            String randomInt3 = Integer.toString(rand.nextInt(upperBound));

            return s.append(char1).append(char2).append(randomInt).append(randomInt2).append(randomInt3).toString();
        }
        /**
         * Generates and Returns A Random Airline
         * @return generated Airline
         */
        public static String RandomAirline(){
            String[] airlines= new String[]{"AirCanada", "UnitedAirlines", "Delta", "FrontierAirlines","Lufthansa"};
            Random rand =  new Random();
            int randomIndex = rand.nextInt(airlines.length);
            return airlines[randomIndex];
        }
        /**
         * Generates and Returns a Random Departure Date between the current time and the next week
         * @return generated Departure Date
         */
        public static LocalDate RandomDeparture(){
            LocalDate startDate  = LocalDate.now();
            long startd = startDate.toEpochDay();

            LocalDate endDate =  startDate.plusDays(7);
            long endd = endDate.toEpochDay();

            long randomEpochDay = ThreadLocalRandom.current().nextLong(startd, endd);
            return LocalDate.ofEpochDay(randomEpochDay);

        }
        /**
         * Generates and Returns a Random Departure Location
         * @return generated Departing Location
         */
        public static String RandomDepartLocation(){
            String[] Locations = new String[]{"Toronto", "Chicago", "New York City", "Vancouver", "Seattle", "Nashville"};
            Random random = new Random();
            int randomIndex = random.nextInt(Locations.length);
            return Locations[randomIndex];

        }
        /**
         * Generates and Returns a Random Arrival Location
         * @return generated Arrival Location
         */
        public static String RandomArrivalLocation(){
            String[] Locations = new String[]{"Madrid", "Venice", "Buenos Aires", "New Delhi", "Moscow", "Shanghai"};
            Random random = new Random();
            int randomIndex = random.nextInt(Locations.length);
            return Locations[randomIndex];
        }
        /**
         * Generates and Returns a Random Arrival Location
         *
         */
        public static LocalTime RandomDuration(){
            Random random = new Random();
            LocalTime time1 = LocalTime.of(6, 0, 0);
            LocalTime time2 = LocalTime.of(14, 0 , 0);

            int Daytime1 = time1.toSecondOfDay();
            int Daytime2 = time2.toSecondOfDay();

            int randomSecondOfDay = Daytime1 + random.nextInt(Daytime2 - Daytime1);
            return LocalTime.ofSecondOfDay(randomSecondOfDay);

        }

    }

