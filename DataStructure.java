package JFRAME;

import java.util.Scanner;

public class LabAct2 {

    static class Node {
        int data;
        Node next;
        Node(int d){ data = d; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Linked List");
            System.out.println("4. Circular Linked List");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch(choice){
                case 1: stackMenu(sc); break;
                case 2: queueMenu(sc); break;
                case 3: listMenu(sc); break;
                case 4: circMenu(sc); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid.");
            }
        }while(choice != 0);
    }

    static void stackMenu(Scanner sc){
        int[] st = new int[10];
        int top = -1, op;
        do {
            System.out.println("\n[Stack]");
            System.out.println("1.Push  2.Pop  3.Show  0.Back");
            op = sc.nextInt();
            if(op==1){
                if(top==st.length-1) System.out.println("Full");
                else {
                    System.out.print("Value: ");
                    st[++top] = sc.nextInt();
                }
            }else if(op==2){
                if(top<0) System.out.println("Empty");
                else {
                    System.out.println("Popped " + st[top]);
                    top--;
                }
            }else if(op==3){
                for(int i=top;i>=0;i--) System.out.print(st[i]+" ");
                System.out.println();
            }
        }while(op!=0);
    }

    static void queueMenu(Scanner sc){
        int[] q = new int[10];
        int front=0,rear=-1,op;
        do {
            System.out.println("\n[Queue]");
            System.out.println("1.Enq  2.Deq  3.Show  0.Back");
            op = sc.nextInt();
            if(op==1){
                if(rear==q.length-1) System.out.println("Full");
                else {
                    System.out.print("Value: ");
                    q[++rear] = sc.nextInt();
                }
            }else if(op==2){
                if(front>rear) System.out.println("Empty");
                else {
                    System.out.println("Dequeued " + q[front]);
                    front++;
                }
            }else if(op==3){
                for(int i=front;i<=rear;i++) System.out.print(q[i]+" ");
                System.out.println();
            }
        }while(op!=0);
    }

    static void listMenu(Scanner sc){
        Node head=null; int op;
        do {
            System.out.println("\n[Linked List]");
            System.out.println("1.InsertEnd  2.DelBegin  3.Show  0.Back");
            op = sc.nextInt();
            if(op==1){
                System.out.print("Value: ");
                Node n=new Node(sc.nextInt());
                if(head==null) head=n;
                else {
                    Node c=head;
                    while(c.next!=null) c=c.next;
                    c.next=n;
                }
            }else if(op==2){
                if(head==null) System.out.println("Empty");
                else {
                    System.out.println("Deleted " + head.data);
                    head=head.next;
                }
            }else if(op==3){
                Node c=head;
                while(c!=null){ System.out.print(c.data+" "); c=c.next; }
                System.out.println();
            }
        }while(op!=0);
    }

    static void circMenu(Scanner sc){
        Node tail=null; int op;
        do {
            System.out.println("\n[Circular List]");
            System.out.println("1.Insert  2.Delete  3.Show  0.Back");
            op = sc.nextInt();
            if(op==1){
                System.out.print("Value: ");
                Node n=new Node(sc.nextInt());
                if(tail==null){ tail=n; tail.next=n; }
                else { n.next=tail.next; tail.next=n; tail=n; }
            }else if(op==2){
                if(tail==null) System.out.println("Empty");
                else {
                    Node h=tail.next;
                    System.out.println("Deleted " + h.data);
                    if(h==tail) tail=null;
                    else tail.next=h.next;
                }
            }else if(op==3){
                if(tail!=null){
                    Node h=tail.next;
                    do{ System.out.print(h.data+" "); h=h.next; }while(h!=tail.next);
                    System.out.println();
                }
            }
        }while(op!=0);
