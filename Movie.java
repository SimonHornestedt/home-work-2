
import javax.swing.JOptionPane;

public class Movie extends Item implements Comparable{
    
    protected String movName, creatorName;
    protected int score;
    /**
     * Konstruktor för klassen Movie. Skapar en film
     * @param sName filmens namn
     * @param cName skaparens namn
     * @param score filmens betyg
     */
    public Movie(String mName, String cName, int score){
        this.movName = mName;
        this.creatorName = cName;
        this.score = score;
    }
    /**
     * Skapar ett nytt item i from av en film utan att tilldela några värden.
     */
    public Movie(){ 
    }
    /**
     * Getmetod för att hämta namnet på filmen
     * @return String namnet
     */
    @Override
    public String getName() {
        return movName;
    }
    /**
     * Getmetod för att hämta skaparens namn
     * @return String namnet
     */
    @Override
    public String getCreatorName() {
        return creatorName;
    }
    /**
     * Getmetod för att hämta filmens betyg
     * @return int betyget
     */
    @Override
    public int getScore() {
        return score;
    }
    /**
     * Sätter betyget på filmen
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
     * Sätter namnet på filmen
     * @param movName det givna namnet
     */
    @Override
    public void setName(String movName) {
        this.movName = movName;
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
     * Används inte eftersom sorteringen gjordes automatiskt i abstractTableModel
     */
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Skriver ut hela objektet som en string
     * @return full information om objektet i form av en string
     */
    @Override
    public String toString(){
        return movName +  ","+ creatorName +  "," + "Movie" +  ","+ Integer.toString(this.score) + "," + id;
    }
     /**
     * hämtar objektets typ
     * @return objektets typ i form av en String
     */
    @Override
    public String getType() {
        return "Movie";
    }

    
}
