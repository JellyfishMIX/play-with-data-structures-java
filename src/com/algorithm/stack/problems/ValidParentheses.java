package com.algorithm.stack.problems;

// import java.util.Stack

// leetcode.com #20 Valid Parentheses
public class ValidParentheses {
    // leetcode提交区只能提交一个class，因此可以将需要的自定义类做成提交class的内部类。leetcode支持折叠，内部类的修饰符可以改为private

    // 动态数组
    private class Array<E> { //泛型
        private E[] data;
        private int size;

        // 构造函数，传入数组的容量capacity构造Array
        public Array(int capacity) {
            data = (E[]) new Object[capacity];  // java不支持new一个泛型类型的静态数组，需要中转一下。new一个Object类型的动态数组，然后强制转换成泛型类型
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
                data[i] = data[i+1];
            }
            size--;
            data[size] = null;  // data[]中存放着一个个类对象的引用，data[size]还占用着一个引用，可以设为空，Java垃圾回收技术会释放掉占用的内存。非必须。该情况被称为loitering objects，注意： loitering objects != memory leak

            if (size == data.length/4 && data.length/2 != 0) {
                this.resize(data.length/2);
            }
            return ret;
        }

        // 删除数组开头元素
        public void deleteFirst() {
            E ret = deleteByIndex(0); //E ret 是作为接收deleteByIndex()的返回值，无实际作用
        }

        // 删除数组末尾元素
        public E deleteLast() {
            E ret = deleteByIndex(size-1); //E ret 是作为接收deleteByIndex()的返回值
            return ret;
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

        // 获得第一个元素
        public E getFirst() {
            return get(0);
        }

        // 获得最后一个元素
        public E getLast() {
            return get(size-1);
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

    // Stack接口
    private interface Stack<E> {
        int getSize();
        boolean isEmpty();
        void push(E e); // 入栈
        E pop();    // 出栈
        E peek();   // 检查栈顶元素
    }

    // ArrayStack
    private class ArrayStack<E> implements Stack<E> {
        Array<E> array; // 动态数组Array，capacity随意

        public ArrayStack() {
            array = new Array<>();
        }
        public ArrayStack(int capacity) {
            array = new Array<>(capacity);
        }

        @Override
        public int getSize() {
            return array.getSize();
        }

        @Override
        public boolean isEmpty() {
            return array.isEmpty();
        }

        // getCapacity()是动态数组Array实现Stack所特有的，Stack本身没有该方法。因为只有动态数组才有capacity这一概念
        public int getCapacity() {
            return array.getCapacity();
        }

        @Override
        // 入栈
        public void push(E e) {
            array.addLast(e);
        }

        @Override
        // 出栈
        public E pop() {
            return array.deleteLast();
        }

        @Override
        // 检查栈顶元素
        public E peek() {
            return array.getLast(); // 判断栈是否为空的逻辑在Array中
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("Stack: ");
            res.append("[");
            for(int i = 0; i<array.getSize(); i++) {
                res.append(array.get(i));
                if (i != array.getSize()-1)
                    res.append(", ");
            }
            res.append("] top");
            return res.toString();
        }
    }

    // leetcode判题所需方法
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * leetcode本地测试，直接在下方写一个main函数用来测试即可。提交leetcode时也可以粘贴进提交区。
     * leetcode判题时，会将提交的class拿出来，创建一个main函数测试用例，创建提交class的对象，将main函数测试用例传入
     * 因此，提交的class中的方法必须是public，不能是private。否则，leetcode测试用例将无法获取到所需方法
     * @param args
     */
    public static void main(String[] args) {
        System.out.println((new ValidParentheses()).isValid("{[]()}")); // 测试输入，输出结果应为true
        System.out.println((new ValidParentheses()).isValid("{[}]")); // 测试输入，输出结果应为false
    }
}
