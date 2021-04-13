package Stack;

import java.util.Stack;

public class LeetCode_Stack_Offer30_155 {
    Stack<Integer> minStack;
    Stack<Integer> mStack;
    /** initialize your data structure here. */
    public LeetCode_Stack_Offer30_155() {
        mStack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        if (mStack.empty() && minStack.empty()){
            minStack.push(x);
        }else{
            if (x <= minStack.peek()){
                minStack.push(x);
            }
        }
        mStack.push(x);
    }

    public void pop() {
        if (mStack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return mStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        LeetCode_Stack_Offer30_155 minStack = new LeetCode_Stack_Offer30_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-3);
        System.out.printf("min-->"+minStack.min());
        minStack.pop();
        System.out.printf("top-->"+minStack.top());
        System.out.printf("min-->"+minStack.min());
    }
}
