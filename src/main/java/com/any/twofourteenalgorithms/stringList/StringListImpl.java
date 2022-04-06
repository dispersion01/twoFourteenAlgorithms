package com.any.twofourteenalgorithms.stringList;

import java.util.Objects;

public class StringListImpl implements StringList {
    private String[] arrayStringList = new String[20];
    private int size = 0;

    @Override
    public String add(String item) {
        if (size >= arrayStringList.length) {
            String[] extend = new String[arrayStringList.length * 2];
            System.arraycopy(arrayStringList, 0, extend, 0, arrayStringList.length);
            arrayStringList = extend;
        }
        arrayStringList[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(item);
        for (int i = size-1; i > index; i--) {
            arrayStringList[i]= arrayStringList[i-1];
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        String old = get(index);
        arrayStringList[index] = item;
        return old;
    }

    @Override
    public String remove(String item) {
        int x = -1;
        for (int i = 0; i < size; i++) {
            if (item.equals(arrayStringList[i])) {
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
    public String remove(int index) {
        String element = get(index);
        for (int i = index; i < size - 1; i++) {
            arrayStringList[i] = arrayStringList[i+1];
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(String item) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (arrayStringList[i].equals(item)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i <size; i++) {
            if (Objects.equals(item, arrayStringList[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        int result = -1;
        for (int i = size-1; i >=0; i--) {
            if (arrayStringList[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arrayStringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
        for (String s : arrayStringList) {
            if (s != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        arrayStringList = new String[10];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArrayStringList = new String[this.size];
        for (int i = 0; i < newArrayStringList.length; i++) {
            newArrayStringList[i] = this.get(i);
        }
        return newArrayStringList;
    }
}
