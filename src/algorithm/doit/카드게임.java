package algorithm.doit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 
 * 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
   이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 
   우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.*/
public class 카드게임 {
	
	public static void main(String[] args) {
		// 1. 스케너 객체 값 입력받기
		Scanner sc = new Scanner(System.in);

		// 2.queue 객체 생성
		Queue<Integer> myQueue = new LinkedList<>();

		System.out.println("카드의 개수 입력하시오");
		int N = sc.nextInt();

		// 3. 카드를 큐에 저장하기 N 보다 작은 수를 순차적으로 큐에 저장
		for (int i = 0; i <= N; i++) {
			myQueue.add(i);
		//
		}
		
		// 4. 큐를 이용하여 위의 값은 버리고 그 다음 값은 맨 아래로 이동하기
		// 큐의 사이지가 하나가 남기 전까지 반복한다.
		while (myQueue.size() > 1) {
			// 큐의 제일 위의 값을 poll 하기
			myQueue.poll();
			myQueue.add(myQueue.poll());
		}
		// 5. while 문을 다 빠져 나오면 마지막 한개의 수가 큐에 저장될 것임
		System.out.println(myQueue.poll());
	}
}
