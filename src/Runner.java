import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        TextProc.load();
        Character[][] symbols = TextProc.phones("Colin Tod");
        for (Character[] symbol : symbols) {
            for (Character aSymbol : symbol) {
                System.out.print(aSymbol);
            }
            System.out.print(" ");
        }
    }
}