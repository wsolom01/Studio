import java.io.*;
import java.nio.file.*;
// This is a sample change to make a pull request
public class CountLetter {
	public static void main(String[] args) throws IOException 
	{
			char target = args[0].charAt(0);
			Path file = Paths.get("xanadu.txt");
			
			int count = 0;
			
			try (InputStream inputStream = Files.newInputStream(file);
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream)))
					{
					String currentLine = bufferedReader.readLine();
					while (currentLine != null) 
					{
							for (int i = 0; i < currentLine.length(); i++) {
									if (target == currentLine.charAt(i)) {
											count++;
									}
							}
						currentLine = bufferedReader.readLine();
					}
			} 
			
			System.out.print(count + " instances of '" + target + "' found in " + file);
	}
}
