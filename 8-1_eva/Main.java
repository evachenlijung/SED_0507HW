import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_file>");
            return;
        }
        try{
            App app = new App();
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while((line = reader.readLine()) != null){
                String[] ss = line.split("\\s+");
                if(ss.length == 1){
                    if(ss[0].equals("Present")){
                        app.display();
                    }else{
                        app.setStyle(ss[0]);
                    }
                }else if(ss.length == 2){
                    app.addWidget(ss[0], ss[1]);
                }
            }

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return;
        }
    }
}