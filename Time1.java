
/**
 * Represents time - hours:minutes. Coordinates cannot be negative.
 *
 * @author Yair Etkes
 * ID - 308224518
 */
public class Time1
{
    
    // instance variables -
    private int _hour;
    private int _minute;
    

    /**
     * Constructor for objects of class Time1
     * initialise instance variables to specific values.
     * @param    h    represent the hour (between 0 and 23)
     * @param    m    represent the minute (between 0 and 59
     */
    
    public Time1(int h, int m)
    {
        if ((h >= 0) && (h<=23)) // A check to make sure that the values are correct.
        { _hour = h;}
        else if ((h<0)||(h>23))
        {_hour = 0;}
        
        if((m>=0) && (m<=59)) // A check to make sure that the values are correct.
        { _minute = m;}
        else if ((m<0)||(m>59))
        { _minute = 0;}
    }
    
    /**
     * Copy constructor for Time1. Construct a time with the same instance variables as another time.
     * 
     * @param    other    The time object from which to construct the new time.
     * 
     */
    
    public Time1(Time1 other)
{
    this._hour = other._hour; 
    this._minute = other._minute; 
}

    /**
     * Returns the hour of the time.
     *
     *
     * @return    the hour of the time.
     */
     
    public int getHour()
    {
        return _hour;
    }
     
    /**
     * Returns the minute of the time.
     *
     *
     * @return    Returns the minute of the time.
     */
     
    public int getMinute()
    {
        return _minute;
    }
    
    /**
     *  Changes the hour of the time.
     * 
     * @param    num    The new hour of the time.
     */

    public void setHour (int num)
    {
      if ((num >= 0) && (num<=23)) // A check to make sure that the values are correct.
        { _hour = num;}
    }
    
     /**
     *  Changes the minute of the time.
     * 
     * @param    num    The new minute of the time.
     */

    public void setMinute (int num)
    {
       if((num>=0) && (num<=59)) // A check to make sure that the values are correct.
        { _minute = num;}
    }
    
    /**
     * Return a string representation of this time (hh:mm).
     *
     *
     * @return     a string representation of this time (hh:mm).
     */
    
    public String toString()
    {
        if ((_minute<10) && (_hour<10)) // A check to make sure that the 0's  .
         return ("0"+ _hour+":0" + _minute);
        
            else if ((_minute>=10) && (_hour<10))
             return ("0"+ _hour+":" + _minute);
          
            else if ((_minute<10) && (_hour>=10))
             return ( _hour+":0" + _minute);
         
             else 
             return ( _hour+":" + _minute);
    }
    
     /**
     * Return the amount of minutes since midnight.
     *
     *
     * @return     the amount of minutes since midnight..
     */
    
    public int minFromMidnight()
    {
        return ((_hour * 60) + _minute);
    }
    
    
    /**
     *  Check if the received time is equal to this time.
     * 
     * @param    Time1 other    represent the other time.
     * @return    true    if the times are equal.
     */
    
    public boolean equals (Time1 other)
    {
        if (this.minFromMidnight() == other.minFromMidnight())
        {return true;}
        else
        {return false;}
    }
        
     /**
     *   Check if this time is before a received time.
     * 
     * @param    Time1 other    represent the other time.
     * @return    m    represent the minute (between 0 and 59)
     */
    
    public boolean before (Time1 other)
    {
        if (this.minFromMidnight() < other.minFromMidnight())
        {return true;}
        else 
        {return false;}
    }
    
    /**
     *   Check if this time is after a received time.
     * 
     * @param    Time1 other    represent the other time.
     * @return    m    represent the minute (between 0 and 59)
     */
    
    public boolean after (Time1 other)
    {
        if (!(this.before(other)) && !((this._hour == other._hour) && (this._minute == other._minute)))
        {return true;}
            else 
        {return false;}
    }
      
    /**
     *   Calculates the difference (in minutes) between two times
     * 
     * @param    Time1 other    represent the other time.
     * @return    difference    represent the difference between this time and other time.
     */
    
    public int difference (Time1 other)
    {
        return this.minFromMidnight() - other.minFromMidnight();
    }
    
    
    
        
}
