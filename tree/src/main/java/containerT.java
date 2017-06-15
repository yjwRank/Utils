import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;

/**
 * Created by yjw on 17-4-10.
 */
public class containerT implements Runnable{
    private String name;
    private Thread t;
    public containerT(String name){
        this.name=name;
    }

    public void start(){
        if(t==null){
            t=new Thread(this,name);
            t.start();
        }
    }
    @Override
        public void run() {
            System.out.println("running:"+name);
            Socket client= null;
            try {
                client = new Socket("127.0.0.1",9090);


        JSONObject json=new JSONObject();
        json.put("input","/opt/matlabadd/testxl.csv");
        json.put("output","/disk1/yarn/nm/usercache/hdfs/appcache/"+Thread.currentThread().getId()+"container---"+Thread.currentThread().getName());
        json.put("jarfile",new File("/opt/matlabadd/testxl.Class1.jarm"));
        json.put("resultnum",1);
                json.put("timeout",600_000);

                DataOutputStream out=new DataOutputStream(client.getOutputStream());
                out.writeUTF(json.toJSONString());
              //  PrintWriter out=new PrintWriter(client.getOutputStream(),true);
               // out.println(json.toString());
                System.out.println("client send:"+json.toString());
              // BufferedReader input=new BufferedReader(new InputStreamReader(client.getInputStream()));
               // String answer=input.readLine();
               // System.out.println("accept:"+answer);

               // input.close();

                DataInputStream in=new DataInputStream(client.getInputStream());
                System.out.println(in.readUTF());
                in.close();out.close();
               // ObjectOutputStream outputStream=new ObjectOutputStream(client.getOutputStream());
              //  outputStream.writeObject(json.toJSONString());
    } catch (IOException e) {
        e.printStackTrace();
    }

        }


    public static void main(String[] args){
        long start=System.currentTimeMillis();
        containerT c1=new containerT("1");c1.start();
        //containerT c2=new containerT("2");c2.start();
        //containerT c3=new containerT("3");c3.start();
        //containerT c4=new containerT("4");c4.start();
        System.out.println("total:"+(System.currentTimeMillis()-start));

         //  String ti="{\"input\":\"\\/disk1\\/yarn\\/nm\\/usercache\\/hdfs\\/appcache\\/application_1493027531698_0601\\/container_e24_1493027531698_0601_01_000002\\/48\\/InputTmp_149387644401056394\\/ts_yearmonthday=20160117\\/20160117_000000_0_wt.csv\",\"resultnum\":1,\"output\":\"\\/disk1\\/yarn\\/nm\\/usercache\\/hdfs\\/appcache\\/application_1493027531698_0601\\/container_e24_1493027531698_0601_01_000002\\/48\\/OutputTmp_149387644401056394\\/ts_yearmonthday=20160117\\/Rout_20160117_000000_0_wt.csv\",\"jarfile\":/disk1/yarn/nm/usercache/hdfs/appcache/application_1493027531698_0601/container_e24_1493027531698_0601_01_000002/48/Matlabsrc/file2.testfile.jarm,\"timeout\":600000}";
       /*     String input="input/eferfe/aerfa";
        String output="output/e/rfaer";
        String test="test/erfaer";
        JSONObject json1=new JSONObject();
        json1.put("input",input);
        json1.put("output",output);
        json1.put("test",test);
        System.out.println(json1.toString());
        System.out.println(json1.toJSONString());
        String ti=json1.toJSONString();
       */


       /* System.out.println(modifyJson(ti));
        String[] test=ti.split("");
        System.out.println(ti);
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<test.length;i++){
            if(test[i].equals("\\")){
                ;
            }else{
                sb.append(test[i]);
            }
        }
        System.out.println(sb.toString());
        String tmpstr=sb.toString().substring(1,sb.toString().length()-1);
        String[] item=tmpstr.split(",");
        StringBuffer sb2=new StringBuffer();
        for(int i=0;i<item.length;i++){
            if(item[i].contains("jarfile")){
                String[] properties=item[i].split(":");
                sb2.append(properties[0]+":\""+properties[1]+"\"");
            }else{
                sb2.append(item[i]);
            }
            sb2.append(",");

        }
        String terminal=sb2.toString().substring(0,sb2.toString().length()-1);
        String te="{"+terminal+"}";
        System.out.println(te);
            JSONParser parser=new JSONParser();
            try {
                JSONObject json=(JSONObject)parser.parse(te);
                System.out.println(json);
            } catch (ParseException e) {
                e.printStackTrace();
            }*/

    }


    public static String modifyJson(String instream){
        StringBuffer sb=new StringBuffer();
        String[] snum=instream.split("");
        for(int i=0;i<snum.length;i++){
            if(snum[i].equals("\\")){
                ;
            }else{
                sb.append(snum[i]);
            }
        }
        StringBuffer sbItem=new StringBuffer();
        String[] item=sb.toString().substring(1,sb.toString().length()-1).split(",");
        for(int i=0;i<item.length;i++){
            if(item[i].contains("jarfile")){
                String[] kv=item[i].split(":");
                sbItem.append(kv[0]+":\""+kv[1]+"\"");
            }else{
                sbItem.append(item[i]);
            }
            sbItem.append(",");
        }
        return "{"+sbItem.toString().substring(0,sbItem.length()-1)+"}";

    }

}
