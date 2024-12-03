package clock;

import time.*;

public abstract class Clock {
    protected ClockTime clockTime_;     //this is the object where actual seconds and partial seconds are stored
    
    protected double offsetPerSecond;   //should be assigned in the concrete constructor


    protected CLOCK_TYPE type_;
    private String name_;

    public Clock(){
        clockTime_ = new ClockTime(0);
        type_ = new CLOCK_TYPE();
    }

    //prints out the date and what type of clock it is
    public void printReadout(){
        displayDate();
        System.out.print("\t//");
        printType();
    }

    public void printType(){
        System.out.println(type_.type + " Clock");
    }

    // moves the clock forward by a number of seconds, adding an offset to each second
    public void tick(int seconds_){
        clockTime_.tick(seconds_, offsetPerSecond * seconds_);
    }

    //print the date after waiting some number of seconds from the UNIX Epoch
    public void displayDate(){
        DateTime dt = new DateTime(clockTime_.getSeconds());
        dt.doTime();

        //for negative numbers, just print the year
        if(dt.secondsTotal < 0){
            System.out.print("[" + (1970 + dt.years) + "]");
            return;
        }
        
        final String[] monthNames = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
        //prints out a standard date readout counting up from UNIX Epoch
        System.out.printf("%s %02d, %04d  %02d:%02d:%02d %s", monthNames[dt.months], dt.days  + 1, (1970 + dt.years), dt.hours % 12,
        dt.minutes, dt.seconds, ((dt.hours >= 12) ? "AM" : "PM"));
    }

    //display the total seconds the clock has counted
    public void displaySeconds(){
        System.out.println("Seconds Total: "+ clockTime_.getSeconds());
    }

    //starts the clock over
    public void reset(){
        clockTime_.reset();
    }

    public final String name(){
        return name_;
    }

}