public class Audio extends Item implements Comparable{
    
    protected String songName, creatorName;
    protected int score;
    public Audio(String sName, String cName, int score){
        this.songName = sName;
        this.creatorName = cName;
        this.score = score;
    }
    public Audio(){
        
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
        if(score >= 0 && score <= 5){
        this.score = score;    
        }else{
            //infoga JOptpane
        }
        
    }
    @Override
    public void setName(String songName) {
        this.songName = songName;
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
    public String getType() {
        return "Audio";
    }
    @Override
    public String toString(){
        return songName +  ","+ creatorName+  "," + "Song"+  "," + Integer.toString(this.score) + "," + id;
    }

}