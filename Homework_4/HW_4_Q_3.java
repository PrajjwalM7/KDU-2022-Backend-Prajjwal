class Notify1 extends Thread {
    public void run() {
        synchronized (this) {
            System.out.println("Starting of " + Thread.currentThread().getName());
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "...notified");
        }
    }
}

class Notify2 extends Thread {
    Notify1 notify1;

    Notify2(Notify1 notify1) {
        this.notify1 = notify1;
    }

    public void run() {
        synchronized (this.notify1) {
            System.out.println("Starting of " + Thread.currentThread().getName());
            try {
                this.notify1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "...notified");
        }
    }
}

class Notify3 extends Thread {
    Notify1 notify1;

    Notify3(Notify1 notify1) {
        this.notify1 = notify1;
    }

    public void run() {
        synchronized (this.notify1) {
            System.out.println("Starting of " + Thread.currentThread().getName());
            this.notify1.notify();
            this.notify1.notify();
//             this.notify1.notifyAll();
            System.out.println(Thread.currentThread().getName() + "...notified");
        }
    }
}

public class HW_4_Q_3 {
    public static void main(String[] args) throws InterruptedException {
        Notify1 notify1 = new Notify1();
        Notify2 notify2 = new Notify2(notify1);
        Notify3 notify3 = new Notify3(notify1);

        // creating the threads
        Thread t1 = new Thread(notify1, "Thread-1");
        Thread t2 = new Thread(notify2, "Thread-2");
        Thread t3 = new Thread(notify3, "Thread-3");

        // call run() method
        t1.start();
        t2.start();
        Thread.sleep(100);
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All threads finished execution. Main method completed.");
    }
}
