
import javax.swing.JOptionPane;

public class Audio extends Item implements Comparable{
    
    protected String songName, creatorName;
    protected int score;
    /**
     * Konstruktor för klassen Audio. Skapar ett ljud
     * @param sName ljudets namn
     * @param cName skaparen namn
     * @param score ljudets betyg
     */
    public Audio(String sName, String cName, int score){
        this.songName = sName;
        this.creatorName = cName;
        this.score = score;
    }
    /**
     * Skapar ett nytt item i from av ett ljud utan att tilldela några värden.
     */
    public Audio(){   
    }
    /**
     * Getmetod för att hämta namnet på ljudet
     * @return String namnet
     */
    @Override
    public String getName() {
        return songName;
    }
    /**
     * Getmetod för att hämta namnet på skaparen
     * @return String skaparens namn
     */
    @Override
    public String getCreatorName() {
        return creatorName;
    }
    /**
     * Getmetod för att hämta betyget
     * @return int betyg
     */
    @Override
    public int getScore() {
        return score;
    }
    /**
     * Sätter betyget på ljudet
     * @param score det givna betyget 
     */
    @Override
    public void setScore(int score) {
        if(score >= 0 && score <= 5){
        this.score = score;    
        }else{
           JOptionPane.showMessageDialog(null, "this score cant be set");
        }
        
    }
    /**
     * Sätter namnet på ljudet
     * @param songName det givna namnet
     */
    @Override
    public void setName(String songName) {
        this.songName = songName;
    }
    /**
     * Sätter namnet på skaparen
     * @param creatorName det nya namnet
     */
    @Override
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    
    
    /**
     * hämtar objektets namn
     * @return objektets typ i form av en String
     */
    @Override
    public String getType() {
        return "Audio";
    }
    /**
     * Skriver ut hela objektet som en string
     * @return full information om objektet i form av en string
     */
    @Override
    public String toString(){
        return songName +  ","+ creatorName+  "," + "Song"+  "," + Integer.toString(this.score) + "," + id;
    }
    /**
     * Används inte eftersom sorteringen gjordes automatiskt i abstractTableModel
     */
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}