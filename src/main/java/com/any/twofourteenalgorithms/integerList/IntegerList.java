package com.any.twofourteenalgorithms.integerList;

public interface IntegerList {

        //Добавление элемента
        Integer add(Integer item);

        //    бинарный поиск
        boolean binarySearch(Integer item);

        // Добавление элемента по индексу
        Integer add(int index, Integer item);

        // Получить элемент по индексу.
        Integer get(int index);

        // Установить элемент на определенную позицию, затерев существующий.
        Integer set(int index, Integer item);

        // Поиск элемента. Вернуть индекс элемента
        int indexOf(Integer item);


        // Удаление элемента, по индексу.
        Integer remove(int index);

        //удаление элемента
        Integer remove(Integer item);

        // Поиск элемента с конца, возврщает индекс элемента или -1 в случае отсутствия.
        int lastIndexOf(Integer item);

        // Создать новый массив
        Integer[] toArray();

        // Сравнить текущий список с другим, true/false
        boolean equals(IntegerList otherList);

        //Вернуть фактическое количество элементов.
        int size();

        // Вернуть true, если элементов в списке нет
        boolean isEmpty();

        // Удалить все элементы из списка.
        void clear();

        //пузырьковый поиск
        Integer[] bubbleSort(Integer[] array);

        //    сортрировка выбором
        Integer[] sortSelection(Integer[] arrayIntegerList);

        // сортировка вставкой
        Integer[] sortInsertion(Integer[] arrayIntegerList);

        // Проверка на существование элемента, true/false;
        boolean contains(Integer item);
}
