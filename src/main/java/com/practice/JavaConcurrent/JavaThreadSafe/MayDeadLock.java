package com.practice.JavaConcurrent.JavaThreadSafe;

/**
 * @ClassName MayDeadLock
 * @Description  死锁问题
 *
 * 竞争条件:如JavaThreadSafe类中WrongResult的例子,两个线程同时进行了i++的操作,对于JVM来说i++并非原子性,而是分了三部
 * 第一步,将i放入寄存器,第二步加一,第三部,写回内存,如果两个线程同时去执行,那么如果无法保证执行的顺序,就会发生结果的错乱
 *
 * 竞争条件定义:两个线程竞争同一资源,对资源访问顺序敏感,就存在竞争条件(理解:如果是加锁的原子性操作,顺序是随意的,都不会影响结果)
 *
 * 临界区:导致竞争条件的代码叫做临界区,也就是说i++就是一个临界区
 *
 * 死锁的定义:死锁是指两个或两个以上的进程（线程）在运行过程中因争夺资源而造成的一种僵局（Deadly-Embrace),若无外力作用，这些进程（线程）都将无法向前推进。
 * 死锁的几个结论:参与的进程数至少有2个
 *               参与死锁所有进程均等待资源
 *               参与死锁的进程至少有2个已经占有资源
 *               死锁进程是当前系统中进程集合的一个子集
 *               死锁会造成浪费大量的系统资源,甚至导致系统崩溃
 *
 * 饥饿（Starvation）指一个进程一直得不到资源。
 * 饥饿也是由于竞争,但是饥饿时抢不到cpu资源,饥饿一般不占有资源,死锁一定占有资源
 *
 * 可重用资源（永久性资源）
 * 可被多个进程多次使用，如所有硬件。
 * 只能分配给一个进程使用,不允许多个进程共享
 * 进程在对可重用资源使用时,要按请求,使用,释放的步骤
 * 每一类的可重用资源都是固定的,进程运行期间不可以创建和删除
 *
 *
 * 消耗性资源（临时性资源）
 * 又称临时性资源，是由进程在运行期间动态的创建和消耗的,通常是由生产者进程创建,消费者进程消耗
 * 最典型的可消耗资源是用于进程间通信的消息
 * 消耗性资源在进程的运行期间可以不断变化,有时为0
 * 进程在运行的过程中,可以不断创造可消耗性资源的单元,将他们放入该资源类的缓冲区中,增加数目(如消费者生产者模式的BlockingQueue)
 * 进程在运行过程中,可以请求若干个可消耗性资源,用于消耗,并不再返回
 *
 * 3.2 可抢占资源和不可抢占资源
 * 3.2.1 可抢占资源
 * 可抢占资源指某进程在获得这类资源后，该资源可以再被其他进程或系统抢占。对于这类资源是不会引起死锁的。
 * 时间片结束之后抢占cpu运算资源
 * CPU 和主存均属于可抢占性资源。
 *
 * 3.2.2 不可抢占资源
 * 一旦系统把某资源分配给该进程后，就不能将它强行收回，只能在进程用完后自行释放。
 *
 * 磁带机、打印机等属于不可抢占性资源
 * ————————————————

 *  死锁产生的原因
 *  竞争不可抢占资源
 *  不可抢占资源不够用,使线程争夺时陷入死锁,如两个人抢打印机
 *  竞争可消耗资源引起死锁
 *      如进程间通信,如果三个进程先创建消息,再接收,那么没有死锁,如果都先等待接收,再创建,那么永远等待,并产生死锁
 *  进程推进顺序不当,如o1,o2锁的例子,不是竞争同一资源,而是在等待对方的资源释放
 *
 *
 * 充分条件和必要条件
 * 充分条件
 * A 我达到了阿里的标准,通过了所有的面试   B进入阿里
 * A是B的充分条件,只要通过了所有面试,一定能进入阿里
 * 反推 我进入了阿里,一定通过所有的面试? 我可能是个名人,也能进入阿里
 *  所以是充分不必要条件
 *
 *
 * 必要条件
 * 如果能进入阿里,必然通过了技术面试
 * 那么小王通过了技术面试,不一定进入阿里,可能hr面挂了
 * 所以通过技术面试,是进入阿里的必要不充分条件
 *
 *
 * 对于我来说
 * 通过所有面试,进入阿里是充要条件,因为我不是名人
 * 过了所有面试,就进入阿里
 * 进了阿里说明我过了所有面试
 *
 *
 *
 *产生死锁的四个必要条件,针对上面的逻辑例子,我产生了死锁,那么必然有必要条件,有了必要条件,不一定有死锁,如果破坏了任意一个必要条件,就一定没有死锁
 * 1.互斥条件
 *      进程要求对所分配的资源(如打印机)进行排他性控制,即一段时间仅被某一个进程占有,如果有其他进程请求,只能等待
 * 2.不可剥夺条件
 *      进程在资源未使用完毕,不能被强行夺走,只能主动释放
 * 3.请求与保持条件
 *      进程保持了一个资源,又提出了请求,请求被阻塞,自己的资源不释放
 * 4.循环等待条件
 *      存在一种进程资源的循环等待链,每一个进程已经获得的资源同时被下一个进程请求.
 *      但是只是必要条件,因为外部可以给资源
 *      如果是死锁等待环,那么Pi等待的资源必须由P(i+1)来满足
 *      而循环等待条件则无此限制,环外可以给资源去解除死锁状态
 *
 *预防死锁
 * 破坏“不可抢占”条件：
 * 破坏“不可抢占”条件就是允许对资源实行抢夺。
 * 方法一：如果占有某些资源的一个进程进行进一步资源请求被拒绝，则该进程必须释放它最初占有的资源，如果有必要，可再次请求这些资源和另外的资源。
 *
 * 破坏“占有并等待”条件:
 *要求每个进程提出新的资源申请前，释放它所占有的资源
 *
 *解除死锁
 *  资源剥夺法。挂起某些死锁进程，并抢占它的资源
 *  撤销进程法。强制撤销部分、甚至全部死锁进程并剥夺这些进程的资源
 *  进程回退法。让一（多）个进程回退到足以回避死锁的地步
 *
 *
 * 那么在实际开发中我们如何查看死锁
 * jps+jstack
 *
 * jps
 *  D:\myproject\JavaConcentration>jps
 * 4644 Launcher
 * 14520
 * 14808 Jps
 * 6136 MayDeadLock
 * 15868 KotlinCompileDaemon
 *
 * 发现我们的类 MayDeadLock 的pid
 *
 * jstack -F 6136  //-F是说当线程挂起时也可以打印
 *
 *
Found one Java-level deadlock:
=============================

THread0等待一个Object类型的monitor锁,正在被Thread1 拿着
"Thread-0":
waiting to lock Monitor@0x000000001d1b25a8 (Object@0x000000076b5ed3c8, a java/lang/Object),
which is held by "Thread-1"
"Thread-1":
waiting to lock Monitor@0x000000001d1b3a48 (Object@0x000000076b5ed3b8, a java/lang/Object),
which is held by "Thread-0"
THread1等待一个Object类型的monitor锁,正在被Thread0 拿着

Found a total of 1 deadlock.

Thread 1: (state = BLOCKED)

 *
 *
 *
 * A thread dump is a text file that contains a relatively short snapshot of the key aspects of the state of that JVM.
 * 线程转储是一个文本文件，包含了JVM状态的关键方面的一个相对较短的快照。
 *  jstack用于生成java虚拟机当前时刻的线程快照
 *
 *
 * 或者使用Jconsole直接连接线程 查看死锁
 *
 *
 *
 * @Author zhaoxu
 * @Date 2019/11/19 13:58
 * @Version 1.0
 **/
public class MayDeadLock {

    Object o1 = new Object();
    Object o2 = new Object();


    public void thread1() throws InterruptedException {
        synchronized (o1) {
            Thread.sleep(500);
            synchronized (o2) {
                System.out.println("线程1成功拿到两把锁");
            }
        }
    }

    public void thread2() throws InterruptedException {
        synchronized (o2) {
            Thread.sleep(500);
            synchronized (o1) {
                System.out.println("线程2成功拿到两把锁");
            }
        }
    }

    public static void main(String[] args) {
        MayDeadLock mayDeadLock = new MayDeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mayDeadLock.thread1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    mayDeadLock.thread2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }



}
