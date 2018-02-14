package WaitAndNotify_8;




public class App {


    public static void main(String[] args) throws InterruptedException {
        

        final Processor processor = new Processor();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException ignored) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}










//=================================================================================
// public class ThreadA {
//     public static void main(String[] args){
//         ThreadB b = new ThreadB();
//         b.start();
 
//         synchronized(b){
//             try{
//                 System.out.println("Waiting for b to complete...");
//                 b.wait();
//             }catch(InterruptedException e){
//                 e.printStackTrace();
//             }
 
//             System.out.println("Total is: " + b.total);
//         }
//     }
// }
 
// class ThreadB extends Thread{
//     int total;
//     @Override
//     public void run(){
//         synchronized(this){
//             for(int i=0; i<100 ; i++){
//                 total += i;
//             }
//             notify();
//         }
//     }
// }

//=================================================================================





//=================================================================================
// class Producer extends Thread {

//     static final int MAXQUEUE = 5;
//     private Vector messages = new Vector();

//     @Override
//     public void run() {
//         try {
//             while (true) {
//                 putMessage();
//                 //sleep(5000);
//             }
//         } catch (InterruptedException e) {
//         }
//     }

//     private synchronized void putMessage() throws InterruptedException {
//         while (messages.size() == MAXQUEUE) {
//             wait();
//         }
//         messages.addElement(new java.util.Date().toString());
//         System.out.println("put message");
//         notify();
//         //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
//     }

//     // Called by Consumer
//     public synchronized String getMessage() throws InterruptedException {
//         notify();
//         while (messages.size() == 0) {
//             wait();//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
//         }
//         String message = (String) messages.firstElement();
//         messages.removeElement(message);
//         return message;
//     }
// }


// public class App extends Thread {


//     Producer producer;

//     public App(Producer prod) {
//         this.producer = prod;
//     }

//     @Override
//     public void run() {

//         try {

//             while (true) {

//                 String message = producer.getMessage();
//                 System.out.println("Got message: " + message);
//                 //sleep(200);
//             }
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void main(String[] args) {

//         System.out.println("Hello Berlin!");

//         Producer producer = new Producer();
//         producer.start();
//         new App(producer).start();
//     }
// }
//=================================================================================

