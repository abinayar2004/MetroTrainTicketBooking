package booking;

import java.util.ArrayList;

public class NewPermanentCard {
	
	
		String oneCardNo="1234";
		private int pIndex;
		private ArrayList<ArrayList<Integer>> newPermanentCards=new ArrayList<ArrayList<Integer>>();
	
	
		//Returns the new permanent card
	 	public ArrayList<ArrayList<Integer>> getNewPermanentCards() {
	        return newPermanentCards;
	    }
	 
	 	
	 	//set value for new permanent card
	 	public void setNewPermanentCards(ArrayList<ArrayList<Integer>> a) {
			newPermanentCards=a;
		}
	
	 	
	 	//to get pIndex
	 	public int getPIndex() {
			return pIndex;
		}
	 	
	 	
	 	//It adds the new permanent card to ArrayList for future Reference
		public void addPermanentCard(int cNo,int b) {
			ArrayList<Integer> card=new ArrayList<Integer>();
			card.add(cNo);
			card.add(b);
			newPermanentCards.add(card);
		}
		
		
		//It subtracts the travel cost from the total amount of new permanent card
		public void newPermanentCardCheckOut(int i,int a) {
			int bal=(newPermanentCards.get(i-1).get(1))-a;
			ArrayList<Integer> t=new ArrayList<Integer>();
			t.add(newPermanentCards.get(i-1).get(0));
			t.add(bal);
			newPermanentCards.set(i-1, t);
		}
		
		//It generates card no. for the new card
		public int generateCardNo(int c) {
			String t=oneCardNo;
			t+=c;
			return Integer.parseInt(t);
		}
		
		//Recharges the new Permanent card
		public void rechargeNewPermanentCart(int a) {
			int b=newPermanentCards.get(pIndex-1).get(1);
			b+=a;
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.add(newPermanentCards.get(pIndex-1).get(0));
			temp.add(b);
			newPermanentCards.set(pIndex-1, temp);
			System.out.println("Your Card has Recharged Successfully");
			System.out.println("Your Current Balance : "+newPermanentCards.get(pIndex-1).get(1));
		}
		

		//It verifies all type of cards
		public boolean verify(int n) {
			int k=0;
			pIndex=0;
			for(int i=0;i<newPermanentCards.size();i++) {
				if(newPermanentCards.get(i).get(0)==n) {
					//System.out.println("VALID USER");
					k++;
					pIndex=i+1;
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

}

