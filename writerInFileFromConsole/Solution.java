package javarush.javacore.level3.lection11.writerInFileFromConsole;

/*program should write into the file ALL user writes in console
unless he writes "exit".
"exit" should be written too.
Every string in new line.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static final String EXIT = "exit";

    public static void main(String[] args) {
        System.out.println("Enter the name of file you want write in:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()))){

            System.out.println("Please enter everything you want to write into the file" +
                    "\nType \"" + EXIT + "\" to exit");

            String str;
            do{
                str = reader.readLine();
                writer.write(str + "\n");

            } while ( !str.equalsIgnoreCase(EXIT));



        } catch(Exception e){
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
    }
}
