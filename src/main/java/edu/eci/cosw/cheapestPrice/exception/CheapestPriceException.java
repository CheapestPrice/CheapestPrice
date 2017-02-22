package edu.eci.cosw.cheapestPrice.exception;

/**
 * Created by Daniela Sepulveda.
 */
public class CheapestPriceException extends Exception{

    /**
     * @param message
     * @param cause
     */
    public CheapestPriceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public CheapestPriceException(String cause) {

        super(cause);
    }
}
