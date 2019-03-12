/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author jarrenj
 */
public class loadInstance {
    private static int instanceLevel;
    private static String line;
    private static String restLevel;

    public static void instance(int instanceLevel) throws FileNotFoundException, InterruptedException{
        File f = new File("instances/"+instanceLevel+".txt");
        Scanner readingFile = new Scanner(f);
        switch(instanceLevel){
            case 1:
                while(readingFile.hasNext()) {
                    line = readingFile.nextLine();
                    Thread.sleep(1000);
                    System.out.println(line);
                }
                readingFile.close();
                break;
            case 2:
                while(readingFile.hasNext()) {
                    line = readingFile.nextLine();
                    Thread.sleep(1000);
                    System.out.println(line);
                }
                readingFile.close();
                break;
        }
    }

    public static void rest(int restLevel){
        switch(restLevel){
            case 1:
                Character.stats();
                //also prints current inventory to screen
        }
    }
}