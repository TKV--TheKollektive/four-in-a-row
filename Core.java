import interfaces.*;
import lib.*;
public class Core implements Game
{
    private int field[][];
    private int fillings[];
    private Player player1;
    private Player player2;
    private int ySize = 6;
    private int xSize = 7;

    /**
     * Initialisizes the game
     */
    public Core(){
        field = new int[ySize][xSize];
        fillings = new int[xSize];
        for (int i = 0; i < xSize;i++){
            for (int j = 0; j < ySize;j++){field[j][i] = 0;}
        }
        for(int i = 0; i < xSize;i++) fillings[i]=0;
    }
    public void init(Player p1, Player p2){
        player1 = p1;
        player2 = p2;
        player1.setNumber(1);
        player2.setNumber(2);
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
        boolean noSpaceFree=false;
        for(int i=0; i < xSize;i++) if(fillings[i] != ySize) noSpaceFree=true;
        return noSpaceFree;
    }

    /**
     * throws a stone of a definable colour into a definable row
     */
    public boolean throwIn(int row, int colour){
        if (fillings[row] < ySize){
            int height = fillings[row];
            field[height][row] = colour;
            fillings[row]++;
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
        boolean gameActive = true;
        while(true){
            if(activePlayer == 1){
                player1.activate();
                activePlayer = 2;
            }else{
                player2.activate();
                activePlayer = 1;
            }
            int winner = Libgame.checkwin(field);
            if(winner != 0){
                    player1.endGame(winner);
                    player2.endGame(winner);
                    break;
            }
            if (checkFull() == false){
                    player1.endGame(0);
                    player2.endGame(0);
                    break;
            }
        }
    }
    
    public int getFillings(int row){
        return fillings[row];
    }
    }
