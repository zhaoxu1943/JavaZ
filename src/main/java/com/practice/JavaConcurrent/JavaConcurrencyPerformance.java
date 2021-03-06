package com.practice.JavaConcurrent;

/**
 * @ClassName JavaConcurrencyPerformance
 * @Description 理解java多线程带来的性能问题
 *
 * 单线程程序是独立工作的，不需要与其他线程进行交互
 * 多线程之间则需要调度以及合作，调度与合作就会带来性能开销从而产生性能问题
 *
 * 一方面是线程调度
 * 上下文切换
 *操作系统就会按照一定的调度算法，给每个线程分配时间片，让每个线程都有机会得到运行。
 * 而在进行调度时就会引起上下文切换，上下文切换会挂起当前正在执行的线程并保存当前的状态，
 * 然后寻找下一处即将恢复执行的代码，唤醒下一个线程，以此类推，反复执行。但上下文切换带来的开销是比较大的，
 * 假设我们的任务内容非常短，比如只进行简单的计算，那么就有可能发生我们上下文切换带来的性能开销比执行线程本身内容带来的开销还要大的情况。
 *
 * 缓存失效
 * 一旦进行了线程调度，切换到其他线程，CPU就会去执行不同的代码，原有的缓存就很可能失效了，需要重新缓存新的数据，这也会造成一定的开销，所以线程调度器为了避免频繁地发生上下文切换，
 * 通常会给被调度到的线程设置最小的执行时间，也就是只有执行完这段时间之后，才可能进行下一次的调度，由此减少上下文切换的次数。
 *
 *
 * 一个方面是线程协作。
 *线程之间如果有共享数据，为了避免数据错乱，为了保证线程安全，就有可能禁止编译器和 CPU 对其进行重排序等优化，也可能出于同步的目的，反复把线程工作内存的数据 flush 到主存中，然后再从主内存 refresh 到其他线程的工作内存中，等等。这些问题在单线程中并不存在，
 * 但在多线程中为了确保数据的正确性，就不得不采取上述方法，因为线程安全的优先级要比性能优先级更高，这也间接降低了我们的性能。
 *
 *
 * @Author zhaoxu
 * @Date 2019/11/22 16:56
 * @Version 1.0
 **/
public class JavaConcurrencyPerformance {
}
