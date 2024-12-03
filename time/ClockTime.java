/*
 * This class handles all of the "raw seconds" fucntionality of counting
 * up on the clock. Converting into date format is handled by the DateTime class.
 */
package time;

public class ClockTime {
    int seconds_;
    double ms_;     //milliseconds. Add this value to your seconds_ to get the full reading.
                    //all offsets due to impresision should be applied here

    public ClockTime(int seconds_){
        this.seconds_ = seconds_;
        ms_ = 0.00d;
    }
    
    //starts the clock over back at zero
    public void reset(){
        seconds_ = 0;
        ms_ = 0.00d;
    }

    public int getSeconds(){
        return seconds_;
    }

    //increment the clock by a given value of seconds and milliseconds. Milliseconds may be negative
    public void tick(int addSec, double addMs){
        seconds_ += addSec;
        ms_ += addMs;

        //push overflow from milliseconds into the seconds
        while(ms_ > 1){
            --ms_;
            ++seconds_;
        }
        //same for negative offsets
        while (ms_ < -1) {
            ++ms_;
            --seconds_;
        }
    }
}
