package com.lingyuanyang.algorithm.jvm;

public class StackOverflow {
    /*
     * JVM设置
     * -Xss128K   => counts = 1825
     * 默认1M     => counts = 18025
     *
     * -Xss设置越小count值越小，说明一个线程栈里能分配的栈帧就越少，但是对JVM整体来说能开启的线程数会更多
     * 最小值必须大于144k
     */
    static int count = 0;

    static void redo() {
        count++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println(count);
        }
    }
}
