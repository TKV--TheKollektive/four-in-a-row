
import lib.*;
public class CursesTest
{
    public static void main(String args[]){
        Curses.initscr(23,80);
        int xSize = Curses.getXSize();
        int ySize = Curses.getYSize();
        Curses.drawFrame('-','|','+');
        Curses.window(10,5,xSize-11,ySize-6,"Test Window");
        Curses.mvaddstr(12,7,"Welcome to Curses");
        Curses.mvaddstr(12,8,"Do you like it?");
        String read;
        do{
            read = Curses.readline(">").trim().toLowerCase();
            Curses.delArea(12,9,xSize-12,ySize-7);
            Curses.mvaddstr(12,9,read);
            switch(read.charAt(0)){
                    case 'y': case 'j':
                        Curses.mvaddstr(12,10,"Thats nice of you!");
                        break;
                    case 'n':
                        Curses.mvaddstr(12,10,"Why not?");
                        break;
                    case 'q':
                        System.out.println("\u000cBye bye");
                        break;
                    default:
                        Curses.mvaddstr(12,10,"Sorry, I didn't understand you.");
                        break;
            }
            Curses.refresh();
        }while(read.charAt(0) != 'q');
        System.out.println("\u000cBye bye");
    }
}