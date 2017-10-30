package in.ravikalla.utils;

import java.util.ArrayList;
import java.util.List;

public class FindNumsForSum {
	private int[] arrNum;
	private int intExpectedSum;

	List<List<Integer>> lstResult;

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
		int[] arrNum = {1,2,3,4,5,6,7,8,9,0};
		int intSum = 10;

		FindNumsForSum objFindNumsForSum = new FindNumsForSum(arrNum, intSum);
		List<List<Integer>> lstResults = objFindNumsForSum.findNumsForSum();

		System.out.println("Number sets that has the sum = " + intSum);
		lstResults.forEach(l -> {l.forEach(j -> {System.out.print(": " + j);});System.out.println("");});
	}
}
