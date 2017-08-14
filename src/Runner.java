import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        TextProc.load();
        System.out.println(TextProc.lexicon.get("HELLO(1)"));
    }
}