package algorithm.doit;
//자료구조: 숫자의 합
import java.util.Scanner;

public class 숫자의합구하기 {

	public static void main(String[] args) {
		// n값 입력받기
		Scanner sc = new Scanner(System.in);
		// 길이의 n의 숫자를 입력받아 String 변수 sNum에 저장하기
		System.out.println("숫자를 입력하세요");
		String sNum = sc.next();
//				System.out.println(sNum);

		// sNum을 다시 char[]형 변수 cNum에 변환하여 저장하기
		char cNum[] = sNum.toCharArray();

//				for (char c : cNum) {
//					System.out.print(c);
//				}
		// int형 변수 sum 선언하기
		int sum = 0;

		System.out.println();
		// for cNum 길이만큼 반복하기
		// 여기서 char 배열에서 더한값을 int형에 넣게되면,
		// 아스키코드가 더해지게 됩니다.
		// 여기서 아스키 코드를 숫자로 바꾸려면 48을 빼줘야합니다.
		for (int i = 0; i < cNum.length; i++) {
			sum += cNum[i] - 48;
		}
		// 배열의 각 자리값을 정수형으로 변환하며 sum에 더하여 누적하기
		// sum 출력하기
		System.out.println("합은 " + sum);
	}

}
