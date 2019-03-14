/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstGame;

/**
 *
 * @author jarrenj
 */
import java.util.*;
public class Dice {
    private static final Random random = new Random();

    public static int roll(int max){
         return 1 + random.nextInt(max);
    }

    public static int d4(){
        return roll(4);
    }

    public static void d6(){
        roll(6);
    }

    public static void d8(){
         roll(8);
    }

    public static void d10(){
         roll(10);
    }

    public static void d12(){
         roll(12);
    }

    public static void d20(){
         roll(20);
    }

    public static void d100(){
         roll(100);
    }
}
