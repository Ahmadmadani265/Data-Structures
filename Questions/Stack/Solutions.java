package Questions.Stack;

public class Solutions {
   // Q1:
     static boolean isBalanced(String expr) {
        Stack<Character> st = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
   // Q2:
    static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            s.push(c);
        }

        StringBuilder s1 = new StringBuilder();
        while (!s.isEmpty()) {
            s1.append(s.pop());
        }
        return s1.toString();
    }
    //Q3:
    static void printNearestSmaller(int[] arr) {
        Stack<Integer> s = new Stack<>();

        for (int x : arr) {
            while (!s.isEmpty() && s.peek() >= x) {
                s.pop();
            }
            if (s.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(s.peek() + " ");
            }
            s.push(x);
        }
    }
   // Q4:
   public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop() {
        if (q1.isEmpty()) return -1;
        return q1.remove();
    }

    int top() {
        if (q1.isEmpty()) return -1;
        return q1.peek();
    }

    boolean isEmpty() {
        return q1.isEmpty();
    }
    
    }
   
   //Q5:
   public static Stack<Integer> sortStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {
            int val = st.pop();

            while (!temp.isEmpty() && temp.peek() > val) {
                st.push(temp.pop());
            }
            temp.push(val);
        }
        return temp;
    }
}
