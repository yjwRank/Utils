import java.io.IOException;
import java.util.Date;

/**
 * Created by yjw on 17-4-11.
 */
public class memorytest {
    public static void main(String[] agrs) throws IOException {
        Runtime run = Runtime.getRuntime();
        System.in.read();   // 暂停程序执行

// System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + (run.totalMemory()-run.freeMemory()) );
        run.gc();
        System.out.println("time: " + (new Date()));
// 获取开始时内存使用量
        long startMem = run.totalMemory()-run.freeMemory();
        System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + startMem );

        String str = "";
        for(int i=0; i<50000; ++i){
            str += i;
        }

        System.out.println("time: " + (new Date()));
        long endMem = run.totalMemory()-run.freeMemory();
        System.out.println("memory> total:" + run.totalMemory() + " free:" + run.freeMemory() + " used:" + endMem );
        System.out.println("memory difference:" + (endMem-startMem));
    }
}
