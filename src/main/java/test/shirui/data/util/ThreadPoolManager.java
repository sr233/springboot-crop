package test.shirui.data.util;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ThreadPoolManager {

    private static ThreadPoolManager sThreadPoolManager = new ThreadPoolManager();

    private static final int SIZE_MIN_POOP = 15;

    private static final int SIZE_MAX_POOL = 15;

    private ThreadPoolManager() {
        if (sThreadPoolManager != null) { // 避免反射 readResolver可解决序列化产生实例的问题
            throw new RuntimeException();
        }
    }

    public static ThreadPoolManager getInstance() {
        return sThreadPoolManager;
    }

    private final ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(SIZE_MIN_POOP, SIZE_MAX_POOL, 0L, TimeUnit.MILLISECONDS,
    new LinkedBlockingQueue<Runnable>());

    public void addExecuteTask(Runnable task) {
        if (null != task) {
            mThreadPool.execute(task);
//            mThreadPool.submit()
        }
    }
}
