import entidades.*;

/**
 * App
 */
public class App
{
    public static void main(String[] args)
    {
        Grau g = Grau.D;
        Aprendiz A = new Aprendiz("PEPEGA","BASED"); 

        System.out.println("Name of Retard:" + A.getNome()); 
        System.out.println("RA :" + A.getRa()); 
        System.out.println(g);
        System.out.println(g.getGrau());
    }
}
