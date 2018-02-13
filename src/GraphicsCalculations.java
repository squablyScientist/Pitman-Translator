import java.awt.*;

public class GraphicsCalculations {


    public static int wordLength(Character[] word){
        int len = 0;
        Stroke stroke;
        for(Character c : word){
            if(TextProc.isVowel(c))
                continue;
            stroke = TextProc.strokeMap.get(c);
            len += stroke.getLength();
        }
        return len;
    }

    /* Height displacement of a word in pixels */
    public static int wordHeight(Character[] word){
        int min = 0, max = 0;
        int y=0;
        Stroke stroke;
        for(Character c : word){
            if(TextProc.isVowel(c))
                continue;

            stroke = TextProc.strokeMap.get(c);
            Point start = stroke.getStart();
            Point end = stroke.getEnd();
            y += (end.y-start.y);

            if(y > max){
                max = y;
            }

            if(y < min){
                min = y;
            }
        }

        return (min + max) / 2;
    }
}
