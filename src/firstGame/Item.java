package firstGame;

public class Item extends Object {
    private int ID;
    private String name;
    private double damage;
    private String type;

    public Item(int itemID, String itemName, double itemDamage, String itemType){
        ID = itemID;
        name = itemType + " " + itemName;
        damage = itemDamage;
        type = itemType;
    }

    public void setID(int newID){
        ID = newID;
    }

    public void updateName(){
        name = "";
        name = type + " " + name;
    }

    public void setDamage(double newDamage){
        damage = newDamage;
    }

    public void setType(String newType){
        type = newType;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public double getDamage(){
        return damage;
    }

    public String getType(){
        return type;
    }

    public String toString(){
        return "Name: " + name + "\n\tID: " + ID + "\n\tType: " + type + "\n\tDamage: " + damage + "\n";
    }

}
