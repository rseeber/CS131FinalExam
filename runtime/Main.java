/*
 * Developer: River Seeber (https://github.com/rseeber)
 * Date: December 02, 2024
 * Project: CS 131 Final Exam
 * Version: 1.0.0
 */

package runtime;

import clock.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num;

        Scanner scnr = new Scanner(System.in);

        System.out.print("How many days do you want to wait for?\n> ");
        double days = scnr.nextFloat();
        System.out.print("How many years do you want to wait for?\n> ");
        double years = scnr.nextFloat();
        scnr.close();
        
        //     (years * number_of_seconds_per_year) + (days * number_of_seconds_per_day)
        num = (int)(years * 12 * 30 * 24 * 60 * 60) + (int)(24 * 60 * 60 * days);

        //tick each clock by the user inputted value, then print the readout
        Clock c = new SundialClock();
        c.tick(num);
        c.printReadout();
        
        c = new AtomicClock();
        c.tick(num);
        c.printReadout();

        c = new CuckooClock();
        c.tick(num);
        c.printReadout();

        c = new GrandfatherClock();
        c.tick(num);
        c.printReadout();

        c = new WristClock();
        c.tick(num);
        c.printReadout();
    }
}
