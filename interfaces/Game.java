package interfaces;
public interface Game
{
    void init(Player p1, Player p2);
    int getField(int x, int y);
    String getPlayerName(int number);
    boolean throwIn(int row,int colour);
}
