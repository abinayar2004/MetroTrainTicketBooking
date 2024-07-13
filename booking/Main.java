package booking;

import java.util.Scanner;


//Metro-train ticket booking and evaluation
public class Main {
	
	int cost[][]=new int[5][5];
	static int cardCount=0;
	static City cty=new City();
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
		City cty=new City();
		NewOneDayCard nOne=new NewOneDayCard();
		NewPermanentCard nPermanent=new NewPermanentCard();
		OldPermanentCard oPermanent=new OldPermanentCard();
		Options option=new Options();
		int tAmount=0;
		int choice=0;
		int c=0, c1=0;
		do {
			System.out.println("\n\t\t\t\t\t * * * METRO-TRAIN TICKET BOOKING * * * ");
			System.out.println("\nCARD TYPES : ");
			System.out.println("1. Create Card");
			System.out.println("2. Metro Card Options");
			System.out.println("3. View Cost Table");
			System.out.println("4. Exit");
			System.out.println("------------------------------------");
			System.out.println("Choose any one Type : ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:{
				
				// New Travel card
				
				option.OptionsNew();
				System.out.println("Enter Choice for new travel card: ");
				c=sc.nextInt();
				if(c==1) {
					option.cardTypes();
					System.out.println("Enter Choice for creating card: ");
					c1=sc.nextInt();
					if(c1==1) {
						
						//New one day card
						
						cardCount++;
						System.out.println("Thank You for choosing one day card");
						int cardNo=nOne.generateCardNo(cardCount);
						System.out.println("Your Card No. : "+cardNo);
						int amount=Main.selectLocation();
						nOne.addOneDayCard(cardNo, amount);
						nOne.setNewOneDayCard(nOne.getNewOneDayCards());
						option.oneTimeCardOptions();
						int otc=sc.nextInt();
						if(otc==1) {
							System.out.println("Enter Card No. : ");
							int t=sc.nextInt();
							NewOneDayCard t1=new NewOneDayCard(t);
							t1.setNewOneDayCard(nOne.getNewOneDayCards());
							boolean allow=t1.verify();
							if(allow)
								System.out.print("\nVALID USER\n\nHAVE A WONDERFUL JOURNEY!!!");
							else {
								System.out.println("Invalid User....");
								while(!allow) {
									System.out.println("Enter Valid Card No. : ");
									t=sc.nextInt();
									NewOneDayCard t2=new NewOneDayCard(t);
									t2.setNewOneDayCard(nOne.getNewOneDayCards());
									allow=t1.verify();
									if(allow)
										System.out.print("\nVALID USER\n\nHAVE A WONDERFUL JOURNEY!!!");
								}
							}
						}
					}
					if(c1==2) {
						
						//New Permanent card
						
						cardCount++;
						System.out.println("Thank you for choosing Permanent card");
						int cardNo=nOne.generateCardNo(cardCount);
						System.out.println("Your Card No. : "+cardNo);
						System.out.println("Card should contain a minimum balance of Rs.2000...");
						System.out.println("Enter Amount to recharge your new Card : ");
						int newCardAmount=sc.nextInt();
						nPermanent.addPermanentCard(cardNo, newCardAmount);
						nPermanent.setNewPermanentCards(nPermanent.getNewPermanentCards());
						System.out.println("CARD CREATED SUCCESSFULLY!!!");
					}
				}
				else
					System.exit(0);
				break;
			}
			case 2:{
				
				//Old Card
				
				System.out.println("Enter Card No. : ");
				int cardNo=sc.nextInt();
				
				
				boolean verify=oPermanent.verify(cardNo);
				boolean verify1=nPermanent.verify(cardNo);
				NewOneDayCard ncc=new NewOneDayCard(cardNo);
				ncc.setNewOneDayCard(nOne.getNewOneDayCards());
				boolean verify22=ncc.verify();
				int options=0;
				if(verify22 || verify1 || verify) {
					System.out.println("VALID USER!!!");
					option.optionsOld();
					options=sc.nextInt();
					switch(options) {
					case 1:{
						
						//Check-in
						
						if(oPermanent.getIndex()>0) {
							System.out.println("Your Balance : "+oPermanent.getOldCards()[oPermanent.getIndex()-1][1]);
							if(oPermanent.getOldCards()[oPermanent.getIndex()-1][1] >=2000) {
								tAmount=Main.selectLocation();
								System.out.println("ENJOY THE JOURNEY!!!");
							}
							else {
								while(oPermanent.getOldCards()[oPermanent.getIndex()-1][1]<2000) {
									System.out.println("\nSorry!!! You don't have enough amount...");
									System.out.println("Would you like to recharge? If Yes press 1");
									int r=sc.nextInt();
									if(r==1) {
										System.out.println("Enter Amount : ");
										int amount=sc.nextInt();
										oPermanent.recharge(amount);	
									}
									else {
										System.out.println("See You Later...");
										break;
									}
								}
								
							}
						}
						else if(nPermanent.getPIndex()>0) {
							System.out.println("Your Balance : "+nPermanent.getNewPermanentCards().get(nPermanent.getPIndex()-1).get(1));
							tAmount=Main.selectLocation();
							System.out.println("ENJOY THE JOURNEY!!!");
						}
						else {
							System.out.println("Your Balance : "+nOne.getNewOneDayCards().get(nOne.getOIndex()).get(1));
							tAmount=Main.selectLocation();
							System.out.println("ENJOY THE JOURNEY!!!");
						}
						
						break;
					}
					case 2:{
						
						//Check out
						
						System.out.println("Enter Card No. : ");
						int cardNo2=sc.nextInt();
						
						boolean veri=oPermanent.verify(cardNo2);
						boolean veri1=nPermanent.verify(cardNo2);
						NewOneDayCard ncc1=new NewOneDayCard(cardNo2);
						ncc1.setNewOneDayCard(nOne.getNewOneDayCards());
						boolean veri22=ncc.verify();
						
						if(veri || veri1 || veri22) {
							if(oPermanent.getIndex()>0) {
								oPermanent.getOldCards()[oPermanent.getIndex()-1][1]-=tAmount;
								System.out.println("Your Current Balance : "+oPermanent.getOldCards()[oPermanent.getIndex()-1][1]);
								System.out.println("THANK YOU FOR CHOOSING METRO TRAIN SERVICE");
							}
							else if(nPermanent.getPIndex()>0) {
								nPermanent.newPermanentCardCheckOut(nPermanent.getPIndex(),tAmount);
								System.out.println("Your Current Balance : "+nPermanent.getNewPermanentCards().get(nPermanent.getPIndex()-1).get(1));
								System.out.println("THANK YOU FOR CHOOSING METRO TRAIN SERVICE");
							}
							else {
								nOne.newOneDayCardCheckOut(nOne.getOIndex(), tAmount);
								System.out.println("THANK YOU FOR CHOOSING METRO TRAIN SERVICE");
								System.out.println("Your OneTime Card EXPIRED!!!");
							}
							
						}
						else
							System.out.println("Invalid user!!! Please try Later.......");
						break;
					}
					case 3:{
						
						//Recharge 
						
						System.out.println("Enter Card No. : ");
						int cardNo1=sc.nextInt();
						
						boolean ve=oPermanent.verify(cardNo1);
						boolean ve1=nPermanent.verify(cardNo);
						NewOneDayCard ncc2=new NewOneDayCard(cardNo);
						ncc2.setNewOneDayCard(nOne.getNewOneDayCards());
						boolean ve22=ncc.verify();
						
						if(ve || ve1 || ve22) {
							if(oPermanent.getIndex()>0) {
								System.out.println("Your Balance : "+oPermanent.getOldCards()[oPermanent.getIndex()-1][1]);
								System.out.println("\nEnter the Amount : ");
								int amt=sc.nextInt();
								oPermanent.recharge(amt);
							}
							else if(nPermanent.getPIndex()>0) {
								System.out.println("Your Balance : "+nPermanent.getNewPermanentCards().get(nPermanent.getPIndex()-1).get(1));
								System.out.println("\nEnter the Amount : ");
								int amt=sc.nextInt();
								nPermanent.rechargeNewPermanentCart(amt);
							}
							else {
								System.out.println("Your Balance : "+nOne.getNewOneDayCards().get(nOne.getOIndex()).get(1));
								System.out.println("\nEnter the Amount : ");
								int amt=sc.nextInt();
								NewOneDayCard t=new NewOneDayCard(amt,nOne.getOIndex());
								t.setNewOneDayCard(nOne.getNewOneDayCards());
								t.recharge();
							}
						}
						else
							System.out.println("Invalid Card No.!!! Please Try Later......");
						break;
					}
					case 4:{
						System.exit(0);
						break;
					}
					}
				}
				else
					System.out.println("INVALID USER.........Sorry for the inconvinent!!!");
				break;
			}
			case 3:{
				
				//Display the cost in table format
				
				cty.displayCost();
				break;
			}
			case 4:{
				
				//Exit
				
				System.exit(0);
			}
			}
		}while(choice>=1 && choice <=4);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	//To Select the source and destination
	public static int selectLocation() {
		int source,destination,amount;
		boolean src,des;
		System.out.println("\nPlease Select Your Soure : ");
		cty.displayCity();
		source=sc.nextInt();
		src=cty.checkCity(source);
		while(!src)
		{
			System.out.println("\nPlease Select Valid Soure : ");
			cty.displayCity();
			source=sc.nextInt();
			src=cty.checkCity(source);
		}
		System.out.println("\nPlease Select Your Destination : ");
		cty.displayCity();
		destination=sc.nextInt();
		des=cty.checkCity(destination);
		while(!des|| (source==destination))
		{
			System.out.println("\nPlease Select Valid Destination : ");
			cty.displayCity();
			destination=sc.nextInt();
			des=cty.checkCity(destination);
		}
		System.out.println("\nSource : "+cty.s[source-1]+"\tDestination : "+cty.s[destination-1]);
		amount=cty.cityAmount(source, destination);
		System.out.println("Your Cost : "+amount);
		
		return amount;
		
	}
	

}


