
import java.lang.Class;
import java.io.*;

public class Widget{
    private String name;

    public Widget(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void display(){
        System.out.println(this.getClass().getName() + " " + this.name);
    }
}