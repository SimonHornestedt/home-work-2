public abstract class Item implements Comparable{

    public static int nbrOfItems;
    public int id;
    public Item(){
        id = this.hashCode();
    }
    
    
    public abstract String getName();
    public abstract String getCreatorName();
    public abstract String getType();
    public abstract int getScore();
    public abstract void setName(String name);
    public abstract void setCreatorName(String name);
    
    public abstract void setScore(int s);
    @Override
    public abstract String toString();
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = this.hashCode();
    }
}
