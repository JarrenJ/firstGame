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
    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
        class Item {
            public String toString() {
                return "I am the base class for all items";
            }
        }

        class BasicSword extends Item {
            public String toString() {
                return "Basic Sword » Dmg: 5";
            }
        }

        class Gold extends Item {
            public String toString() {
                return "Gold » 10";
            }
        }
        ArrayList<Item> inventory = new ArrayList<>();
        BasicSword sword1 = new BasicSword();
        Gold gold1 = new Gold();
        Scanner stdin = new Scanner(System.in);
        Dice roll = new Dice();
        int raceSelection;
        double gold = 0.0;
        String input = "";
        String name = "";
        String playerClass = "";
        ArrayList<String> races = new ArrayList();
        races.add("Archer");
        races.add("Sorcerer");
        races.add("Barbarian");
        System.out.println("Please select which race you would like to be:");

        for (int i = 0; i < races.size(); i++) {
            System.out.println("[" + i + "]" + races.get(i));
        }

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
                break;
        }

        do {
            System.out.println("Tutorial:");
            System.out.println("Enter the command '/stats'.");
            System.out.print("» ");
            input = stdin.next();
        } while (input.compareTo("/stats") != 0);
        stats();

        do {
            System.out.println("\nEnter the command '/i'.");
            System.out.print("» ");
            input = stdin.next();
        } while (input.compareTo("/i") != 0);

        for (Item i : inventory) {
            System.out.println(i.toString());
        }

        System.out.println("\nYou can use other commands to help you on your journey.\nThese can be found by typing in '/help'.\n");
        System.out.print("Good morning sir ...  Kastle\nhm, I'm sorry but I seem to have forgotten your first name all of a sudden\ncould you remind me of it again?\n");
        System.out.print("» ");
        input = stdin.next();
        name = name(input);
        System.out.printf("Oh yes, I remember now, it's %s", name);
        System.out.println("");
        boolean game = true;
        while(game){
            System.out.println("Started the game");
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

            System.out.println("[LOOT] »» You found a basic sword and 10 gold!");
            inventory.add(sword1);
            inventory.add(gold1);
            //for loop to show current inventory
            System.out.println("-----[ Inventory ]-----");
            for (Item i : inventory) {
                System.out.println(i.toString());
            }
            System.out.println("-----[ Inventory ]-----");
            for (Item i : inventory) {
                if (i == gold1) {
                    gold += 10; //10 is the amount of 'gold1'
                    System.out.printf("[BALANCE] »» %.2f", gold);
                }
            }
            inventory.remove(gold1);
            loadInstance.instance(1);
            do {
                System.out.print("» ");
                input = stdin.next();
                if (input.equals("1")) {
                    System.out.println("You choose Path 1");
                } else System.out.println("You chose Path 2");
            } while (!input.equals("1") || !input.equals(2));

            game = false;
        }
        System.out.println("\nCongratz! You beat the game!");
    }

    public static void encounter(int eLevel){
        String action;
        String spellAction = null;
        System.out.println("An enemy approcahes");
        createEnemy(eLevel); //creates a level 1 enemy
        combat = true;
        while(combat == true){
            System.out.println("Press 'a' to use a melee attack.\n\nPress 'r' to use a ranged attack. *(Remember - some races dont have a ranged attck\nbe sure to check if your race does.");
            if (race.equals("Sorcerer")) {
                System.out.println("Type 'spells' for a list of spells.");
            }
            System.out.print("» ");
            action = input.next();
            if (action.charAt(0) == 'a') {
                combat = attack();
            }else if (action.charAt(0) == 'r') {
                combat = attackRange();
            }
                if (combat == false) {
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
