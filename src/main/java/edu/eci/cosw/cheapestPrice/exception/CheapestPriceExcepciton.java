package edu.eci.cosw.cheapestPrice.exception;

/**
 * Created by Daniela Sepulveda.
 */
public class CheapestPriceExcepciton extends Exception{

    /**
     * @param message
     * @param cause
     */
    public CheapestPriceExcepciton(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public CheapestPriceExcepciton(String cause) {
        super(cause);
    }
}
