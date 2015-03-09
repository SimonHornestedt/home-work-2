public class Movie extends Item implements Comparable{
    
    protected String movName, creatorName;
    protected int score;
    public Movie(String mName, String cName, int score){
        
        this.movName = mName;
        this.creatorName = cName;
        this.score = score;
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
        if(score >= 0 && score <= 10){
        this.score = score;    
        }else{
            //infoga JOptpane
        }
        
    }
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return movName +  ","+ creatorName +  "," + "Movie" +  ","+ Integer.toString(this.score) + "," + id;
    }

}
