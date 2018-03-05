/**
 * Created by kevin on 2/24/2018.
 */
public class StackNode {
    private int data;

    public StackNode next;

    public StackNode(int data) {

        this.data = data;
        next = null;
    }

    public StackNode(StackNode next, int data) {
        this.next = next;
        this.data = data;
    }

    public int Data() {
        return data;
    }
}
