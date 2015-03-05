
import java.util.ArrayList;

public class Library{
    
    private String libName;
    ArrayList <Item> library; 
    public Library (String name){
        this.libName = name;
        library = new ArrayList<>();
    }
}
