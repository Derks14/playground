package dsa;

import java.util.Objects;
import java.util.function.Supplier;

public class DynamicArray<T> {

    int size;
    int capacity;
    Object[] array;
    int loadingFactor;

    public DynamicArray() {
        this.capacity = 10;
        this.loadingFactor = 2;
        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.loadingFactor = 2;
        this.array = new Object[this.capacity];
    }

    public void add(T element) {
        if (size >= capacity) this.growTheArray();
        this.array[size] = element;
        this.size++;

    }

    public void insert(int index, Object element) {
//        if the requested index is larger than the capacity. what should be done,
//        lets grow the array until the array has that size - we are implementing a dynamic array with no restrictions so we have to do ths
//        We can also give the user an error saying we don't have up to that capacity
        if (index < this.capacity) this.array[index] = element;
        else {
            while (index > this.capacity) {
                this.growTheArray();
            }
        }
    }

    private void growTheArray() {
//        double the capacity
//        create a new array with the doubled capacity
//        copy the items in the old array into the new array
//        then replace the old array with the newly created array

        this.capacity = this.capacity * loadingFactor;
        Object[] tempArray = new Object[this.capacity];

        if (this.size >= 0) System.arraycopy(this.array, 0, tempArray, 0, this.size);

        this.array = tempArray;
    }


//    we going to compare linkedList behaviour with ArrayList ( thats a dynamic array )


}
