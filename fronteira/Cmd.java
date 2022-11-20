package fronteira;

import java.util.Scanner;

/**
 * Cmd
 */
public class Cmd extends CmdI
{
    public char respostaUsuario()
    {
        Scanner input = new Scanner(System.in);
        char c = input.next().charAt(0);
        input.close();
        return c;
    }
}
