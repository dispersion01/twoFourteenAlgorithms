package com.any.twofourteenalgorithms.integerList;


import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class IntegerListImpl implements IntegerList {
    private Integer[] arrayIntegerList;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public IntegerListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public IntegerListImpl(Integer capacity) {
        this.arrayIntegerList = new Integer[capacity];
    }

    private void checkNotNull(Integer item) {
        if (item == null) {
            throw new RuntimeException();
        }
    }

    @Override
    public Integer add(Integer item) {
        checkNotNull(item);
        arrayIntegerList[size++] = item;
        return item;
    }


    public boolean binarySearch(Integer item) {
        int min = 0;
        int max = arrayIntegerList.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(arrayIntegerList[mid])) {
                return true;
            }

            if (item < arrayIntegerList[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;

    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException();
        }
    }

    @Override
    public Integer add(int index, Integer item) {
        checkNotNull(item);
        checkIndex(index);
        add(item);
        for (int i = size - 1; i >= index; i--) { //сдвиг массива через цикл
            arrayIntegerList[i + 1] = arrayIntegerList[i];
        }
//        System.arraycopy(arrayIntegerList,0,arrayIntegerList,index+1, size-index);
        arrayIntegerList[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arrayIntegerList[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        int old = get(index);
        arrayIntegerList[index] = item;
        return item;
    }


    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, arrayIntegerList[i])) {
                return i;
            }
        }
        return -1;
    }

    private void removeItem(int index) {
        if (size - 1 > index) {
            System.arraycopy(arrayIntegerList, index + 1, arrayIntegerList, index, size - index - 1);
        }
        arrayIntegerList[size--] = null;
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = get(index);
        removeItem(index);
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkNotNull(item);
        checkIndex(item);
        int index = indexOf(item);
        removeItem(index);
        return item;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkNotNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(arrayIntegerList[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArrayStringList = new Integer[this.size];
        for (int i = 0; i < newArrayStringList.length; i++) {
            newArrayStringList[i] = this.get(i);
        }
        return arrayIntegerList;
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            return false;
        }
        return Arrays.equals(arrayIntegerList, otherList.toArray());
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        boolean result = true;
        for (Integer s : arrayIntegerList) {
            if (s != null) {
                result = false;
                break;
            }
        }
        return result;
    }
    @Override
    public void clear() {
        arrayIntegerList = new Integer[10];
        size = 0;
    }
    private static void swapElements(Integer[] arrayIntegerList, int indexA, int indexB) {
        int tmp = arrayIntegerList[indexA];
        arrayIntegerList[indexA] = arrayIntegerList[indexB];
        arrayIntegerList[indexB] = tmp;
    }

    //    @Override
    public Integer[] bubbleSort(Integer[] arrayIntegerList) {
        for (int i = 0; i < arrayIntegerList.length - 1; i++) {
            for (int j = 0; j < arrayIntegerList.length - 1 - i; j++) {
                if (arrayIntegerList[j] > arrayIntegerList[j + 1]) {
                    swapElements(arrayIntegerList, j, j + 1);
                }
            }
        }
        return arrayIntegerList;
    }

    @Override
    public Integer[] sortSelection(Integer[] arrayIntegerList) {
        for (int i = 0; i < arrayIntegerList.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arrayIntegerList.length; j++) {
                if (arrayIntegerList[j] < arrayIntegerList[minElementIndex]) {
                    minElementIndex = j;
                }
            }
        }
        return arrayIntegerList;
    }

    @Override
    public Integer[] sortInsertion(Integer[] arrayIntegerList) {
        for (int i = 1; i < arrayIntegerList.length; i++) {
            int temp = arrayIntegerList[i];
            int j = i;
            while (j > 0 && arrayIntegerList[j - 1] >= temp) {
                arrayIntegerList[j] = arrayIntegerList[j - 1];
                j--;
            }
            arrayIntegerList[j] = temp;
        }
        return arrayIntegerList;
    }
    public boolean contains(Integer item) {
        bubbleSort(arrayIntegerList);
        return binarySearch(item);
    }

    private Integer[] grow() {
        return Arrays.copyOf(arrayIntegerList, (int) (arrayIntegerList.length * 1.5));
    }

    private Integer[] resize() {
        return Arrays.copyOf(arrayIntegerList, (arrayIntegerList.length * 2 / 3));
    }
    private void checkCapacity() {
        if (size == arrayIntegerList.length) {
            arrayIntegerList = grow();
        } else if (size < arrayIntegerList.length *2 /3) {
            arrayIntegerList = resize();
        }
    }
}
