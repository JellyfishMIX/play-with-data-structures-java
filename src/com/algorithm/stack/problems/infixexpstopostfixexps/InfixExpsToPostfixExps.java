package com.algorithm.stack.problems.infixexpstopostfixexps;

import com.algorithm.array.Array;
import com.algorithm.queue.arrayqueue.ArrayQueue;
import com.algorithm.stack.arraystack.ArrayStack;

// convert infix expression to a postfix expression
public class InfixExpsToPostfixExps {
    Array<ArrayQueue<Character>> infixArray = new Array<>();    // 中缀式字符串队列集合，infixArray每个元素都是一个队列。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列

    // 中缀式字符串使用队列储存，以处理多位操作数。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列
    public void inputStr(String str) {
        int count = 0;  // 记录第几个infixArray元素将要存储，即第几个队列将要进行存储
        infixArray.addLast(new ArrayQueue());
        boolean isContinuousOperator = false;   // 锁，防止多个操作符连续出现导致infixArray中有空元素出现
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                if (isContinuousOperator != true) {
                    count++;
                    infixArray.addLast(new ArrayQueue());
                }
                infixArray.get(count).enqueue(c);
                count++;
                infixArray.addLast(new ArrayQueue());
                isContinuousOperator = true;    // 加入了操作符，加锁
                continue;
            }
            infixArray.get(count).enqueue(c);
            isContinuousOperator = false;   // 加入了操作数，解锁
        }
        // 输入是操作符后，操作符本身占了一个infixArray元素，此外infixArray中必定还会多加一个元素。防止因为最后一次输入是操作符，导致infixArray中最后一个元素为空
        if (isContinuousOperator == true) {
            infixArray.removeLast();
        }
    }

    // 显示中缀式字符串队列集合infixArray中储存的元素
    public void outputInfixArray() {
        System.out.println(infixArray);
    }

    // 测试"中缀式字符串使用队列储存"的效果
    public void testOutputInfixArray() {
        InfixExpsToPostfixExps infixExpsToPostfixExps = new InfixExpsToPostfixExps();
        // infixExpsToPostfixExps.inputStr("55+98*7");
        infixExpsToPostfixExps.inputStr("6789+2*(679*(3-1*345+1))");
        infixExpsToPostfixExps.outputInfixArray();
    }

    StringBuilder postfixExpsBuilder = new StringBuilder();    // 后缀表达式字符串构建器
    ArrayStack<Character> postfixArrayStack = new ArrayStack<>();   // 储存操作符的栈
    Array<ArrayQueue<Character>> postfixArray = new Array<>();    // 可以理解为postfixExpsBuilder的记录器。postfixArray每个元素都是一个队列。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列。后缀式字符串使用队列储存，以处理多位操作数。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列

    /**
     * 中缀转化为后缀表达式
     * 1.按次序读取中缀表达式的字符。
     * 2.读到一个操作数的时候，立即放入到输出中。
     * 3.从栈顶到第一个优先级不大于（小于，低于或等于）它的运算符（或 '(',但优先满足前一个条件）之间的运算符加入后缀表达式中，该运算符再入栈
     *   通俗理解：设预设操作符为'+', '-', '*', '/'。
     *   设读取为'*'，开始检测操作符栈顶是「同级或更高运算级符号」or「比自己低级的运算级符号」
     *      如果遇到「同级或更高运算级符号」,例如'*'或'/'，则将此「同级或更高运算级符号」赶出栈
     *      如果遇到「同级或更高运算级符号」,例如'*'或'/'，则将此「同级或更高运算级符号」赶出栈
     *      如果遇到「同级或更高运算级符号」,例如'*'或'/'，则将此「同级或更高运算级符号」赶出栈...
     *          每次赶出操作符后检测是否操作符栈为空，为空栈则将自己压入栈，停止检测
     *          每次检测中，如果遇到了'('，则将'('保留，自己进栈
     *      如果遇到「比自己低级的运算级符号」,例如'+'或'-'，则将此「比自己低级的运算级符号」保留，自己入栈，停止检测
     *   设读取为'+'，开始检测操作符栈顶是「同级或更高运算级符号」or「比自己低级的运算级符号」
     *      如果遇到「同级或更高运算级符号」,例如'+'或'-'，则将此「同级或更高运算级符号」赶出栈
     *      如果遇到「同级或更高运算级符号」,例如'+'或'-'，则将此「同级或更高运算级符号」赶出栈
     *      如果遇到「同级或更高运算级符号」,例如'+'或'-'，则将此「同级或更高运算级符号」赶出栈...
     *          每次赶出操作符后检测是否操作符栈为空，为空栈则将自己压入栈，停止检测
     *          此处，由于预设操作符中运算级别最低的是'+', '-'，没有比其更低的，所以'+', '-'会一直将栈中的操作符赶出去，直到遇到'('或空栈
     *              如果遇到了'('，则将'('保留，自己进栈
     *              如果遇到了空栈，则自己进栈
     *      如果遇到「比自己低级的运算级符号」,例如'=='或'!='，则将此「比自己低级的运算级符号」保留，自己入栈，停止检测
     *  4.读到操作符“)”，则从栈中弹出栈元素并输出，直到遇到第一个“(”为止。其中“(”不再添加到输出中，而是直接舍弃。
     *  5.当输入为空时，把栈里的操作符全部依次弹出并输出。
     */
    public void toPostfixExps() {
        int count = 0;  // 记录第几个postfixArray元素将要存储，即第几个队列将要进行存储
        postfixArray.addLast(new ArrayQueue());
        for (int i=0; i<infixArray.getSize(); i++) {
            char frontElem = infixArray.get(i).getFront();  // 获取infixArray中的当前队列队首，用来做读取判断。除用作判断外，别无他用
            if (frontElem != '+' && frontElem != '-' && frontElem != '*' && frontElem != '/' && frontElem != '(' && frontElem != ')') {
                int myQueueSize = infixArray.get(i).getSize();  // 接下来的for循环过程中，infixArray.get(i).getSize()的值会改变，因此先记录下来
                for (int j=0; j<myQueueSize; j++) {
                    postfixArray.get(count).enqueue(infixArray.get(i).getFront());  // 记录后缀表达式，后缀式字符串使用队列储存，以处理多位操作数。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列
                    postfixExpsBuilder.append(infixArray.get(i).getFront()); // 输出后缀表达式到字符串到StringBuilder
                    infixArray.get(i).dequeue();    // infixArray中的当前队列出队
                }

                count++;
                postfixArray.addLast(new ArrayQueue());
            } else if (frontElem == '(') {
                postfixArrayStack.push(infixArray.get(i).getFront());   // 获取infixArray中的当前队列队首（其实当前队列中只有一个操作符'('）
                infixArray.get(i).dequeue();    // infixArray中的当前队列出队
            } else if (frontElem == ')') {
                infixArray.get(i).dequeue();    // 进入到')'分支，当前'('使命就此终结。infixArray中的当前队列出队，即'('出队
                while (postfixArrayStack.peek() != '(') {
                    postfixArray.get(count).enqueue(postfixArrayStack.peek());  // 记录后缀表达式，后缀式字符串使用队列储存，以处理多位操作数。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列
                    postfixExpsBuilder.append(postfixArrayStack.peek()); // 输出后缀表达式到字符串到StringBuilder
                    postfixArrayStack.pop();

                    count++;
                    postfixArray.addLast(new ArrayQueue());
                }
                postfixArrayStack.pop();    // 发现postfixArrayStack中的'('，将其出栈
            } else if (frontElem == '*' || frontElem == '/') {
                // 读到操作符“+”，“-”，“*”，“/”，则从栈中弹出栈元素并输出，直到遇到优先级更低或者“(”的为止操作符为止。读取到的该运算符再入栈

                // 判断栈是否为空，若为空，则直接把'*'或'/'压入栈中。没有此步判空会导致后面的postfixArrayStack.peek()报异常
                if (postfixArrayStack.isEmpty()) {
                    postfixArrayStack.push(infixArray.get(i).getFront());
                    infixArray.get(i).dequeue();    // infixArray中的当前队列出队
                    continue;
                }
                while (postfixArrayStack.peek() != '+' && postfixArrayStack.peek() != '-' && postfixArrayStack.peek() != '(') {
                    postfixArray.get(count).enqueue(postfixArrayStack.peek());  // 记录后缀表达式，后缀式字符串使用队列储存，以处理多位操作数。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列
                    postfixExpsBuilder.append(postfixArrayStack.peek()); // 输出后缀表达式到字符串到StringBuilder
                    postfixArrayStack.pop();    // 栈顶元素出栈

                    count++;
                    postfixArray.addLast(new ArrayQueue());

                    // 检测逻辑会不断取栈顶检测，但如果栈中没有( 或 '+' 或'-'，会取空栈的栈顶，显然空栈是没有栈顶的，会报异常。因此每次从栈中赶出一个操作符，都要检测一下是否为空栈
                    if (postfixArrayStack.isEmpty()) {
                        break;
                    }
                }

                postfixArrayStack.push(infixArray.get(i).getFront());
                infixArray.get(i).dequeue();    // infixArray中的当前队列出队
            } else if (frontElem == '+' || frontElem == '-') {
                // 读到操作符“+”，“-”，“*”，“/”，则从栈中弹出栈元素并输出，直到遇到优先级更低或者“(”的为止操作符为止。读取到的该运算符再入栈
                // 通俗解释：如果出现'+'或'-'，一直把栈中操作符赶出去，直到遇到'('为止，不会把'('赶出去

                // 判断栈是否为空，若为空，则直接把'+'或'-'压入栈中。没有此步判空会导致后面的postfixArrayStack.peek()报异常
                if (postfixArrayStack.isEmpty()) {
                    postfixArrayStack.push(infixArray.get(i).getFront());
                    infixArray.get(i).dequeue();    // infixArray中的当前队列出队
                    continue;
                }
                while (postfixArrayStack.peek() != '(') {
                    postfixArray.get(count).enqueue(postfixArrayStack.peek());  // 记录后缀表达式，后缀式字符串使用队列储存，以处理多位操作数。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列
                    postfixExpsBuilder.append(postfixArrayStack.peek()); // 输出后缀表达式到字符串到StringBuilder
                    postfixArrayStack.pop();    // 栈顶元素出栈

                    count++;
                    postfixArray.addLast(new ArrayQueue());

                    // 如果读取为'+'或'-'，一直把栈中操作符赶出去，直到遇到'('为止，不会把'('赶出去
                    // 上述逻辑会不断取栈顶检测，但如果栈中没有(，会取空栈的栈顶，显然空栈是没有栈顶的，会报异常。因此每次从栈中赶出一个操作符，都要检测一下是否为空栈
                    if (postfixArrayStack.isEmpty()) {
                        break;
                    }
                }
                postfixArrayStack.push(infixArray.get(i).getFront());
                infixArray.get(i).dequeue();    // infixArray中的当前队列出队
            }
        }

        // 当结束读取时，把栈里的操作符全部依次弹出并输出
        while (!postfixArrayStack.isEmpty()) {
            postfixArray.get(count).enqueue(postfixArrayStack.peek());  // 记录后缀表达式，后缀式字符串使用队列储存，以处理多位操作数。原则上 一个操作数/一个操作符/一个'('或')' 占用一个队列
            postfixExpsBuilder.append(postfixArrayStack.peek()); // 输出后缀表达式到字符串到StringBuilder
            postfixArrayStack.pop();    // 栈顶元素出栈

            count++;
            postfixArray.addLast(new ArrayQueue());
        }
    }

    // 打印中缀式字符串存储队列集合，打印后缀表达式postfixExps, 后缀表达式记录器postfixArray, 后缀栈postfixArrayStack
    public void printPostfixExps() {
        String postfixExps = postfixExpsBuilder.toString();
        System.out.println("后缀表达式为：");
        System.out.println(postfixExps);
        // System.out.println("中缀式字符串存储队列集合为：");
        // System.out.println(infixArray); // 打印中缀式字符串存储队列集合，查看是否全部出队
        System.out.println("后缀表达式的存储队列集合为：");
        System.out.println(postfixArray);   // 打印后缀表达式的存储队列集合postfixArray
        // System.out.println(postfixArrayStack);
    }

    ArrayStack<Double> operandStack = new ArrayStack<>();  // 操作数栈
    /**
     * 后缀表达式求值
     * 1.按次序读取后缀表达式的每一个字符。
     * 2.读取到操作数时，把操作数压入栈中。
     * 3.读取到操作符时，对栈顶的2个操作数做相应运算，要注意操作数的前后顺序。结果压入栈中。
     * 4.读取完所有的字符后，弹出栈。得到的值就是所求结果。
     * @return
     */
    public double calcPostfixExps() {
        for (int i=0; i<postfixArray.getSize()-1; i++) {
            char frontElem = postfixArray.get(i).getFront();    // 获取postfixArray中的当前队列队首，用来做读取判断。除用作判断外，别无他用
            if (frontElem != '+' && frontElem != '-' && frontElem != '*' && frontElem != '/') {
                int myQueueSize = postfixArray.get(i).getSize();  // 接下来的for循环过程中，infixArray.get(i).getSize()的值会改变，因此先记录下来
                double myNumber = 0;   // 记录当前多位操作数数值
                for (int j=0; j<myQueueSize; j++) {
                    int myOperand = postfixArray.get(i).dequeue() - '0';
                    myNumber += myOperand * Math.pow(10, ((double)myQueueSize-j-1));
                }

                operandStack.push(myNumber);    // 操作数入栈
                // System.out.println(operandStack);   // 打印操作数栈，展示后缀表达式运算过程第一处。第一处在207行 ，第二处在226行，第三处在230行
            } else {
                double a = operandStack.pop();
                char operator = postfixArray.get(i).getFront(); // 获取操作符
                postfixArray.get(i).dequeue();  // 操作符出队列，给下个操作符腾空间
                double b = operandStack.pop();

                double myRes = 0;
                if (operator == '+') {
                    myRes = b + a;
                } else if (operator == '-') {
                    myRes = b - a;
                } else if (operator == '*') {
                    myRes = b * a;
                } else if (operator == '/'){
                    myRes = b / a;
                }

                operandStack.push(myRes);
                // System.out.println(operandStack);   // 打印操作数栈，展示后缀表达式运算过程第二处。第一处在207行 ，第二处在226行，第三处在230行
            }
        }

        // System.out.println(operandStack);   // 打印操作数栈,展示后缀表达式运算过程第三处。第一处在207行 ，第二处在226行，第三处在230行
        return operandStack.pop();
    }
}
