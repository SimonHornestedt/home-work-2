public abstract class Item implements Comparable{
    /**
     * Medlemsvariabler
     */
    public static int nbrOfItems;
    public int id;
    /**
     * Konstruktor som ger Objektet ett ID
     */
    public Item(){
        id = this.hashCode();
    }
    
    /**
     * Hämtar namnet
     * @return String med namnet
     */
    public abstract String getName();
    /**
     * Hämtar skaparens namn
     * @return String med skaparens namn
     */
    public abstract String getCreatorName();
    /**
     * Hämtar typen
     * @return String för vilken typ objektet är
     */
    public abstract String getType();
    /**
     * Hämtar betyget
     * @return int med objektets betyg
     */
    public abstract int getScore();
    /**
     * Sätter objektets titel till det givna värdet
     * @param name det nya namnet
     */
    public abstract void setName(String name);
    /**
     * Sätter skaparens namn til det givna värdet
     * @param name det nya namnet
     */
    public abstract void setCreatorName(String name);
    /**
     * Sätter betyget för objektet
     * @param s det nya betyget
     */
    public abstract void setScore(int s);
    /**
     * Hämtar all information som en sträng
     * @return String med all info om objektet
     */
    @Override
    public abstract String toString();
    /**
     * Hämtar objektets ID
     * @return int med objektets ID
     */
    public int getID(){
        return id;
    }
    /**
     * Hashkodar fram ett nytt ID  
     */
    public void setID(){
        this.id = this.hashCode();
    }
}
