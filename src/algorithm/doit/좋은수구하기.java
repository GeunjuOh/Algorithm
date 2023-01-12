package algorithm.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다. 
   N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.*/
public class 좋은수구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// 1. 입력받을 수의 자리를 N에 저장합니다.
		System.out.println("수의 개수를 입력하세요");
		int N = Integer.parseInt(bf.readLine());

		// 좋은수를 넣을 변수 저장
		int goodN = 0;

		// 2. N만큼의 길이가 되는 배열을 저장한다.
		long[] array = new long[N];

		System.out.println("띄어쓰기 하나씩 해서 배열에 저장합니다.");
		System.out.println("예시) 1 2 3 4 5 6 7 8 9 10");
		// 3. StringToken 을 이용하여 for문으로 돌면서 값을 배열에 저장한다.
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			array[i] = Long.parseLong(st.nextToken());
		}

		// 4. 들어온 수를 정렬합니다.
		Arrays.sort(array);

		// 5. for문 안에 find 배열에 하나씩 돌면서 값을 넣습니다.
		//여기서 포인트는 i와 j가 돌면서 만날때까지 두수의 합이 K가 되는 경우가 있느냐 없느냐는 겁니다!!!
		//		1,2,3,4,5
		//		k
		//		1,2,3,4,5
		//		  k
		//		1,2,3,4,5
		//		    k
		//		1,2,3,4,5
		//		      k
		for (int k = 0; k < N; k++) {
			
			//찾을 변수 생성하여, 배열 다 돌면서 값을 하나씩 넣는다.
			long find = array[k];
			int i = 0;//0번째 배열부터 +1 하면서 돌기
			int j = N-1;//마지막 배열부터 -1하면서 돌기

			// 5. 투포인터 알고리즘 시작!
			//포인터는 i는 작은수부터 j는 제일 끝(큰수)부터 순차적으로 내려옵니다.
			while (i < j) {
				//양쪽 끝에서 다하면서 만약 찾는 값이랑 같을때
				if (array[i] + array[j] == find) {
					// 베열을 포인터로 이용해서 서로 돌면서 더할때 find 에 들어가있는 배열의 개수가 있다면 좋은수 입니다.
					if (i != k && j != k) {
					// 단!! 그 더하는 수가 같은 값이면 안됩니다!
						goodN++;
						break;
						//빠져 나오기
					} else if (i == k) {
					//다 돌고 다시 k가 돌아오면 포인터를 이동한다.
						i++;
					} else if (j == k) {
						j--;
					}
				} else if (array[i] + array[j] < find) {
				//더하는 두 값이 찾을값보다 작다면 작은수를 ++해서 다음 포인터로 이동한다.
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(goodN);
		bf.close();
	}

}
