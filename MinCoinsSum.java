import java.util.*;

public class MinCoinsSum {
	
	private int getMinCoins(int sum, int [] vals) {
		int num = 0;
		
		return num;
	}
	
	private int[] toIntArray(List<Integer> list)  {
	    int[] ret = new int[list.size()];
	    int i = 0;
	    for (Integer e : list)  
	        ret[i++] = e.intValue();
	    return ret;
	}
	
	public static void main(String args[]) {
		MinCoinsSum m = new MinCoinsSum();
		List<Integer> vals = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the sum\n");
		int sum = in.nextInt();
		System.out.println("Enter the denominations\n");
		while(in.hasNext())
			vals.add(in.nextInt());
		
		System.out.printf("Minimum number of coins for sum %d is %d", 
				sum, m.getMinCoins(sum, m.toIntArray(vals)));		
	}
}
