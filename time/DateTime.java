package time;

public class DateTime {
    public int secondsTotal;

    public int years, months, days, hours, minutes, seconds;
    
    public DateTime(int secondsTotal){
        this.secondsTotal = secondsTotal;
    }

    //statically returns a DateTime object of the specified second length
    public static DateTime getTime(int secondsTotal){
        DateTime dt = new DateTime(secondsTotal);
        dt.doTime();
        return dt;
    }

    public void doTime(){
        //pre-assign seconds, without messing with secondsTotal
        seconds = secondsTotal;

        //divide and modulo by number of seconds in a year
        years = seconds / (60 * 60 * 24 * 30 * 12);
        seconds %= (60 * 60 * 24 * 30 * 12);

        //number of seconds in a month on what remains
        months = seconds / (60 * 60 * 24 * 30);
        seconds %= (60 * 60 * 24 * 30);

        //seconds in a day
        days = seconds / (60 * 60 * 24);
        seconds %= (60 * 60 * 24);

        //seconds in an hour
        hours = seconds / (60 * 60);
        seconds %= (60 * 60);

        //seconds in a minute
        minutes = seconds / (60);
        seconds %= (60);
    }
}