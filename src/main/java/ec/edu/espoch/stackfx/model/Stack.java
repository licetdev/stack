
package ec.edu.espoch.stackfx.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class Stack {
    private Node top;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // push: apilar (insertar en el tope) -> O(1)
    public void push(int value) {
        Node n = new Node(value);
        n.next = top;
        top = n;
        size++;
    }
    
    // pop: desapilar (quitar del tope) -> O(1)
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        int v = top.value;
        top = top.next;
        size--;
        return v;
    }
   public ArrayList<Integer> toList() {
        ArrayList<Integer> out = new ArrayList<>(size);
        Node cur = top;
        while (cur != null) {
            out.add(cur.value);
            cur = cur.next;
        }
        return out;
    }
    
    
    
}
