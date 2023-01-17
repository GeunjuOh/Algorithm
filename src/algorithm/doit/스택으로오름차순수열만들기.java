package algorithm.doit;

import java.util.Scanner;
import java.util.Stack;

/*임의의 수열을 스택에 넣었다가 출력하는 방식으로 오름차순 수열을 출력할 수 있는지 확인하고, 
 *출력할 수 있다면 push와 pop연산을 어떤 순서로 수행해야 하는지 알아보는 프로그램을 작성해 보자.

<입력>
1번째 줄에 수열의 개수 n(1 <= n <= 100000)이 주어진다. 2번째 줄에서 n개의 수열을 이루는 1이상 n이하의 정수가 1개씩 순서대로 주어진다. 이때 같은 정수가 두 번 이상 나오지는 않는다.

<출력>
오름차순 수열을 만들기 위한 연산 순서를 출력한다. push 연산은 +, pop 연산은 -로 출력하고, 불가능 할 때는 NO를 출력한다.*/

public class 스택으로오름차순수열만들기 {

	public static void main(String[] args) {

		// [예제 입력 1] = 4, 3, 6, 8, 7, 5, 2, 1

		// 1. 총 수열의 길이를 만들어 봅시당
		Scanner sc = new Scanner(System.in);

		System.out.println("총 수열의 길이를 몇으로 할뀨? 예) 8 ");
		int N = sc.nextInt();

		// 2. 정답 배열을 만들어 뺴는 수 대로 저장할 것!!
		int[] A = new int[N];

		System.out.println("입력 예시: 4, 3, 6, 8, 7, 5, 2, 1");
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		// 3. 스택 객체를 생성합니다.
		Stack<Integer> stack = new Stack<>();

		StringBuffer bf = new StringBuffer();

		// 4. 하나씩 들어오는 정수의 값은 1부터 시작합니다.
		int num = 1;

		Boolean result = true;

		// 5. su에 들어오는 수열을 저장하면서 크게 for문을 돕니다.
		for (int i = 0; i < A.length; i++) {
			int su = A[i];
			// su = 4, 3, 6, 8, 7, 5, 2, 1
			if (su >= num) {
				// su를 0번째 돌때: 4 >= num: 1
				while (su >= num) {
		// 6. while 문 푸시 : num이 더 커지지 않을때까지 while 돌기
					stack.push(num++);
					// 1,2,3,4 푸시
					bf.append("+\n");
					// ++++ (1회전)
				}
		// 7. while 문 팝 : su보다 num이 더 클때 그전걸 팝 해옵니다.
				stack.pop();
				// 스텍에서 빼올때 bf에 -를 넣는다.
				bf.append("-\n");
			} else {
		// 8. for문 팝 : 현재 수열 값이 오름차순 자연수보다 값이 더 클때
				int n = stack.pop();
				// n에 팝값을 저장
		// 9. 만약 팝한 값이 수열의 값보다 더 클때, 즉 원하는 수열을 빼올수 없을때에는		
				if (n > su) {
					System.out.println("No");
					//노를 리턴하고 결과값은 false가 되어 노만 출력됩니당!!!!!
					result = false;
					break; //빠져나와요
		// 10. 만약 팝한 값이랑 수열의 값이 같으면 bf에 -를 저장합니다.
				} else {
					bf.append("-\n");
				}
			}
		}
		// 11. 최종적으로 result가 false가 아닌경우에는 모두 정상으로 마쳤으므로,
		// bf에 담은 +,- 값을 출력합니다.
		if (result)
			System.out.print(bf.toString());
	}
}
