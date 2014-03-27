import interfaces.*;
import static lib.Curses.*;
public class TUIPlayer implements Player
{
    private int number;
    private Game game;
    private String name;

    public void init(int colour, Game g){
        initscr(23,80);
        drawFrame('-','|','+');
        window(1,1,21,12,"Spielfeld");
        window(61,1,78,12,"Info");
        number = colour;
        refresh();
        game = g;
    }

    public void activate(){
        mvaddstr(62,2,"Player number:" + number);
        mvaddstr(62,4,"gib die Nummer");
        mvaddstr(62,5,"der Spalte ein,");
        mvaddstr(62,6,"in die du");
        mvaddstr(62,7,"einwerfen");
        mvaddstr(62,8,"willst");
        printField(3,3);
        refresh();
        int row = readInt(">");
        game.throwIn(row,number);
    }
    
    public void printField(int xPos, int yPos){
        for(int i = 0;i <= 6;i++){
            mvaddstr((xPos + 2*i),yPos,("|" + i));
        }
        mvaddstr((xPos + 14),yPos,"|");
        int mod = 0;
        for(int i = 5;i >= 0;i--){
            mvaddstr(xPos,yPos+mod+2,"|");
            for(int j = 0;j <= 6;j++){
                int actual = game.getField(j,i);
                if(actual == 0){
                    addstr(" |" );
                }else{
                    addstr(Integer.toString(actual) + "|" );
                }
            }
            mod++;
        }
    }
    public void endGame(int winner){
           delArea(23,10,53,15);
           window(23,10,55,15,"Spiel Beendet");
           mvaddstr(62,2,"Player number:" + number);
            if(winner == number){
                mvaddstr(24,11,"Du hast gewonnen");
                mvaddstr(24,12,"Glueckwunsch!");
           }else if(winner != number){
               mvaddstr(24,11,"Du hast verloren");
               mvaddstr(24,12,"Oooooh Tut mir leid fuer dich");
               mvaddstr(24,13,"eine ganz grosse Tüte Mitleid");
           }else{
               mvaddstr(24,11,"UNENTSCHIEDEN");
               //mvaddstr(24,12,"Schlappschwanz!");
           }
           printField(3,3);
           refresh();
    }
    public String getMyName(){
        return name;
    }
    public void setNumber(int nbr){
        number = nbr;
    }
}
