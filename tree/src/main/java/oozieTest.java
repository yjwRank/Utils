/**
 * Created by yjw on 17-5-11.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.OozieClientException;
import org.apache.oozie.client.WorkflowJob;
import org.apache.oozie.client.WorkflowJob.Status;

import org.joda.time.DateTime;

public class oozieTest {

    public static void main(String[] args) throws OozieClientException, InterruptedException {
        /*OozieClient wc=new OozieClient("http://localhost:11000/oozie");
        Properties conf=wc.createConfiguration();
        conf.setProperty(OozieClient.APP_PATH,"hdfs://loclhost:9000/user/yjw/examples/apps/map-reduce");
        conf.setProperty("jobTracker","localhost:8032");
        conf.setProperty("inputDir","/user/yjw/examples/input-data/text");
        conf.setProperty("outputDir","map-reduce");
        conf.setProperty("nameNode","hdfs://localhost:9000");
        conf.setProperty("examplesRoot","examples");
        conf.setProperty("queueName","default");
        String jobId=wc.run(conf);
        System.out.println("workflow job submitted");

        while(wc.getJobInfo(jobId).getStatus()== Status.RUNNING){
            System.out.println("workflow job running...");
            Thread.sleep(10*1000);
        }
        System.out.println("workflow job completed");
        System.out.println(wc.getJobInfo(jobId));
        String rd = Double.toString(Math.random());
        rd = rd.substring(2, 7);
        long t = DateTime.now().getMillis();

        System.out.println(t+"-"+rd);*/

        OozieClient wc= new OozieClient("http://192.168.130.100:11000/oozie");
        Properties conf=wc.createConfiguration();
        conf.setProperty(OozieClient.APP_PATH,"hdfs://k2data-101.k2data.com.cn:8020/tmp/pasoozie/testworkflow");
        conf.setProperty("jobTracker","k2data-101.k2data.com.cn:8032");
        conf.setProperty("nameNode","hdfs://k2data-101.k2data.com.cn:8020");
        conf.setProperty("queueName","default");
        conf.setProperty("pasdir","pas");
        conf.setProperty("pasjobdir","testoozie");
        conf.setProperty(OozieClient.LIBPATH,"/tmp/pasoozie/testworkflow/lib/pas/lib");
        conf.setProperty(OozieClient.USER_NAME,"hdfs");
      //  conf.setProperty("pasdir","conf/test1.txt");
        //conf.setProperty("pasjobdir","/tmp/yjw/testjava/test2.txt");
        String jobId=wc.run(conf);
        while (wc.getJobInfo(jobId).getStatus()==Status.RUNNING){
            System.out.println("worklow job running");
            Thread.sleep(10*1000);
        }
        System.out.println("workflow job completed");



       /* OozieClient wc= new OozieClient("http://192.168.130.100:11000/oozie");
        Properties conf=wc.createConfiguration();
        conf.setProperty(OozieClient.APP_PATH,"hdfs://k2data-101.k2data.com.cn:8020/tmp/oozieActionTest");
        conf.setProperty("jobTracker","k2data-101.k2data.com.cn:8032");
        conf.setProperty("nameNode","hdfs://k2data-101.k2data.com.cn:8020");
        conf.setProperty("queueName","default");
        conf.setProperty("input","/tmp/wc/input/wc.txt");
        conf.setProperty("output","/tmp/wc/output");
        //  conf.setProperty("pasdir","conf/test1.txt");
        //conf.setProperty("pasjobdir","/tmp/yjw/testjava/test2.txt");
        String jobId=wc.run(conf);
        while (wc.getJobInfo(jobId).getStatus()==Status.RUNNING){
            System.out.println("worklow job running");
            Thread.sleep(10*1000);
        }
        System.out.println("workflow job completed");*/

    }
}
