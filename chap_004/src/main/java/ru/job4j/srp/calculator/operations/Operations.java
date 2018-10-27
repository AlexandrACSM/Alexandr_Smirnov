package ru.job4j.srp.calculator.operations;


/**
 * @author Aleksandr Smirnov.
 */
public abstract class Operations {

    private  boolean quantityArgument;

    private  String operationKey;

    private String info;

    public Operations(boolean quantityArgument, String operationKey,String info) {
        this.quantityArgument = quantityArgument;
        this.operationKey = operationKey;
        this.info = info;
    }

    public String getKey() {
        return operationKey;
    }

    public boolean getQuantityArgument() {
        return quantityArgument;
    }

    public String getInfo(){
        return info;
    }

    public abstract double execute(double... argument);

}
