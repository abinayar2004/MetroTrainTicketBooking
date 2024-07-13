package booking;

public class OldPermanentCard {

		String oneCardNo="1234";
		private int index;
		private int[][] oldCards = {{11111, 1000}, {11112, 15000}, {11113, 20000}, {11114, 25000}, {11115, 5000}};
    
	
		//return index
		public int getIndex() {
			return index;
		}
    
    
		//return old permanent cards
		public int[][] getOldCards() {
			return oldCards;
		}


		//It generates card no. for the new card
		public int generateCardNo(int c) {
			String t=oneCardNo;
			t+=c;
			return Integer.parseInt(t);
		}
	
	
		//It verifies all type of cards
		public boolean verify(int n) {
			int k=0;
			index=0;
			for(int i=0;i<5;i++) {
				if(oldCards[i][0]==n) {
					//System.out.println("VALID USER ");
					k++;
					index=i+1;
					return true;
				}
			}
			if(k==0) {
			//System.out.println("Invalid User!!!");
			return false;
			}
			else
				return false;
		}
		
		
		//Recharges the old card
		public void recharge(int a) {
			int b=oldCards[index-1][1];
			b+=a;
			oldCards[index-1][1]=b;
			System.out.println("Your Card has Recharged Successfully");
			System.out.println("Your Current Balance : "+oldCards[index-1][1]);
			
		}

		

		
	
}
