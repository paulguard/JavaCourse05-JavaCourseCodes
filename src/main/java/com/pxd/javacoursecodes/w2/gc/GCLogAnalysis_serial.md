PS D:\demo> java -XX:+PrintGCDetails -XX:+UseSerialGC -Xms1g -Xmx1g  GCLogAnalysis
正在执行...
[GC (Allocation Failure) [DefNew: 279616K->34944K(314560K), 0.0333584 secs] 279616K->84955K(1013632K), 0.0336461 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
[GC (Allocation Failure) [DefNew: 314450K->34943K(314560K), 0.0465978 secs] 364461K->170058K(1013632K), 0.0468074 secs] [Times: user=0.01 sys=0.03, real=0.05 secs]
[GC (Allocation Failure) [DefNew: 314559K->34944K(314560K), 0.0354303 secs] 449674K->251788K(1013632K), 0.0355940 secs] [Times: user=0.02 sys=0.02, real=0.03 secs]
[GC (Allocation Failure) [DefNew: 314560K->34943K(314560K), 0.0347857 secs] 531404K->328352K(1013632K), 0.0349471 secs] [Times: user=0.00 sys=0.03, real=0.04 secs]
[GC (Allocation Failure) [DefNew: 314559K->34943K(314560K), 0.0343014 secs] 607968K->401223K(1013632K), 0.0344246 secs] [Times: user=0.00 sys=0.03, real=0.04 secs]
[GC (Allocation Failure) [DefNew: 314250K->34943K(314560K), 0.0374995 secs] 680529K->480905K(1013632K), 0.0377512 secs] [Times: user=0.02 sys=0.03, real=0.04 secs]
[GC (Allocation Failure) [DefNew: 314559K->34943K(314560K), 0.0361086 secs] 760521K->559451K(1013632K), 0.0363808 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
[GC (Allocation Failure) [DefNew: 314559K->34943K(314560K), 0.0338042 secs] 839067K->631175K(1013632K), 0.0339411 secs] [Times: user=0.03 sys=0.02, real=0.03 secs]
[GC (Allocation Failure) [DefNew: 314559K->34941K(314560K), 0.0356930 secs] 910791K->708443K(1013632K), 0.0359624 secs] [Times: user=0.00 sys=0.03, real=0.04 secs]
[GC (Allocation Failure) [DefNew: 314557K->314557K(314560K), 0.0001541 secs][Tenured: 673501K->372099K(699072K), 0.0382749 secs] 988059K->372099K(1013632K), [Metaspace: 2712K->2712K(1056768K)], 0.0386500 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
[GC (Allocation Failure) [DefNew: 279616K->34943K(314560K), 0.0103994 secs] 651715K->458059K(1013632K), 0.0105631 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
[GC (Allocation Failure) [DefNew: 314559K->34942K(314560K), 0.0131245 secs] 737675K->533828K(1013632K), 0.0132975 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
[GC (Allocation Failure) [DefNew: 314558K->34943K(314560K), 0.0131628 secs] 813444K->611033K(1013632K), 0.0134975 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
[GC (Allocation Failure) [DefNew: 314559K->34943K(314560K), 0.0139767 secs] 890649K->690802K(1013632K), 0.0142597 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
[GC (Allocation Failure) [DefNew: 314559K->314559K(314560K), 0.0003306 secs][Tenured: 655858K->390386K(699072K), 0.0420864 secs] 970418K->390386K(1013632K), [Metaspace: 2712K->2712K(1056768K)], 0.0428644 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
执行结束!共生成对象次数:16236
Heap
 def new generation   total 314560K, used 132170K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,  47% used [0x00000000c0000000, 0x00000000c8112be8, 0x00000000d1110000)
  from space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
  to   space 34944K,   0% used [0x00000000d1110000, 0x00000000d1110000, 0x00000000d3330000)
 tenured generation   total 699072K, used 390386K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
   the space 699072K,  55% used [0x00000000d5550000, 0x00000000ed28caf0, 0x00000000ed28cc00, 0x0000000100000000)
 Metaspace       used 2718K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 297K, capacity 386K, committed 512K, reserved 1048576K
===========================================================================================
分析：共进行了15次GC，其中2次进行了老年代的回收

第一次回收，年轻代 273M -> 34M(一个survivor区的大小), 堆占用 273M -> 83M , 说明有大约49M的对象晋升到了老年代 花费30ms
第二次回收，年轻代 307M -> 34M, 堆占用 356M -> 166M , 说明有老年代占用132M，又有83M的对象晋升到老年代  花费50ms
第三次回收，年轻代 307M -> 34M, 堆占用 439M -> 246M , 说明有老年代占用212M，又有80M的对象晋升到老年代  花费30ms
...
第十次回收，年轻代 307M -> 307M,Eden和一个Survivor区已经满了，此时必须要进行MajorGC了：老年代：658M -> 363M，堆总的大小 964M -> 363M，也就是年轻代的对象全部晋升到了老年代， 回收了295M，花费40ms
第十一次回收，年轻代 273M -> 34M (又回到第一次了), 堆占用 636M -> 447M, 老年代占用413M，花费10ms
第十二次回收，年轻代 307M -> 34M (又回到第一次了), 堆占用 720M -> 521M, 老年代占用487M，花费13ms
...
第十五此回收，年轻代又满了，又需要进行majorGC，老年代：640M -> 381M ,堆占用 947M -> 381M，说明年轻代的对象都已经被回收或者晋升至老年代，花费 42ms



==============================================================================================

正在执行...
[GC (Allocation Failure) [DefNew: 838912K->104831K(943744K), 0.0875249 secs] 838912K->209178K(3040896K), 0.0958887 secs] [Times: user=0.03 sys=0.06, real=0.10 secs]
[GC (Allocation Failure) [DefNew: 943743K->104831K(943744K), 0.1066188 secs] 1048090K->357692K(3040896K), 0.1068907 secs] [Times: user=0.06 sys=0.03, real=0.11 secs]
[GC (Allocation Failure) [DefNew: 943743K->104831K(943744K), 0.0735463 secs] 1196604K->494028K(3040896K), 0.0736533 secs] [Times: user=0.05 sys=0.03, real=0.07 secs]
[GC (Allocation Failure) [DefNew: 943743K->104831K(943744K), 0.0759957 secs] 1332940K->645171K(3040896K), 0.0762445 secs] [Times: user=0.06 sys=0.01, real=0.08 secs]
执行结束!共生成对象次数:12910
Heap
 def new generation   total 943744K, used 207284K [0x0000000700000000, 0x0000000740000000, 0x0000000740000000)
  eden space 838912K,  12% used [0x0000000700000000, 0x000000070640d3f8, 0x0000000733340000)
  from space 104832K,  99% used [0x0000000733340000, 0x000000073999fff0, 0x00000007399a0000)
  to   space 104832K,   0% used [0x00000007399a0000, 0x00000007399a0000, 0x0000000740000000)
 tenured generation   total 2097152K, used 540339K [0x0000000740000000, 0x00000007c0000000, 0x00000007c0000000)
   the space 2097152K,  25% used [0x0000000740000000, 0x0000000760face70, 0x0000000760fad000, 0x00000007c0000000)
 Metaspace       used 2719K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 297K, capacity 386K, committed 512K, reserved 1048576K