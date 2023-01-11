package algorithm.doit;

/*<문제>- 백준 2018
 * 어떠한 자연수 N은, 
 * 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 
 * 당신은 어떤 자연수 N(1≤N≤10,000,000)에 대해서,
 * 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 
 * 이때, 사용하는 자연수는 N이하여야 한다.

예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다. N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.*/
import java.util.Scanner;

public class 연속된자연수의합 {
	/*
	 * 배열을 도는데 세 가지 조건으로 돈다. sum == 찾고자 하는 값 --> 값을 만족하는 구간을 찾았으니 cnt(카운트 개수)를 하나
	 * 늘려주고, sum의 값에서 start인덱스의 값을 빼주고 1을 늘려준다. 그리고 end값을 1을 더한 후 그 인덱스의 값을 sum에
	 * 더해준다. sum < 찾고자 하는 값 --> sum이 더 작으니까 값을 늘려주어야 한다. start 값은 그대로 두고, end 값을 1
	 * 늘려주고 그 end 인덱스의 값을 sum에 더해준다. sum > 찾고자 하는 값 --> sum이 더 크니까 값을 줄여주어야 한다. end
	 * 값은 그대로 두고, start 인덱스 값을 sum에서 빼주고 start값을 1 늘려서 갱신해준다. 루프를 탈출하는 경우는 start 값이나
	 * end 값이 배열의 인덱스를 초과하면 예외처리를 통해 탈출한다.(이 방법은 권장하지 않으니 다른 방법을 생각해보기 바란다.)
	 */

	public static void main(String[] args) {
		System.out.println("연속된 자연수의 합이 될 최종 숫자 입력: ");
		Scanner sc = new Scanner(System.in);

		// 1. 연속될 숫자를 N에 넣기
		int N = sc.nextInt();

		// 2. 각각 사용할 그릇 생성
		int count = 1, start_idx = 1, end_idx = 1, sum = 1;
		// 각각의 그릇은 N 은 포함이 되어야 하기 떄문에 1로 초기화 진행

		// 3. 마지막 인덱스가 N이 아닐때 까지 돌면서 더했을때 N 이 되는 수를 count
		while (end_idx != N) {
			if (sum == N) {
				count++;
				// 돌면서 더할때 sum의 값이 N과 같아지면 count++
				end_idx++;
				sum += end_idx;
				// 계속해서 도는 인덱스의 값을 올려주면서 sum에 더합니다.
			} else if (sum > N) {
				sum = sum - start_idx;
				//더하는 수가 N보다 커지면 큰 수만큼 빼기
				start_idx++;
				//합의 값이 N보다 클때마다 start인덱스에 값을 1씩 증가시킴
			} else {
				//합이 N보다 작을 경우에는
				end_idx++;
				sum = sum + end_idx;
				//더한 값이 N이 되지 않으므로, count는 하지 않고, end인덱스를 계속 증가하여 값을 sum에 저장
			}
		}
		System.out.println(count);
	}
}
