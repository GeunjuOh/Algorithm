package algorithm.doit;

import java.util.Scanner;

public class 수정렬하기_버블정렬 {

	public static void main(String[] args) {

		System.out.println("원하는 수열의 개수를 적으시오 예) 5");
		Scanner sc = new Scanner(System.in);
		// 들어오고자 하는 수의 개수를 N에 담고 배열의 길이로 활용
		int N = sc.nextInt();

		int[] arr = new int[N];

		// for문을 활용하여 다음으로 입력되는 값을 N개 만큼씩 A배열에 저장 될 수 있도록 함
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// 버블 정렬 시작
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}


