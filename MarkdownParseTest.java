import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void markdownTest() throws IOException {
	    String contents = Files.readString(Path.of("test-file.md"));
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test3() throws IOException {
	    String contents = Files.readString(Path.of("new3.md"));
        assertEquals(List.of("https://google.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test4() throws IOException {
	    String contents = Files.readString(Path.of("new2.md"));
        assertEquals(List.of("https://dell.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testRepo() throws IOException {
	    String contents = Files.readString(Path.of("test-file3.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(contents).get(0));
    }

    
    @Test
    public void testRepo2() throws IOException {
	    String contents = Files.readString(Path.of("test-file4.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testRepo3() throws IOException {
	    String contents = Files.readString(Path.of("test-file5.md"));
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
}