package ma.enset.glsid.hamzaelghazouani.ebankapp.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message){
        super(message);
    }
}

