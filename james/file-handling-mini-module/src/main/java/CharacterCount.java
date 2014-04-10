import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.*;

public class CharacterCount {

        public static void main (String[] args) throws IOException {
                Path file = Paths.get("src/xanadu.txt");
                CharacterCount characterCount = new CharacterCount();
                char character = characterCount.requestUserInput();
                int count = characterCount.countCharacters(character, file);
                System.out.println("There are " + count + " " + character + " in the file");
				//New comment
        }

        private char requestUserInput() throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String tempInput;
                try {
                        System.out.print("Please enter the letter you want to be counted: ");
                        tempInput = br.readLine().trim();
                        return tempInput.toCharArray()[0];
                }
                finally {
                        br.close();
                }
        }

        public int countCharacters(char character, Path file) throws IOException {
                int count = 0;
                InputStream in = Files.newInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String currentLine = null;
                try {
                        while ((currentLine = reader.readLine()) != null) {
                                for (int i = 0; i < currentLine.length(); i++) {
                                        if (Character.toLowerCase(character)==
                                                Character.toLowerCase(currentLine.charAt(i))) {
                                                count ++;
                                        }
                                }
                        }

                } catch (IOException x) {
                        //DO SOMETHING
                }
                finally {
                        reader.close();
                        in.close();
                }

                return count;
        }
}
