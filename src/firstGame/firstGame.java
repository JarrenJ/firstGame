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
import static firstGame.Character.*;

import java.io.FileNotFoundException;
import java.util.*;
public class firstGame {

    /**
     * @param args the command line arguments
     */

    public static ItemCollection<Item> itemCollection;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
        itemCollection = new ItemCollection<Item>();
        Item boots = new Item(0, "Boots", 0, "Leather");
        Item leggings = new Item(1, "Leggings", 0, "Leather");
        Item chestplate = new Item(2, "Chestplate", 0, "Leather");
        Item helmet = new Item(3, "Helmet", 0, "Leather");
        Item sword = new Item(4, "Sword", 5, "Wood");
        Item bow = new Item(5, "Bow", 0, "Wood");

        Scanner stdin = new Scanner(System.in);

        Dice roll = new Dice();

        int raceSelection;
        double gold = 0.0;
        String input = "";
        String name = "";
        String playerClass = "";
        ArrayList<String> races = new ArrayList<>();
        races.add("Archer");
        races.add("Sorcerer");
        races.add("Barbarian");
        System.out.println("Please select which race you would like to be:");
        for (int i = 0; i < races.size(); i++) {
            System.out.println("[" + i + "]" + races.get(i));
        }

        do {
            System.out.print("» ");
            raceSelection = stdin.nextInt();
            switch(raceSelection){
                case 0:
                    createArcher();
                    break;
                case 1:
                    createSorcerer();
                    break;
                case 2:
                    createBarbarian();
                    break;
                default:
                    System.out.println("Error selecting class");
                    continue;
            }
            break;
        } while (true);

        /*
        do {
            System.out.println("Tutorial:");
            System.out.println("Enter the command '/stats'.");
            System.out.print("» ");
            input = stdin.next();
        } while (input.compareTo("/stats") != 0);
        */
        stats();

        System.out.println("\nYou can use other commands to help you on your journey.\nThese can be found by typing in '/help'.\n");
        System.out.print("Good morning sir ...  Kastle\nhm, I'm sorry but I seem to have forgotten your first name all of a sudden\ncould you remind me of it again?\n");
        System.out.print("» ");
        input = stdin.next();
        name = name(input);
        System.out.printf("Oh yes, I remember now, it's %s", name);
        System.out.println();

        boolean game = true;
        while(game){
            //first encounter - use '1' to create a level 1 enemy
            encounter(1);
            System.out.println("Servant »» Great fight " + name + "!\nHere are your current stats!");
            stats();
            System.out.println();
            System.out.println("[HINT] »» After some battles, they might drop loot on the ground so be sure to pick it up!\nYou can check for loot with '/check'.");

            do {
                System.out.print("» ");
                input = stdin.next();
            } while (!input.equals("/check"));

            System.out.println("[LOOT] »» You found a wooden sword and a wooden bow!");
            itemCollection.add(sword);
            itemCollection.add(bow);
            printInventory();
            System.out.println();
            loadInstance.instance(1);

            do {
                System.out.print("» ");
                input = stdin.next();
                if (input.equals("1")) {
                    System.out.println("You chose Path 1");
                    break;
                } else if (input.equals("2")) {
                    System.out.println("You chose Path 2");
                    System.out.println("You were annihilated by a ferocious bear!");
                    System.exit(0);
                }
            } while (true);

            loadInstance.instance(2);

            System.out.println("You can rest with '/rest'.");
            do {
                System.out.print("» ");
                input = stdin.next();
            } while (!input.equals("/rest"));
            System.out.println();
            System.out.println("You haven't slept this well in a long time. You wake up and something happens...");
            Thread.sleep(1000);
            Character.addXp(7);
            System.out.println("You leveled up!");
            Character.checkLevelUp();
            System.out.println("Your wooden sword was upgraded to an Iron sword!");
            String[] newItem = new String[2];
            sword.setType("Iron");
            String itemName = sword.getName();
            newItem = itemName.split(" ");
            sword.setName(sword.getType() + " " + newItem[1]);
            printInventory();
            game = false;
        }
        System.out.println("\nCongratz! You beat the game!");
    }

    public static void printInventory(){
        System.out.println("-----[ Inventory ]-----");
        for (Item Item : itemCollection) {
            System.out.println(Item);
        }
        System.out.println("-----[ Inventory ]-----");
    }

    public static void encounter(int eLevel) throws InterruptedException{
        String action;
        String spellAction = null;
        int spellDamage = 0;
        System.out.println("An enemy approcahes");
        createEnemy(eLevel); //creates a level 1 enemy
        combat = true;
        while(combat){
            System.out.println("Press 'a' to use a melee attack.\n\nPress 'r' to use a ranged attack. *(Remember - some races dont have a ranged attack\nbe sure to check if your race does.");
            if (race.equals("Sorcerer")) {
                System.out.println("Press 's' for a list of spells. *once you press 's' you can no longer use 'a' or 'r'");
            }
            System.out.print("» ");
            action = input.next();
            if (action.charAt(0) == 'a') {
                combat = attack(false);
            }else if (action.charAt(0) == 'r') {
                combat = attack(true);
            } else if (action.charAt(0) == 's') {
                System.out.println("Press 'f' for Fireball *roll a D4 [1 - 4 damage]");
                System.out.println("Press 'c' for Cure Wounds *roll a D4 [1 - 4 health is restored]");
                System.out.println("» ");
                spellAction = input.next();
                if (spellAction.charAt(0) == 'f') {
                    combat = spellAttack("fireball", Dice.d4());
                }else if (spellAction.charAt(0) == 'c'){
                    combat = spellAttack("cure wounds", Dice.d4());
                }
            }
                if (!combat) {
                    switch(level){
                        case 1:
                            xp = xp + 3;
                            break;
                        case 2:
                            xp = xp + 4;
                            break;
                        case 3:
                            xp = xp + 5;
                            break;
                        case 4:
                            xp = xp + 6;
                            break;
                    }
                    System.out.println("You earned " + xp + " xp!");
                    checkLevelUp();
                    return;
                }
                enemyAttack();
        }
    }

}