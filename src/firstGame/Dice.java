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
    private final Random random = new Random();

    public int roll(int max){
        return 1 + random.nextInt(max);
    }

    public int d4(){
        return roll(4);
    }

    public int d6(){
        return roll(6);
    }

    public int d8(){
        return roll(8);
    }

    public int d10(){
        return roll(10);
    }

    public int d12(){
        return roll(12);
    }

    public int d20(){
        return roll(20);
    }

    public int d100(){
        return roll(100);
    }
}
