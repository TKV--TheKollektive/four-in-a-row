
import interfaces.*;

public class Launcher
{
    public static void main(String args[]){
        Player player1 = new TUIPlayer();
        Player player2 = new TUIPlayer();
        Game game = new Core();
        
        player1.init(1,game);
        player2.init(2,game);
        game.init(player1,player2);
    }
}
