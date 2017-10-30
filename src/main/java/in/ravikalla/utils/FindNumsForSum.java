package in.ravikalla.utils;

import java.util.ArrayList;
import java.util.List;

public class FindNumsForSum {
	public static void main( String[] args ) {
		int[] arrNum = {1,2,3,4,5,6,7,8,9,0};
		int intSum = 10;

		findNumsForSum(arrNum, intSum, new ArrayList<Integer>(), 0);
	}

	private static void findNumsForSum(int[] arrNum, int intExpectedSum, List<Integer> lstNum, int intCurrPos) {

		int intParentValueSize = sumOfNumsInList(lstNum);
		int intSumCurrentLevel;

		for (int intCurrPosLocal = intCurrPos; intCurrPosLocal < arrNum.length; intCurrPosLocal++) {
			intSumCurrentLevel = intParentValueSize + arrNum[intCurrPosLocal];

			if (intSumCurrentLevel == intExpectedSum)
				printResult(lstNum, arrNum[intCurrPosLocal]);
			else if ((intSumCurrentLevel < intExpectedSum)
					&& (intCurrPosLocal + 1 < arrNum.length)) {
				lstNum.add(arrNum[intCurrPosLocal]);
				findNumsForSum(arrNum, intExpectedSum, lstNum, intCurrPosLocal + 1);
				lstNum.remove(lstNum.size() - 1);
			}			
		}
	}

	private static int sumOfNumsInList(List<Integer> lstNum) {
		int intSum = 0;
		if (null != lstNum)
			for (Integer i : lstNum)
				intSum += i;
		return intSum;
	}

	private static void printResult(List<Integer> lstNum, int intLastValue) {
		System.out.print("Numbers with the expected sum ");
		if (null != lstNum) {
//			lstNum.forEach(System.out::print);
			lstNum.forEach(i -> {System.out.print(" : " + i);});
		}
		System.out.println(" : " + intLastValue);
	}
}
