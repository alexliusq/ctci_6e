package ch3.q3_05_Sort_Stack;

import java.util.Stack;

public class SortStack extends Stack<Integer> {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  Stack<Integer> tempStack;

  public SortStack() {
    super();
    tempStack = new Stack<Integer>();
  }

  public void push(int val) {
    while (!super.empty() && val >  super.peek()) {
      tempStack.push(super.pop());
    }
    super.push(val);

  }

  public static Stack<Integer> sort(Stack<Integer> s) {
    Stack<Integer> rightStack = new Stack<Integer>();

    while(!s.empty()) {
      int temp = s.pop();
      boolean pushed = false;
      while(!pushed) {
        if (rightStack.empty() || rightStack.peek() >= temp) {
          rightStack.push(temp);
          pushed = true;
        } else {
          s.push(rightStack.pop());
        }
      }
    }
    return rightStack;
  }

  public static void main(String[] args) {
    SortStack stack = new SortStack();
    Stack<Integer> unsortedStack = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
      int r = (int) (Math.random() * 1000);
      
      stack.push(r);
      unsortedStack.push(r);
    }
    
    Stack<Integer> sorted = sort(unsortedStack);
		// while(!stack.isEmpty()) {
		// 	  System.out.println(stack.pop());
    //  }

    while(!sorted.empty()) {
      System.out.println(sorted.pop());
    }

  }
}