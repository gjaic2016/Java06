package main;

/**
 * Incorrect hourly rate exception
 *
 * Raises warning when hourly rate is incorrect
 *
 */
public class IncorrectHourlyRateException extends Exception{
    public IncorrectHourlyRateException(String message) {
        super(message);
    }
}
