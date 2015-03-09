public abstract class Item implements Comparable{

    public static int nbrOfItems;
    public int id;
    public Item(){
        nbrOfItems++;
        id = nbrOfItems;
    }
    
    
    public abstract String getName();
    public abstract String getCreatorName();
    public abstract int getScore();
    public abstract void setScore(int s);
    @Override
    public abstract String toString();
    public int getID(){
        return id;
    }
}
