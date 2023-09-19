import java.util.Random;

public class Dados{
    private int sideUp;

    public Dados(){
        sideUp=1;
    }
    public void roll(){
        Random r = new Random();
        sideUp = r.nextInt(6)+1; //ver se isso ta certo
    }
    public int getSideUp(){
        return sideUp;
    }
    /*public String toString(){
        System.out.println(""); 
    }*/  
    //esse toString precisa ver como vai ficar, nao sei certinho
    
}