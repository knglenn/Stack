import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

/**
 * Created by kevin on 2/24/2018.
 */
public class Stack {
    private StackNode head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    // adding a node at the head
    public void push(int data) {
        if(head == null) {
            head = new StackNode(null, data);

        }
        else {
            StackNode newNode = new StackNode(head, data);

            head = newNode;
        }
        //account for new node;
        size++;
    }


    public void pop() {
        if(head == null) {
            return;
        }
        head = head.next;

        size--;
    }



    public void print() {
        StackNode currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.Data() + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    public int size() {
        //returns number of links
        return size;
    }


    public String[] readFile(String inFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));

            String line = null;
            String[] val = null;
            while ((line = reader.readLine()) != null) {
                val = line.split(" ");
            }
            reader.close();
            return val;
        }
        catch(java.io.IOException e) {
            System.out.println("Either the file was not found, or something went wrong. Please try again.");
            System.exit(0);
        }
        return null;
    }
    public void execute(String[] target) {

        Stack stack = new Stack();
        int key;

        System.out.println("\nInput read from file: ");
        for(int i = 0; i < target.length; i ++) {
            System.out.print(target[i] + " ");
        }
        System.out.println("\n");
        try {
            //maximum size of stack specified by user
            int maxSize = Integer.parseInt(target[0]);


            for (int i = 1; i < target.length; i++) {

                //System.out.println(target[i])
                if (target[i].endsWith(".push")) {

                    try {
                        //regex deletes nondigits
                        key = Integer.parseInt(target[i].replaceAll("\\D+", ""));
                        if (stack.size() >= maxSize) {

                            System.out.println("\nCommand '" + target[i] + "' rejected. Reason: OVERFLOW. Size of (" + maxSize + ") exceeded. Please remove some items.");
                        } else {
                            System.out.print("\nCommand '" + target[i] + "' successful. \nStack before operation: ");
                            if(stack.size() > 0) {
                                stack.print();
                            }
                            else {
                                System.out.println("The stack is empty!");
                            }
                            stack.push(key);
                            System.out.print("Stack after operation: ");
                            stack.print();

                        }
                    }
                    catch(NumberFormatException e) {
                        System.out.println("FATAL ERROR: You can only push integers into the stack. The command '" + target[i] + "' is not a valid command. Please modify your input file and try again.");
                        System.exit(0);
                    }

                } else if (target[i].contains("pop")) {
                    if (stack.size() > 0) {

                        System.out.print("\nCommand '" + target[i] + "' successful. \nStack before operation: ");
                        if(stack.size() > 0) {
                            stack.print();
                        }
                        else {
                            System.out.println("The stack is empty!");
                        }

                        stack.pop();
                        System.out.print("Stack after operation: ");
                        if (stack.size() > 0) {
                            stack.print();
                        } else {
                            System.out.println("The stack is empty!");
                        }

                    } else {

                        System.out.println("\nCommand '" + target[i] + "' rejected. Reason: You can't pop if you have nothing in the stack!");
                    }
                } else {

                    System.out.println("\nCommand '" + target[i] + "' rejected. Reason: \nNot a valid command.");
                }
            }

            System.out.println("\nEnd of command list. Your stack: ");
            if (stack.size() > 0) {
                stack.print();
            } else {
                System.out.println("The stack is empty!");
            }
        }
        catch(NumberFormatException e) {
            System.out.println("FATAL ERROR: The first entry in the file must be a number that specifies the size of your stack. Please modify your input file and try again.");
        }



    }
    public static void main(String[] args) {

        Stack run = new Stack();

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a file name.");
        String userIn = scan.nextLine();

        run.execute(run.readFile(userIn));


    }
}
