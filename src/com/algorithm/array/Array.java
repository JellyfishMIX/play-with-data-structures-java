package com.algorithm.array;

public class Array<E> { //泛型
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组中元素的个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向指定位置添加新元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. Require index>=0 && index<=size");
        }

        // 若数组已满，则新建扩容数组，把原数组中数据逐个挪入新数组中，实现动态数组
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 向数组开头添加一个新元素
    public void addFirst(E e) {
        this.add(0, e);
    }

    // 向数组末尾添加一个新元素
    public void addLast(E e) {
        this.add(size, e);
    }

    // 删除指定位置的元素，返回删除的元素
    public E deleteByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. Require index>=0 && index<=size");
        }
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;  // data[]中存放着一个个类对象的引用，data[size]还占用着一个引用，可以设为空，Java垃圾回收技术会释放掉占用的内存。非必须。该情况被称为loitering objects，注意： loitering objects != memory leak
        return ret;
    }

    // 删除数组开头元素
    public void deleteFirst() {
        E ret = deleteByIndex(0); //E ret 是作为接收deleteByIndex()的返回值，无实际作用
    }

    // 删除数组末尾元素
    public void deleteLast() {
        E ret = deleteByIndex(size - 1); //E ret 是作为接收deleteByIndex()的返回值，无实际作用
    }

    // 删除指定的某个元素
    public void delete(E e) {
        int index = find(e);
        if (index != -1) {
            E ret = deleteByIndex(index); //E ret 是作为接收deleteByIndex()的返回值，无实际作用
        }
    }

    // 获得index索引位置元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("getArrayElem failed. Require index>=0 && index<=size");
        }
        return data[index];
    }

    // 设置index索引位置元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("setArrayElem failed. Require index>=0 && index<=size");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean isContain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) { // data[i]和e都是类对象，equals()是值比较，比较两个对象的值是否相等。 ==是引用比较，比较变量名区域所放的值是否相等。
                return true;
            }
        }
        return false;
    }

    // 查询数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) { // data[i]和e都是类对象，equals()是值比较，比较两个对象的值是否相等。 ==是引用比较，比较变量名区域所放的值是否相等。
                return i;
            }
        }
        return -1;
    }

    // 新建扩容数组，把原数组中数据逐个挪入新数组中，实现动态数组
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0; i<size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
