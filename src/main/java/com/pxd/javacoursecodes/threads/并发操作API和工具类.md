并发操作API
Thread.join():用于当前线程等待另一个线程执行完后，再继续执行
Thread.yield()：线程由RUNNING状态转为READY状态，并且
Thread.sleep():线程睡眠一段时间，由RUNNING转为TIMED_WAITING状态，出让cpu时间片，但是不释放锁
Thread.interrupt()：当线程调用wait(),join(),sleep()的时候，中断其线程，并抛出异常

Object.wait()：出让cpu时间片，且释放锁
Object.notify()：唤醒某等待线程，让其重新获得锁
Object.notifyAll()：唤醒所有调用当前对象的wait方法的线程

LockSupport.park()：暂停当前线程
LockSupport.unpark()：恢复当前线程的执行

Excutor.execute(Runnable task): 执行可运行的任务

ExecutorService.execute(Runnable task):执行可运行的任务
ExecutorService.shutdown()：停止接收新任务，原来的任务继续执行
ExecutorService.shutdownNow()：停止接收新任务，原来的任务停止执行
ExecutorService.submit(Runnable task): 提交任务; 允许获取执行结果
ExecutorService.submit(Runnable task, T result): 提交任务（指定结果）; 控制|获取执行结果
ExecutorService.submit(Callable task): 提交任务; 允许控制任务和获取执行结果
ExecutorService.awaitTermination(timeOut, unit)：阻塞当前线程，返回是否线程都执行完

并发操作工具类：
AQS：JUC的核心基础组件，抽象了竞争的资源和线程队列
Semaphore：可以用于控制访问某个资源的线程数量，进而达到限流的效果
CountDownLatch：用于让所有线程都完成工作后，等待着的线程可以继续回复执行任务，不可以复用
CyclicBarrier：让一组线程达到一个屏障时被阻塞，直到最后一个线程到达时，屏障开门，CyclicBarrier可以被复用