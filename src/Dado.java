import java.util.Random;

public class Dado{
    private int sideUp;

    public Dado(){
        sideUp=1;
    }
    public void roll(){
        Random r = new Random();
        sideUp = r.nextInt(6)+1; 
    }
    public int getSideUp(){
        return sideUp;
    }
    public String toString(){
       return "" + sideUp;
    }
    
}