
package com.itrail.test.exception.mapper;
/**
 *
 * @author barysevich_k
 */
public class ItException extends Exception{
    private  int code;

 
    public ItException(){
    }

    public ItException(String string) {
        super(string);
    }

    public ItException(int code, String message ){
        super(message);
        this.code = code;
    }  

    
    public int getPri(){
        return code;
    } 

    @Override
    public String toString() {
        return "ItException{" + "code=" + code + '}';
    }
    
}
