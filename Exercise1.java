package com.studio.bill.file_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class Exercise1 {
    private static final String FILENAME = "xanadu.txt";
    private static final Charset CHARSET = Charset.defaultCharset();
    private static final String PROMPTFORCHAR = "Please enter a character to count: ";
    private Path file = null;

    public static void main(String[] args)
    {
        Exercise1 exercise1 = new Exercise1();
        exercise1.run();

    }

    public void run()
    {
        char c = this.getCharFromUser();
        List<String> fileList;

        this.openFile();
        fileList = this.readFile();
        System.out.println("Character " + c + " occurs "
                + this.numberOfOccurances(fileList, c) + " times");

    }

    // TODO: Read character from user
    public char getCharFromUser()
    {
        char c = 0;
        BufferedReader readIn = null;
        readIn = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println(PROMPTFORCHAR);
            c = readIn.readLine().trim().charAt(0);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                readIn.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return c;
    }

    public void openFile()
    {
        file = Paths.get(FILENAME);
    }

    @SuppressWarnings("finally")
    public List<String> readFile()
    {
        List<String> returnList = null;
        try
        {
            returnList = Files.readAllLines(this.file, CHARSET);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return returnList;
        }
    }

    public int numberOfOccurances(List<String> fileList, char c)
    {
        int count = 0;
        for (String line : fileList)
        {
            char[] charArray = line.toCharArray();
            for (int i = 0; i < charArray.length; i++)
            {
                if (charArray[i] == c)
                {
                    count++;
                }
            }
        }
        return count;
    }
}

