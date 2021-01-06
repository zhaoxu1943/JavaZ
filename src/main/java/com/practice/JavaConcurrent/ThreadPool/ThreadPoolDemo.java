package com.practice.JavaConcurrent.ThreadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolDemo
 * @Description 线程池
 * ali规约
 * 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
 * 的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明： Executors 返回的线程池对象 的弊端 如下
 * 1 FixedThreadPool 和 SingleThread Pool
 * 允许的请求队列长度为 Integer.MAX_VALUE，可 能会堆积大量的请求，从而导致 OOM。
 * 2 CachedThreadPool 和 ScheduledThreadPool
 * 允许的创建线程数量为 Integer.MAX_VALUE 可能会创建大量的线程，从而导致 OOM
 *
 * 创建线程池的好处
 * 减少资源创建 => 减少内存开销，创建线程占用内存
 * 降低系统开销 => 创建线程需要时间，会延迟处理的请求
 * 提高稳定稳定性 => 避免无限创建线程引起的OutOfMemoryError【简称OOM]
 *
 * 线程池的内部结构
 * 第一部分是线程池管理器，它主要负责管理线程池的创建、销毁、添加任务等管理操作，它是整个线程池的管家。
 *
 * 第二部分是工作线程，也就是图中的线程 t0~t9，这些线程勤勤恳恳地从任务队列中获取任务并执行。
 *
 * 第三部分是任务队列，作为一种缓冲机制，线程池会把当下没有处理的任务放入任务队列中，由于多线程同时从任务队列中获取任务是并发场景，此时就需要任务队列满足线程安全的要求，所以线程池中任务队列采用 BlockingQueue 来保障线程安全。
 *
 * 第四部分是任务，任务要求实现统一的接口，以便工作线程可以处理和执行。
 *
 * 常用的阻塞队列
 * LinkedBlockingQueue
 * 对于 FixedThreadPool 和 SingleThreadExecutor 而言，
 * 它们使用的阻塞队列是容量为 Integer.MAX_VALUE 的 LinkedBlockingQueue，可以认为是无界队列。
 * 由于 FixedThreadPool 线程池的线程数是固定的，所以没有办法增加特别多的线程来处理任务，
 * 这时就需要 LinkedBlockingQueue 这样一个没有容量限制的阻塞队列来存放任务。
 * 这里需要注意，由于线程池的任务队列永远不会放满，所以线程池只会创建核心线程数量的线程，所以此时的最大线程数对线程池来说没有意义，
 * 因为并不会触发生成多于核心线程数的线程。
 *
 * SynchronousQueue
 * 第二种阻塞队列是 SynchronousQueue，对应的线程池是 CachedThreadPool。
 * 线程池 CachedThreadPool 的最大线程数是 Integer 的最大值，
 * 可以理解为线程数是可以无限扩展的。
 * CachedThreadPool 和上一种线程池 FixedThreadPool 的情况恰恰相反，
 * FixedThreadPool 的情况是阻塞队列的容量是无限的，
 * 而这里 CachedThreadPool 是线程数可以无限扩展，
 * 所以 CachedThreadPool 线程池并不需要一个任务队列来存储任务，
 * 因为一旦有任务被提交就直接转发给线程或者创建新线程来执行，而不需要另外保存它们。
 * 我们自己创建使用 SynchronousQueue 的线程池时，
 * 如果不希望任务被拒绝，那么就需要注意设置最大线程数要尽可能大一些，
 * 以免发生任务数大于最大线程数时，没办法把任务放到队列中也没有足够线程来执行任务的情况。
 *
 * DelayedWorkQueue
 * 第三种阻塞队列是DelayedWorkQueue，
 * 它对应的线程池分别是 ScheduledThreadPool 和 SingleThreadScheduledExecutor，
 * 这两种线程池的最大特点就是可以延迟执行任务，比如说一定时间后执行任务或是每隔一定的时间执行一次任务。
 * DelayedWorkQueue 的特点是内部元素并不是按照放入的时间排序，
 * 而是会按照延迟的时间长短对任务进行排序，
 * 内部采用的是“堆”的数据结构。之所以线程池 ScheduledThreadPool 和 SingleThreadScheduledExecutor 选择 DelayedWorkQueue，
 * 是因为它们本身正是基于时间执行任务的，而延迟队列正好可以把任务按时间进行排序，方便任务的执行。
 *
 *
 *合适的线程数量是多少，以及 CPU 核心数和线程数的关系。
 * 我们调整线程池中的线程数量的最主要的目的是为了充分并合理地使用 CPU 和内存等资源，
 * 从而最大限度地提高程序的性能。在实际工作中，我们需要根据任务类型的不同选择对应的策略。
 *
 *CPU 密集型任务
 * 首先，我们来看 CPU 密集型任务，比如加密、解密、压缩、计算等一系列需要大量耗费 CPU 资源的任务。对于这样的任务最佳的线程数为 CPU 核心数的 1~2 倍
 *
 * 第二种任务是耗时 IO 型，比如数据库、文件的读写，网络通信等任务，这种任务的特点是并不会特别消耗 CPU 资源，但是 IO 操作很耗时，
 * 总体会占用比较多的时间。对于这种任务最大线程数一般会大于 CPU 核心数很多倍
 *
 * 合适的线程计算方法
 * 线程数 = CPU 核心数 *（1+平均等待时间/平均工作时间）
 *
 * 线程的平均工作时间所占比例越高，就需要越少的线程；
 *
 * 线程的平均等待时间所占比例越高，就需要越多的线程；
 *
 * 针对不同的程序，进行对应的实际测试就可以得到最合适的选择。
 *
 * @Author zhaoxu
 * @Date 2019/11/26 1:00
 * @Version 1.0
 **/
public class ThreadPoolDemo {
    //使用线程池比手动创建线程主要有三点好处。
    //
    //第一点，线程池可以解决线程生命周期的系统开销问题，同时还可以加快响应速度。因为线程池中的线程是可以复用的，
    // 我们只用少量的线程去执行大量的任务，这就大大减小了线程生命周期的开销。
    // 而且线程通常不是等接到任务后再临时创建，而是已经创建好时刻准备执行任务，这样就消除了线程创建所带来的延迟，提升了响应速度，增强了用户体验。
    //
    //第二点，线程池可以统筹内存和 CPU 的使用，避免资源使用不当。
    // 线程池会根据配置和任务数量灵活地控制线程数量，不够的时候就创建，太多的时候就回收，避免线程过多导致内存溢出，
    // 或线程太少导致 CPU 资源浪费，达到了一个完美的平衡。
    //
    //第三点，线程池可以统一管理资源。比如线程池可以统一管理任务队列和线程，
    // 可以统一开始或结束任务，比单个线程逐一处理任务要更方便、更易于管理，
    // 同时也有利于数据统计，比如我们可以很方便地统计出已经执行过的任务的数量。
    public static void main(String[] args) {
        //这就是以Executors方式创建
        //
        //    /**
        //     * Creates a {@code LinkedBlockingQueue} with a capacity of
        //     * {@link Integer#MAX_VALUE}.
        //     */
        //    public LinkedBlockingQueue() {
        //        this(Integer.MAX_VALUE);
        //    }
        //看LinkedBlockingQueue()的构造函数,默认会创建一个无界队列,引发OOM异常


        //创建固定大小的线程池,使用了无界队列,return new ThreadPoolExecutor(nThreads, nThreads,
        //                                      0L, TimeUnit.MILLISECONDS,
        //                                      new LinkedBlockingQueue<Runnable>());
        //
        //核心和最大都为n,也就是同样没有非核心线程,keepAliveTime无效,同一个队列一样,当任务超过核心线程数还是
        //全存进无界队列中,引发OOM

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }


        //创建单线程的线程池,还是无界队列,  (new ThreadPoolExecutor(1, 1,
        //                                    0L, TimeUnit.MILLISECONDS,
        //                                    new LinkedBlockingQueue<Runnable>()));
        //CorePoolSize 为1 ,MaxPoolSize 为1,最多创建一个线程,唯一的线程就是核心线程
        //当一个任务提交首先创建一个核心线程,任务超过核心线程数量,放入队列,
        //而LinkedBlockingQueue是无界队列,向无界队列中插入无限多的任务,可能会引发OOM,
        //在这里,MaxPoolSize和keepAlive都是没用的,因为根本没有非核心线程

        //所以非常适合用于所有任务都需要按被提交的顺序依次执行的场景，
        // 而前几种线程池不一定能够保障任务的执行顺序等于被提交的顺序，因为它们是多线程并行执行的。
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            executorService1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        //创建可缓存的线程池,看构造函数可知ThreadPoolExecutor(0, Integer.MAX_VALUE,
        //                                      60L, TimeUnit.SECONDS,
        //                                      new SynchronousQueue<Runnable>())
        //corePoolSize=0 ,maximumPoolSize=Integer.MAX_VALUE也就是说核心线程数为0,最大线程数拉满,无限的去创建非核心线程执行任务
        //60L unit second ,非核心线程被回收
        //而SynchronousQueue是一个不储存元素的队列,永远是满的
        //所以由于 CachedThreadPool 并不限制线程的数量，当任务数量特别多的时候，
        // 就可能会导致创建非常多的线程，最终超过了操作系统的上限而无法创建新线程，或者导致内存不足。
        // 所以说资源有限容易OOM
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService2.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }


        //  public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        //        return new ScheduledThreadPoolExecutor(corePoolSize);
        //    }
        //支持定时/周期性的执行任务,参数只有一个corePoolSize
        //插播一个内部类,这里直接引用会有问题,那么我们需要改成静态内部类 ,或者使用外部对象
        //1）上面的问题主要是因为成员内部类。构造一个成员内部类对象时应使用
        //
        //new TaskThreadDemo().new PrintChar();
        //（2）可以使用静态内部类，加上static关键字，静态内部类的创建不需要依赖外部类
        //它采用的任务队列是 DelayedWorkQueue，这是一个延迟队列，同时也是一个无界队列，所以和 LinkedBlockingQueue 一样，如果队列中存放过的任务，就可能导致 OOM。
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //延迟10s执行一次
        scheduledExecutorService.schedule(new ThreadPoolDemo().new Task(), 10, TimeUnit.SECONDS);
        //延迟10s执行一次,第一次延时后,每10s执行一次
        scheduledExecutorService.scheduleAtFixedRate(new ThreadPoolDemo().new Task(), 10, 10, TimeUnit.SECONDS);
        //延迟10s执行一次,以每次任务结束的时间作为下一次的起点计时10s
        scheduledExecutorService.scheduleWithFixedDelay(new ThreadPoolDemo().new Task(), 10, 10, TimeUnit.SECONDS);


        //public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        //        return new DelegatedScheduledExecutorService
        //            (new ScheduledThreadPoolExecutor(1));
        //    }
        //即核心线程数为1的ScheduledExecutor;保证任务顺序执行
        //它采用的任务队列是 DelayedWorkQueue，这是一个延迟队列，同时也是一个无界队列，所以和 LinkedBlockingQueue 一样，如果队列中存放过的任务，就可能导致 OOM。
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();


        //所以说禁止Executors创建线程池,应该自己手动使用ThreadPoolExecutors创建,确定那六个参数
        //corePoolSize => 线程池核心线程数量,常驻线程数量,初始为0,任务减少也不会销毁
        //maximumPoolSize => 线程池最大数量
        //keepAliveTime => 非核心空闲线程存活时间
        //unit => 时间单位
        //workQueue => 线程池所使用的缓冲队列
        //threadFactory => 线程池创建线程使用的工厂
        //handler => 线程池对拒绝任务的处理策略
        //public ThreadPoolExecutor(int corePoolSize,
        //                              int maximumPoolSize,
        //                              long keepAliveTime,
        //                              TimeUnit unit,
        //                              BlockingQueue<Runnable> workQueue,
        //                              ThreadFactory threadFactory,
        //                              RejectedExecutionHandler handler) {
        //
        //线程池的工作流程(假设任务在不停增加)
        //首先提交任务,创建核心线程,直到核心线程满
        //此时仍有任务,则放入blockingQueue,等待核心线程执行完,从Queue中提取任务执行,直到队列满
        //这是队列满了,核心满了,但是线程数还没到max,这时才创建非核心线程执行
        //继续增加后,线程已经达到了max,就按策略处理了,这就是拒绝的时机
        //即按顺序判断corePoolSize --- workQueue --MaxPoolSize


        //四种拒绝策略都实现了 RejectedExecutionHandler 接口
        //new ThreadPoolExecutor.AbortPolicy()
        //会直接抛出一个类型为 RejectedExecutionException 的 RuntimeException
        // new ThreadPoolExecutor.DiscardPolicy()
        //直接把新提交的任务丢掉
        //new ThreadPoolExecutor.DiscardOldestPolicy()
        //丢弃任务队列中的头结点(通常是存活时间最长的)
        //new ThreadPoolExecutor.CallerRunsPolicy()
        //一般来说使用这个,一个是不会丢弃
        //谁提交谁负责执行,给了线程池一定的缓冲期

        //corePoolSize 核心线程数，在上一课时我们讲过，合理的线程数量和任务类型，以及 CPU 核心数都有关系，
        // 基本结论是线程的平均工作时间所占比例越高，就需要越少的线程；线程的平均等待时间所占比例越高，就需要越多的线程

        //而对于最大线程数而言，如果我们执行的任务类型不是固定的，比如可能一段时间是 CPU 密集型，另一段时间是 IO 密集型，
        // 或是同时有两种任务相互混搭。那么在这种情况下，我们可以把最大线程数设置成核心线程数的几倍，以便应对任务突发情况


        //当然更好的办法是用不同的线程池执行不同类型的任务，让任务按照类型区分开，而不是混杂在一起，
        // 这样就可以按照上一课时估算的线程数或经过压测得到的结果来设置合理的线程数了，达到更好的性能。

        //但相比于无限增加任务或者线程数导致内存不足，进而导致程序崩溃，数据丢失还是要更好一些的，如果我们使用了 ArrayBlockingQueue 这种阻塞队列，再加上我们限制了最大线程数量，就可以非常有效地防止资源耗尽的情况发生。此时的队列容量大小和 maxPoolSize 是一个 trade-off，如果我们使用容量更大的队列和更小的最大线程数，就可以减少上下文切换带来的开销，但也可能因此降低整体的吞吐量；
        // 如果我们的任务是 IO 密集型，则可以选择稍小容量的队列和更大的最大线程数，这样整体的效率就会更高，不过也会带来更多的上下文切换。

        //线程工厂,有必要通过不同的名字来进行区分，所以可以传入能根据业务信息进行命名的线程工厂，
        //来自google.guava
        ThreadFactoryBuilder builder = new ThreadFactoryBuilder();
        ThreadFactory rpcFactory = builder.setNameFormat("zhaoxu-pool-%d").build();


        //最后一个参数是拒绝策略，我们可以根据业务需要，选择第 11 讲里的四种拒绝策略之一来使用：AbortPolicy，DiscardPolicy，DiscardOldestPolicy 或者 CallerRunsPolicy。除此之外，我们还可以通过实现 RejectedExecutionHandler 接口来实现自己的拒绝策略，在接口中我们需要实现 rejectedExecution 方法，
        // 在 rejectedExecution 方法中，执行例如打印日志、暂存任务、重新执行等自定义的拒绝策略，以便满足业务需求。
        ExecutorService executorService3 = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10),rpcFactory, new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 100; i++) {
            executorService2.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });

            //关闭线程池的五种方法


            //使用shutdown()关闭线程池,可以安全的关闭一个线程池,但是调用完shutdown()方法之后,
            // 线程池并不是立刻就关闭,因为这时线程池中有正在执行的任务,或者有阻塞队列中排队的任务
            // 这时执行shutdown(),首先将正在执行的,和队列中等待的任务都完成
            //才会彻底关闭,
            //shutdown()准确的效果是,调用后如果有新的任务被提交,会根据拒绝策略直接拒绝
            //并且将isShutdown标志置为true(即开始关闭流程,可能并未真的关闭)
            // 将执行未执行完的任务
            executorService3.shutdown();
            //isShutdown(),它返回true或者false判断线程池是否已经开始了关闭工作
            //也就是是否执行了shutdown或者shutdownNow方法,
            //在上面也提过了,如果isShutdown返回true并不代表线程池已经彻底关闭
            //仅仅代表线程池已经开始了关闭的流程
            executorService3.isShutdown();

            //检测线程池是否真正的终结,不仅代表线程池已经关闭,内部为空
            //同时代表线程池中的所有任务已经执行完毕
            executorService3.isTerminated();

            //可能会抛出InterruptedException
            //1.等待期间,线程池完全终结,返回true
            //2.等待期间,未终结,返回false
            //等待期间主线程被中断,抛出InterruptedException
            //可以设置尽量长的一段时间,来优雅的关闭线程
            try {
                executorService3.awaitTermination(1,TimeUnit.HOURS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //立刻关闭,给所以的线程发送interrupt中断信号,尝试中断(但是不是强制的中断,有的线程你要是没有while判断中断就不会响应)
            //然后将任务队列中的任务转移到一个list中返回
            executorService3.shutdownNow();

        }


        //ForkJoinPool 在jdk8中加入的,理念是拆分Fork 与汇总join,适合task可以拆分为多个subtask的情况,可以提高多核cpu的利用率




}

    class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

