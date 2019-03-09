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
    public static int instanceLevel;
    public static String line;

    public static void instance(int instanceLevel) throws FileNotFoundException, InterruptedException{
        File f = new File("instances/"+Integer.toString(instanceLevel)+".txt");
        Scanner readingFile = new Scanner(f);
        switch(instanceLevel){
            case 1:
                while(readingFile.hasNext()) {
                    line = readingFile.nextLine();
                    Thread.sleep(3000);
                    System.out.println(line);
                }
        }
    }
}
