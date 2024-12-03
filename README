# CS 131 Final Exam - Clock Offsets and Counting

This project focused on the ways that clocks of varying accuracy will drift over time at different rates. The definitions for what rate each clock will drift at is defined in Table 1 at the bottom of the Exam Requirements pdf in `/1-projectRequirements`. This was a solo project, and all code is my own, excepting what was included within the two included project requirement pdfs.

## ClockTime class - storing raw seconds

The ClockTime class has two properties, `int seconds_` and `double ms_`. The first
records the total number of seconds elapsed on the clock, and the second records a quantity of partial seconds, which is used to increment offsets and simulated inaccuracies in the clock's time measurement.

For each second that the Clock object is ticked forward by, it also ticks the partial seconds (`ms_`) by the designated offset for that clock type. Whenever the partial seconds adds up to 1 second, it rolls over into the `seconds_` variable, allowing the small simulated innacuracies to add up over time.

## DateTime class - converting raw seconds into human readable format

The DateTime class allows a user to take the `seconds_` value from the ClockTime class (or any total of seconds) and calculate a number of seconds, minutes, hours, days, months, and years that have elapsed. For our purposes, I've defined 1 month equal to 30 days, and 1 year equal to 12 months. Thus a year is defined as 360 days. So this calandar is not meant to be perfectly accurate on the scale of months or years.

Furthermore, both the DateTime and ClockTime class count raw seconds on an 32 bit signed integer, and so it falls prey to the so-called "Year 2038 Problem".