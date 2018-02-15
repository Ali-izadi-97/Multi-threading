package ReentrantLocks_10;



// the ReentrantLock 
// -----------------

/*

A reentrant mutual exclusion Lock with the same basic behavior and semantics as 
the implicit monitor lock accessed using synchronized methods and statements, but 
with extended capabilities.

A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking 
it. A thread invoking lock will return, successfully acquiring the lock, when the lock 
is not owned by another thread. The method will return immediately if the current thread 
already owns the lock. This can be checked using methods isHeldByCurrentThread(), and 
getHoldCount().

The constructor for this class accepts an optional fairness parameter. When set true, 
under contention, locks favor granting access to the longest-waiting thread. Otherwise 
this lock does not guarantee any particular access order. Programs using fair locks 
accessed by many threads may display lower overall throughput (i.e., are slower; often 
much slower) than those using the default setting, but have smaller variances in times 
to obtain locks and guarantee lack of starvation. Note however, that fairness of locks 
does not guarantee fairness of thread scheduling. Thus, one of many threads using a fair 
lock may obtain it multiple times in succession while other active threads are not 
progressing and not currently holding the lock. Also note that the untimed tryLock 
method does not honor the fairness setting. It will succeed if the lock is available 
even if other threads are waiting.
*/



/**
 * the {@link java.util.concurrent.locks.ReentrantLock} class in Java as an
 * alternative to synchronized code blocks.
 * <br>
 * {@link java.util.concurrent.locks.ReentrantLock}s let you do all the
 * stuff that you can do with {@code synchronized}, {@link Object#wait()} and
 * {@link Object#notify()}, plus some more stuff. Besides that may come in
 * handy from time to time.
 * <br><br>
 * Source:<em>
 * http://docs.oracle.com/javase/1.5.0/docs/api/java/util/concurrent/locks/ReentrantLock.html
 * </em>
 * <br><br>
 * {@link java.util.concurrent.locks.ReentrantLock} Extended capabilities
 * include:
 * <br>
 * <ul>
 * <li>
 * The ability to have more than one {@link java.util.concurrent.locks.Condition}
 * variable per monitor.
 * </li>
 * <li>Monitors that use the synchronized keyword can only have one. This means
 * {@link java.util.concurrent.locks.ReentrantLock}s support more than one
 * {@link Object#wait()}/{@link Object#notify()} queue.
 * </li>
 * <li>
 * The ability to make the lock "fair".
 * <em>
 * "[fair] locks favor granting access to the longest-waiting
 * thread. Otherwise this lock does not guarantee any particular access order."
 * </em>
 * </li>
 * <li> Synchronized blocks are unfair.</li>
 * <li> The ability to check if the lock is being
 * held.</li>
 * <li>The ability to get the list of threads waiting on the lock.</li>
 * </ul>
 * <br><br>
 * The disadvantages of {@link java.util.concurrent.locks.ReentrantLock}s are:
 * <br>
 * <ul>
 * <li>Need to add import statement.</li>
 * <li>Need to wrap lock acquisitions in a try/finally block. This makes it more
 * ugly than the synchronized keyword.</li>
 * <li>The synchronized keyword can be put in method definitions which avoids
 * the need for a block which reduces nesting.</li>
 * </ul>
 * <br><br>
 * For more complete comparison of
 * {@link java.util.concurrent.locks.ReentrantLock}s and {@code synchronized}
 * see:<em>
 * http://guruzon.com/1/concurrency/explicit-lock-locking/difference-between-synchronized-and-reentrantlock-in-java
 * </em>
 * <br><br>
 * Codes with minor comments are from
 * <a href="http://www.caveofprogramming.com/youtube/">
 * <em>http://www.caveofprogramming.com/youtube/</em>
 * </a>
 * <br>
 * also freely available at
 * <a href="https://www.udemy.com/java-multithreading/?couponCode=FREE">
 *     <em>https://www.udemy.com/java-multithreading/?couponCode=FREE</em>
 * </a>
 *
 * @author Z.B. Celik <celik.berkay@gmail.com>
 */




public class App {


    public static void main(String[] args) throws Exception {

        final Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {

            public void run() {

                try {
                    runner.firstThread();
                } catch (InterruptedException ignored) {
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException ignored) {
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        runner.finished();
    }

}
