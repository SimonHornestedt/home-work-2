
import java.util.ArrayList;

public class Library{
    private String name;
    ArrayList <Item> library; 
    public Library (){
        library = new ArrayList<>();
    }public Library (String name){
        this.name = name;
        library = new ArrayList<>();
    }
    public void addMovie(Movie m){
        library.add(m);
    }
    public void addAudio(Audio a){
        library.add(a);
    }
    public String getName(){
        return this.name;
    }
    public void newLibrary(){
        
    }
    
}
