public class TeX implements TextFormat{
    public TeX(){}

    @Override
    public void display(String tokens){
        for(char c : tokens.toCharArray()){
            switch(c){
                case 'C' -> {System.out.print('c'); }
                case 'F' -> {System.out.print('_'); }
                case 'P' -> {System.out.print('|'); }
                default -> {}
            }
        }
        System.out.println();
    }
}