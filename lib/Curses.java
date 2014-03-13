package lib;


/**
 * Write a description of class Curses here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class Curses
{
    // instance variables - replace the example below with your own
     private static char screen[][];
     private static int xSize;
     private static int ySize;
     private static int xPos;
     private static int yPos;
    
     public static void initscr(int x, int y){
        xSize = x;
        ySize = y;
        screen=new char[ySize][xSize];
        yPos = 0;
        xPos = 0;
        for (int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++)screen[i][j]= ' ';
        }
    }
    
     public static void refresh(){
        System.out.print("\u000c");
        for (int i = 0; i < ySize; i++){
            for(int j = 0; j < ySize; j++)System.out.print(screen[i][j]);
            System.out.println("");
        }
    }

     public static void addstr(String string){
        for (int i = 0; i < string.length(); i++){
            if(xPos < xSize){   
                xPos++;
            }else if (xPos >= xSize){
                yPos++;
                xPos = 0;
            }else{
                yPos = 0;
                xPos = 0;
            }
            screen[yPos][xPos] = string.charAt(i);
        }
    }
    
     public static void move(int x, int y){
        xPos = x;
        yPos = y;
    }
    
     public static void mvaddstr(int x, int y, String string){
        move(x,y);
        addstr(string);
    }
    
    public static void horizontalLine(char character, int y){
        for(int i=0; i < xSize; i++)screen[y][i]=character;
    }
}
