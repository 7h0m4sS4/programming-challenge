package de.bcxp.challenge.exceptions;

public class NotImplementedException extends RuntimeException {
    /**
     * Custom exception for not implemented methods
     */
    private static final long serialVersionUID = 1L;

    public NotImplementedException(String message) {
        super(message);
    }

}
