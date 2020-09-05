/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/* https://www.geeksforgeeks.org/stock-buy-sell */
/*
* max profit will be sum of positive slopes between two consecutive days (Greedy)
* */
public class StockBuyAndSell {

    private static void printMaxProfitIntervals(int[] prices) {
        List<List<Integer>> intervals = new ArrayList<>();
        int n = prices.length;
        int i=0;
        while(i < n-1) {
            while(i<n-1 && prices[i+1] < prices[i])
                i++;

            if(i == n-1) break;

            List<Integer> interval = new ArrayList<>();
            interval.add(i);

            while(i < n-1 && prices[i] < prices[i+1])
                i++;

            interval.add(i);
            intervals.add(interval);
        }

        int numOfIntervals = intervals.size();
        if(numOfIntervals == 0) System.out.println("No Profit");
        else {
            for(i=0; i< numOfIntervals-1; i++) {
                System.out.print("("+intervals.get(i).get(0) + " " + intervals.get(i).get(1)+") ");
            }
            System.out.print("("+intervals.get(numOfIntervals-1).get(0) + " " + intervals.get(numOfIntervals-1).get(1)+") ");

            System.out.println();
        }

    }

    private static int maxStockProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i+1] > prices[i]) {
                maxProfit += prices[i+1]-prices[i];
            }
        }

        return maxProfit;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());
        while(t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            String[] pricesStringValue = new String[n];
            pricesStringValue = scanner.nextLine().trim().split(" ");
            int[] prices = new int[n];
            for(int i=0; i< n; i++) {
                prices[i] = Integer.parseInt(pricesStringValue[i]);
            }
            System.out.println(maxStockProfit(prices));
            printMaxProfitIntervals(prices);
        }
    }
}