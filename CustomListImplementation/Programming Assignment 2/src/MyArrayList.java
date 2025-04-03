import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList <E> implements List <E> {

    private int size; //tracks number of elements
    private E[] array; //stores elements of the list

    //default constructor
    public MyArrayList() {
        array = (E[]) new Object[10];
        this.size = 0;
    }

    //adding at the end of the ArrayList
    public boolean add(E e){
        if(isFull()){
            resize();
        }
        array[size++] =e;
        return true;
    }

    //adding at a specified index on the arrayList
    public void add(int index, E element){
        //checking if index is within bounds
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("invalid index at "+ index);
        }
        //resize array if full
        if(isFull()) {
            resize();
        }
        //shifting elements to the right to make space
        for(int i=size; i>index; i--){
            array[i]=array[i-1];
        }
        //inserting elements at index
        array[index]=element;
        size++; //incrementing size after adding elements
    }

    public void clear(){
        for (int i=0; i<size; i++) {
            array[i]=null; //by setting the values to null, the garbage collection will do the rest
        }
        size=0;

    }

    public boolean remove(Object O) {
        for (int i = 0; i < size; i++) {
            if ((O == null && array[i] == null) || (O != null && array[i].equals(O))) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[--size] = null; // Avoid memory leak
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        E removedElement = array[index];

        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[--size] = null; // Avoid memory leak
        return removedElement;
    }


    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        String result = "[";

        for (int i = 0; i < size; i++) {
            result += array[i]; // Append element
            if (i < size - 1) {
                result += ", "; // Add comma if it's not the last element
            }
        }

        result += "]";
        return result;
    }
    //helper function to check if arraylist is full
    public boolean isFull(){
        if(size==array.length){
            return true;
        }
        return false;
    }

    //helper function to resize the old array by doubling it and copying the old array elements into the new one
    public void resize(){
        E[] newArray = (E[]) new Object[array.length*2]; //doubling array size
        for(int i=0;i<size;i++){
            newArray[i] = array[i];
        }
        array = newArray;
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

