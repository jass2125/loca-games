/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.loca.games.exceptions;

/**
 *
 * @author Anderson Souza
 */
public class RentException extends Exception {

    public RentException(String msg) {
        super(msg);
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMessage() {
        return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }

    public RentException() {
    }

    public RentException(Throwable cause) {
        super(cause);
    }

    public RentException(String message, Throwable cause) {
        super(message, cause);
    }
    

}
