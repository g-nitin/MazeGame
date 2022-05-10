/*
Nitin Gupta
Class example 2/22/22
 */

public class LLStack<T> implements StackI<T> {

    private class ListNode
    {
        T data;
        ListNode link;

        public ListNode(T aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }

    private ListNode head;

    public LLStack()
    {
        head = null;
    }

    public void push(T aData)
    {
        if (aData == null)
            return;

        ListNode newNode = new ListNode(aData, head);
        head = newNode;
    }

    public T pop()
    {
        if (head == null) // empty list
            return null;

        T toReturn = head.data;
        head = head.link;

        return toReturn;
    }

    public T peek()
    {
        if (head == null) // empty list
            return null;

        return head.data;
    }

    public void print()
    {
        for (ListNode temp = head; temp != null; temp = temp.link)
            System.out.println(temp.data);
    }

}
