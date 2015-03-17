
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Simon
 */
public class Collection {
    /**
     * medlemsvariabler
     */
    private String name;
    ArrayList <Item> collection; 
    /**
     * Konstruktor för kollektioner
     * @param name namnet på kollektionen
     */
    public Collection(String name){
        this.name = name;
        collection = new ArrayList<>();
    }
    /**
     * skapar en kollektion med en tillhörande arraylist
     * @param name namnet på kollektionen
     * @param current arraylist med items
     */
    public Collection(String name, ArrayList<Item> c){
        this.name = name;
        collection = c;
    }
    /**
     * Lägger till en film i collectionen
     * @param m filmen
     */
    public void addMovie(Movie m){
        collection.add(m);
    }
    /**
     * Lägger till ett ljud
     * @param a ljudet
     */
    public void addAudio(Audio a){
        collection.add(a);
    }
    /**
     * Hämtar kollektionen
     * @return Arraylist med kollektionen
     */
    public ArrayList getCollection(){
        return collection;
    }
    /**
     * Sätter en ny kollektion
     * @param c den nya listan med Items
     */
    public void setCollection(ArrayList<Item> c){
        collection = c;
    }
    /**
     *  hämtar namnet på kollektionen
     * @return String med namnet 
     */
    public String getName(){
        return name;
    }
}
