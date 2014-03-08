package lib;
public class Libgame{

	/**
	* Checks, if someone has won.
	*/
	public static int checkwin(int toCheck[][]){

		int winner = 0;
		int fillings[] = new int[toCheck[0].length];
		for (int i = 0; i < toCheck[0].length;i++){
			int j = 0;			
			while (toCheck[j][i] != 0){
				fillings[i]++;		
			}
		}
		int i = 0;
		int j = 0;
		for(int pnbr = 1; pnbr <= 2 ; pnbr++){			
				while((	toCheck[j][i]== pnbr &&
				toCheck[(j+1)][(i+1)]==pnbr &&
				toCheck[(j+2)][(i+2)]==pnbr &&
				toCheck[(j+3)][(i+3)]==pnbr )||(

				toCheck[j][i]==pnbr &&
				toCheck[(j+1)][i]== pnbr &&
				toCheck[(j+2)][i]==pnbr &&
				toCheck[(j+3)][i]==pnbr )||(

				toCheck[j][i]==pnbr &&
				toCheck[j][(i+1)]==pnbr &&
				toCheck[j][(i+2)]== pnbr &&
				toCheck[j][(i+3)]==pnbr )||(

				toCheck[j][i]==pnbr &&
				toCheck[(j+1)][(i-1)]==pnbr &&
				toCheck[(j+2)][(i-2)]==pnbr && 
				toCheck[(j+3)][(i-3)]== pnbr )||(
				j < (toCheck[0].length-3))){
							while((	toCheck[j][i]== pnbr &&
									toCheck[(j+1)][(i+1)]==pnbr &&
									toCheck[(j+2)][(i+2)]==pnbr &&
									toCheck[(j+3)][(i+3)]==pnbr )||(

									toCheck[j][i]==pnbr &&
									toCheck[(j+1)][i]== pnbr &&
									toCheck[(j+2)][i]==pnbr &&
									toCheck[(j+3)][i]==pnbr  )||

									(i < toCheck.length)) i++;
							i = 3;							
							while(((

									toCheck[j][i]==pnbr &&
									toCheck[(j+1)][(i-1)]==pnbr &&
									toCheck[(j+2)][(i-2)]==pnbr && 
									toCheck[(j+3)][(i-3)]== pnbr ))||(
	
									toCheck[j][i]==pnbr &&
									toCheck[j][(i-1)]==pnbr &&
									toCheck[j][(i-2)]== pnbr &&
									toCheck[j][(i-3)]==pnbr )||
									(i < toCheck.length))

					j++;
				
   	   		}
			if(j != (toCheck[0].length-3)){
				winner = pnbr;
			}else{
				winner = 0;
			}
		}
		return winner;    
	}
} 