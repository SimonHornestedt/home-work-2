public class Audio extends Item implements Comparable{
    
    protected String songName, creatorName;
    protected int score;
    public Audio(String sName, String cName, int score){
        this.songName = sName;
        this.creatorName = cName;
        this.score = score;
    }
    
    @Override
    public String getName() {
        return songName;
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
        return songName + creatorName + "Song" + Integer.toString(this.score);
    }

}