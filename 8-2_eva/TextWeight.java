public class TextWeight implements TextFormat{
    public TextWeight(){

    }
    
    @Override
    public void display(String tokens){
        for(char c : tokens.toCharArray()){
            switch(c){
                case 'C' -> {System.out.print("<Char>"); }
                case 'F' -> {System.out.print("<Font>"); }
                case 'P' -> {System.out.print("<Paragraph>"); }
                default -> {}
            }
        }
        System.out.println();
    }
}