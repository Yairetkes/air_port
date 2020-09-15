
/**
 * This class represents a flight. A Flight object is represented by the flight's origin,destination,departure time, 
 * flight duration, no of passengers,if it is full and the price.
 *
 * @author Yair Etkes.
 * ID - 308224518
 */
public class Flight
{
    // instance variables:
    private String _origin;
    private String _destination;
    private Time1 _departure;
    private int _flightDuration;
    private int _noOfPassengers;
    private boolean _isFull;
    private int _price;

    // A final represents maximum passenger allowed on plane:
    private final int MAX_CAPACITY = 250;

    /**
     * Constructor for a Flight object. If the number of passengers exceeds the
     * maximum capacity, the number of passengers will be set to the maximum
     * capacity. If the number of passengers is negative, the number of passengers
     * will be set to zero. If the flight duration is negative the flight duration
     * will be set to zero. If the price is negative the price will be set to zero.
     * 
     * @param     origin    The city the flight leaves from.
     * @param     destination    The city the flight lands at.
     * @param     hour      the departure hour (should be between 0-23).
     * @param     minute     The departure minute (should be between 0-59).
     * @param     flightDuration     The duration time in minutes (should not be negative).
     * @param     noOfPassengers     The number of passengers (should be between 0-maximum capacity).
     * @param     price      The price (should not be negative).
     */

    public Flight(String origin, String destination, int hour, int minute, int flightDuration, int noOfPassengers, int price)
    {
        _origin = origin;
        _destination = destination;
        _departure = new Time1(hour, minute);
        if (flightDuration < 0) // A check to make sure that the values are correct.
        { _flightDuration = 0;}
        else 
        {_flightDuration = flightDuration;}
        if (noOfPassengers < 0) // Capacity is between 0 and 250.
        {_noOfPassengers = 0;}
        else if (noOfPassengers > MAX_CAPACITY)
        {_noOfPassengers = MAX_CAPACITY;}
        else
        {_noOfPassengers = noOfPassengers;}
        if (price < 0) // A check to make sure that the price is not negative.
        {_price = 0;}
        else 
        {_price = price;}

        if (_noOfPassengers == MAX_CAPACITY) // A check wether the flight is full or not.
        {_isFull = true;}
        else
        {_isFull = false;}
    }

    /**
     * Copy constructor for a Flight object. Constructs a Flight object with the
     * same attributes as another Flight object.
     * 
     * @param      other    The Flight object from which to construct the new Flight.
     */
    public Flight(Flight other) 
    {
        _origin = other._origin;
        _destination = other._destination;
        _departure = new Time1(other._departure);
        _flightDuration = other._flightDuration;
        _noOfPassengers = other._noOfPassengers;
        _price = other._price;
        _isFull = other._isFull;
    }

    /**
     *  Returns the flight departure time.
     *
     * @return    flight departure time.
     */
    public Time1 getDeparture()
    {
        return new Time1 (_departure);
    }

    /**
     *  Returns the flight origin.
     *
     * @return    flight origin.
     */
    public String getOrigin()
    {
        return _origin;
    }

    /**
     *  Returns the flight destination.
     *
     * @return    flight destination.
     */
    public String getDestination()
    {
        return _destination;
    }

    /**
     *  Returns the flight duration time in minutes.
     *
     * @return    flight duration time in minutes.
     */
    public int getFlightDuration()
    {
        return _flightDuration;
    }

    /**
     * Returns whether the flight is full or not.
     * 
     * @return    True    if the flight is full.
     */
    public boolean getIsFull() 
    {
        return _isFull;
    }

    /**
     * Returns the number of passengers on the flight.
     *
     * @return    the number of passengers on the flight.
     */
    public int getNoOfPassengers()
    {
        return _noOfPassengers;
    }

    /**
     * Returns the price of a ticket on the flight.
     * 
     * @return The price of a ticket on the flight.
     */
    public int getPrice() 
    {
        return _price;
    }

    /**
     * Changes the flight's departure time
     * 
     * @param      Time1 departureTime    The Flight's new departure time.
     */
    public void setDeparture (Time1 departureTime)
    {
        _departure = new Time1 (departureTime);
    }

    /**
     * Changes the flight's origin.
     * 
     * @param      origin     The Flight's new origin.
     */
    public void setOrigin(java.lang.String origin)
    {
        _origin = origin;
    }

    /**
     * Changes the flight's destination.
     * 
     * @param      destination    The Flight's new destination.
     */
    public void setDestination(java.lang.String destination)
    {
        _destination = destination;
    }

    /**
     * Changes the flight's duration time.
     * If the parameter is negative, the
     * duration time will remain unchanged.
     *
     * @param      durTimeMinutes    The Flight's new duration time.
     */
    public void setFlightDuration(int durTimeMinutes)
    {
        if (durTimeMinutes >= 0)
        { _flightDuration = durTimeMinutes;}
    }

    /**
     * Changes the number of passengers.
     * If the parameter is negative,or bigger than maximum capacity the
     * number of passengers will remain unchanged.
     *
     * @param      noOfPass    The Flight's new number of passengers.
     */
    public void setNoOfPassengers(int noOfPass)
    {
        if (noOfPass >= 0 && noOfPass<= MAX_CAPACITY)
        {_noOfPassengers = noOfPass;}
    }

    /**
     * Changes the flight price.
     * If the parameter is negative
     * flight price will remain unchanged.
     *
     * @param      price    The Flight's new price.
     */
    public void setPrice(int price)
    {
        if (price >= 0)
        {_price = price;}
    }

    /**
     * Checks if the received flight is equal to this flight. Flights are considered
     * equal if the origin, destination and departure times are the same.
     * 
     * @param        other      The flight to be compared with this flight.           
     * @return       True        if the received flight is equal to this flight.
     */
    public boolean equals(Flight other)
    {
        return (_origin.equals(other._origin) && _destination.equals(other._destination)
            && _departure.equals(other._departure));
    }

    /**
     * Returns the arrival time of the flight. 
     *
     * @return    Arrival time of the flight.
     */
    public Time1 getArrivalTime()
    {
        int arrivalTime = _departure.minFromMidnight() + _flightDuration; // time from midnight to the arrival, in
        // minutes
        return new Time1(arrivalTime / 60 % 24, arrivalTime % 60); 
        //Note - the flights may land on different days 
    }

    /**
     *  Add passengers to this flight. 
     *
     * @param       num         the number of passengers added.
     * @return      true        if there's space for everyone.
     */

    public boolean addPassengers(int num)
    {
        if (_noOfPassengers + num <= MAX_CAPACITY)
        {
            _noOfPassengers += num;
            _isFull = (_noOfPassengers == MAX_CAPACITY) ? true : false;
            return true;
        }
        return false;
    }

    /**
     * Check if this flight is cheaper than another flight.
     * 
     * @param        other       The flight whose price is to be compared with this flight's price.
     * @return       True        if this flight is cheaper than the received flight.
     */

    public boolean isCheaper(Flight other)
    {
        return (this._price < other. _price);
    }

    /**
     * Calculate the total price of the flight.
     * 
     * @return       the total price of the flight.
     */

    public int totalPrice()
    {
        return (_price * _noOfPassengers);
    }

    /**
     * Check if this flight lands before another flight.
     *
     * @param         Flight other            the other flight to be compared with.
     * @return        true        if this flight lands before another flight.
     */

    public boolean landsEarlier(Flight other)
    {
        int arrivalFromMidnight = this._departure.minFromMidnight() + this._flightDuration;
        int otherArrivalFromMidnight = other._departure.minFromMidnight() + other._flightDuration;

        return (arrivalFromMidnight < otherArrivalFromMidnight);
    }

    /**
     * Return a string representation of this flight (for example: "Flight from London to Paris departs at 09:24.Flight is full.").
     *
     * @return     a string representation of this flight as described above.
     */

    public String toString()
    {
        if (_isFull)
        {return ("Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". Flight is full.");}
        else
        {return ("Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". Flight is not full.");}
    }


}
