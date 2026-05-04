import java.io.*;

public class Boiler{
    private Chocolate chocolate;
    private boolean boiled;


    public Boiler(){
        this.chocolate = null;
        this.boiled = false;
    }

    public boolean isEmpty(){
        return this.chocolate == null;
    }

    public boolean isFilled(){
        return chocolate != null;
    }

    public boolean isBoiled(){
        return this.boiled;
    }

    public void setBoiled(boolean boiled){
        this.boiled = boiled;
    }

    public void fill(){
        if(isEmpty()){
            this.chocolate = new Chocolate();
            System.out.println("Fill chocolate");
        }
    }
    
    public void boil(){
        if(isFilled() && !isBoiled()){
            setBoiled(true);
            System.out.println("Boil chocolate");
        }
    }

    public void drain(){
        if(isFilled() && isBoiled()){
            this.chocolate = null;
            setBoiled(false);
            System.out.println("Drain the boiled chocolate");
        }
    }
}