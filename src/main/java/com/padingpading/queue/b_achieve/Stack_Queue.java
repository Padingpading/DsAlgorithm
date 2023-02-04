package com.padingpading.queue.b_achieve;

import java.util.Stack;

/**
 * 栈实现队列:保证 出队栈到入队栈时候 出队栈一定是为空的。
 * 入队栈:
 * 出队栈:
 */
public class Stack_Queue {
	
	public static class TwoStacksQueue {
		
		/**
		 * 入队列的栈
		 */
		public Stack<Integer> stackPush;
		
		/**
		 * 出队列的栈
		 */
		public Stack<Integer> stackPop;
		
		/**
		 * 初始化
		 */
		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}
		
		// push栈向pop栈倒入数据
		private void pushToPop() {
			if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
		}
		
		public void add(int pushInt) {
			stackPush.push(pushInt);
			pushToPop();
		}
		
		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
			pushToPop();
			return stackPop.pop();
		}
		
		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
			pushToPop();
			return stackPop.peek();
		}
	}
	
	public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}
}
