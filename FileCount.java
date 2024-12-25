import java.io.*;

public class FileCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        String line;
        int characterCount = 0, wordCount = 0, lineCount = 0;

        while ((line = br.readLine()) != null) {
            lineCount++;
            String[] words = line.split("\\s+");
            wordCount += words.length;
            characterCount += line.length();
        }

        br.close();
        System.out.println("Characters: " + characterCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Lines: " + lineCount);
    }
}
