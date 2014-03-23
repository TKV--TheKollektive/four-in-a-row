package interfaces;
public interface Player
{
    // void init() = constructor?
    void init(int colour, Game game); // 1=red,2=yellow
    void activate(); 
    void endGame(int winner);
    String getMyName();
    void setNumber(int number);
}
