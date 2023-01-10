package algorithm.doit;

import java.util.Scanner;

public class 평균구하기 {

	public static void main(String[] args) {
		// 40/80*100 =50
		// 80/80*100=100
		// 60/80*100=75
		// (40+80+60)*100/최댓값/총개수

		// 1. 첫번째 스케너로 시험을 본 과목의 개수 n의 값을 입력받는다.
		System.out.println("근주 너 시험 몇개 봤니?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(n + "개요");

		// 2. 입력 받은 과목수를 배열의 길이로 저장한다.
		int[] array = new int[n];

		// 3. 과목의 수만큼 반복하며 과목의 점수를 입력받을 것.
		System.out.println("점수 입력해라");
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}

		// 4. 최고점을 찾고 총점은 따로 변수에 저장
		int max = 0;
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
			sum += array[i];
		}
		System.out.println("과목 3개 총합 " + sum + "점");

		// 5. 출력하기
		// (40+80+60)*100/최댓값/총개수
		System.out.println("뻥튀기한 총점의 평균은? " + sum * 100 / max / n);
	}

}
