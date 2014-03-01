public interface Game
{
    void init(Player p1, Player p2, int xSize, int ySize);
    char getField(int x, int y);
    String getPlayerName(int number);
}
