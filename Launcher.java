
import interfaces.*;
import static lib.Curses.*;
import java.io.*;

public class Launcher
{
    public static void main(String args[]){
        Player player1 = getPlayer(1);
        Player player2 = getPlayer(2);
        Game game = new Core();
        
        player1.init(1,game);
        player2.init(2,game);
        game.init(player1,player2);
    }
    
    private static Player getPlayer(int pnbr){
        System.out.print("\u000c");
        String ptypes[]= {"Mensch / TUI","Maschine / KI"};
        for(int i=0; i <= 1; i++) 
                System.out.println("[" + i + "] " + ptypes[i]); 
        int ptype = readint("Type of Player" + pnbr + ":");
        Player p;
        switch(ptype){
            case 0: p = new TUIPlayer();
                    break;
            case 1: p = new KI();
                    break;
            default:p = new TUIPlayer();
                    break;
        }
        System.out.print("\u000c");
        return p;
    }
    
    private static int readint(String question){ 
        String read = "";
        while(read.length() == 0){
            System.out.print(question);
            try {
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
                read = bufferedreader.readLine();
            } catch (IOException ioe) {
                System.out.println("IO-Error reading System.in");
                //System.exit(1);
                return 0;
            }
        }
        return Integer.parseInt(read);}
}
