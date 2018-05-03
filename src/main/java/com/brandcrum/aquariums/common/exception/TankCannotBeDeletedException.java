package com.brandcrum.aquariums.common.exception;

/**
 * Created by jadiaz on 3/05/18.
 */
public class TankCannotBeDeletedException extends RuntimeException {
    public TankCannotBeDeletedException(String message) {
        super(message);
    }
}
