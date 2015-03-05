public abstract class Item implements Comparable{

    
    public abstract String getName();
    public abstract String getCreatorName();
    public abstract int getScore();
    public abstract void setScore(int s);
    @Override
    public abstract String toString();
}
