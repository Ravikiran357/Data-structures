import java.io.*;
import java.util.*;

class ShopDiscount {
	
	public static void main(String args[]) {
		int[] arr = new int []{5,1,4,3,6,2};
		ShopDiscount.finalPrice(arr);
	}

    static void finalPrice(int[] prices) {
        int total = 0;
        List<Integer> nonDiscountedItems = new ArrayList<Integer>();
        for (int index = 0; index < prices.length-1; index++) {
            boolean foundDiscount = false;
            for (int priceIndex = index+1; priceIndex < prices.length; priceIndex++) {
                if (prices[index] >= prices[priceIndex]) {
                    foundDiscount = true;
                    total += prices[index] - prices[priceIndex];
                    break;
                }
            }
            if (!foundDiscount) {
                nonDiscountedItems.add(index);
                total += prices[index];
            }
        }
        total += prices[prices.length-1];
        nonDiscountedItems.add(prices.length-1);
        System.out.println(total);
        for (int nonDiscountedItem: nonDiscountedItems)
            System.out.print(nonDiscountedItem + " ");
    }
}