import lib.*;
import interfaces.*;

public class KI implements Player
{
    private String name = "TKV-4WIN"; 
    private Game gam;
    private int nr;
    private int throwinRow;
    private int throwin;
    private int ySize = 6;
    private int xSize = 7;
    private int [][] fieldi = new int [ySize][xSize];
    private int [] fillingsi = new int[7]; 
    private int [] assessment = new int[7];
    private int thinkahead=10;
    int spnr2;
     
    public void init(int colour, Game game)
    {
        gam = game;
        nr=colour;
    }
    public void activate(){gam.throwIn(throwinRow,nr);}
    public void endGame(int winner){}
    public String getMyName(){return name;}
    public void setNumber(int number){nr = number;}
    
    private int throwinRow()
    {
        if(nr==1){spnr2=2;}
        else {spnr2=1;}
        
        assessment[0]=0;
        assessment[1]=10;
        assessment[2]=20;
        assessment[3]=25;
        assessment[4]=20;
        assessment[5]=10;
        assessment[6]=0;
        
        
        for(int i=0;i<7;i++)
        {
            fillingsi[i]=gam.getFillings(i);
            for(int j=0;j<6;j++){ fieldi[j][i]=gam.getField(i,j);}
        }
        if (canIwin(fillingsi,fieldi)==true){}
        else if (canUwin(fillingsi,fieldi)==true){}
        else {dobestturn();}
        return throwin;    
    }
    
    private boolean canIwin(int []filling,int [][]field)
    {
        if (wagerechtueberpruefung(filling,field,nr)==true){return true;}
        else if (senkrechtueberpruefung(filling,field,nr)==true){return true;}
        else if (diagonalueberpruefung(filling,field,nr)==true){return true;}
        return false;
    }
    
    private boolean canUwin(int []filling,int [][]field)
    {
         
        if(nr==1){spnr2=2;}
        else {spnr2=1;}
        if (wagerechtueberpruefung(filling,field,spnr2)==true){return true;}
        else if (senkrechtueberpruefung(filling,field,spnr2)==true){return true;}
        else if (diagonalueberpruefung(filling,field,spnr2)==true){return true;}
        return false;
    }
    
    private boolean wagerechtueberpruefung(int []filling,int [][]field,int colour)
    {
        int [][]tocheckfiel = field;
        
        for(int i=5;i>=0;i--)
        {
           for(int j=0;j<=3;j++)
           {
               
                if (tocheckfiel[j][i]==0 &&
                tocheckfiel[(j+1)][i]==colour &&
                tocheckfiel[(j+2)][i]==colour &&
                tocheckfiel[(j+3)][i]==colour &&
                filling[j]==i)
                {
                    throwin=j;
                    return true;
                }
               
                if (tocheckfiel[j][i]==colour &&
                tocheckfiel[(j+1)][i]==0 &&
                tocheckfiel[(j+2)][i]==colour &&
                tocheckfiel[(j+3)][i]==colour &&
                filling[j+1]==i)
                {
                    throwin=j+1;
                    return true;
                }
               
                if (tocheckfiel[j][i]==colour &&
                tocheckfiel[(j+1)][i]==colour &&
                tocheckfiel[(j+2)][i]==0 &&
                tocheckfiel[(j+3)][i]==colour &&
                filling[j+2]==i)
                {
                    throwin=j+2;
                    return true;
                }
               
                if (tocheckfiel[j][i]==colour &&
                tocheckfiel[(j+1)][i]==colour &&
                tocheckfiel[(j+2)][i]==colour &&
                tocheckfiel[(j+3)][i]==0 &&
                filling[j+3]==i)
                {
                    throwin=j+3;
                    return true;
                }
                
           }
        }
        return false;
    }
    
    private boolean senkrechtueberpruefung(int []filling,int [][]field,int colour)
    {
        int [][]tocheckfiel = field;
        
        for(int i=0;i<7;i++)
        {
            for(int j = 0;j<3;j++)
            {
                if(tocheckfiel[i][j]==colour &&
                tocheckfiel[i][j+1]==colour &&
                tocheckfiel[i][j+2]==colour &&
                tocheckfiel[i][j+3]==0 &&
                filling[i]<6)
                {
                    throwin=i;
                    return true;
                }
            }
        }
        

        
        return false;
    }
    
    private boolean diagonalueberpruefung(int []filling,int [][]field,int colour)
    {
        int [][]tocheckfiel = field;
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(tocheckfiel[j][i]==0 &&//null
                   tocheckfiel[(j+1)][(i+1)]==colour &&
                   tocheckfiel[j+2][i+2]==colour &&
                   tocheckfiel[j+3][j+3]==colour &&
                   filling[j]==i)
                   {
                       throwin=j;
                       return true;
                   }
                       
                else if(tocheckfiel[j][i]==colour &&
                        tocheckfiel[(j+1)][(i+1)]==0 &&
                        tocheckfiel[j+2][i+2]==colour &&
                        tocheckfiel[j+3][j+3]==colour &&
                        filling[(j+1)]==(i+1))
                        {
                            throwin=j+1;
                            return true;
                        }
                        
                else if(tocheckfiel[j][i]==colour &&
                        tocheckfiel[(j+1)][(i+1)]==colour &&
                        tocheckfiel[j+2][i+2]==0 &&
                        tocheckfiel[j+3][i+3]==colour &&
                        filling[(j+2)]==(i+2))
                        {
                            throwin=j+2;
                            return true;
                        }
                        
                else if(tocheckfiel[j][i]==colour &&
                        tocheckfiel[(j+1)][(i+1)]==colour &&
                        tocheckfiel[j+2][i+2]==colour &&
                        tocheckfiel[j+3][i+3]==0 &&
                        filling[(j+3)]==(i+3))
                        {
                            throwin=j+3;
                            return true;
                        }
                
            }
        }
        
        for(int i=5;i>2;i--)
        {
            for(int j=0;j<=3;j++)
            {
                if(tocheckfiel[j][i]==0 &&
                   tocheckfiel[(j+1)][(i-1)]==colour &&
                   tocheckfiel[(j+2)][(i-2)]==colour &&
                   tocheckfiel[(j+3)][(i-3)]==colour &&
                   filling[j]==(i))
                   {
                       throwin=j;
                       return true;
                   }
                   
                else if(tocheckfiel[j][i]==colour &&
                        tocheckfiel[(j+1)][(i-1)]==0 &&
                        tocheckfiel[(j+2)][(i-2)]==colour &&
                        tocheckfiel[(j+3)][(i-3)]==colour&&
                        filling[j+1]==(i-1))
                        {
                            throwin=j+1;
                            return true;
                        }
                        
                else if(tocheckfiel[j][i]==colour &&
                       tocheckfiel[(j+1)][(i-1)]==colour &&
                        tocheckfiel[(j+2)][(i-2)]==0 &&
                        tocheckfiel[(j+3)][(i-3)]==colour&&
                        filling[j+2]==(i-2))
                        {
                           throwin=j+2;
                           return true;
                        }
                        
                else if(tocheckfiel[j][i]==colour &&
                        tocheckfiel[(j+1)][(i-1)]==colour &&
                        tocheckfiel[(j+2)][(i-2)]==colour &&
                        tocheckfiel[(j+3)][(i-3)]==0 &&
                        filling[j+3]==(i-3))
                        {
                           throwin=j+3;
                           return true;
                        }      
            }
        }
        return false ;
    } 
    
    public void dobestturn()
    {   
        int [][][] fieldclone = new int [thinkahead][6][7];
        int [][] fillingsclone = new int [thinkahead][7];
        int spnr2; 
        int turns=0;
        
        
        if(nr==1){spnr2=2;}
        else {spnr2=1;}
        for (int i=0;i<7;i++)
        {
            fillingsclone[turns]= fillingsi.clone();
            fieldclone[turns]= fieldi.clone();
            
            throwinKI(fillingsclone[turns],fieldclone[turns],i,nr);
                    
                if (canUwin(fillingsclone[turns],fieldclone[turns])==true)
                {assessment[i]=assessment[i]-30;}
                                    
                if (canIwin(fillingsclone[turns],fieldclone[turns])==true)
                {assessment[i]=assessment[i]+20;}
                                    
                if (canIwin(fillingsclone[turns],fieldclone[turns])==false
                &&canUwin(fillingsclone[turns],fieldclone[turns])==false)
                assessment[i]=assessment[i]+5;
                
                turns++;
                
                for (int j=0;j<7;j++)
                {
                    fillingsclone[turns]=fillingsclone[turns-1].clone();
                    fieldclone[turns]=fieldclone[turns-1].clone();
                    throwinKI(fillingsclone[turns],fieldclone[turns],j,spnr2);
                    turns++;
                    
                    
            
                
                }
            }
        }
        
    
                                            
                                        
                                        
        
    
    private boolean throwinKI(int [] filling,int [][] field ,int row,int colour)
    {
        return false;
    }
    
  
}
