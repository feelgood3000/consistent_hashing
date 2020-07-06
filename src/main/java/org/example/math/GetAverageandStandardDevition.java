package org.example.math;

public class GetAverageandStandardDevition {

	//均值
	private static double getAverage(long[] array) {
		long sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return (double) (sum / array.length);
	}

	//标准差
	public static double getStandardDevition(long[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			double a = array[i] - getAverage(array);
			double a2 = a * a;
			sum += a2;
		}
		double fangcha = sum / array.length;
		return Math.sqrt(fangcha);
	}
}
