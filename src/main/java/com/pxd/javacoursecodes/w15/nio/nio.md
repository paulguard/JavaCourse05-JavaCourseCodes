Nio 也就是non-blocking io,意为无阻塞IO，主要通过把与IO处理的相关的逻辑分给单独的线程去做，而把业务处理分给其他线程去做。
因为IO处理是不占据cpu资源的，而业务处理则是需要cpu处理的，这样一来，就可以让cpu不用等待io处理结束才继续工作，而是可以在有任务的时候不间断的最大效率地处理
NIO是一种

NIO是一种同步非阻塞，其三大核心组件：
1. Channel
2. Buffer
3. Selector

selector监听多个Channel，数据从channel写到buffer，或者从buffer到channel。
数据可以经由channel直接从server到client
而Buffer是一块直接内存，无需参与GC，因此不会影响JVM的性能

netty框架则把一些NIO的底层操作封装起来，方便我们进行使用