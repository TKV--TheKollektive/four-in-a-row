import interfaces.*;
import lib.*;
public class Core implements Game
{
    private int field[][];
    private int fillings[];
    private Player player1;
    private Player player2;
    private int ySize;
    private int xSize;
    public Core(Player p1, Player p2, int x, int y){
        this.init(p1, p2, x, y);
    }
   
    /**
     * Initialisizes the game
     */
    public void init(Player p1, Player p2, int x, int y){
        player1 = p1;
        player2 = p2;
        player1.setNumber(1);
        player2.setNumber(2);
        field = new int[y][x];
        fillings = new int[x];
        xSize = x;
        ySize = y;
        for (int i = 0; i < field.length;i++){
            for (int j = 0; j < field[0].length;i++) field[j][i] = ' ';
        }
        loop();
    }
    
    /**
     * returns the value of any field
     */
    public int getField(int x, int y){
        return (field[y][x]);
    }
    
    /**
     * returns a player name
     */
    public String getPlayerName(int number){
        switch (number){
            
            case 1: return(player1.getMyName()); 
            case 2: return(player2.getMyName()); 
            default: return("No Player to Number " + number);
            
        }
    }
    

    
    /**
     * Checks, if the field is full
     */
    public boolean checkFull(){
        boolean spaceFree=false;
        for(int i=0; i < xSize;i++) if(fillings[i] < ySize - 1) spaceFree=true;
        return spaceFree;
    }
    
    /**
     * throws a stone of a definable colour into a definable row
     */
    public boolean throwIn(int row, int colour){
        if (fillings[row] > ySize){
            fillings[row]++;
            int height = fillings[row];
            field[height][row] = colour;
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * The loop, that is executed troughout the Game
     */
    public void loop(){
        int activePlayer = 1;
        boolean gameActive=true;
        while(gameActive){
            if(activePlayer == 1){
                player1.activate();
                activePlayer = 2;
            }else{
                player2.activate();
                activePlayer = 1;
            }
            int winner = Libgame.checkwin(field);
            if(winner == 1){
                    player1.endGame(true);
                    player2.endGame(false);
                    gameActive=false;
            }else if (winner == 2){
                    player1.endGame(false);
                    player2.endGame(true);
                    gameActive=false;
            }
            if (checkFull() == true){
                    player1.endGame(false);
                    player2.endGame(false);
                    gameActive=false;
            }
        }
    }
}
