package com.any.twofourteenalgorithms.integerList;


import java.util.Objects;
import java.util.Random;

public class IntegerListImpl implements IntegerList {
    private Integer[] arrayIntegerList = new Integer[8];
    private int size = 0;



    @Override
    public Integer add(Integer item) {
        if (size <= arrayIntegerList.length) {
            Integer[] extend = new Integer[arrayIntegerList.length * 2];
            System.arraycopy(arrayIntegerList, 0, extend, 0, arrayIntegerList.length);
            arrayIntegerList = extend;
        }
        arrayIntegerList[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(item);
        for (int i = size - 1; i > index; i--) {
            arrayIntegerList[i] = arrayIntegerList[i - 1];
        }
        return item;
    }


    @Override
    public Integer set(int index, Integer item) {
        int old = get(index);
        arrayIntegerList[index] = item;
        return old;
    }

    @Override
    public Integer remove(Integer item) {
        int x = -1;
        for (int i = 0; i < size; i++) {
            if (item == arrayIntegerList[i]) {
                x = i;
                break;
            }
        }
        if (x != -1) {
            remove(x);
        } else {
            throw new RuntimeException();
        }
        return item;
    }

    @Override
    public Integer removeIndex(int index) {
        Integer element = get(index);
        for (int i = index; i < size - 1; i++) {
            arrayIntegerList[i] = arrayIntegerList[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(Integer item) {
        sortInsertion(arrayIntegerList);
        boolean exist = true;
        for (int i = 0; i < size; i++) {
            if (!arrayIntegerList[i].equals(item)) {
                exist = false;
                break;
            }
        }
        return binarySearch(item);
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

    @Override
    public int lastIndexOf(Integer item) {
        int result = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (arrayIntegerList[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arrayIntegerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            return false;
        }
        boolean result = true;
        if (this.size != otherList.size()) {
            result = false;
        } else {
            for (int i = 0; i < this.size; i++) {
                if (!this.get(i).equals(otherList.get(i))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
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

    @Override
    public Integer[] toArray() {
        Integer[] newArrayStringList = new Integer[this.size];
        for (int i = 0; i < newArrayStringList.length; i++) {
            newArrayStringList[i] = this.get(i);
        }
        return arrayIntegerList;
    }

    @Override
    public Integer[] randomNumberOfArray() { //генератор случайного массива

       Random random = new Random();
        for (int i = 0; i < arrayIntegerList.length; i++) {
            arrayIntegerList[i] = random.nextInt(100_000) + 100_000;
        }
        return arrayIntegerList;

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

    @Override
    public Integer compareSort() {
        long start = System.currentTimeMillis();
        int a = Math.toIntExact(System.currentTimeMillis() - start);
        return a;
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

}
