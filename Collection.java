
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
    private String name;
    ArrayList <Item> collection; 
    public Collection(String name){
        this.name = name;
        collection = new ArrayList<>();
    }
    public Collection(String name, ArrayList<Item> current){
        this.name = name;
        collection = current;
    }
    public void addMovie(Movie m){
        collection.add(m);
    }
    public void addAudio(Audio a){
        collection.add(a);
    }
    public ArrayList getCollection(){
        return collection;
    }
    public void setCollection(ArrayList<Item> c){
        collection = c;
    }
    public String getName(){
        return name;
    }
}
