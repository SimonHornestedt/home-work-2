
import java.io.*;
import java.net.BindException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Model{
    /**
     * Medlemsvariabler
     */
    private String name;
    private ArrayList <Collection> allCollections;
    private ArrayList <Item> currentCollection;
    private Collection modelCol;
    private String selectedCollection;
    private FileWriter skrivFil1;
    /**
     * Konstruktor för modellen
     * @throws IOException kastas om filen inte kan skapas
     */
    public Model() throws IOException{
        selectedCollection = "default.csv";
        skrivFil1 = new FileWriter("default.csv");
        allCollections = new ArrayList<>();
        currentCollection = new ArrayList<>();
        modelCol = new Collection(selectedCollection);
        allCollections.add(modelCol);
        readDefault();
    }
    /**
     * Lägger till en film
     * @param m filmen
     */
    public void addMovie(Movie m){
        
        modelCol.addMovie(m);
        currentCollection = modelCol.getCollection();
    }
    /**
     * Lägger till ett ljud
     * @param a ljudet
     */ 
    public void addAudio(Audio a){
       
        modelCol.addAudio(a);
        currentCollection = modelCol.getCollection();
    }/**
     * Hämtar namet
     * @return nameet
     */
    public String getName(){
        return this.name;
    }
    /**
     * Skapar en ny kollektion och en ny fil
     * @param name nament på nya filen
     * @throws IOException kastas om filen inte kan skapas
     */
    public void newCollection(String name) throws IOException{
        Collection c = new Collection(name +".csv");
        skrivFil1 = new FileWriter(c.getName(), true); 
        allCollections.add(c);
    }
    /**
     * läser in en csv fil
     */ 
     public void readFile(){
        String s;
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Välj fil");
        try{
            String filnamn = fc.getSelectedFile().getName(); 
                if(filnamn.equals(selectedCollection)){
                    JOptionPane.showMessageDialog(null, "This collection has already been selected");
                }else{
                selectedCollection = filnamn;
                    for(Collection c : allCollections){
                        if(c.getName().equals(selectedCollection)){
                            modelCol = c;
                            currentCollection = modelCol.getCollection();
                            break;
                        }
                    }    
            BufferedReader lasFil = new BufferedReader(new FileReader(selectedCollection));
            s = lasFil.readLine();
            while(s != null){
                String [] posts = s.split(",");
                Item item;            
                for(int i = 0; i < posts.length; i++){
                    posts[i] = posts[i].trim();
                }
                if("Movie".equals(posts[2])){
                    item = new Movie();
                    item.setName(posts[0]);
                    item.setCreatorName(posts[1]);
                    item.setScore(Integer.parseInt(posts[3]));
                }else{
                    item = new Audio();
                    item.setName(posts[0]);
                    item.setCreatorName(posts[1]);
                    item.setScore(Integer.parseInt(posts[3]));
                }     
                currentCollection.add(item);
                s = lasFil.readLine();
            }
            modelCol.setCollection(currentCollection);
            allCollections.add(modelCol);
            lasFil.close();
        }
        }catch(IOException e){
            System.out.print("filen finns inte");
        }
    }/**
     * Läser in defaultfilen
     */
     private void readDefault(){
         try{
         String s;
         BufferedReader lasFil = new BufferedReader(new FileReader("default.csv"));
            s = lasFil.readLine();
            while(s != null){
                String [] posts = s.split(",");
                Item item;            
                for(int i = 0; i < posts.length; i++){
                    posts[i] = posts[i].trim();
                }
                if("Movie".equals(posts[2])){
                    item = new Movie();
                    item.setName(posts[0]);
                    item.setCreatorName(posts[1]);
                    item.setScore(Integer.parseInt(posts[3]));
                }else{
                    item = new Audio();
                    item.setName(posts[0]);
                    item.setCreatorName(posts[1]);
                    item.setScore(Integer.parseInt(posts[3]));
                }
                currentCollection.add(item);
                s = lasFil.readLine();
            }
            modelCol.setCollection(currentCollection);
            allCollections.add(modelCol);
            lasFil.close();
            }catch(IOException e){
            System.out.print("filen finns inte");
        }
     }
    
    /**
     * Hämtar nuvarande kollektion
     * @return Arraylist med nuvarande kollektion
     */
    public ArrayList<Item> getCurrentCollection() {
        return currentCollection;
    }
    /**
     * Hämtar namnet på filen som skall exporteras
     * @return stirng med namnet
     */
    public String getImportFileName(){
        
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Välj fil");
        try{
        String filnamn = fc.getSelectedFile().getName(); 
        if(filnamn.contains(".xml")){
            return filnamn;
        }else{
            return "error";
        }
        
        }catch(NullPointerException e){
            
        }
        return "error";
    }
    /**
     * tar bort ett objekt med det valda ID:t
     * @param selectedID 
     */
    public void removeObject(int selectedID){
        for(Item i : currentCollection){
            if(i.getID() == selectedID){
                currentCollection.remove(i);
                break;
            }
        }
    }/**
     * getmetod för namnet på den valda Kollektionen
     * @return string med namnet.
     */
    public String getSelectedCollection() {
        return selectedCollection;
    }/**
     * Uppdaterar tabellen
     * @param tableModel tabellen model
     */
    public void updateTable(MyTableModel tableModel){
        
        for(int k = 0; k < currentCollection.size(); k++){
            Item i = currentCollection.get(k);
            String [] str = i.toString().split(",");
            for(int n = 0; n < str.length; n++){
                tableModel.setValueAt(str[n], k, n);
            }
        }
    }
   /**
    * Skriver till den aktuella csv filen
    * @throws IOException kastas om filen inte finns
    */
    public void writeToFile() throws IOException{
            currentCollection = modelCol.getCollection();
            skrivFil1 = new FileWriter(selectedCollection, true); 
            BufferedWriter writer = new BufferedWriter(skrivFil1);
            PrintWriter printer = new PrintWriter(writer);
            for(Item i : currentCollection){
                String s = i.toString();
                printer.println(s); 
            }
            if(currentCollection.isEmpty()){
                skrivFil1 = new FileWriter(selectedCollection);
            }
            printer.close();
        }
    /**
     * Startar en tråd som kör servern tills programmet stängs av
     */
    public void startServer(){
        
        Runnable r = new Runnable() {
            @Override
            public void run(){
                
                Server serv = new Server();
                serv.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
                serv.startRunning();
                
                
            }
        };
        Thread thr = new Thread(r);
        thr.start();
        
    } 
    /**
     * Startar en tråd som kör en klient tills programmet stängs av.
     * @param ip ip adressen som klienten ska kopplas mot.
     */
    public void startClient(final String ip){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Client charlie;
                charlie = new Client( ip ); //192.168.0.105
                charlie.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
                charlie.startRunning();
            }
        };
        Thread thr = new Thread(r);
        thr.start();
        
        
    }
}
    

