相同内存大小（1g）情况下：
1. SerialGC消耗的GC的时间基本在0.03~0.05秒之间
2. ParallelGC中，GC的时间基本在0.01秒以下
3. CMS的YoungGC用的也是ParallelGC,所以消耗时间也在0.01秒以下
4. G1的YoungGC的消耗时间也都在0.01秒以下，因为内存不大，所以优势体现不明显

内存增加（3g）的情况下：
1. SerialGC消耗的YoungGC的时间基本在0.08~0.1秒之间,GC时间明显增加
2. ParallelGC中，YoungGC的时间基本在0.02~0.03秒，没有明显增加
3. CMS的YoungGC用的也是ParallelGC,所以消耗时间也在0.01~0.03秒之间
4. G1的GC消费时间依然在0.01秒左右，并未受到很大的影响

结论：
相同内存，并且内存较小的情况下，横向对比，SerialGC的消耗时间最长，而ParallelGC，GMC和G1消耗时间比较接近
内存增大的情况下，横向对比，SerialGC的消耗时间增加也变长了，ParallelGC与CMS稍有增加，但并不明显，而G1回收器并没有受到很大的影响。
因此Serial的回收性能最低，G1回收器适合以高性能回收较大的内存空间
在YoungGC方面，ParallelGC与CMS性能接近
在FullGC方面，则CMS更胜一筹，因为它用6阶段让回收的过程尽可能减少STW的时间