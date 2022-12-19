package org.example;

/**
 * Utility class for sout usage
 */
public class Logger {
    /**
     * @param message String we want to output
     *                Used to log messages instead of stdout
     */
    static void log(String message){
        System.out.println(message);
    }

    /**
     * Private constructor to hide
     */
    private Logger(){}
}
