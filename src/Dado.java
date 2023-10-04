import java.util.Random;
import java.io.Serializable;


public class Dado implements Serializable{
    private int sideUp;

    public Dado(){
        sideUp=1;
    }
    public void roll(){ // O dado é jogado e um valor aleatório de 1 a 6 é escolhido
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