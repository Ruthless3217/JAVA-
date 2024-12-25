import java.io.*;

public class FileWordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
        String line;
        int lineCount = 0, wordCount = 0, charCount = 0;

        while ((line = reader.readLine()) != null) {
            lineCount++;
            charCount += line.length();
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }

        reader.close();
        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);
    }
}
