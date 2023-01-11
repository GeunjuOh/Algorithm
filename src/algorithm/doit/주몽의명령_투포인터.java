package algorithm.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다. 
 * 갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다. 
 * 야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다. 
 * 이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.*/
public class 주몽의명령_투포인터 {

	public static void main(String[] args) throws IOException {
		// ( a )+ ( b )= M
		// 배열 = {a,b};

		// Scanner를 사용하지 않고 InputStreamReader를 사용한다.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// 1. N에 가지고 있는 재료의 개수를 적는다.
		System.out.println("현재 가지고 있는 재료의 개수를 적으시오!!");
		int N = Integer.parseInt(bf.readLine());

		// 2. 갑옷이 만들어져야하는 수를 M 에 저장한다.
		System.out.println("갑옷의 가격은?!!");
		int M = Integer.parseInt(bf.readLine());

		// 3. 재료의 개수만큼 반복하여 배열에 저장한다.
		int[] array = new int[N];

		// 4. StringTokenizer를 사용하여들어오는 다음 값을 st에 저장한다.
		System.out.println("재료는 띄어쓰기 해서 하나씩 입력하세요 예시) 2 7 4 1 5 3");
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// for 문을 돌면서 N개만큼의 수를 받아 배열에 저장한다.
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}


		// 5. 들어온 수를 Sort를 해준다.
		Arrays.sort(array);

		// 6. 각각 count를 하는 변수를 초기화한다.
		int count = 0;
		int i = 0;
		int j = N - 1;
		// j는 들어오는 N개보다 1를 뺸 값을 저장한다,
		// 즉 배열의 뒤에서 부터 포인터를 돈다는 뜻!!!!

		// 7. 두 배열의 포인터가 만나지 않을때까지 돌면서
		while (i < j) {
			if (array[i] + array[j] < M) {
				i++;
			} else if (array[i] + array[j] > M) {
				j--;
			}else {
				//계속해서 포인터를 움직이면서 비교하기
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
		bf.close();
	}

}
