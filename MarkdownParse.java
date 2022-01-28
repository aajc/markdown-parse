// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);

            if (markdown.indexOf("(", nextCloseBracket) != nextCloseBracket + 1) {
                return toReturn;
            }

            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (openParen == closeParen - 1) {
                openParen = markdown.indexOf("(", closeParen + 1);
                closeParen = markdown.indexOf(")", closeParen + 1);
            }

            if (openParen == -1) {
                return toReturn;
            }

            System.out.println(currentIndex);
            if (openParen > 0 || closeParen > 0) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }

            currentIndex = closeParen + 1;
            //System.out.println(currentIndex);


        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}