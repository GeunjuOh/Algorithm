package algorithm.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙구하기 {

		public static void main(String [] args) throws IOException {

			// 맨처음 콘솔창에 입력되는 값은 연산의 개수로 설정
			System.out.println("연산의 개수를 입력하세요");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
				int n = Integer.parseInt(br.readLine());
				// 우선순위 큐를 선언해주고 타입은 Integer로 해준다.
				//	자바의 우선순위 큐는 힙메모리를 사용하며, 이진트리 구조이다. 
				
//				그리고 최소힙을 구현하므로, 작은값이 큐의 뿌리가 된다.......
				
				PriorityQueue<Integer>myQueue = new PriorityQueue<>((x1,x2)->{
//					여기서 PriorityQueue 객체를 선언하고 타입을 Integer로 받는다 선언한뒤
//					매개변수 두개를 받는다
					
				//문제에서 -231부터 231범위내의 값을 받는다고 하였으므로
//					각 매개변수들을 int형으로 언박싱해준다.
//				오토 언박싱은 -128부터 128까지만 진행되므로!
					
					//절댓값 비교할 변수 저
					int first = Math.abs(x1);
					int second = Math.abs(x2);
					
					// 우선순위 큐 클래스 안에 comparator라는 메소드를 가지고 있고
//					comparator 클래스 안의 compare 메소드를 오버라이딩 했으므로
//					람다식으로 매개변수를 바꿔준것이다.
					
					 if(first == second)
//						 여기서 x1>x2면 양수값 1을 반환하므로 우선순위가 밀린다.
//						 따라서 절대값이 같은경우엔 음수가 더 앞에 정렬되고
						 return x1>x2? 1:-1;
					 else
//				 절대값이 다르면 대소관계대로 정렬
//				 만약 첫번째값 - 두번째 값이 >0 이면 첫번째 값이 더 큰값이므로 (7-5)= 2 >0
//				 두번째값을 먼저 큐에 넣어주고, 그다음 첫번째값을 넣어준다.
//		       만약 첫번째값 - 두번째값이 <0 이면 두번째 값이 더 큰값이므로 (5-7)= -2 < 0
//				 첫번째값을 큐에 먼저 넣어주고, 그다음 두번째값을 넣어준다.	
		 				 return first - second;
				});
				
				for(int i = 0; i<n; i++) {
//					연산의 개수만큼 for를 돌립니다. n개의 수를 받을 것 입니다.
//					입력받은 값을 int로 변환해 input에 담아준다.
					int input = Integer.parseInt(br.readLine());
					
					// 입력받은 값이 0일때, 우선순위 큐 안의 값을 출력해줘야 하므로
					if(input==0) {
						if(myQueue.isEmpty()) 
							System.out.println("0");
						//0을 입력 받았는데 큐가 비어있으면 0을 리턴
						else
							// 아니라면 정렬되어있는 큐의 첫번째 값을 출력하고 삭제하는
							// poll 메소드를 사용한다.
							System.out.println(myQueue.poll());
					}
					// 0이 아니라면 큐에 입력받은 값을 집어넣는다.
					else {
						myQueue.add(input);
					}
				}
			}

		}

