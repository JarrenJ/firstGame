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
public class Character {
    public static String playerName;
    public static int playerHp;
    public static int maxHp;
    public static int maxMana;
    public static int mana;
    public static int playerMeleeDmg;
    public static int playerRangeDmg;
    public static int xp;
    public static int enemyHp;
    public static int enemyMaxHp;
    public static int enemyMeleeDmg;
    public static int enemyRangeDmg;
    public static int damage;
    public static int level;
    public static int enemyLevel;
    public static String race;
    public static boolean combat;
    public static Scanner input = new Scanner(System.in);

    public static void stats(){
        if (race.compareTo("Sorcerer") == 0) {
            System.out.printf("-----[ Stats ]-----\nRace: %s\nMax HP: %d\nCurrent HP: %d\nMelee DMG: %d\nRange DMG: %d\nXP: %d\nLevel: %d\nMax Mana: %d\nMana: %d\n-----[ Stats ]-----", race, maxHp, playerHp, playerMeleeDmg, playerRangeDmg, xp, level, maxMana, mana);
        } else {
            System.out.printf("-----[ Stats ]-----\nRace: %s\nMax HP: %d\nCurrent HP: %d\nMelee DMG: %d\nRange DMG: %d\nXP: %d\nLevel: %d\n-----[ Stats ]-----", race, maxHp, playerHp, playerMeleeDmg, playerRangeDmg, xp, level);
        }
    }

    public static void createArcher(){
        race = "archer";
        maxHp = 12;
        playerHp = 12;
        playerMeleeDmg = 4;
        playerRangeDmg = 6;
        xp = 0;
        level = 1;
    }

    public static void createSorcerer(){
        race = "Sorcerer";
        maxHp = 12;
        playerHp = 12;
        playerMeleeDmg = 5;
        playerRangeDmg = 6;
        xp = 0;
        level = 1;
        mana = 10;
        maxMana = 10;
    }

    public static void createBarbarian(){
        race = "Barbarian";
        maxHp = 14;
        playerHp = 14;
        playerMeleeDmg = 8;
        playerRangeDmg = 0;
        xp = 0;
        level = 1;
    }

    public static void enemyAttack(){
        System.out.println("The enemy hit you!");
        playerHp = playerHp - enemyMeleeDmg;
            if(playerHp <= 0){
                System.out.println("DEATH");
                System.exit(0);//game over if player health < 0
            }else{
            System.out.println("Enemy dealt " + enemyMeleeDmg + " damage!\nYou have " + playerHp + " health left.");
            }
    }

    public static boolean attack(Boolean ranged){
        //set boolean 'ranged' to true if using ranged attack
        System.out.println("You hit!");
        if (ranged) {
            enemyHp = enemyHp - playerRangeDmg;
            damage = playerRangeDmg;
        } else {
            enemyHp = enemyHp - playerMeleeDmg;
            damage = playerMeleeDmg;
        }
        if (enemyHp <= 0) {
            System.out.println("You Won!");
            return false;
        } else {
            System.out.println("You dealt " + damage + " damage!\nThe enemy has " + enemyHp + " health left \nGet back in there and fight!");
        }
        return true;
        }

    public static boolean spellAttack(String spellType, int spellDamage) throws InterruptedException{
        if (mana > 0){
            switch(spellType){
                case "fireball":
                    mana = mana - 5;
                    System.out.println("Rolling a D4 to determine Fireball Damage...");
                    Thread.sleep(1000);
                    enemyHp = enemyHp - spellDamage;
                    damage = spellDamage;
                    System.out.println("Current Mana: " + mana);
                    break;
                case "cure wounds":
                    mana = mana - 5;
                    System.out.println("Rolling a D4 to determine Health to restore...");
                    Thread.sleep(1000);
                    playerHp = playerHp + spellDamage;
                    System.out.println("You restored " + spellDamage + " health!");
                    System.out.println("Current Mana: " + mana);
                    return true;
            }
        }

        if (enemyHp <= 0) {
        System.out.println("You Won!");
        return false;
        } else {
            System.out.println("You dealt " + damage + " damage!\nThe enemy has " + enemyHp + " health left \nGet back in there and fight!");
        }
        return true;
    }


    public static void addXp(int xpAdd){
        xp += xpAdd;
    }

    public static void checkLevelUp(){
        if (xp > 10) {
            level = 2;
            maxHp = maxHp + 5;
            playerHp = maxHp;
            if (race.equals("Sorcerer")) {
                maxMana = maxMana + 5;
                mana = maxMana;
            }
            playerMeleeDmg = playerMeleeDmg + 3;
            if (race.equals("Archer") || race.equals("Sorcerer")) {
                playerRangeDmg = playerRangeDmg + 2;
            }
            stats();
        }
    }

    public static void createEnemy(int eLevel){
        double chance;
        chance = Math.random();
        //50% chance
        if (eLevel == 1) {
            if (chance < .5) {
                enemyMaxHp = 8;
                enemyHp = 8;
                enemyMeleeDmg = 2;
                enemyLevel = 1;
            }
            else if (chance < .7) {
                //race = "Bandit";
                enemyMaxHp = 10;
                enemyHp = 10;
                enemyMeleeDmg = 4;
                enemyLevel = 1;
            }
            //30% chance
            else {
                //race = "Bandit";
                enemyMaxHp = 11;
                enemyHp = 11;
                enemyMeleeDmg = 5;
                enemyLevel = 1;
            }
        }
        else if (eLevel == 2) {
            if (chance < .5) {
                enemyMaxHp = 10;
                enemyHp = 10;
                enemyMeleeDmg = 4;
                enemyLevel = 2;
            }
            else if (chance < .9) {
                enemyMaxHp = 11;
                enemyHp = 11;
                enemyMeleeDmg = 5;
                enemyLevel = 2;
            }
            else {
                enemyMaxHp = 13;
                enemyHp = 13;
                enemyMeleeDmg = 4;
                enemyLevel = 2;
            }
        }
    }

    public static String name(String name){
        playerName = name;
        return playerName;
    }

}
