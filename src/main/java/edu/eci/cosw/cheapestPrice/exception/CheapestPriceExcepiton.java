package edu.eci.cosw.cheapestPrice.exception;

/**
 * Created by Daniela Sepulveda.
 */
public class CheapestPriceExcepiton extends Exception{

    /**
     * @param message
     * @param cause
     */
    public CheapestPriceExcepiton(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public CheapestPriceExcepiton(String cause) {
        super(cause);
    }
}
