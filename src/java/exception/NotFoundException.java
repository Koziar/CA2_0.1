/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;


/**
 *
 * @author Cookie
 */
public class NotFoundException extends Exception{

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super("Not found");//May have to change this message to something more interesting;)
    }
    
}
