package VideoZuo38;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStack {
	public static void main(String[] args) {
		Deque<Integer> deque=new ArrayDeque<>();
		deque.push(1);
		deque.push(2);
		deque.push(3);
		System.out.println(deque);//[3, 2, 1]
		reverseStack(deque);
		System.out.println(deque);//[1, 2, 3]

	}
	
	public static void reverseStack(Deque<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		Integer bottom= bottomOut(stack);//获取栈低的元素并返回
		reverseStack(stack);
		stack.push(bottom);
	}
	
	//移除并返回返回
	public static Integer bottomOut(Deque<Integer> stack) {
		Integer top=stack.pop();
		if(stack.isEmpty()) {
			return top;
		}
		
		int nextBottom=bottomOut(stack);
		stack.push(top);
		return nextBottom;
		
	}
	

}
