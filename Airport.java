
/**
 * Class Airport Represents an airport. An airport object is represented by the airport's
 * name, the number of flights that departs or arrives to the airport, and a
 * list of those flights.
 * 
 * @author Yair Etkes (ID 308224518)
 * @version 13.1.2018
 */

public class Airport
{
    // instance variables - 
    private Flight[] _flightSchedule;
    private int _noOfFlights;
    private String _airport;

    public final int MAX_FLIGHTS = 200;

    /**
     * Constructor for objects of class Airport.
     * @param  city  the city where the airport is located.
     */
    public Airport(String city)
    {
        _flightSchedule = new Flight [MAX_FLIGHTS];
        _noOfFlights = 0;
        if (city!=null) {_airport = city;}

    }

    /**
     * A method ment to add flight to the array. 
     *
     * @param  f  the desired flight to enter the array.
     * @return  true  if the flight was added correctly to the array.
     */
    public boolean addFlight(Flight f) 
    {
        if ((f.getOrigin() != null) && (f.getDestination() != null)) { // Makes sure the flight origin or destination is
            // not null.
            if ((f.getOrigin().equals(_airport) || (f.getDestination().equals(_airport)))
            && (_noOfFlights < MAX_FLIGHTS)) {
                _flightSchedule[_noOfFlights] = new Flight(f);
                _noOfFlights++;
                return true;
            }
        }
        return false;
    }

    /**
     * This method remove flight from the array. and than fill up the "hole" with the last flight.
     *
     * @param  f  the flight we wish to remove from array.
     * @return  true  if the flight removed succesfully, otherwise return false.
     */
    public boolean removeFlight (Flight f)
    {
        if (f != null) 
        {
            for (int i = 0; i < _noOfFlights; i++) 
            {
                if (_flightSchedule[i].equals(f)) { // If the given flight is equal to any flight in the array.
                    _flightSchedule[i] = new Flight(_flightSchedule[_noOfFlights - 1]); // Moves the last flight in the
                    // array to the "deleted" spot.
                    _flightSchedule[_noOfFlights - 1] = null; // Deletes the last flight from the array.
                    _noOfFlights--;
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * Returns the Time1 object of the first flight that departure from a given
     * place. If there are no flights that departure from the given place, the
     * method will return "null".
     * 
     * @param place
     *            The place to check what is the first flight that departs from.
     * @return A Time1 object of the first flight that departures from the given
     *         place.
     */
    public Time1 firstFlightFromDestination(String place) 
    {
        Time1 earliestTime = null;
        for (int i = 0; i < _noOfFlights; i++)
        {
            if (_flightSchedule[i].getOrigin().equals(place))
            {
                if (earliestTime == null)
                {
                    earliestTime = _flightSchedule[i].getDeparture(); // The getDeparture method returns a new time1
                    // object.
                }
                else if (_flightSchedule[i].getDeparture().before(earliestTime))
                {
                    earliestTime = _flightSchedule[i].getDeparture();
                }

            }
        }
        return earliestTime;
    }

    /**
     * A method to check how many full flight there is in the array
     *
     * 
     * @return    the number of full flights.
     */
    public int howManyFullFlights()
    {
        int counter = 0;
        for (int i = 0; i < _noOfFlights; i ++)
        {
            if (_flightSchedule[i].getIsFull())
            { 
                counter ++; // This counter counts the full flights.
            }
        }
        return counter;
    }

    /**
     * This method check how many flights depart from city1 and arrive at city2, or depart from city2 and arrive at city1.
     *
     * @param  city1  one city in which the flight depart from or arrives at.
     * @param  city2  the other city in which the flight depart from or arrives at.
     * @return    how many flights fly between this two cities.
     */
    public int howManyFlightsBetween(String city1,String city2)
    { 
        int flightsBetween = 0;
        for (int i = 0; i < _noOfFlights; i++)
        {
            // A check to make sure that the flight is in between the two citis:
            if (((_flightSchedule[i].getOrigin() == city1) && (_flightSchedule[i].getDestination().equals(city2))) ||
            ((_flightSchedule[i].getOrigin().equals(city2)) && (_flightSchedule[i].getDestination().equals(city1)))) 
            {
                flightsBetween ++;
            }
        }
        return flightsBetween;
    }

    /**
     * Returns the most popular destination in the airport. If there are no flights
     * in the airport, the method returns "null".
     * 
     * @return The most popular destination in the airport.
     */
    public String mostPopularDestination()
    {
        if (_noOfFlights == 0)
        { // in case there are no flights in the airport
            return null;
        }
        String mostPopular = _flightSchedule[0].getDestination();
        int mostPopularCount = 0;
        for (int i = 0; i < _noOfFlights; i++)
        {
            int tempCount = 0;
            for (int j = 0; j < _noOfFlights; j++)
            {
                if (_flightSchedule[j].getDestination().equals(_flightSchedule[i].getDestination())) {
                    tempCount++;
                }
            }
            if (tempCount > mostPopularCount)
            {
                mostPopularCount = tempCount;
                mostPopular = _flightSchedule[i].getDestination();
            }
        }
        return mostPopular;
    }

    
    /**
     * This method finds out which flight has the most expensive ticket in array.
     *
     * 
     * @return    the flight which has the most expensive ticket.
     */
    public Flight mostExpensiveTicket()
    {
        if (_noOfFlights == 0)
        { // in case there are no flights in the airport
            return null;
        }
        else
        {
            int mostExpensivePrice = _flightSchedule[0].getPrice();
            int mostExpensive = 0; //This int will contain the index of the most expensive flight.
            for (int i = 0; i < _noOfFlights; i++)
            {
                if (_flightSchedule[i].getPrice() > mostExpensivePrice)
                {
                    mostExpensivePrice = _flightSchedule[i].getPrice();
                    mostExpensive = i;
                }
            }

            return (new Flight(_flightSchedule[mostExpensive]));

        }
    }

    /**
     * This method finds out which flight has the longest flight duration.
     *
     * 
     * @return    the flight which has the the longest flight duration.
     */
    public Flight longestFlight()
    {
        if (_noOfFlights == 0)
        { // in case there are no flights in the airport
            return null;
        }
        else
        {
            int longestDuration = _flightSchedule[0].getFlightDuration();
            int longesFlight = 0; //This int will contain the index of the longest flight.
            for (int i = 0; i < _noOfFlights; i++)
            {
                if (_flightSchedule[i].getFlightDuration() > longestDuration)
                {
                    longestDuration = _flightSchedule[i].getFlightDuration();
                    longesFlight = i;
                }
            }
            return (new Flight(_flightSchedule[longesFlight]));

        }

    }

    /**
     * Returns a string representation of the airport. (For example: The flights for
     * airport Tel-Aviv today are: Flight from Tel-Aviv to London departs at 12:00.
     * Flight is full. Flight from New York to Tel-Aviv departs at 10:50. Flight is
     * full.)
     * 
     * @return a string representation of the airport. (for example: The
     *         flights for airport Tel-Aviv today are: Flight from Tel-Aviv to
     *         London departs at 12:00. Flight is full. Flight from New York to
     *         Tel-Aviv departs at 10:50. Flight is full.)
     */
    public String toString()
    {
        String output = "The flights for airport " + _airport + " today are:";
        if (_noOfFlights != 0) 
        { // in case there are no flights in the airport
            for (int i = 0; i < _noOfFlights; i++)
            {
                output +="\n";
                output += _flightSchedule[i].toString();
            }
        }
        return output;
    }
}

