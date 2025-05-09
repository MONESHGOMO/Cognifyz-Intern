class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running using Thread class");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // start() invokes run() in a separate thread
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running using Runnable interface");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}