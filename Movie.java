public class Movie extends Item implements Comparable{
    
    protected String movName, creatorName;
    protected int score;
    public Movie(String mName, String cName, int score){
        
        this.movName = mName;
        this.creatorName = cName;
        this.score = score;
    }
    public Movie(){
        
        
    }
    @Override
    public String getName() {
        return movName;
    }
    @Override
    public String getCreatorName() {
        return creatorName;
    }
    @Override
    public int getScore() {
        return score;
    }
    @Override
    public void setScore(int score) {
        if(score >= 0 && score <= 5){
        this.score = score;    
        }else{
            //infoga JOptpane
        }
        
    }

    @Override
    public void setName(String movName) {
        this.movName = movName;
    }
    
    @Override
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return movName +  ","+ creatorName +  "," + "Movie" +  ","+ Integer.toString(this.score) + "," + id;
    }

    @Override
    public String getType() {
        return "Movie";
    }

    
}
