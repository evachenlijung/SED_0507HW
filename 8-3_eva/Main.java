import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_file>");
            return;
        }
        try{
            Boiler boiler = new Boiler();

            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while((line = reader.readLine()) != null){
                switch(line){
                    case "Fill" -> {boiler.fill(); }
                    case "Boil" -> {boiler.boil(); }
                    case "Drain" -> {boiler.drain(); }
                    default -> {}
                }
            }
            reader.close();
        }catch(Exception e){
            System.out.print(e.getMessage());
            return;
        }
    }
}