package task1;

import java.util.Arrays;

public class SimpleArrayList {

    private final static int INITIAL_CAPACITY = 5;
    private int cap = INITIAL_CAPACITY;
    private int size = 0;
    private int[] arr = new int[cap];

    /**
     * Constructors
     */

    // default constructor
    public SimpleArrayList() {
        this.cap = INITIAL_CAPACITY;
        this.size = 0;
        this.arr = new int[cap];
    }

    // Constructor taking one integer value
    public SimpleArrayList(int value) {
        this.cap = INITIAL_CAPACITY;
        this.size = 1;
        this.arr = new int[] {value};
    }

    // Constructor taking an array of ints
    public SimpleArrayList(int[] values) {
        this.size = values.length;
        this.cap = Math.max(size, INITIAL_CAPACITY);
        this.arr = Arrays.copyOf(values, cap);
    }

    // Constructor taking another vector of type SimpleArrayList
    public SimpleArrayList(SimpleArrayList other) {
        this.size = other.size;
        this.cap = other.cap;
        this.arr = Arrays.copyOf(other.arr, cap);
    }

    /**
     * Methods
     */

    //Method size
    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        cap = INITIAL_CAPACITY;
        arr = new int[cap];
    }

    // Method trim
    public void trim() {
        int[] newArr = new int[size];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
        cap = size;
    }

    // Method insert
    public SimpleArrayList insert(int ind, int[] other) {
        if (ind > size || ind < 0) {
            throw new IndexOutOfBoundsException();
        }
        int sz = other.length;
        int newSize = size + sz;
        if (newSize > cap) {
            int newCap = 2 * newSize;
            int[] newArr = new int[newCap];
            System.arraycopy(arr, 0, newArr, 0, ind);
            System.arraycopy(other, 0, newArr, ind, sz);
            System.arraycopy(arr, ind, newArr, ind + sz, size - ind);
            arr = newArr;
            cap = newCap;
        } else {
            System.arraycopy(arr, ind, arr, ind + sz, size - ind);
            System.arraycopy(other, 0, arr, ind, sz);
        }
        size = newSize;
        return this;
    }

    public SimpleArrayList insert(int ind, int e) {
        insert(ind, new int[] { e });
        return this;
    }

    public SimpleArrayList append(int e) {
        insert(size, e);
        return this;
    }

    public SimpleArrayList append(int[] a) {
        insert(size, a);
        return this;
    }

    public SimpleArrayList append(SimpleArrayList a) {
        insert(size, a.arr);
        return this;
    }

    public int get(int ind) {
        if (ind < 0 || ind >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[ind];
    }
    public SimpleArrayList set(int ind, int val) {
        if (ind < 0 || ind >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[ind] = val;
        return this;
    }
    public String toString() {
        return "Cap=" + cap + ", size=" + size + ": " + Arrays.toString(Arrays.copyOfRange(arr, 0, size));
    }


    public static void main(String[] args) {
        SimpleArrayList a =
                new SimpleArrayList()
                        .append(new int[]{1,3}).insert(1,2)
                        .append(6).insert(3,new int[]{4,5});
        SimpleArrayList b = new SimpleArrayList(a);
        for (int i = 0; i < a.size(); ++i)
            a.set(i,a.get(i)+6);
        b.append(a).append(13).trim();
        System.out.println("a -> " + a);
        System.out.println("b -> " + b);



    }
}
