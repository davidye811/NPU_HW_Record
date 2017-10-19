package FindMaxProfit;

import java.util.LinkedList;

public class FindMaxProfit {
	static LinkedList<Integer> buyday = new LinkedList<Integer>();
	static LinkedList<Integer> sellday = new LinkedList<Integer>();

	public static void main(String[] argv) {
		int[] price = { 100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97 };
		System.out.println("The maximum profit is " + MaxProfit(price, 16));
		System.out.println("Buy on day " + buyday + " and sell on day " + sellday);
	}

	static int MaxProfit(int[] array, int end) {
		if (end < 1)
			return 0;
		if (array[end] > array[end - 1]) {
			buyday.add(end - 1);
			sellday.add(end);
			return MaxProfit(array, end - 1) + array[end] - array[end - 1];

		}
		return MaxProfit(array, end - 1);

	}
}
