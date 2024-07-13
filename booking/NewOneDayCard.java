package booking;

import java.util.ArrayList;

public class NewOneDayCard {
	
	
	int cardNo;
	int index;
	int balance;
    private int oIndex;
	String oneCardNo="1234";
	private ArrayList<ArrayList<Integer>> newOneDayCards=new ArrayList<ArrayList<Integer>>();
	
	
	//Default Constructor
	NewOneDayCard(){}
	
	
	//Constructor initialize values for recharges
	NewOneDayCard(int amount,int index){
		balance=amount;
		this.index=index;
	}
	
	
	//Constructor initialize values for verify
	NewOneDayCard(int cardNo){
		this.cardNo=cardNo;
	}
	
	
	//It generates card no. for the new card
	public int generateCardNo(int c) {
		String t=oneCardNo;
		t+=c;
		return Integer.parseInt(t);
	}
	
	
	//It adds the new one time card to ArrayList for future Reference
	public void addOneDayCard(int cNo,int b) {
		ArrayList<Integer> card=new ArrayList<Integer>();
		card.add(cNo);
		card.add(b);
		newOneDayCards.add(card);
	}
	
	
	//It subtracts the travel cost from the total amount of new one time card
	public void newOneDayCardCheckOut(int i,int a) {
		newOneDayCards.remove(i);
	}
	

	//return old one time card index
	public int getOIndex() {
		return oIndex;
	}
	
	
	//return new one time card array
	public ArrayList<ArrayList<Integer>> getNewOneDayCards() {
        return newOneDayCards;
    }
	
	
	//set value for new one time card array
	public void setNewOneDayCard(ArrayList<ArrayList<Integer>> a) {
		newOneDayCards=a;
	}
	
	
	//verifies card no.
	public boolean verify() {
		//System.out.println("FROM NEW CLASS --");
		for(int i=0;i<newOneDayCards.size();i++) {
			if(newOneDayCards.get(i).get(0)==cardNo)
				return true;
		}
		return false;
	}
	
	
	//Recharges option
	public void recharge() {
		System.out.println("YEAH NEW THING!!!");
		int b=newOneDayCards.get(index).get(1);
		b+=balance;
		ArrayList<Integer> temp=new ArrayList<Integer>();
		temp.add(newOneDayCards.get(index).get(0));
		temp.add(b);
		newOneDayCards.set(index, temp);
		System.out.println("Your Card has Recharged Successfully");
		System.out.println("Your Current Balance : "+newOneDayCards.get(index).get(1));
	}
}
