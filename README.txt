
	Note
	————

    The code is not mine and collected for the educational purpose from various blogs/ web-pages and books. Many instances, I refactored the code and occasionally, re-write some portion to adjust well.       

	
	
	MULTI-THREADING IN JAVA
	———————————————————————
	
	
	THREAD CLASS METHODS
	————————————————————
	
	public void start(): START A THREAD BY CALLING ITS run() METHOD
	
	public void run(): ENTRY POINT FOR THE THREAD
	
	public final vod setName(String tName): SET THE NAME OF THE THREAD
	
	public final vod setPriority(int tPriority): TO SET THE PRIORITY OF THE THREAD
	
	public final vod setDaemon(BOOLEAN ON): A PARAMETER OF TRUE DENOTES THIS THREAD AS A DAEMON THREAD.
	
	void join(Long miliSec): WAIT FOR A THREAD TO TERMINATE. THIS METHOD WHEN CALLED FROM THE PARENT THREAD MAKES PARENT THREAD WAIT TILL CHILD THREAD TERMINATES. THE CURRENT THREAD INVOKES THIS METHOD ON A SECOND THREAD, CAUSING THE CURRENT THREAD TO BLOCK UNTIL THE SECOND THREAD TERMINATES OR THE SPECIFIED NUMBER OF MILLISECONDS PASSES.
	
	public void interrupt(): INTERRUPTS THIS THREAD, CAUSING IT TO CONTINUE EXECUTION IF IT WAS BLOCKED FOR ANY REASON.
	
	public final boolean isAlive(): DETERMINE IF A THREAD IS STILL RUNNING
	
	
	THE FOLLOWING METHODS IN THE THREAD CLASS ARE STATIC. INVOKING ONE OF THE STATIC METHODS PERFORMS THE OPERATION ON THE CURRENTLY RUNNING THREAD.
	
	public static void yield(): CAUSES THE CURRENTLY RUNNING THREAD TO YIELD TO ANY OTHER THREADS OF THE SAME PRIORITY THAT ARE WAITING TO BE SCHEDULED.
	
	public static void sleep(Long miliSecond): CAUSES THE CURRENTLY RUNNING THREAD TO BLOCK FOR AT LEAST THE SPECIFIED NUMBER OF MILLISECONDS.
	
	public static boolean holdSlock(Object x): RETURNS TRUE IF THE CURRENT THREAD HOLDS THE LOCK ON THE GIVEN OBJECT.
	
	public static Thread currentThread(): RETURNS A REFERENCE TO THE CURRENTLY RUNNING THREAD, WHICH IS THE THREAD THAT INVOKES THIS METHOD.
	
	public static void dumpStack(): PRINTS THE STACK TRACE FOR THE CURRENTLY RUNNING THREAD, WHICH IS USEFUL WHEN DEBUGGING A MULTITHREADED APPLICATION.
	
	getName(): IT IS USED FOR OBTAINING A THREAD’S NAME
	void getPriority(): OBTAIN A THREAD’S PRIORITY
	
	
	MIN_PRIORITY, NORM_PRIORITY OR MAX_PRIORITY.
	
	
	THERE ARE SOME METHODS THAT CAN BE USE BY THE THREADS TO COMMUNICATE WITH EACH OTHER. THEY ARE AS FOLLOWING,
	
	wait(): TELLS THE CALLING THREAD TO GIVE UP THE MONITOR AND GO TO SLEEP UNTIL SOME OTHER THREAD ENTERS THE SAME MONITOR AND CALLS NOTIFY().
	
	notify(): WAKES UP THE FIRST THREAD THAT CALLED WAIT() ON THE SAME OBJECT.
	notifyAll(): WAKES UP ALL THE THREADS THAT CALLED WAIT() ON THE SAME OBJECT. THE HIGHEST PRIORITY THREAD WILL RUN FIRST.
	
	
	JAVA THREAD PRIORITIES ARE IN THE RANGE BETWEEN MIN_PRIORITY (A CONSTANT OF 1) AND MAX_PRIORITY (A CONSTANT OF 10). BY DEFAULT, EVERY THREAD IS GIVEN PRIORITY NORM_PRIORITY (A CONSTANT OF 5). THREADS WITH HIGHER PRIORITY ARE MORE IMPORTANT TO A PROGRAM AND SHOULD BE ALLOCATED PROCESSOR TIME BEFORE LOWER-PRIORITY THREADS. HOWEVER, THREAD PRIORITIES CANNOT GUARANTEE THE ORDER IN WHICH THREADS EXECUTE AND VERY MUCH PLATFORM DEPENDENT.
	
	
	
	THREAD SYNCHRONIZATION
	——————————————————————
	
	WHEN TWO OR MORE THREADS NEED ACCESS TO A SHARED RESOURCE THERE SHOULD BE SOME WAY THAT THE RESOURCE WILL BE USED ONLY BY ONE RESOURCE AT A TIME. THE PROCESS TO ACHIEVE THIS IS CALLED SYNCHRONIZATION. ONCE A THREAD IS INSIDE A SYNCHRONIZED METHOD, NO OTHER THREAD CAN CALL ANY OTHER SYNCHRONIZED METHOD ON THE SAME OBJECT. TO UNDERSTAND SYNCHRONIZATION JAVA HAS A CONCEPT OF MONITOR. MONITOR CAN BE THOUGHT OF AS A BOX WHICH CAN HOLD ONLY ONE THREAD. ONCE A THREAD ENTERS THE MONITOR ALL THE OTHER THREADS HAVE TO WAIT UNTIL THAT THREAD EXITS THE MONITOR.
	
	INTER-THREAD COMMUNICATION
	INTER THREAD COMMUNICATION IS IMPORTANT WHEN YOU DEVELOP AN APPLICATION WHERE TWO OR MORE THREADS EXCHANGE SOME INFORMATION.
	public void wait(): CAUSES THE CURRENT THREAD TO WAIT UNTIL ANOTHER THREAD INVOKES THE NOTIFY().
	public void notify(): WAKES UP A SINGLE THREAD THAT IS WAITING ON THIS OBJECT'S MONITOR.
	public void notifyAll(): WAKES UP ALL THE THREADS THAT CALLED WAIT( ) ON THE SAME OBJECT.
	THESE METHODS HAVE BEEN IMPLEMENTED AS FINAL METHODS IN OBJECT, SO THEY ARE AVAILABLE IN ALL THE CLASSES. ALL 3 METHODS CAN BE CALLED ONLY FROM WITHIN A SYNCHRONIZED CONTEXT.
	THREAD DEADLOCK
	DEADLOCK DESCRIBES A SITUATION WHERE TWO OR MORE THREADS ARE BLOCKED FOREVER, WAITING FOR EACH OTHER. DEADLOCK OCCURS WHEN MULTIPLE THREADS NEED THE SAME LOCKS BUT OBTAIN THEM IN DIFFERENT ORDER. A JAVA MULTITHREADED PROGRAM MAY SUFFER FROM THE DEADLOCK CONDITION BECAUSE THE SYNCHRONIZED KEYWORD CAUSES THE EXECUTING THREAD TO BLOCK WHILE WAITING FOR THE LOCK, OR MONITOR, ASSOCIATED WITH THE SPECIFIED OBJECT.
	
	THREAD CONTROL
	——————————————
	
	CORE JAVA PROVIDES A COMPLETE CONTROL OVER MULTITHREADED PROGRAM. YOU CAN DEVELOP A MULTITHREADED PROGRAM WHICH CAN BE SUSPENDED, RESUMED OR STOPPED COMPLETELY BASED ON YOUR REQUIREMENTS. THERE ARE VARIOUS STATIC METHODS WHICH YOU CAN USE ON THREAD OBJECTS TO CONTROL THEIR BEHAVIOR.
	PUBLIC VOID SUSPEND(): THIS METHOD PUTS A THREAD IN SUSPENDED STATE AND CAN BE RESUMED USING RESUME() METHOD.
	PUBLIC VOID STOP(): THIS METHOD STOPS A THREAD COMPLETELY.
	PUBLIC VOID RESUME(): THIS METHOD RESUMES A THREAD WHICH WAS SUSPENDED USING SUSPEND() METHOD.
	PUBLIC VOID WAIT(): CAUSES THE CURRENT THREAD TO WAIT UNTIL ANOTHER THREAD INVOKES THE NOTIFY().
	PUBLIC VOID NOTIFY(): WAKES UP A SINGLE THREAD THAT IS WAITING ON THIS OBJECT'S MONITOR.
	BE AWARE THAT LATEST VERSIONS OF JAVA HAS DEPRECATED THE USAGE OF SUSPEND(), RESUME() AND STOP() METHODS AND SO YOU NEED TO USE AVAILABLE ALTERNATIVES.
	THREAD LIFE CYCLE AND THREAD SCHEDULING
	THE START METHOD CREATES THE SYSTEM RESOURCES, NECESSARY TO RUN THE THREAD, SCHEDULES THE THREAD TO RUN, AND CALLS THE THREAD’S RUN METHOD.
	A THREAD BECOMES “NOT RUNNABLE” WHEN ONE OF THESE EVENTS OCCURS:
	IF SLEEP METHOD IS INVOKED.
	THE THREAD CALLS THE WAIT METHOD.
	THE THREAD IS BLOCKING ON I/O.
	A THREAD DIES NATURALLY WHEN THE RUN METHOD EXITS.
	
	THREAD SCHEDULING
	EXECUTION OF MULTIPLE THREADS ON A SINGLE CPU, IN SOME ORDER, IS CALLED SCHEDULING.
	IN GENERAL, THE RUNNABLE THREAD WITH THE HIGHEST PRIORITY IS ACTIVE (RUNNING)
	JAVA IS PRIORITY-PREEMPTIVE
	IF A HIGH-PRIORITY THREAD WAKES UP, AND A LOW-PRIORITY THREAD IS RUNNING
	THEN THE HIGH-PRIORITY THREAD GETS TO RUN IMMEDIATELY
	ALLOWS ON-DEMAND PROCESSING
	EFFICIENT USE OF CPU
	TYPES OF SCHEDULING
	WAITING AND NOTIFYING
	WAITING [WAIT()] AND NOTIFYING [NOTIFY(), NOTIFYALL()] PROVIDES MEANS OF COMMUNICATION BETWEEN THREADS THAT SYNCHRONIZE ON THE SAME OBJECT.
	WAIT(): WHEN WAIT() METHOD IS INVOKED ON AN OBJECT, THE THREAD EXECUTING THAT CODE GIVES UP ITS LOCK ON THE OBJECT IMMEDIATELY AND MOVES THE THREAD TO THE WAIT STATE.
	NOTIFY(): THIS WAKES UP THREADS THAT CALLED WAIT() ON THE SAME OBJECT AND MOVES THE THREAD TO READY STATE.
	NOTIFYALL(): THIS WAKES UP ALL THE THREADS THAT CALLED WAIT() ON THE SAME OBJECT.
	RUNNING AND YIELDING
	YIELD() IS USED TO GIVE THE OTHER THREADS OF THE SAME PRIORITY A CHANCE TO EXECUTE I.E. CAUSES CURRENT RUNNING THREAD TO MOVE TO RUNNABLE STATE.
	SLEEPING AND WAKING UP
	NSLEEP() IS USED TO PAUSE A THREAD FOR A SPECIFIED PERIOD OF TIME I.E. MOVES THE CURRENT RUNNING THREAD TO SLEEP STATE FOR A SPECIFIED AMOUNT OF TIME, BEFORE MOVING IT TO RUNNABLE STATE. THREAD.SLEEP(NO. OF MILLISECONDS);
	
	THREAD PRIORITY
	WHEN A JAVA THREAD IS CREATED, IT INHERITS ITS PRIORITY FROM THE THREAD THAT CREATED IT.
	YOU CAN MODIFY A THREAD’S PRIORITY AT ANY TIME AFTER ITS CREATION USING THE SETPRIORITY() METHOD.
	THREAD PRIORITIES ARE INTEGERS RANGING BETWEEN MIN_PRIORITY (1) AND MAX_PRIORITY (10) . THE HIGHER THE INTEGER, THE HIGHER THE PRIORITY.NORMALLY THE THREAD PRIORITY WILL BE 5.
	BLOCKING THREADS
	WHEN READING FROM A STREAM, IF INPUT IS NOT AVAILABLE, THE THREAD WILL BLOCK
	THREAD IS SUSPENDED (“BLOCKED”) UNTIL I/O IS AVAILABLE
	ALLOWS OTHER THREADS TO AUTOMATICALLY ACTIVATE
	WHEN I/O AVAILABLE, THREAD WAKES BACK UP AGAIN
	BECOMES “RUNNABLE” I.E. GETS INTO READY STATE
	GROUPING THREADS
	THREAD GROUPS PROVIDE A MECHANISM FOR COLLECTING MULTIPLE THREADS INTO A SINGLE OBJECT AND MANIPULATING THOSE THREADS ALL AT ONCE, RATHER THAN INDIVIDUALLY.
	TO PUT A NEW THREAD IN A THREAD GROUP THE GROUP MUST
	BE EXPLICITLY SPECIFIED WHEN THE THREAD IS CREATED
	– PUBLIC THREAD(THREADGROUP GROUP, RUNNABLE RUNNABLE)
	– PUBLIC THREAD(THREADGROUP GROUP, STRING NAME)
	– PUBLIC THREAD(THREADGROUP GROUP, RUNNABLE RUNNABLE, STRING NAME)
	A THREAD CAN NOT BE MOVED TO A NEW GROUP AFTER THE THREAD HAS BEEN CREATED.
	WHEN A JAVA APPLICATION FIRST STARTS UP, THE JAVA RUNTIME SYSTEM CREATES A THREADGROUP NAMED MAIN.
	JAVA THREAD GROUPS ARE IMPLEMENTED BY THE JAVA.LANG.THREADGROUP CLASS.
	
	DAEMON THREAD
	DAEMON THREAD IS A LOW PRIORITY THREAD (IN CONTEXT OF JVM) THAT RUNS IN BACKGROUND TO PERFORM TASKS SUCH AS GARBAGE COLLECTION (GC) ETC., THEY DO NOT PREVENT THE JVM FROM EXITING (EVEN IF THE DAEMON THREAD ITSELF IS RUNNING) WHEN ALL THE USER THREADS (NON-DAEMON THREADS) FINISH THEIR EXECUTION. JVM TERMINATES ITSELF WHEN ALL USER THREADS (NON-DAEMON THREADS) FINISH THEIR EXECUTION, JVM DOES NOT CARE WHETHER DAEMON THREAD IS RUNNING OR NOT, IF JVM FINDS RUNNING DAEMON THREAD (UPON COMPLETION OF USER THREADS), IT TERMINATES THE THREAD AND AFTER THAT SHUTDOWN ITSELF.
	# A NEWLY CREATED THREAD INHERITS THE DAEMON STATUS OF ITS PARENT. THAT’S THE REASON ALL THREADS CREATED INSIDE MAIN METHOD (CHILD THREADS OF MAIN THREAD) ARE NON-DAEMON BY DEFAULT, BECAUSE MAIN THREAD IS NON-DAEMON.
	# METHODS OF THREAD CLASS THAT ARE RELATED TO DAEMON THREADS AS FOLLOWING,
	PUBLIC VOID SETDAEMON(BOOLEAN STATUS): THIS METHOD IS USED FOR MAKING A USER THREAD TO DAEMON THREAD OR VICE VERSA. FOR EXAMPLE IF I HAVE A USER THREAD T THEN T.SETDAEMON(TRUE) WOULD MAKE IT DAEMON THREAD. ON THE OTHER HAND IF I HAVE A DAEMON THREAD TD THEN BY CALLING TD.SETDAEMON(FALSE) WOULD MAKE IT NORMAL THREAD(USER THREAD/NON-DAEMON THREAD).
	PUBLIC BOOLEAN ISDAEMON(): THIS METHOD IS USED FOR CHECKING THE STATUS OF A THREAD. IT RETURNS TRUE IF THE THREAD IS DAEMON ELSE IT RETURNS FALSE.
	SETDAEMON(): METHOD CAN ONLY BE CALLED BEFORE STARTING THE THREAD. THIS METHOD WOULD THROW ILLEGALTHREADSTATEEXCEPTION IF YOU CALL THIS METHOD AFTER THREAD.START() METHOD. (REFER THE EXAMPLE)
	THREAD JOIN() METHOD
	THE JOIN() METHOD IS USED TO HOLD THE EXECUTION OF CURRENTLY RUNNING THREAD UNTIL THE SPECIFIED THREAD IS DEAD(FINISHED EXECUTION).
	
	DIFFERENCE BETWEEN CALLING RUN AND START METHOD
	WE CAN CALL RUN() METHOD IF WE WANT BUT THEN IT WOULD BEHAVE JUST LIKE A NORMAL METHOD AND WE WOULD NOT BE ABLE TO TAKE THE ADVANTAGE OF MULTITHREADING. WHEN THE RUN METHOD GETS CALLED THOUGH START() METHOD THEN A NEW SEPARATE THREAD IS BEING ALLOCATED TO THE EXECUTION OF RUN METHOD, SO IF MORE THAN ONE THREAD CALLS START() METHOD THAT MEANS THEIR RUN METHOD IS BEING EXECUTED BY SEPARATE THREADS (THESE THREADS RUN SIMULTANEOUSLY).
	ON THE OTHER HAND IF THE RUN() METHOD OF THESE THREADS ARE BEING CALLED DIRECTLY THEN THE EXECUTION OF ALL OF THEM IS BEING HANDLED BY THE SAME CURRENT THREAD AND NO MULTITHREADING WILL TAKE PLACE, HENCE THE OUTPUT WOULD REFLECT THE SEQUENTIAL EXECUTION OF THREADS IN THE SPECIFIED ORDER.
	
	
	
	————————————————————————————————————————————————————————————————————————————————————————
	
	
	
	
	
	Concurrency Classes 
	———————————————————
	
	BlockingQueue
	
	ArrayBlockingQueue
	
	DelayQueue
	
	LinkedBlockingQueue
	
	PriorityBlockingQueue
	
	SynchronousQueue
	
	BlockingDeque
	
	LinkedBlockingDeque
	
	ConcurrentMap
	
	ConcurrentNavigableMap
	
	CountDownLatch
	
	CyclicBarrier
	
	Exchanger
	
	Semaphore
	
	ExecutorService
	
	ThreadPoolExecutor
	
	ScheduledExecutorService
	
	Java Fork and Join using ForkJoinPool
	
	Lock
	
	ReadWriteLock
	
	AtomicBoolean
	
	AtomicInteger
	
	AtomicLong
	
	AtomicReference
	
	AtomicStampedReference
	
	AtomicIntegerArray
	
	AtomicLongArray
	
	AtomicReferenceArray
	————————————————————————————————————————————————————————————————————————————————————————
	
	
	
	
	
	
	
	
	
	
	OBJECT LEVEL LOCKING VS. CLASS LEVEL LOCKING IN JAVA
	————————————————————————————————————————————————————
	
	Synchronization refers to multi-threading. A synchronized block of code can only be
	executed by one thread at a time.
	
	Java supports multiple threads to be executed. This may cause two or more threads to
	access the same fields or objects. Synchronization is a process which keeps all concurrent
	threads in execution to be in sync. Synchronization avoids memory consistence errors caused due to inconsistent view of shared memory. When a method is declared as synchronized; the
	thread holds the monitor for that method’s object If another thread is executing the
	synchronized method, your thread is blocked until that thread releases the monitor.
	
	Synchronization in java is achieved using synchronized keyword. You can use synchronized
	keyword in your class on defined methods or blocks. Keyword can not be used with variables
	or attributes in class definition.
	
	
	
	
	OBJECT LEVEL LOCKING
	--------------------
	
	Object level locking is mechanism when you want to synchronize a non-static method or
	non-static code block such that only one thread will be able to execute the code block
	on given instance of the class. This should always be done to make instance level data
	thread safe. This can be done as below :
	
	
	public class DemoClass{
	
	   public synchronized void demoMethod(){}
	}
	
	
	
	OR,
	
	
	public class DemoClass
	{
	   public void demoMethod()
	   {
	       synchronized (this)
	       {
	
	           //other thread safe code
	       }
	   }
	}
	
	
	
	OR,
	
	
	
	public class DemoClass
	{
	
	   private final Object lock = new Object();
	
	   public void demoMethod()
	   {
	       synchronized (lock)
	       {
	           //other thread safe code
	       }
	   }
	}
	
	
	
	
	CLASS LEVEL LOCKING
	-------------------
	
	Class level locking prevents multiple threads to enter in synchronized block in any of
	all available instances on runtime. This means if in runtime there are 100 instances of
	DemoClass, then only one thread will be able to execute demoMethod() in any one of instance
	at a time, and all other instances will be locked for other threads. This should always be
	done to make static data thread safe.
	
	
	public class DemoClass
	{
	   public synchronized static void demoMethod(){}
	}
	
	
	OR,
	
	
	public class DemoClass
	{
	
	   public void demoMethod()
	   {
	
	       synchronized (DemoClass.class)
	       {
	
	           //other thread safe code
	       }
	   }
	}
	
	
	
	OR,
	
	
	
	public class DemoClass{

	   private final static Object lock = new Object();
	
	   public void demoMethod(){

	       synchronized (lock){

	           //other thread safe code
	       }
	   }
	}
	
	


	NOTES
	—————
	
	a. Synchronization in Java guarantees that no two threads can execute a synchronized
	  method which requires same lock simultaneously or concurrently.
	
	b. Synchronized keyword can be used only with methods and code blocks. These methods
	  or blocks can be static or non-static both.
	
	c. When ever a thread enters into java synchronized method or block it acquires a lock
	  and whenever it leaves java synchronized method or block it releases the lock. Lock
	  is released even if thread leaves synchronized method after completion or due to any
	  Error or Exception.
	
	d. Java synchronized keyword is re-entrant in nature it means if a java synchronized method
	  calls another synchronized method which requires same lock then current thread which is
	  holding lock can enter into that method without acquiring lock.
	
	e. Java Synchronization will throw NullPointerException if object used in java synchronized
	  block is null. For example, in above code sample if lock is initialized as null, the
	  synchronized (lock) will throw NullPointerException.
	
	f. Synchronized methods in Java put a performance cost on your application. So use
	  synchronization when it is absolutely required. Also, consider using synchronized
	  code blocks for synchronizing only critical section of your code.
	
	g. It’s possible that both static synchronized and non static synchronized method can
	  run simultaneously or concurrently because they lock on different object.
	
	h. According to the Java language specification you can not use java synchronized keyword
	  with constructor it’s illegal and result in compilation error.
	
	i. Do not synchronize on non final field on synchronized block in Java. because reference of
	  non final field may change any time and then different thread might synchronizing on
	  different objects i.e. no synchronization at all. Best is to use String class, which is
	  already immutable and declared final.
	
	—————————————————————————————————————————————
	
	
	
	
	
	
	
	





	


	Java Concurrency - Jakob Jenkov
	———————————————————————————————
	

	Even if an object is immutable and thereby thread safe, the reference to this object may not be thread safe. 


	Concurrency Models
	——————————————————

	Concurrent systems can be implemented using different concurrency models. A concurrency model specifies how threads in the the system collaborate to complete the jobs they are are given. Different concurrency models split the jobs in different ways, and the threads may communicate and collaborate in different ways.

	The concurrency models described in this text are similar to different architectures used in distributed systems. In a concurrent system different threads communicate with each other. In a distributed system different processes communicate with each other (possibly on different computers). Threads and processes are quite similar to each other in nature. That is why the different concurrency models often look similar to different distributed system architectures.

	Of course distributed systems have the extra challenge that the network may fail, or a remote computer or process is down etc. But a concurrent system running on a big server may experience similar problems if a CPU fails, a network card fails, a disk fails etc. The probability of failure may be lower, but it can theoretically still happen.


	Categories of the concurrecy models
	———————————————————————————————————

		A. Parallel Workers

		B. Assembly Line (Reactive Systems/ Event-Driven Systems/ Shared Nothing)
			
			i.  Actors 
			ii. Channels

		C. Functional Parallelism






	A. Parallel Workers
	———————————————————

	In the parallel worker concurrency model a delegator distributes the incoming jobs to different workers. Each worker completes the full job. The workers work in parallel, running in different threads, and possibly on different CPUs.

	If the parallel worker model was implemented in a car factory, each car would be produced by one worker. The worker would get the specification of the car to build, and would build everything from start to end.


		i.   Shared State Can Get Complex
		ii.  Stateless Workers
		iii. Job Ordering is Nondeterministic



	B. Assembly Line (Reactive Systems/ Event-Driven Systems/ Shared Nothing)
	—————————————————————————————————————————————————————————————————————————

	The workers are organized like workers at an assembly line in a factory. Each worker only performs a part of the full job. When that part is finished the worker forwards the job to the next worker. Each worker is running in its own thread, and shares no state with other workers.


	Systems using the assembly line concurrency model are usually designed to use non-blocking IO. Non-blocking IO means that when a worker starts an IO operation (e.g. reading a file or data from a network connection) the worker does not wait for the IO call to finish. IO operations are slow, so waiting for IO operations to complete is a waste of CPU time. The CPU could be doing something else in the meanwhile. When the IO operation finishes, the result of the IO operation ( e.g. data read or status of data written) is passed on to another worker.

	With non-blocking IO, the IO operations determine the boundary between workers. A worker does as much as it can until it has to start an IO operation. Then it gives up control over the job. When the IO operation finishes, the next worker in the assembly line continues working on the job, until that too has to start an IO operation etc.

	In reality, the jobs may not flow along a single assembly line. Since most systems can perform more than one job, jobs flows from worker to worker depending on the job that needs to be done. In reality there could be multiple different virtual assembly lines going on at the same time. 

	Jobs may even be forwarded to more than one worker for concurrent processing. For instance, a job may be forwarded to both a job executor and a job logger.


	Systems using an assembly line concurrency model are also sometimes called reactive systems, or event driven systems. The system's workers react to events occurring in the system, either received from the outside world or emitted by other workers. Examples of events could be an incoming HTTP request, or that a certain file finished loading into memory etc.


	Actors vs. Channels
	———————————————————

	In the actor model each worker is called an actor. Actors can send messages directly to each other. Messages are sent and processed asynchronously. Actors can be used to implement one or more job processing assembly lines.


	In the channel model, workers do not communicate directly with each other. Instead they publish their messages (events) on different channels. Other workers can then listen for messages on these channels without the sender knowing who is listening.


		Assembly Line Advantages

			i. No Shared State
			i. Stateful Workers
			i. Better Hardware Conformity
			i. Job Ordering is Possible




	Mechanical sympathy/ Hardware Conformity
	————————————————————————————————————————

	Singlethreaded code has the advantage that it often conforms better with how the underlying hardware works. First of all, you can usually create more optimized data structures and algorithms when you can assume the code is executed in single threaded mode.

	Second, singlethreaded stateful workers can cache data in memory as mentioned above. When data is cached in memory there is also a higher probability that this data is also cached in the CPU cache of the CPU executing the thread. This makes accessing cached data even faster.

	I refer to it as hardware conformity when code is written in a way that naturally benefits from how the underlying hardware works. Some developers call this mechanical sympathy. I prefer the term hardware conformity because computers have very few mechanical parts, and the word "sympathy" in this context is used as a metaphor for "matching better" which I believe the word "conform" conveys reasonably well. Anyways, this is nitpicking. Use whatever term you prefer.




	C. Functional Parallelism
	—————————————————————————

	The basic idea of functional parallelism is that you implement your program using function calls. Functions can be seen as "agents" or "actors" that send messages to each other, just like in the assembly line concurrency model (AKA reactive or event driven systems). When one function calls another, that is similar to sending a message.

	All parameters passed to the function are copied, so no entity outside the receiving function can manipulate the data. This copying is essential to avoiding race conditions on the shared data. This makes the function execution similar to an atomic operation. Each function call can be executed independently of any other function call.


	When each function call can be executed independently, each function call can be executed on separate CPUs. That means, that an algorithm implemented functionally can be executed in parallel, on multiple CPUs.

	With Java 7 we got the java.util.concurrent package contains the ForkAndJoinPool which can help you implement something similar to functional parallelism. With Java 8 we got parallel streams which can help you parallelize the iteration of large collections. Keep in mind that there are developers who are critical of the ForkAndJoinPool (you can find a link to criticism in my ForkAndJoinPool tutorial).


	The hard part about functional parallelism is knowing which function calls to parallelize. Coordinating function calls across CPUs comes with an overhead. The unit of work completed by a function needs to be of a certain size to be worth this overhead. If the function calls are very small, attempting to parallelize them may actually be slower than a singlethreaded, single CPU execution.

	It can be implemented an algorithm using an reactive, event driven model and achieve a breakdown of the work which is similar to that achieved by functional parallelism. With an even driven model you just get more control of exactly what and how much to parallelize. 

	Additionally, splitting a task over multiple CPUs with the overhead the coordination of that incurs, only makes sense if that task is currently the only task being executed by the the program. However, if the system is concurrently executing multiple other tasks (like e.g. web servers, database servers and many other systems do), there is no point in trying to parallelize a single task. The other CPUs in the computer are anyways going to be busy working on other tasks, so there is not reason to try to disturb them with a slower, functionally parallel task. You are most likely better off with an assembly line (reactive) concurrency model, because it has less overhead (executes sequentially in singlethreaded mode) and conforms better with how the underlying hardware works.




	Full volatile Visibility Guarantee
	——————————————————————————————————

	Actually, the visibility guarantee of Java volatile goes beyond the volatile variable itself. The visibility guarantee is as follows:

		i.  If Thread A writes to a volatile variable and Thread B subsequently reads the same volatile variable, then all variables visible to Thread A before writing the volatile variable, will also be visible to Thread B after it has read the volatile variable.

		ii. If Thread A reads a volatile variable, then all all variables visible to Thread A when reading the volatile variable will also be re-read from main memory.

	The Java VM and the CPU are allowed to reorder instructions in the program for performance reasons, as long as the semantic meaning of the instructions remain the same. 


	The Java volatile Happens-Before Guarantee
	——————————————————————————————————————————

	To address the instruction reordering challenge, the Java volatile keyword gives a "happens-before" guarantee, in addition to the visibility guarantee. The happens-before guarantee guarantees that:

		Reads from and writes to other variables cannot be reordered to occur after a write to a volatile variable, if the reads / writes originally occurred before the write to the volatile variable. 
		The reads / writes before a write to a volatile variable are guaranteed to "happen before" the write to the volatile variable. Notice that it is still possible for e.g. reads / writes of other variables located after a write to a volatile to be reordered to occur before that write to the volatile. Just not the other way around. From after to before is allowed, but from before to after is not allowed.


		Reads from and writes to other variables cannot be reordered to occur before a read of a volatile variable, if the reads / writes originally occurred after the read of the volatile variable. Notice that it is possible for reads of other variables that occur before the read of a volatile variable can be reordered to occur after the read of the volatile. Just not the other way around. From before to after is allowed, but from after to before is not allowed.



	Java ThreadLocal
	————————————————

	The ThreadLocal class in Java enables you to create variables that can only be read and written by the same thread. Thus, even if two threads are executing the same code, and the code has a reference to a ThreadLocal variable, then the two threads cannot see each other's ThreadLocal variables.






	
	CONCURRENCY MODELS AND DISTRIBUTED SYSTEM SIMILARITIES
	
	PARALLEL WORKERS
	
	STATELESS WORKERS
	
	ASSEMBLY LINE
	
	REACTIVE, EVENT DRIVEN SYSTEMS
	
	ACTORS VS. CHANNELS
	
	STATEFUL WORKERS
	
	FUNCTIONAL PARALLELISM
	———————————————————————————————————————————————————————————
	
	
	SAME-THREADING
	
	CONCURRENCY VS. PARALLELISM
	
	CREATING AND STARTING JAVA THREADS
	
	RACE CONDITIONS AND CRITICAL SECTIONS
	
	THREAD SAFETY AND SHARED RESOURCES
	
	THREAD SAFETY AND IMMUTABILITY
	
	JAVA MEMORY MODEL
	
	JAVA SYNCHRONIZED BLOCKS
	
	JAVA VOLATILE KEYWORD
	
	JAVA THREADLOCAL
	
	THREAD SIGNALING
	
	DEADLOCK
	
	DEADLOCK PREVENTION
	
	STARVATION AND FAIRNESS
	
	NESTED MONITOR LOCKOUT
	
	SLIPPED CONDITIONS
	
	LOCKS IN JAVA
	
	READ / WRITE LOCKS IN JAVA
	
	REENTRANCE LOCKOUT
	
	SEMAPHORES
	
	BLOCKING QUEUES
	
	THREAD POOLS
	
	COMPARE AND SWAP
	
	ANATOMY OF A SYNCHRONIZER
	
	NON-BLOCKING ALGORITHMS
	
	AMDAHL'S LAW
	
	JAVA CONCURRENCY REFERENCES
	————————————————————————————————————————————————————————————————————————————————————————
	






	Multithreaded Servers/ Jakob Jenkov 
	————————————————————————————————————
	
	Singlethreaded Server In Java
	
	Multithreaded Server In Java
	
	Thread Pooled Server

	
	
	

	

	Java Performance/ Jakob Jenkov 
	———————————————————————————————
	
	Modern Hardware
	
	Memory Management For Performance
	
	Jmh - Java Microbenchmark Harness
	
	Java Ring Buffer
	
	Java Resizable Array
	
	Java For VS Switch Performance
	
	Java Arraylist Vs. Openarraylist Performance
	
	Java High Performance Read Patterns
	
	Micro Batching 








	Java Networking/ Jakob Jenkov 
	———————————————————————————————
	
	Java Networking: Socket
	
	Java Networking: Serversocket
	
	Java Networking: Udp Datagramsocket
	
	Java Networking: Url + Urlconnection
	
	Java Networking: Jarurlconnection
	
	Java Networking: Inetaddress
	
	Java Networking: Protocol Design

	
	
		


	Java NIO/ Jakob Jenkov 
	———————————————————————

	Java NIO Overview
	
	Java NIO Channel
	
	Java NIO Buffer
	
	Java NIO Scatter / Gather
	
	Java NIO Channel To Channel Transfers
	
	Java NIO Selector
	
	Java NIO FileChannel
	
	Java NIO SocketChannel
	
	Java NIO ServerSocketChannel
	
	Java NIO: Non-blocking Server
	
	Java NIO DatagramChannel
	
	Java NIO Pipe
	
	Java NIO Vs. Io
	
	Java NIO Path
	
	Java NIO Files
	
	Java NIO AsynchronousFileChannel



	Java IO Tutorial/ Jakob Jenkov 
	——————————————————————————————

	Java IO Overview

	Java IO: Files

	Java IO: Pipes

	Java IO: Networking

	Java IO: Byte & Char Arrays

	Java IO: System.in, System.out, and System.error

	Java IO: Streams

	Java IO: Input Parsing

	Java IO: Readers and Writers

	Java IO: Concurrent IO

	Java IO: Exception Handling

	Java IO: InputStream

	Java IO: OutputStream

	Java IO: FileInputStream

	Java IO: FileOutputStream

	Java IO: RandomAccessFile

	Java IO: File

	Java IO: PipedInputStream

	Java IO: PipedOutputStream

	Java IO: ByteArrayInputStream

	Java IO: ByteArrayOutputStream

	Java IO: FilterInputStream

	Java IO: FilterOutputStream

	Java IO: BufferedInputStream

	Java IO: BufferedOutputStream

	Java IO: PushbackInputStream

	Java IO: SequenceInputStream

	Java IO: DataInputStream

	Java IO: DataOutputStream

	Java IO: PrintStream

	Java IO: ObjectInputStream

	Java IO: ObjectOutputStream

	Java IO: Serializable

	Java IO: Reader

	Java IO: Writer

	Java IO: InputStreamReader

	Java IO: OutputStreamWriter

	Java IO: FileReader

	Java IO: FileWriter

	Java IO: PipedReader

	Java IO: PipedWriter

	Java IO: CharArrayReader

	Java IO: CharArrayWriter

	Java IO: BufferedReader

	Java IO: BufferedWriter

	Java IO: FilterReader

	Java IO: FilterWriter

	Java IO: PushbackReader

	Java IO: LineNumberReader

	Java IO: StreamTokenizer

	Java IO: PrintWriter

	Java IO: StringReader

	Java IO: StringWriter




	
	Distributed Systems Architecture - Jakob Jenkov 
	———————————————————————————————————————————————

	Software Architecture   

			Single Process Architecture
			
			Computer Architecture
			
			Client-Server Architecture
			
			N Tier Architecture
			
			RIA Architecture
			
			Service Oriented Architecture (SOA)
			
			Event-driven Architecture
			
			Peer-to-peer (P2P) Architecture
			
			Scalable Architectures
			
			Load Balancing
			
			Caching Techniques



	ION   
	
	IAP   
	
	IAP Tools for Java  
	
	Grid Ops for Java  
	
	SOA - Service Oriented Architecture   
	
	Web Services   
	
	SOAP   
	
	WSDL 2.0   
	
	RSync   
	
	Peer-to-Peer (P2P) Networks










	
	Java Concurrency/ ABHI On Java
	——————————————————————————————
	
	Java 5 Concurrency 
	
	Java 5 Concurrency: Selecting Locks 
	
	Java 5 Concurrency: Selecting Synchronizers 
	
	Java 5 Concurrency: Synchronizers 
	
	Java 5 Concurrency: Conditions 
	
	Java 5 Concurrency: Reader-writer Locks 
	
	Java 5 Concurrency: Locks 
	
	Java 5 Concurrency: Callable And Future 
	
	Java 5 Executors: Threadpool 
	
	Java 5: New Features In Concurrency 
	
	Java: Handling Interrupts 

	





	
	
	
	
	————————————————————————————————————————————————————————————————————————————————————————
	JAVA 8 CONCURRENCY TUTORIAL: ATOMIC VARIABLES AND CONCURRENTMAP - BENJAMIN WINTERBERG/ HANOVER, GERMANY
	
	JAVA 8 CONCURRENCY TUTORIAL: SYNCHRONIZATION AND LOCKS - BENJAMIN WINTERBERG/ HANOVER, GERMANY
	
	JAVA 8 CONCURRENCY TUTORIAL: THREADS AND EXECUTORS - BENJAMIN WINTERBERG/ HANOVER, GERMANY
	
	
	JAVA 8 STREAM TUTORIAL - BENJAMIN WINTERBERG/ HANOVER, GERMANY
	
	JAVA 8 TUTORIAL - BENJAMIN WINTERBERG/ HANOVER, GERMANY
	————————————————————————————————————————————————————————————————————————————————————————
	
	
	
	GCP: COMPLETE GOOGLE DATA ENGINEER AND CLOUD ARCHITECT GUIDE - UDEMY/ LOONY CORN

	

	Apache Kafka
	————————————

	Apache Kafka Series - Learn Apache Kafka For Beginners - Stephane Maarek/ Udemy 
	
	Apache Kafka Series - Kafka Connect Hands-on Learning - Stephane Maarek/ Udemy 
	
	Apache Kafka Series - Kafka Streams For Data Processing - Stephane Maarek/ Udemy 
	
	Apache Kafka Series - Kafka Security (Ssl Sasl Kerberos Acl) - Udemy 
	
	Apache Kafka Series - Confluent Schema Registry & Rest Proxy - Udemy 
	
	Apache Kafka Series - Kafka Cluster Setup & Administration - Stephane Maarek/ Udemy 
	
	Apache Kafka Series - Kafka Monitoring And Operations - Udemy

	
	






	Blockchain And Cryptography
	———————————————————————————

	Learn Blockchain Technology & Cryptocurrency In Java - Udemy/ Holczer Balazs

	Cryptography In Java - Udemy/ Holczer Balazs

	Bitcoin And Cryptocurrency Technologies - Coursera/ Princeton University

	Bitcoin And Cryptocurrency - Stanford University 








	
	LIGHTBEND/ COGNITIVECLASS 
	—————————————————————————

	DEVELOPING DISTRIBUTED APPLICATIONS USING ZOOKEEPER - COGNITIVECLASS.AI

	REACTIVE ARCHITECTURE: INTRODUCTION TO REACTIVE SYSTEMS - COGNITIVECLASS.AI/ LIGHTBEND 

	REACTIVE ARCHITECTURE: DOMAIN DRIVEN DESIGN - COGNITIVECLASS.AI/ LIGHTBEND 

	REACTIVE ARCHITECTURE: REACTIVE MICROSERVICES - COGNITIVECLASS.AI/ LIGHTBEND 
	—————————————————————————————————————————————————————————————————————————






    PLURALSIGHT
    ———————————

	REACTIVE PROGRAMMING IN JAVA 8 WITH RXJAVA - RUSSELL ELLEDGE/ PLURALSIGHT

	A Quick Introduction to Reactive Java - DZONE

	What Are Reactive Streams in Java? - DZONE
	—————————————————————————————————————————————————————————————————————————



	MEMORY MANAGEMENT
	—————————————————
	
	JAVA MEMORY MANAGEMENT - UDEMY 
	
	A COMPREHENSIVE INTRODUCTION TO JAVA VIRTUAL MACHINE (JVM) - UDEMY 

	JAVA MULTITHREADING, CONCURRENCY & PERFORMANCE OPTIMIZATION - UDEMY 
	
	MEMORY MANAGEMENT AND GARBAGE COLLECTION IN JAVA - LYNDA 
	
	MANAGING THREADS IN JAVA - LYNDA
	—————————————————————————————————————————————————————————————————————————————————————
	
	
	
	—————————————————————————————————————————————————————————————————————————————————————
	MULTITHREADING AND PARALLEL COMPUTATION IN JAVA -  UDEMY/ HOLCZER BALAZS
	
	BYTE SIZE CHUNKS : JAVA MULTITHREADING - UDEMY 
	
	ADVANCED ALGORITHMS IN JAVA -  HOLCZER BALAZS/ UDEMY 
	
	JAVA NETWORK PROGRAMMING - TCP/IP SOCKET PROGRAMMING - UDEMY 
	
	PROFESSIONAL WEB SCRAPING WITH JAVA - UDEMY 
	
	JAVA SOCKET PROGRAMMING: BUILD A CHAT APPLICATION - UDEMY 
	
	COMPLEXITY THEORY BASICS - UDEMY 
	
	INTRO COLLECTIONS, GENERICS AND REFLECTIONS) IN JAVA @ HOLCZER BALAZS
	
	INTRODUCTION TO NUMERICAL METHODS IN JAVA @ HOLCZER BALAZS <HTTPS://WWW.UDEMY.COM/NUMERICAL-METHODS-IN-JAVA/?COUPONCODE=NUMMETHOD_10> 
	—————————————————————————————————————————————————————————————————————————————————————
	
	
	
	
	——————————————————————————————————————————————————————————————————————————————
	
	——————————————
	HADOOP COURSES 
	——————————————
	
	JAVA PARALLEL COMPUTATION ON HADOOP - UDEMY 
	
	BUILD BIG DATA PIPELINES WITH HADOOP, FLUME, PIG, MONGODB - UDEMY

	Learn Big Data: The Hadoop Ecosystem Masterclass - Edward Viaene/ UDEMY

	THE ULTIMATE HANDS-ON HADOOP - TAME YOUR BIG DATA
	——————————————————————————————————————————————————————————————————————————————
	
	
	EFFICIENT PYTHON FOR HIGH PERFORMANCE PARALLEL COMPUTING - YOUTUBE- ENTHOUGHT/ MIKE MCKERNS
	
	



	
	TIM BERGLUND/ CONFLUENT
	———————————————————————
	
	FOUR DISTRIBUTED SYSTEMS ARCHITECTURAL PATTERNS - TIM BERGLUND/ CONFLUENT

	LESSONS LEARNED FORM KAFKA IN PRODUCTION - TIM BERGLUND/ CONFLUENT
	


	
	AKKA
	——————
	
	INTRODUCTION TO AKKA ACTORS WITH JAVA 8 - YOUTUBE 

	Introduction to the Actor Model for Concurrent Computation - Youtube 
	



	
	FUNCTIONAL PROGRAMMING
	——————————————————————

	FUNCTIONAL PROGRAMMING WITH JAVA 8 - YOUTUBE/ VENKAT SUBRAMANIAM


	Functional Programming in Scala Specialization - EPFL
	—————————————————————————————————————————————————————

		Functional Programming Principles in Scala

		Functional Program Design in Scala

		Parallel programming

		Big Data Analysis with Scala and Spark

		Functional Programming in Scala Capstone
		



	RUSSIAN CONFERENCE ON PARALLEL COMPUTING (JUG.RU)
	—————————————————————————————————————————————————
	
	
	

	LOCKING, FROM TRADITIONAL TO MODERN I, II, III, IV - NIR SHAVIT / YOUTUBE
	
	LOCK-FREE CONCURRENT DATA STRUCTURES I, II, III, IV - DANNY HENDLER/ YOUTUBE
	
	WAIT-FREE COMPUTING "FOR DUMMIES" I, II, III, IV - RACHID GUERRAOUI/ YOUTUBE
	
	RECOMMENDERS AND DISTRIBUTED MACHINE LEARNING I, II - ANNE-MARIE KERMARREC/ YOUTUBE
	
	TRANSACTIONAL MEMORY AND BEYOND I, II, III, IV - MAURICE HERLIHY/ YOUTUBE 
	
	IMPLEMENTATION TECHNIQUES FOR LIBRARIES OF TRANSACTIONAL CONCURRENT DATA TYPES I, II - LIUBA SHRIRA/ YOUTUBE
	
	LOCK-FREE ALGORITHMS FOR KOTLIN COROUTINES I, II - ROMAN ELIZAROV/ YOUTUBE
	
	RELAXED CONCURRENT DATA STRUCTURES I, II, III, IV - DAN ALISTARH /YOUTUBE
	
	UNIVERSAL DISTRIBUTED CONSTRUCTIONS: A GUIDED TOUR I, II  - MICHEL RAYNAL/ YOUTUBE
	
	MEMORY MANAGEMENT FOR CONCURRENT DATA STRUCTURES I, II, III, IV - EREZ PETRANK/ YOUTUBE
	
	
	
	
	
	
	

	ADVANCED TOPICS IN PROGRAMMING LANGUAGES: A LOCK-FREE HASH TABLE - GOOGLE TECH ARCHIVE/ YOUTUBE
	DISTRIBUTED OPTIMISTIC ALGORITHM
	SYNCHRONIZATION, ATOMIC OPERATIONS, LOCKS-  CS 162-UC BERKELEY/ YOUTUBE
	
	NON-BLOCKING MICHAEL-SCOTT QUEUE ALGORITHM - ALEXEY FYODOROV/ YOUTUBE
	"DISTRIBUTED, EVENTUALLY CONSISTENT COMPUTATIONS" BY CHRISTOPHER MEIKLEJOHN/ YOUTUBE
	HOW THREADS HELP EACH OTHER - ALEXEY FYODOROV/ YOUTUBE
	
	
	
	GARBAGE COLLECTION IS GOOD!  - INFOQ
	
	G1 GARBAGE COLLECTOR DETAILS AND TUNING - SIMONE BORDET/ YOUTUBE
	
	EVERYTHING I EVER LEARNED ABOUT JVM PERFORMANCE TUNING AT TWITTER - ATTILA SZEGEDI/YOUTUBE
	
	GARBAGE FIRST GARBAGE COLLECTOR  -  MONICA BECKWITH/YOUTUBE
	
	"GC TUNING CONFESSIONS OF A PERFORMANCE ENGINEER"  -  MONICA BECKWITH/YOUTUBE
	
	JVM ( JAVA VIRTUAL MACHINE) ARCHITECTURE - RANJITH RAMACHANDRAN/ YOUTUBE
	GARBAGE COLLECTION IN JAVA, WITH ANIMATION AND DISCUSSION OF G1 GC - RANJITH RAMACHANDRAN/ YOUTUBE
	
	
	LRU CACHE 
	—————————
	THE MAGIC OF LRU CACHE (100 DAYS OF GOOGLE DEV) - GOOGLE DEVELOPERS/ YOUTUBE
	IMPLEMENTING LRU - GEORGIA TECH HPCA III - UDACITY/ YOUTUBE
	
	
	CPU CACHE
	————————— 
	THE MEMORY HIERARCHY - MIT 6.004 L15/ YOUTUBE
	CACHE ISSUES - MIT 6.004 L16/ YOUTUBE

	
	
	
	
	DIFFERENCE BETWEEN A PROCESS AND A THREAD
	
	
	

	JAVA PARALLELISM AND DISTRIBUTED COMPUTING SPECIALIZATION IN COURSERA
	—————————————————————————————————————————————————————————————————————
	
	PARALLEL PROGRAMMING IN JAVA - COURSERA/ RICE UNIVERSITY 
	CONCURRENT PROGRAMMING IN JAVA - COURSERA/ RICE UNIVERSITY 
	DISTRIBUTED PROGRAMMING IN JAVA - COURSERA/ RICE UNIVERSITY 
	—————————————————————————————————————————————————————————————————————
	



	DECENTRALIZED APPLICATIONS - SIRAJ RAVAL/ THE SCHOOL OF AI 
	

	EDX COURSERS 
	————————————
	
	RELIABLE DISTRIBUTED ALGORITHMS I & II - KTH/ EDX + YOUTUBE 
	
	DISTRIBUTED MACHINE LEARNING WITH APACHE SPARK - UC BERKELEY/ EDX 
	
	ARCHITECTING DISTRIBUTED CLOUD APPLICATIONS - MICROSOFT/ EDX 

	
	
	

	
	PARALLEL COMPUTER ARCHITECTURE - PROF. ONUR MUTLU, CMU/ YOUTUBE 
	—————————————————————————————————————————————————————————
	
	
	L-1  INTRODUCTION
	
	L-2  PARALLELISM BASICS 
	
	L-3  PROGRAMMING MODELS
	
	L-4  MULTI-CORE PROCESSORS
	
	L-5  MULTI-CORE PROCESSORS II 
	
	L-6  ASYMMETRY
	
	L-7  EMERGING MEMORY
	
	L-8  MORE ASYMMETRY
	
	L-9  MULTITHREADING
	
	L-10  MULTITHREADING II
	
	L-11 CACHES IN MULTICORES
	
	L-12 CACHING IN MULTI-CORE
	
	L-13 MULTI-THREADING II
	
	L-14 
	
	L-15 SPECULATION 1
	
	L-16
	
	L-17 INTERCONNECTION NETWORKS I
	
	L-18 INTERCONNECTION NETWORKS II
	
	L-19
	
	L-20 SPECULATION+INTERCONNECT III
	
	L-21 INTERCONNECTS IV
	
	L-22 DATAF-LOW I
	
	L-23 DATAFLOW II
	
	L-24-MAIN MEMORY I
	
	L-25 MAIN MEMORY II
	
	L-26 MEMORY INTERFERENCE
	
	L-27 MAIN MEMORY III
	—————————————————————————————————————————————————————————————————————
	



	HIGH SPEED STREAMING TRADE DATA
	———————————————————————————————

	STREAMING STOCK MARKET DATA WITH APACHE SPARK AND KAFKA -  JOHN O'NEILL/ YOUTUBE 

       





	
	—————————————————————————————————————————————————————————————————————
	MULTI-CORE PROGRAMMING PRIMER - MIT OPEN COURSEWARE
	
	DISTRIBUTED ALGORITHMS - MIT OCW
	
	PROBABILISTIC SYSTEMS ANALYSIS AND APPLIED PROBABILITY - MIT OCW

	DISTRIBUTED SYSTEMS (CS-6.824) - MIT OCW
	
	DISTRIBUTED COMPUTER SYSTEMS ENGINEERING - MIT OCW 



	ETH ZURICH 
	——————————

	Distributed Systems - ETH Zurich (https://disco.ethz.ch/courses/distsys/)
	
	Principles of Distributed Computing - ETH Zurich (https://disco.ethz.ch/courses/podc/)

	Discrete Event Systems - ETH Zurich (https://disco.ethz.ch/courses/des/)

	Operating Systems & Networks - ETH Zurich (https://disco.ethz.ch/courses/ti2/)
	—————————————————————————————————————————————————————————————————————
	
	
	
	
	
	CORE JAVA CONCURRENCY <HTTPS://DZONE.COM/REFCARDZ/CORE-JAVA-CONCURRENCY>
	
	JAVA / CONCURRENCY <HTTP://TUTORIALS.JENKOV.COM/JAVA-CONCURRENCY/JAVA-MEMORY-MODEL.HTML>
	
	CRUNCHIFY JAVA MULTI-THREADING <CRUNCHIFY.COM>
	
	HIGH PERFORMANCE JAVA PERSISTENCE 
	
	ASYNCHRONOUS PROGRAMMING IN JAVA  <HTTPS://CODING2FUN.WORDPRESS.COM/2016/08/09/ASYNCHRONOUS-PROGRAMMING-IN-JAVA/>
	
	A GENTLE GUIDE TO ASYNCHRONOUS PROGRAMMING WITH ECLIPSE VERT.X FOR JAVA DEVELOPERS
	
	HIGHER-ORDER FUNCTIONS, FUNCTIONS COMPOSITION, AND CURRYING IN JAVA 
	
	JAVA DISTRIBUTED COMPUTING - JIM FARLEY/ O'REILLY MEDIA
	
	
	
	
	
	————————————————————————————————————————————————————————
	HIGH PERFORMANCE COMPUTING - GEORGIA TECH/ UDACITY
	
	HIGH PERFORMANCE COMPUTER ARCHITECTURE - GEORGIA TECH/ UDACITY 
	
	INTRO TO PARALLEL TO PROGRAMMING (NIVIDA CUDA) - UDACITY 
	————————————————————————————————————————————————————————
	
	

	
	
	
	CLOUDS, DISTRIBUTED SYSTEMS, NETWORKING SERIES - UNIVERSITY OF ILLINOIS/ COURSERA 
	—————————————————————————————————————————————————————————————————————————————————
	
	CLOUD COMPUTING CONCEPTS, PART 1 - UNI. OF ILLINOIS/ COURSERA 
	
	CLOUD COMPUTING CONCEPTS: PART 2 - UNI. OF ILLINOIS/ COURSERA 
	
	CLOUD COMPUTING APPLICATIONS, PART 1: CLOUD SYSTEMS AND INFRASTRUCTURE - UNI. OF ILLINOIS/ COURSERA 
	
	CLOUD COMPUTING APPLICATIONS, PART 2: BIG DATA AND APPLICATIONS IN THE CLOUD - UNI. OF ILLINOIS/ COURSERA 
	
	CLOUD NETWORKING - UNI. OF ILLINOIS/ COURSERA 
	
	CLOUD COMPUTING PROJECT - UNI. OF ILLINOIS/ COURSERA 
	
	
	
	
	
	

	COMPUTER ARCHITEKTUR
	————————————————————

	COMPUTER ARCHITECTURE - COURSERA/ PRINCETON UNIVERSITY
	
	COMPUTER SYSTEM ARCHITECTURE - MIT OPEN COURSEWARE 
	
	COMPILERS - STANFORD UNIVERSITY 
	
	COMPILERS: THEORY AND PRACTICE - UDACITY
	
	INTRODUCTION TO OPERATING SYSTEMS - UDACITY
	
	ADVANCED OPERATING SYSTEMS - UDACITY
	
	HIGH PERFORMANCE COMPUTER ARCHITECTURE - UDACITY
	
	BUILD A MODERN COMPUTER FROM FIRST PRINCIPLES: FROM NAND TO TETRIS (PROJECT-CENTERED COURSE) - COURSERA 
	———————————————————————————————————————————————————————————————————————————————————————
	
	
	

	
	
	
	
	BLOG POSTS, WEB PAGES 
	—————————————————————
	
	What's Wrong with Java 8: Currying vs Closures I - DZone

	What's Wrong in Java 8, Part II: Functions & Primitives - DZone

	What's Wrong in Java 8, Part III: Streams and Parallel Streams - DZone





	A Java? Fork-Join Calamity - coopsoft

	A Java™ Parallel Calamity - coopsoft






	THE LMAX ARCHITECTURE - MARTIN FOWLER 

	MECHANICAL SYMPATHY - <HTTPS://MECHANICAL-SYMPATHY.BLOGSPOT.COM/>


	LINEARIZABILITY, SERIALIZABILITY, TRANSACTION ISOLATION AND CONSISTENCY MODELS - DDDPAUL.GITHUB.IO
	
	LINEARIZABILITY VERSUS SERIALIZABILITY - PETER BAILIS
	
	DISTRIBUTED CONSISTENCY AND SESSION ANOMALIES - BLOG.ACOLYER.ORG
	
	A CRITIQUE OF ANSI SQL ISOLATION LEVELS - BLOG.ACOLYER.ORG
	
	STRONG CONSISTENCY MODELS - APHYR.COM
	
	A BEGINNER’S GUIDE TO DATABASE LOCKING AND THE LOST UPDATE PHENOMENA - VLAD MIHALCEA
	
	GENERALIZED ISOLATION LEVEL DEFINITIONS - BLOG.ACOLYER.ORG
	
	TRANSACTION ISOLATION - POSTGRESQL.ORG
	
	
	JAVA CONCURRENCY ESSENTIAL - Java Code Geeks (JCG) 
	
	JAVA ANNOTATION TUTORIAL - Java Code Geeks (JCG) 
	
	META-ANNOTATIONS IN JAVA
	
	CUSTOM NETWORKING - Oracle Tutorials 
	
	JAVA MULTI-THREADING - CRUNCHIFY
	
	HIGH PERFORMANCE JAVA PERSISTENCE 
	
	ASYNCHRONOUS PROGRAMMING IN JAVA  <HTTPS://CODING2FUN.WORDPRESS.COM/2016/08/09/ASYNCHRONOUS-PROGRAMMING-IN-JAVA/>
	
	A GENTLE GUIDE TO ASYNCHRONOUS PROGRAMMING WITH ECLIPSE VERT.X FOR JAVA DEVELOPERS
	
	HIGHER-ORDER FUNCTIONS, FUNCTIONS COMPOSITION, AND CURRYING IN JAVA 8 - DZONE

	JAVA THEORY AND PRACTICES - IBM Talk series 





	DISTRIBUTED SYSTEMS COURSE -  CHRIS COLOHAN/ GOOGLE 
	———————————————————————————————————————————————————

	WEBPAGE: <HTTP://WWW.DISTRIBUTEDSYSTEMSCOURSE.COM/>

	i. 		Introduction 

	        	WHAT IS A DISTRIBUTED SYSTEM? [VIDEO, SLIDES]
	        	WHY BUILD A DISTRIBUTED SYSTEM? [VIDEO, SLIDES]
	        	HOW TO LEARN DISTRIBUTED SYSTEMS. [VIDEO, SLIDES]

	ii.     How systems fail 

	        	WHAT COULD GO WRONG? [VIDEO, SLIDES]
	        	TYPES OF FAILURES [VIDEO, SLIDES]
	        	BYZANTINE FAULT TOLERANCE [VIDEO, SLIDES]


	iii.   HOW TO EXPRESS YOUR GOALS: SLIS, SLOS, AND SLAS [VIDEO, SLIDES]

	iv.    CLASS PROJECT: BUILDING A MULTIUSER CHAT SERVER [VIDEO, SLIDES]


	v.     HOW TO GET AGREEMENT -- CONSENSUS
	       		PAXOS [VIDEO, SLIDES] [VIDEO REPLACED WITH...]
	       		PAXOS SIMPLIFIED [VIDEO, SLIDES]


	vi.    HOW COUNTERSTRIKE WORKS (A.K.A. TIME IN DISTRIBUTED SYSTEMS) [VIDEO, SLIDES]

	vii.   HOW TO COMBINE UNRELIABLE COMPONENTS TO MAKE A MORE RELIABLE SYSTEM

	viii.  HOW NODES COMMUNICATE -- RPCS

	ix.    HOW NODES FIND EACH OTHER -- NAMING

	x.     HOW TO PERSIST DATA -- DISTRIBUTED STORAGE

	xi.    HOW TO SECURE YOUR SYSTEM

	xii.   HOW TO OPERATE YOUR DISTRIBUTED SYSTEM -- THE ART OF SRE







	DISTRIBUTED COMPUTER SYSTEMS (CS-436)  - UNI. OF WATERLOO/ Prof. S Keshav
	—————————————————————————————————————————————————————————

		Introduction

		Link layer

		Addressing, ethernet

		Switches, wireless, circuit switching

		Packet switching, dijkstra's algorithm, loss, throughput

		Network layer intro, datagrams, routing

		Ipv4, ipv6, NAT, Tunnelling

		Fipsec, ospf, bgp, broadcast routing

		Transport layer, multiplexing, udp

		Reliable data transfer

		TCP

		TCP fast retransmit, congestion, flow control

		Http, smtp et. Al., dns

		Mobile issues

		Distributed architectures, cloud computing

		Consistency, replication

		Fault tolerance

		Case studies

		Security





	DISTRIBUTED SYSTEMS (COS-418) - PRINCETON UNIVERSITY
	—————————————————————————————————————————————————————————

	SEC - A: Fundamentals 
	—————————————————————

	Course overview, principles, mapreduce

	Go systems programming

	Network file systems

	Network communication and remote procedure calls 	

	Concurrency in go

	Time synchronization and logical clocks		


	SEC - B: Fault tolerance
	————————————————————————

	Primary backup

	Rpcs in go

	Two-phase commit, introducing safety and liveness

	Consensus I: flp impossibility, paxos 		

	2pc and paxos review		

	Consensus ii: replicated state machines, raft

	Byzantine fault tolerance

	Big data and spark


	SEC - C: Scalability, consistency, and transactions
	———————————————————————————————————————————————————

	Peer-to-peer systems and distributed hash tables

	Eventual consistency

	Scaling services: key-value storage

	Strong consistency and cap theorem
	Causal consistency

	Concurrency control, locking, and recovery

	Concurrency control 2 (occ, mvcc) and distributed transactions

	Spanner 	


	SEC - D: Boutique topics
	————————————————————————

	Conflict resolution (ot), crypto, untrusted cloud services

	Blockchains

	Content delivery networks

	Distributed mesh wireless networks


	SEC-E: More big data processing
	—————————————————————————————————

	Graph processing

	Chandy-lamport snapshotting	

	Stream processing

	Cluster scheduling




	RUTGERS UNIVERSITY (CS 417) - DISTRIBUTED SYSTEMS
	—————————————————————————————————————————————————

		Introduction 

		Networking
		
		Remote procedure calls
		
		RPC case studies
		
		Remote Procedure Calls
		
		Clock synchronization
		
		Precision Time Protocol
		
		Logical clocks
		
		Vector Clocks 
		
		Group communication
		
		Virtual synchrony

		Mutual exclusion and election algorithms
		
		Consensus: Paxos
		
		Mutual exclusion and election algorithms
		
		Distributed transactions
		
		Distributed deadlock
		
		Network file systems
		
		Distributed file systems
		
		Distributed lookup services
		
		MapReduce
		
		Bigtable
		
		Spanner
		
		Other parallel computing frameworks
		
		Content Delivery Networks
		
		Clusters
		
		Cryptography
		
		Authentication & authorization

		Caching & peer-to-peer systems
		
		


	
	Cajo, the easiest way for distributed computing in Java - Java Code Geeks (JCG)

	Deadlock Detection with new Locks - Java Specialists Teachable(javaspecialists.teachable.com)





	JAVA SPECIALISTS TEACHABLE (https://javaspecialists.teachable.com)
	—————————————————————————————————————————————————————————————————

	Extreme Java Concurrency Performance (Java 8) - Java Specialists (By Dr. Heinz Kabutz)
	
	Java Concurrency in Practice Bundle - Java Specialists (By Dr. Heinz Kabutz)

	Threading essentials - Java Specialists (By Dr. Heinz Kabutz)


	Transmogrifier: Java NIO and Non-Blocking IO - Java Specialists (By Dr. Heinz Kabutz)

	Refactoring to Java 8 Streams and Lambdas - Java Specialists (By Dr. Heinz Kabutz)

	Transition to Continuous Delivery with Enterprise Java - Java Specialists (By Dr. Heinz Kabutz)


	Data Structures in Java - Java Specialists (By Dr. Heinz Kabutz)




	

	
	
	
	OPTIMIZATION 
	————————————
	
	OPTIMIZE THE JAVA CODE - JOOQ.ORG <HTTPS://BLOG.JOOQ.ORG/2015/02/05/TOP-10-EASY-PERFORMANCE-OPTIMISATIONS-IN-JAVA/>
	
	MAKE FAST JAVA <HTTP://WWW.JAVAWORLD.COM/ARTICLE/2077647/BUILD-CI-SDLC/MAKE-JAVA-FAST--OPTIMIZE-.HTML?PAGE=1>
	
	
	JAVA PERFORMANCE
	————————————————
	NETTY, VERT.X, QBIT, JCTOOLS AND CHRONICLE






	
	
	
	
	
	DISTRIBUTED SYSTEMS ARCHITECTURE
	————————————————————————————————
	
	SOFTWARE ARCHITECTURE   
	
	ION   
	
	IAP   
	
	IAP TOOLS FOR JAVA  
	
	GRID OPS FOR JAVA  
	
	SOA - SERVICE ORIENTED ARCHITECTURE   
	
	WEB SERVICES   
	
	SOAP   
	
	WSDL 2.0   
	
	RSYNC   
	
	PEER-TO-PEER (P2P) NETWORKS   
	
	
	——————————————————————————————————————
	YOUTUBE JAVA CHANNEL - YEGOR BUGAYENKO
	——————————————————————————————————————
	
	
	
		
	Vmlens Blog 
	———————————

	7 techniques for thread-safe classes - Vmlens 

	3 tips for volatile fields in java - Vmlens 

	A new way to detect deadlocks during tests - Vmlens 


	Thread Safe LIFO Data Structure Implementations - Baeldung
	





	Serialization - Benchresources
	——————————————————————————————

	How to serialize and de-serialize ArrayList in Java  - Benchresources

	Construct a singleton class in a multi-threaded environment in Java - Benchresources

	How to stop Serialization in Java - Benchresources

	Singleton Design pattern with Serialization - Benchresources

	Importance of SerialVersionUID in Serialization - Benchresources

	Serializable v/s Externalizable - Benchresources

	Externalizable interface with example - Benchresources

	Serialization with Inheritance - Benchresources

	Serialization with Aggregation - Benchresources

	Order of Serialization and De-Serialization - Benchresources

	Serializing a variable with transient modifier or keyword - Benchresources

	Transient keyword with final variable in Serialization - Benchresources

	Transient keyword with static variable in Serialization - Benchresources

	Transient keyword with Serialization in Java - Benchresources

	Serializable interface - Benchresources

	Serialization and De-Serialization in Java - Benchresources

	Serialization interview question and answer in Java - Benchresources
	——————————————————————————————————————————————————————————————————————————








	Baeldung
	————————

	Thread Safe LIFO Data Structure Implementations - Baeldung

	——————————————————————————————————————————————————————————






	BOOKS 
	—————
	
	CONCURRENT PROGRAMMING IN JAVA: DESIGN PRINCIPLES AND PATTERNS - DOUG LEA 
	
	JAVA CONCURRENCY IN PRACTICE - BRIAN GOETZ
	
	7 CONCURRENCY MODELS IN 7 WEEKS: WHEN THREADS UNRAVEL - PAUL BUTCHER 
	
	JAVA 8 IN ACTION: LAMBDAS, STREAMS, AND FUNCTIONAL-STYLE PROGRAMMING - ALAN MYCROFT, MARIO FUSCO
	
	DISTRIBUTED ALGORITHMS BY PROF. NANCY LYNCH
	
	PROGRAMMING FOR THE JAVA™ VIRTUAL MACHINE - JOSHUA ENGEL
	
	DESIGNING DISTRIBUTED SYSTEMS: PATTERNS AND PARADIGMS FOR SCALABLE, RELIABLE SERVICES - BRENDAN BURNS/ OREILLY
	
	DESIGNING DATA-INTENSIVE APPLICATIONS: THE BIG IDEAS BEHIND RELIABLE, SCALABLE, AND MAINTAINABLE SYSTEMS - MARTIN KLEPPMANN
	
	KUBERNETES: UP AND RUNNING: DIVE INTO THE FUTURE OF INFRASTRUCTURE - KELSEY HIGHTOWER, BRENDAN BURNS, JOE BEDA
	
	JAVA DISTRIBUTED COMPUTING - JIM FARLEY/ O'REILLY MEDIA
	
	BUILDING REACTIVE MICROSERVICES IN JAVA BY CLEMENT ESCOER (OREILLY)
	ASYNCHRONOUS AND EVENT-BASED APPLICATION DESIGN
	
	JAVA NETWORK PROGRAMMING: DEVELOPING NETWORKED APPLICATIONS - ELLIOTTE HAROLD
	
	APACHE MAHOUT: BEYOND MAPREDUCE - DMITRIY LYUBIMOV, ANDREW PALUMBO 
	
	MAPREDUCE DESIGN PATTERNS: BUILDING EFFECTIVE ALGORITHMS AND ANALYTICS FOR HADOOP AND OTHER SYSTEMS - DONALD MINER, ADAM SHOOK

    Building Microservices: Designing Fine-Grained Systems - Sam Newman

    Reactive Messaging Patterns with the Actor Model: Applications and Integration in    Scala and Akka - Vaughn Vernon

    Java™ Network Programming and Distributed Computing - Michael Reilly, David Reilly

	Distributed Computing in Java 9 - Raja Malleswara, Rao Pattamsetti/ Packt 

	Concurrent and Distributed Computing in Java - Vijay K. Garg

	Java Distributed Computing - Jim Farley

	Distributed Computing with Go - V.N. Nikhil Anurag


	Java Network Programming: Developing Networked Applications - Elliotte Rusty Harold

	Java Performance: The Definitive Guide - Scott Oaks
	
	Java Performance Tuning - Jack Shirazi 


	High-Performance Java Persistence - Vlad Mihalcea
	——————————————————————————————————————————————————————————————————————————————————————












	——————————————————————————————————————————————————————————————————————————————————————

	AWESOME DISTRIBUTED SYSTEMS
	———————————————————————————

	A (hopefully) curated list on awesome material on distributed systems, inspired by
	other awesome frameworks like [awesome-python](https://github.com/vinta/awesome-python).
	Most links will tend to be readings on architecture itself rather than code itself.

	## Bootcamp
	Read things here before you start.
	- [CAP Theorem](http://en.wikipedia.org/wiki/CAP_theorem), Also [plain english](http://ksat.me/a-plain-english-introduction-to-cap-theorem/) explanation
	- [Fallacies of Distributed Computing](http://en.wikipedia.org/wiki/Fallacies_of_distributed_computing), expect things to break, *everything*
	- [Distributed systems theory for the distributed engineer](http://the-paper-trail.org/blog/distributed-systems-theory-for-the-distributed-systems-engineer/), most of the papers/books in the blog might reappear in this list again. Still a good BFS approach to distributed systems.
	- [FLP Impossibility Result (paper)](https://groups.csail.mit.edu/tds/papers/Lynch/jacm85.pdf), an easier [blog post](http://the-paper-trail.org/blog/a-brief-tour-of-flp-impossibility/) to follow along
	- [An Introduction to Distributed Systems](https://github.com/aphyr/distsys-class) @aphyr's excellent introduction to distributed systems 

	## Books
	- [Distributed Systems for fun and profit](http://book.mixu.net/distsys/single-page.html) [Free]
	- [Distributed Systems Principles and Paradigms, Andrew Tanenbaum](http://www.amazon.com/Distributed-Systems-Principles-Paradigms-2nd/dp/0132392275) [Amazon Link]
	- [Scalable Web Architecture and Distributed Systems](http://www.aosabook.org/en/distsys.html) [Free]
	- [Principles of Distributed Systems](http://dcg.ethz.ch/lectures/podc_allstars/lecture/podc.pdf) [Free] [ETH Zurich University]
	- [Making reliable distributed systems in the presence of software errors](http://www.erlang.org/download/armstrong_thesis_2003.pdf), [Free] Joe Amstrong's (Author of Erlang) PhD thesis 
	- [Designing Data Intensive Applications](https://www.amazon.com/Designing-Data-Intensive-Applications-Reliable-Maintainable/dp/1449373321) [Amazon Link]
	- [Distributed Computing, By Hagit Attiya and Jennifer Welch](http://hagit.net.techNIOn.ac.il/publications/dc/)
	- [Distributed Algorithms, Nancy Lynch](https://www.amazon.com/Distributed-Algorithms-Kaufmann-Management-Systems/dp/1558603484) [Amazon Link]
	- [Impossibility Results for Distributed Computing](http://www.morganclaypool.com/doi/abs/10.2200/S00551ED1V01Y201311DCT012) (paywall)

	## Papers
	Must read papers on distributed systems. While nearly *all* of Lamport's work should feature here, just adding a few that *must* be read.
	- [Times, Clocks and Ordering of Events in Distributed Systems](http://research.microsoft.com/en-us/um/people/lamport/pubs/time-clocks.pdf) Lamport's paper, the Quintessential distributed systems primer
	- [Session Guarantees for Weakly Consistent Replicated Data](http://www.cs.utexas.edu/~dahlin/Classes/GradOS/papers/SessionGuaranteesPDIS.pdf) a '94 paper that talks about various recommendations for session guarantees for eventually consistent systems, many of this would be standard vocabulary in reading other dist. sys papers, like monotonic reads, read your writes etc.

	### Storage & Databases
	- [Dynamo: Amazon's Highly Available Key Value Store](http://bnrg.eecs.berkeley.edu/~randy/Courses/CS294.F07/Dynamo.pdf)
	Paraphrasing @fogus from their [blog](http://blog.fogus.me/2011/09/08/10-technical-papers-every-programmer-should-read-at-least-twice/), it is very rare for a paper describing an active production system to influence the state of active research in any industry; this is one of those seminal distributed systems paper that solves the problem of a highly available and fault tolerant database in an elegant way, later paving the way for systems like Cassandra, and many other AP systems using a consistent hashing.
	- [Bigtable: A Distributed Storage System for Structured Data](http://static.googleusercontent.com/media/research.google.com/en//archive/bigtable-osdi06.pdf)
	- [The Google File System](http://static.googleusercontent.com/external_content/untrusted_dlcp/research.google.com/en/us/archive/gfs-sosp2003.pdf)
	- [Cassandra: A Decentralized Structured Storage System](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.161.6751&rep=rep1&type=pdf) Inspired heavily by Dynamo, an now an open source 
	- [CRUSH: Controlled, Scalable, Decentralized Placement of Replicated Data](http://www.ssrc.ucsc.edu/Papers/weil-sc06.pdf), the algorithm for the basis of Ceph distributed storage system, for the architecture itself read [RADOS](http://ceph.com/papers/weil-rados-pdsw07.pdf)

	### Messaging systems
	- [The Log: What every software engineer should know about real-time data's unifying abstraction](http://engineering.linkedin.com/distributed-systems/log-what-every-software-engineer-should-know-about-real-time-datas-unifying), a somewhat long read, but covers brilliantly on logs, which are at the heart of most distributed systems
	- [Kafka: a Distributed Messaging System for Log Processing](http://notes.stephenholiday.com/Kafka.pdf)

	### Distributed Consensus and Fault-Tolerance
	- [Practicle Byzantine Fault Tolerance](http://pmg.csail.mit.edu/papers/osdi99.pdf)
	- [The Byzantine Generals Problem](http://bnrg.cs.berkeley.edu/~adj/cs16x/hand-outs/Original_Byzantine.pdf)
	- [Impossibility of Distributed Consensus with One Faulty Process](http://macs.citadel.edu/rudolphg/csci604/ImpossibilityofConsensus.pdf)
	- [The Part Time Parliament](http://research.microsoft.com/en-us/um/people/lamport/pubs/lamport-paxos.pdf) Paxos, Lamport's original Paxos paper, a bit difficult to understand, may require multiple passes
	- [Paxos Made Simple](http://research.microsoft.com/en-us/um/people/lamport/pubs/paxos-simple.pdf), a more terse readable Paxos paper by Lamport himself. Shorter and more easier compared to the original.
	- [The Chubby Lock Service for loosely coupled distributed systems](http://static.googleusercontent.com/media/research.google.com/en//archive/chubby-osdi06.pdf) Google's lock service used for loosely coupled distributed systems. Sort of Paxos as a Service for building other distributed systems. Primary inspiration behind other Service Discovery & Coordination tools like Zookeeper, etcd, Consul etc.
	- [Paxos made live - An engineering perspective](http://research.google.com/archive/paxos_made_live.html) Google's learning while implementing systems atop of Paxos. Demonstrates various practical issues encountered while implementing a theoritical concept.
	- [Raft Consensus Algorithm](https://raftconsensus.github.io/) An alternative to Paxos for distributed consensus, that is much simpler to understand. Do checkout an [interesting visualization of raft](http://thesecretlivesofdata.com/raft/)

	### Testing, monitoring and tracing
	While designing distributed systems are hard enough, testing them is even harder. 
	- [Dapper](http://static.googleusercontent.com/media/research.google.com/en//pubs/archive/36356.pdf), Google's large scale distributed-systems tracing infrastructure, this was also the basis for the design of open source projects such as [Zipkin](http://zipkin.io/), [Pinpoint](https://github.com/naver/pinpoint) and [HTrace](http://htrace.incubator.apache.org/).

	### Programming Models
	- [Distributed Programming Model](http://web.cs.ucdavis.edu/~pandey/Research/Papers/icdcs01.pdf)
	- [PSync: a partially synchronous language for fault-tolerant distributed algorithms](http://www.di.ens.fr/~cezarad/popl16.pdf) Video: [Conference Video](https://www.youtube.com/watch?v=jxfq9_L9T1U&t=51s)
	- [Programming Models for Distributed Computing](http://heather.miller.am/teaching/cs7680/)
	- [Logic and Lattices for Distributed Programming](http://db.cs.berkeley.edu/papers/UCB-lattice-tr.pdf)

	### Verification of Distributed Systems
	- [Jepsen](https://github.com/jepsen-io/jepsen) A framework for distributed systems verification, with fault injection
	  @aphyr has featured enough times in this list already, but Jepsen and the blog posts that go with are a quintessntial addition to any distributed systems reading list.
	- [Verdi](http://verdi.uwplse.org/) A Framework for Implementing and Formally Verifying Distributed Systems [Paper](http://verdi.uwplse.org/verdi.pdf)

	## Courses
	- [Reliable Distributed Algorithms, Part 1](https://www.edx.org/course/reliable-distributed-algorithms-part-1-kthx-id2203-1x-0), KTH Sweden
	- [Reliable Distributed Algorithms, Part 2](https://www.edx.org/course/reliable-distributed-algorithms-part-2-kthx-id2203-2x), KTH Sweden
	- [Cloud Computing Concepts](https://class.coursera.org/cloudcomputing-001), University of Illinois
	- [CMU: Distributed Systems](http://www.cs.cmu.edu/~dga/15-440/F12/syllabus.html) in Go Programming Language
	- [Software Defined Networking](https://www.coursera.org/course/sdn) , Georgia Tech.
	- [ETH Zurich: Distributed Systems](http://dcg.ethz.ch/lectures/podc_allstars/)
	- [ETH Zurich: Distributed Systems Part 2](http://dcg.ethz.ch/lectures/distsys), covers  Distributed control algorithms, communication models, fault-tolerance among other things. In particular fault tolerence issues (models, consensus, agreement) and replication issues (2PC,3PC, Paxos), which are critical in understanding distributed systems are explained in great detail.

	## Blogs and other reading links
	- [Notes on Distributed Systems for Young Bloods](http://www.somethingsimilar.com/2013/01/14/notes-on-distributed-systems-for-young-bloods/)
	- [High Scalability](http://highscalability.com/) Several architectures of huge internet services, for eg [twitter](http://highscalability.com/blog/2013/7/8/the-architecture-twitter-uses-to-deal-with-150m-active-users.html), [whatsapp](http://highscalability.com/blog/2014/2/26/the-whatsapp-architecture-facebook-bought-for-19-billion.html)
	- [There is No Now](http://queue.acm.org/detail.cfm?id=2745385), Problems with simultaneity in distributed systems
	- [Turing Lecture: The Computer Science of Concurrency: The Early Years](http://cacm.acm.org/magazines/2015/6/187316-turing-lecture-the-computer-science-of-concurrency/fulltext), An article by Leslie Lamport on concurrency
	- [The Paper Trail](http://the-paper-trail.org/blog/tag/distributed-systems/) blog, a very readable blog covering various aspects of distributed systems
	- [aphyr](https://aphyr.com/tags/Distributed-Systems), Posts on [jepsen](https://github.com/aphyr/jepsen) series are pretty awesome
	- [All Things Distributed](http://www.allthingsdistributed.com/) - Wernel Vogel's (Amazon CTO) blog on distributed systems 
	- [Distributed Systems: Take Responsibility for Failover](http://ivolo.me/distributed-systems-take-responsibility-for-failover/)
	- [The C10K problem](http://www.kegel.com/c10k.html)
	- [On Designing and Deploying Internet-Scale Services](http://static.usenix.org/event/lisa07/tech/full_papers/hamilton/hamilton_html/)
	- [Files are hard](http://danluu.com/file-consistency/) A blog post on filesystem consistency, pretty important to read if you are into distributed storage or databases.
	- [Distributed Systems Testing: The Lost World](http://tagide.com/blog/research/distributed-systems-testing-the-lost-world/) Testing distributed systems are hard enough, a well researched blog post which again covers a lot of links to various approaches and other papers


	## Meta Lists
	Other lists like this one
	- [Readings in distributed systems](http://christophermeiklejohn.com/distributed/systems/2013/07/12/readings-in-distributed-systems.html)
	- [Distributed Systems meta list](https://gist.github.com/macintux/6227368)
	- [List of required readings for Distributed Systems](http://www.andrew.cmu.edu/course/15-749/READINGS/required/) Part of CMU's Engineering Distributed Systems course
	- [The Distributed Reader](http://reiddraper.github.io/distreader/)
	- [A Distributed Systems Reading List](https://dancres.github.io/Pages/), A collection of material, mostly papers on Distributed Systems Theory as well as seminal industry papers 
	- [Distributed Systems Readings](https://henryr.github.io/distributed-systems-readings/), A comprehensive list of online courses related to distributed systems 


	——————————————————————————————————————————————————————————————————————————————————————







			
			
			
			
			
			
			
			
			
			
			
			
			
