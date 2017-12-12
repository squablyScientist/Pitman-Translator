public class GraphicsCalculations {


    public static int wordLength(Character[] word){
        int len = 0;
        Stroke stroke;
        for(Character c : word){
            if(TextProc.isVowel(c))
                continue;
            stroke = TextProc.strokeMap.get(c);
            int strokeSpan = stroke.getEnd().x - stroke.getStart().x;
            len+= strokeSpan;
        }
        return len;
    }
}
