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
public class CompanyNotFoundException extends Exception{
    public CompanyNotFoundException(String message){
        super(message);
    }
    public CompanyNotFoundException(){
        super("Company not found");
    }
}