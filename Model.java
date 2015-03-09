
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class Model{
    private String name;
    ArrayList <Collection> allCollections;
    ArrayList <Item> currentCollection;
    Collection modelCol;
    private String selectedCollection;
    FileWriter skrivFil1;
    
    public Model() throws IOException{
        selectedCollection = "default.csv";
        skrivFil1 = new FileWriter("default.csv");
        allCollections = new ArrayList<>();
        currentCollection = new ArrayList<>();
        modelCol = new Collection(selectedCollection);
        allCollections.add(modelCol);
    }
    public void addMovie(Movie m){
        modelCol = allCollections.get(0);
        modelCol.addMovie(m);
        currentCollection = modelCol.getCollection();
    }
    public void addAudio(Audio a){
        modelCol = allCollections.get(0);
        modelCol.addAudio(a);
        currentCollection = modelCol.getCollection();
    }
    public String getName(){
        return this.name;
    }
    public void newCollection(String name) throws IOException{
        Collection c = new Collection(name +".csv");
        skrivFil1 = new FileWriter(name +".csv", true); 
        allCollections.add(c);
    }
    public void selectCollection(){
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Välj fil");
        try{
        String filnamn = fc.getSelectedFile().getName(); 
        selectedCollection = filnamn;
        
        }catch(NullPointerException e){
            
        }
    }
    public String getSelectedCollection() {
        return selectedCollection;
    }
    public void updateTable(MyTableModel tableModel){
        
        for(int k = 0; k < currentCollection.size(); k++){
            Item i = currentCollection.get(k);
            String [] str = i.toString().split(",");
            for(int n = 0; n < str.length; n++){
                tableModel.setValueAt(str[n], k, n);
            }
        }
    }
    public void writeToFile() throws IOException{
            modelCol = allCollections.get(0);
            currentCollection = modelCol.getCollection();
            FileWriter skrivFil1 = new FileWriter(selectedCollection, true); 
            BufferedWriter writer = new BufferedWriter(skrivFil1);
            PrintWriter printer = new PrintWriter(writer);
            for(Item i : currentCollection){
                String s = i.toString();
                printer.println(s); 
            }
            printer.close();
        }
    }
    
    

