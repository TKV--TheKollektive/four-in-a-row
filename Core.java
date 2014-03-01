import interfaces.*;
public class Core implements Game
{
    private char field[][];
    private int fillings[];
    private Player player1;
    private Player player2;
    private int ySize;
    private int xSize;
    public Core(Player p1, Player p2, int x, int y){
        this.init(p1, p2, x, y);
    }
    public void init(Player p1, Player p2, int x, int y){
        player1 = p1;
        player2 = p2;
        player1.setNumber(1);
        player2.setNumber(2);
        field = new char[y][x];
        fillings = new int[x];
        xSize = x;
        ySize = y;
        for (int i = 0; i < field.length;i++){
            for (int j = 0; j < field[0].length;i++) field[j][i] = ' ';
        }
    }
    
    public char getField(int x, int y){
        return field[y][x];
    }
    
    public String getPlayerName(int number){
        switch (number){
            
            case 1: return(player1.getMyName()); 
            case 2: return(player2.getMyName()); 
            default: return("No Player to Number " + number);
            
        }
    }
    
    private char checkWin(){
        int counter = 0;
        char last = ' ';
       for (int i = 0 ; i < field.length ; i++){
           for (int j = 0 ; j < field[0].length ; j++){
                if(last != ' '){
                    if( last == field[i][j]) counter++;
                    else counter = 0;
                }
                last = field[i][j];
                if (counter == 4){
                    return last;
                }
           }
       }
       for (int j = 0 ; j < field[0].length ; j++){ 
           for (int i = 0 ; i < field.length ; i++){
                if(last != ' '){
                    if( last == field[i][j]) counter++;
                    else counter = 0;
                }
                last = field[i][j];
                if (counter == 4){
                    return last;
                }
           }
       }
       
       return ' ';
    }
    
    public boolean throwIn(int row, char colour){
        if (fillings[row] > ySize){
            fillings[row]++;
            int height = fillings[row];
            field[height][row] = colour;
            return true;
        }else{
            return false;
        }
    }
}
