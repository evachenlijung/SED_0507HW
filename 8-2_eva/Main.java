import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_file>");
            return;
        }
        try{
            Reader reader = new Reader();
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String line;
            while((line = br.readLine()) != null){
                TextFormat textformat = null;
                switch(line){
                    case "TeX" -> {textformat = new TeX(); }
                    case "TextWidget" -> {textformat = new TextWidget(); }
                    default -> {}
                }

                line = br.readLine();
                RTF rtf = new RTF(line);

                reader.convert(rtf.getTokens(), textformat);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }

    } 
}