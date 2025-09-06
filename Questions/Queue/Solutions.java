package Questions.Queue;

public class Solutions {
    //Q1:
     public static void reverse(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) {
            st.push(q.remove());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
    }
    //Q2:
    public static void generate(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 1; i <= n; i++) {
            String s = q.remove();
            System.out.print(s + " ");
            q.add(s + "0");
            q.add(s + "1");
        }
    }
    //Q3:
    public static void reverseK(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
    }

    //Q4:
     static void smallest90(int rem) { 
        Queue<Integer> q = new LinkedList(); 
        int x; 
        q.add(9); 
        while (true) { 
            x = q.poll(); 
            if (x % rem == 0) { 
                break; 
            } 
            q.add(10 * x); 
            q.add(10 * x + 9); 
        } 
        System.out.println(x); 
    } 

   // Q5:
     ArrayList<Integer> maxWindow(int arr[], int k) { 
        Queue<Integer> q = new LinkedList(); 
        ArrayList<Integer> a = new ArrayList(); 
        int c = 0; 
        for (int i = 0; i < k - 1; i++) { 
            q.add(arr[c++]); 
        } 
        while (c < arr.length) { 
            q.add(arr[c++]); 
            int max = Integer.MIN_VALUE; 
            for (int i = 0; i < k; i++) { 
                int x = q.poll(); 
                if (x > max) { 
                    max = x; 
                } 
                q.add(x); 
            } 
            a.add(max); 
            q.poll(); 
        } 
        return a; 
 
    }
    

}
