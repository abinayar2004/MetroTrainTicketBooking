package booking;

public class City {

	String s[]= {"Erode","Namakkal","Salem","Tiruppur","Coimbatore","Rasipuram"};
	int cost[][]= {{0,500,1000,500,500,1000},{500,0,500,1000,1000,1500},{1000,500,0,1000,1500,500},
			{500,1000,1000,0,500,1000},{500,1000,1500,500,0,2000},{1000,1500,500,1000,2000,0}};
	
	
	//Displays the Amount for the mentioned cities in tabular format
	public void displayCost() {
		System.out.println("\n \t\t\t\t\t\tPrice Table\n");
		System.out.print("\t\t");
		for(int k=0;k<s.length;k++) {
			if (k==0 || k==2)
				System.out.print(s[k]+"\t\t");
			else
				System.out.print(s[k]+"\t");
		}
		System.out.println();
		for(int i=0;i<cost.length;i++) {
			if (i==0 || i==2)
				System.out.print(s[i]+"\t\t");
			else
				System.out.print(s[i]+"\t");
			for(int j=0;j<cost.length;j++) {
				System.out.print(cost[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
	
	
	//To show the predefined cities
	public void displayCity() {
		for(int i=0;i<s.length;i++)
			System.out.print(""+(i+1)+". "+s[i]+"\t");
		System.out.println();
	}
	
	
	//Checks if the city is present in the predefined cities
	public boolean checkCity(int n) {
		if(n<=s.length && n>0)
			return true;
		else
			return false;
	}
	
	
	//It Returns the Cost of Travel
	public int cityAmount(int i,int j) {
		return cost[i-1][j-1];
	}
	
}

