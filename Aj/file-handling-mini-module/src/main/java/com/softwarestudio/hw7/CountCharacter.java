package com.softwarestudio.hw7;

import java.io.*;
import java.nio.file.*;

public class CountCharacter {

	private char letter;
	private Path file;
	public CountCharacter(char letter, Path file) {
		this.letter = letter;
		this.file = file;
	}
	
	public static void main(String[] args) {
		char letter = args[0].charAt(0);
		Path file = Paths.get("xanadu.txt");
		int count = new CountCharacter(letter, file).getCount(letter, file);
		System.out.format("File %s has %d instances of letter '%c'.%n", file, count, letter);
	}

	private int getCount(char letter, Path file) {
		int count = 0;
        try {
        		InputStream in = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            {
            String line = null;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (letter == line.charAt(i)) {
                        count++;
                    }
                }
             }
            }
            //System.out.println("count: "+ count);
        } catch (IOException x) {
            System.err.println(x);
        }
		return count;
	}

}
