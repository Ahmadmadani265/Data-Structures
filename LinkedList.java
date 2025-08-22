//class node
class Node {
    int val;
    Node next;
    Node(int val){
        this.val=val;
        next=null;
    }
}

//class MyLinked list
 class MyLinkedList {
    Node head,tail;
    int size=0;
     void addfirst(int val){
         Node n=new Node(val);
         if(head==null){
             head=n;
             tail=n;
         }
         else{
             n.next=head;
             head=n;
         }
         size++;
     }
     void removefirst(){
         Node cur=head;
         head=cur.next;
         cur.next=null;
         if(head==null){
             tail=null;
         }
         size--;
     }
     void addlast(int val){
          Node n=new Node(val);
          if(head==null){
              head=n;
              tail=n;
          }
          else{
              tail.next=n;
              tail=n;
          }
     }
      void removelast(){
          if(head==null){
              return ;
          }
          if(size==1){
              head=tail=null;
              size--;
              return;
          }
         Node cur=head;
         while(cur.next.next!=null){
             cur=cur.next;
         }
         cur.next=null;
         tail=cur;
         size--;
     }
      void add_by_index(int index,int val){
          Node n=new Node(val);
          int i=0;
          Node cur=head;
          if(head==null){
              head=n;
              tail=n;
          }
          else{
              while(cur!=null){
                  if(i==index-1){
                      break;
                  }
                  cur=cur.next;
                  i++;
              }
              n.next=cur.next;
              cur.next=n;
              size++;  
          }
      }
      void remove_by_index(int index){
          if(index==0){
              removefirst();
          }
          int i=0;
          Node cur=head;
          while(cur!=null){
              if(index-1==i){
                  break;
              }
              i++;
              cur=cur.next;
          }
          if(cur!=null){
              cur.next=cur.next.next;
          }
          size--;
      }
      int indexOf(int val){
             Node cur=head;
              int i=0;
              while(cur!=null){
                  if(cur.val==val){
                      return i;
                  }
                  i++;
                  cur=cur.next;
              }
          return -1;
      }
      boolean isContain(int val){
          Node cur=head;
          while(cur!=null){
              if(cur.val==val){
                  return true;
              }
              cur=cur.next;
          }
          return false;
      }
      Node get(int index){
          int i=0;
          Node cur=head;
          while(cur!=null){
              if(i==index){
                  return cur;
              }
              i++;
              cur=cur.next;
          }
          return null;
      }
      int MaxAllNode(){
          int max=Integer.MIN_VALUE;
          Node cur=head;
          while(cur!=null){
              if(cur.val>max){
                  max=cur.val;
              }
              cur=cur.next;
          }
          return max;
      }
      int sizo(){
          int c=0;
          Node cur=head;
          while(cur!=null){
              c++;
              cur=cur.next;
          }
          return c;
      }
      Node mid(){//Node edit
          Node fast=head;
          Node slow=head;
          while(fast!=null&&fast.next!=null){
              fast=fast.next.next;
              slow=slow.next;
          }
          return slow;
      }
       void rotlift(){
       if(head==null||head.next==null){
           return ;
       }
       Node cur=head;
       while(cur.next!=null){
           cur=cur.next;
       }
       cur.next=head;
       head=head.next;
       cur.next.next=null;
   }
    void rotRight() {
        if (head == null || head.next == null) {
            return;
        }
        Node cur = head;
        Node temp = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        temp = cur.next;
        temp.next = head;
        head = temp;
        cur.next = null;
    }
    void swap(int i,int j){
        Node a=get(i);
        Node aa=get(i+1);
        Node b=get(j);
        Node bb=get(j+1);
        Node cur=head;
        while(cur.next!=null){
            if(cur.equals(a)){
                cur.next=b;
                b.next=aa;
            }
             if(cur.equals(b)){
                cur.next=a;
                a.next=bb;
            }
             cur=cur.next;
        }
    }
     void reverse() { 
        Node pre = null; 
        Node cur = head; 
        Node next; 
        while (cur != null) { 
            next = cur.next; 
            cur.next = pre; 
            pre = cur; 
            cur = next; 
        } 
        head = pre; 
    }
     void rearrangeOddEven() { 
   if (head == null || head.next == null || head.next.next == null) { 
            return; 
        } 
        Node cur = head; 
        Node even = null; 
        Node temp = null; 
        Node pre = null; 
 
        while (cur != null && cur.next != null) { 
            pre = cur; 
            temp = cur.next; 
            cur.next = cur.next.next; 
            temp.next = even; 
            even = temp; 
            cur = cur.next; 
        } 
        if (cur == null) { 
            pre.next = even; 
        } else { 
            cur.next = even; 
        } 
    }
     void print(){
         Node cur=head;
         System.out.print("[");
         while(cur!=null){
             System.out.print(cur.val);
             if(cur.next!=null)
             System.out.print(",");
             cur=cur.next;
         }
         System.out.println("]");
     }
     
}

