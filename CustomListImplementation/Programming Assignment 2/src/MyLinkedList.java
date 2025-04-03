import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List <E>{

    private static class Node<E>{
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }


    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds " + index);
        }

        if (size == 0) {
            return null; // Handle empty list case
        }

        Node<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {  // Fixed loop condition
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {  // Fixed loop condition
                current = current.prev;
            }
        }
        return current;
    }


    private Node<E> head;
    private Node<E> tail;
    private int size;


    public MyLinkedList(){
        head=null;
        tail= null;
        size =0;
    }

    public boolean add(E e){
        Node<E> newNode = new Node<>(e);
        if(tail==null){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            tail.next = newNode;
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
        return true;
    }

    public void insertathead(E e){
        Node<E> newNode = new Node<E>(e);

        if (head == null){ //if the list is empty
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        }
        else{ //if list is not empty
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    public void insertattail(E e){
        Node<E> newNode = new Node<E>(e);
        if(head == null){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }

    }

    public void DeleteAtHead(){
        if (head == null){
            return;
        }
        Node<E> temp = head;
        head = temp.next;
        head.prev = null;
        size--;
    }

    public void DeleteAtTail(){
        if(head == null){
            return;
        }
        Node<E> temp = tail;
        tail = temp.prev;
        tail.next = null;
        size--;
    }

    public void add(int index, E element){
        if(index<0||index >size){
            throw new IndexOutOfBoundsException("index out of range at "+ index);
        }
        //insert at head
        if(index==0){
            insertathead(element);
            return;
        }
        if(index==size){
            insertathead(element);
            return;
        }
        else if(index == size-1){
            insertattail(element);
            return;
        }
        else{
            Node<E> currentNode = head;

            for(int i=0;i<index;i++){
                currentNode = currentNode.next;
            }
            Node<E> previousNode = currentNode.prev;

            //insertion will happen somewhere between those two nodes

            Node<E> newNode = new Node<E>(element);

            newNode.next = currentNode;
            newNode.prev = previousNode;
            previousNode.next = newNode;
            currentNode.prev = newNode;
            size++;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Node<E> nodeToRemove = getNode(index);
        if (nodeToRemove == null) {
            throw new NullPointerException("Node at index " + index + " is null");
        }

        E removedData = nodeToRemove.data;

        // Handle head removal
        if (nodeToRemove == head) {
            head = nodeToRemove.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // If list becomes empty
            }
        }
        // Handle tail removal
        else if (nodeToRemove == tail) {
            tail = nodeToRemove.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null; // If list becomes empty
            }
        }
        // Handle middle node removal
        else {
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }

        size--;
        return removedData;
    }


    
    public boolean remove(Object O) {
        if (size == 0) {
            return false; // Nothing to remove
        }

        Node<E> current = head;  // Start from head

        while (current != null) {
            if (current.data.equals(O)) {  // Found first occurrence
                Node<E> prevNode = current.prev;
                Node<E> nextNode = current.next;

                // Case 1: Removing head
                if (prevNode == null) {
                    head = nextNode;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;  // If list becomes empty
                    }
                }
                // Case 2: Removing tail
                else if (nextNode == null) {
                    tail = prevNode;
                    tail.next = null;
                }
                // Case 3: Removing a middle node
                else {
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                }

                size--;  // Reduce size after removing
                return true;
            }

            current = current.next;
        }

        return false; //not found
    }



    public int size(){
        return size;
    }

    String tostring(){
        if(head==null){
            return "[]";
        }
        String result = "[";
        Node<E> current = head;

        while (current != null) {
            result += String.valueOf(current.data);  // Convert node data to String
            if (current.next != null) {
                result += ", ";  // Add comma between elements
            }
            current = current.next;  // Move to next node
        }

        result += "]";
        return result;

    }

   public void clear(){
        head=null;
        tail=null;
        size=0;
    }

@Override
public boolean isEmpty() {
	throw new UnsupportedOperationException();
}

@Override
public boolean contains(Object o) {
	throw new UnsupportedOperationException();
}

@Override
public Iterator<E> iterator() {
	throw new UnsupportedOperationException();
}

@Override
public Object[] toArray() {
	throw new UnsupportedOperationException();
}

@Override
public <T> T[] toArray(T[] a) {
	throw new UnsupportedOperationException();
}

@Override
public boolean containsAll(Collection<?> c) {
	throw new UnsupportedOperationException();
}

@Override
public boolean addAll(Collection<? extends E> c) {
	throw new UnsupportedOperationException();
}

@Override
public boolean addAll(int index, Collection<? extends E> c) {
	throw new UnsupportedOperationException();
}

@Override
public boolean removeAll(Collection<?> c) {
	throw new UnsupportedOperationException();
}

@Override
public boolean retainAll(Collection<?> c) {
	throw new UnsupportedOperationException();
}

@Override
public E get(int index) {
	throw new UnsupportedOperationException();
}

@Override
public E set(int index, E element) {
	throw new UnsupportedOperationException();
}

@Override
public int indexOf(Object o) {
	throw new UnsupportedOperationException();
}

@Override
public int lastIndexOf(Object o) {
	throw new UnsupportedOperationException();
}

@Override
public ListIterator<E> listIterator() {
	throw new UnsupportedOperationException();
}

@Override
public ListIterator<E> listIterator(int index) {
	throw new UnsupportedOperationException();
}

@Override
public List<E> subList(int fromIndex, int toIndex) {
	throw new UnsupportedOperationException();
}
}

