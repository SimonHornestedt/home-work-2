
import java.io.*;
import java.net.BindException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Model{
    private String name;
    private ArrayList <Collection> allCollections;
    private ArrayList <Item> currentCollection;
    private Collection modelCol;
    private String selectedCollection;
    private FileWriter skrivFil1;
    
    public Model() throws IOException{
        selectedCollection = "default.csv";
        skrivFil1 = new FileWriter("default.csv");
        allCollections = new ArrayList<>();
        currentCollection = new ArrayList<>();
        modelCol = new Collection(selectedCollection);
        allCollections.add(modelCol);
    }
    public void addMovie(Movie m){
        
        modelCol.addMovie(m);
        currentCollection = modelCol.getCollection();
    }
    public void addAudio(Audio a){
       
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
   
     public void readFile(){
        String s;
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Välj fil");
        try{
        String filnamn = fc.getSelectedFile().getName(); 
        selectedCollection = filnamn;
        for(Collection c : allCollections){
            if(c.getName().equals(selectedCollection)){
                modelCol = c;
                currentCollection = modelCol.getCollection();
                break;
            }
        }
        }catch(NullPointerException e){
            
        }
         try{
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
        
        }catch(IOException e){
            System.out.print("filen finns inte");
        }
     }
    public ArrayList<Item> getCurrentCollection() {
        return currentCollection;
    }
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
            skrivFil1 = new FileWriter(selectedCollection, true); 
            BufferedWriter writer = new BufferedWriter(skrivFil1);
            PrintWriter printer = new PrintWriter(writer);
            for(Item i : currentCollection){
                String s = i.toString();
                printer.println(s); 
            }
            printer.close();
        }
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
    

