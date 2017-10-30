package in.ravikalla.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ravi_kalla
 * 
 * Utility to find sub sets in an array of numbers - each subset should have the sum equal to the user input sum.
 * 
 * Eg1:
 * 	In an array {1,2,3,4,5,6,7,8,9}, we need to find the sub set of numbers whose sum is equal to 10.
 * 	Valid subsets are :
 * 	{1, 2, 3, 4}
 * 	{1, 2, 7}
 * 	{1, 3, 6}
 * 	{1, 4, 5}
 * 	{1, 9}
 * 	{2, 3, 5}
 * 	{2, 8}
 * 	{3, 7}
 * 	{4, 6}
 * 
 *  Eg2:
 *  In an array {1,2,3,4,5,6,7,8,9}, we need to find the sub set of numbers whose sum is equal to 5.
 * 	Valid subsets are :
 * 	{1, 4}
 * 	{2, 3}
 * 	{5}
 */
public class FindNumsForSum {
	private int[] arrNum;
	private int intExpectedSum;

	private List<List<Integer>> lstResult;

	public FindNumsForSum(int[] arrNum, int intExpectedSum) {
		this.arrNum = arrNum;
		this.intExpectedSum = intExpectedSum;
		lstResult = new ArrayList<>();
	}

	public List<List<Integer>> findNumsForSum() {
		findNumsForSum(new ArrayList<Integer>(), 0);
		return lstResult;
	}

	private void findNumsForSum(List<Integer> lstNum, int intCurrPos) {

		int intParentValueSize = sumOfNumsInList(lstNum);
		int intSumCurrentLevel;

		for (int intCurrPosLocal = intCurrPos; intCurrPosLocal < arrNum.length; intCurrPosLocal++) {
			intSumCurrentLevel = intParentValueSize + arrNum[intCurrPosLocal];

			if (intSumCurrentLevel == intExpectedSum) {
//				printResult(lstNum, arrNum[intCurrPosLocal]);
				saveResult(lstNum, arrNum[intCurrPosLocal]);
			}
			else if ((intSumCurrentLevel < intExpectedSum)
					&& (intCurrPosLocal + 1 < arrNum.length)) {
				lstNum.add(arrNum[intCurrPosLocal]);
				findNumsForSum(lstNum, intCurrPosLocal + 1);
				lstNum.remove(lstNum.size() - 1);
			}			
		}
	}

	private int sumOfNumsInList(List<Integer> lstNum) {
		int intSum = 0;
		if (null != lstNum)
			for (Integer i : lstNum)
				intSum += i;
		return intSum;
	}

//	private void printResult(List<Integer> lstNum, int intLastValue) {
//		System.out.print("Numbers with the expected sum ");
//		if (null != lstNum) {
////			lstNum.forEach(System.out::print);
//			lstNum.forEach(i -> {System.out.print(" : " + i);});
//		}
//		System.out.println(" : " + intLastValue);
//	}

	private void saveResult(List<Integer> lstNum, int intLastValue) {
		List<Integer> lstResultTemp = new ArrayList<>(lstNum);
		lstResultTemp.add(intLastValue);

		lstResult.add(lstResultTemp);
	}

	public static void main(String[] args) {
		int[] arrNum = {1,2,3,4,5,6,7,8,9};
		int intSum = 10;

		FindNumsForSum objFindNumsForSum = new FindNumsForSum(arrNum, intSum);
		List<List<Integer>> lstResults = objFindNumsForSum.findNumsForSum();

		System.out.println("Number sets that has the sum = " + intSum);
		lstResults.forEach(l -> {l.forEach(j -> {System.out.print(": " + j);});System.out.println("");});
	}
}
