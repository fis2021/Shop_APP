package jpm.exceptions;

public class NotEnoughtBalance extends Exception {



    public NotEnoughtBalance() {
        super(String.format("You don't have enought funds to make the purchase!"));

    }
}
