import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        TextProc.load();
        Character[][] symbols = TextProc.phones("hello world");
        for(int i = 0; i< symbols.length; i++){
            for(int j = 0; j < symbols[i].length; j++){
                System.out.print(symbols[i][j]);
            }
            System.out.print(" ");

        }
    }
}