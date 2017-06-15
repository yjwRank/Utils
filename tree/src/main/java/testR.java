import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by yjw on 17-5-2.
 */
public class testR {

    public static void main(String[] args) throws IOException {
        Configuration conf=new Configuration();
        conf.addResource(new URL("http://:8088/conf"));
        Path dstPath=new Path("/tmp/hello.txt");

        StringBuffer sb=new StringBuffer();
        sb.append(",");
        sb.append("testaerga.csv");
        System.out.println(sb.toString().substring(1));
       // fs.copyFromLocalFile(localpath,dstPath);
        List<Path> files=new LinkedList<>();
        files.add(new Path("hdfs://namespace1/eterag.csv"));

        StringBuffer paths=new StringBuffer();


    }



    public static void main3(String[] args) throws IOException {

        String mapstr="{\n" +
                "    \"pas.multi.source.info\": [\n" +
                "        {\n" +
                "            \"type\": \"ObjectA\",\n" +
                "            \"classid\": 19,\n" +
                "            \"groupCondition\": [\n" +
                "                \"tid\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"ObjectB\",\n" +
                "            \"classid\": 20,\n" +
                "            \"groupCondition\": [\n" +
                "                \"fid\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String tt="aeSFEFEaio1iorgaeEFEEFjio3";
        System.out.println(tt.toLowerCase());
        ObjectMapper mapper=new ObjectMapper();
        Map<String,Object> map=mapper.readValue(mapstr,HashMap.class);
        System.out.println(map);
        ObjectMapper mp=new ObjectMapper();
        String json=mp.writeValueAsString(map.get("pas.multi.source.info"));
        System.out.println(json);


    }


    public static void main2(String[] args) {
        List<Map<String, Object>> tes = new LinkedList<>();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("name", "column1");
        m1.put("type", "Character");
        m1.put("value", "hello");
        Map<String, Object> m2 = new HashMap<>();
        m2.put("name", "column2");
        m2.put("type", "Integer");
        m2.put("value", "1");
        Map<String,Object> m3=new HashMap<>();
        m3.put("name","column3");
        m3.put("type","Numeric");
        m3.put("value","3.1415926");
        Map<String,Object> m4=new HashMap<>();
        m4.put("name","column4");
        m4.put("type","Logical");
        m4.put("value","false");
        tes.add(m1);tes.add(m2);tes.add(m3);tes.add(m4);
        System.out.println(tes);

        StringBuffer sb=new StringBuffer();
        /*for(Map<String,Object> tmp:tes){
            System.out.println(tmp);

            String type=tmp.get("type").toString().toUpperCase();
            Object value=tmp.get("value");

            sb.append(" , ");
            switch (type){
                case "STRING":
                    sb.append("'");
                    if(value instanceof String){
                        sb.append(String.valueOf(value));
                    }else{
                        String tmpvalue=String.valueOf(value);
                        sb.append(tmpvalue);
                    }
                    sb.append("'");
                    break;
                case "INTEGER":
                    if(value instanceof Integer){
                        sb.append(Integer.valueOf(value.toString()));
                    }else{
                        int tmpvalue=Integer.valueOf(String.valueOf(value));
                        sb.append(tmpvalue);
                    }
                    break;
                case "DOUBLE":
                    if(value instanceof Double){
                        sb.append(Double.valueOf(value.toString()));
                    }else{
                        double tmpvalue2=Double.valueOf(String.valueOf(value));
                        sb.append(tmpvalue2);
                    }
                    break;
                case "BOOLEAN":
                    if(value instanceof Boolean){
                        sb.append(Boolean.valueOf(value.toString()));
                    }else{
                        String tmpvalue=String.valueOf(value);
                        sb.append(tmpvalue);
                    }
                    break;
                default:
                    break;
            }
        }*/

        System.out.println(sb.toString());


        String params="[\n" +
                "        {\n" +
                "            \"name\": \"column1\",\n" +
                "            \"type\": \"Character\",\n" +
                "            \"value\": \"hello\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"column2\",\n" +
                "            \"type\": \"Integer\",\n" +
                "            \"value\": 998\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"column3\",\n" +
                "            \"type\": \"Numeric\",\n" +
                "            \"value\": 3\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"column4\",\n" +
                "            \"type\": \"Logical\",\n" +
                "            \"value\": true\n" +
                "        }\n" +
                "    ]";

        params="[\n" +
                "            {\n" +
                "                \"name\": \"dcols\",\n" +
                "                \"type\": \"STRING\",\n" +
                "                \"value\": \"x,y\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"centers\",\n" +
                "                \"type\": \"INT\",\n" +
                "                \"value\": \"2\"\n" +
                "            }\n" +
                "        ]";
        System.out.println(params);
        try {
            System.out.println(setParams(params));
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(Integer.MAX_VALUE);
    }


    public static String setParams(String paramJson) throws NumberFormatException, IOException {
        StringBuffer sb=new StringBuffer();
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String,Object>> listmap=mapper.readValue(paramJson,List.class);
        for(Map<String,Object> list:listmap){
            sb.append(",");
            String name=list.get("name").toString();
            String type=list.get("type").toString().toUpperCase();
            Object value=list.get("value");

            switch (type){
                case "STRING":
                    String append_value=null;
                    if(value instanceof String){
                        append_value=value.toString();
                    }else{
                        append_value=String.valueOf(value);
                    }
                    sb.append(name+"='"+append_value+"'");
                    break;
                case "INT":
                    int append_int=-1;
                    if(value instanceof Integer){
                        append_int=Integer.valueOf(value.toString());
                    }else{
                        append_int=Integer.valueOf(String.valueOf(value));
                    }
                    sb.append(name+"="+append_int);
                    break;
                case "DOUBLE":
                    double append_double=0;
                    if(value instanceof Double){
                        append_double=Double.valueOf(value.toString());
                    }else{
                        append_double=Double.valueOf(String.valueOf(value));
                    }
                    sb.append(name+"="+append_double);
                    break;
                case "BOOLEAN":
                    boolean append_boolean=false;
                    if(value instanceof Boolean){
                        append_boolean=Boolean.valueOf(value.toString());
                    }else{
                        append_boolean=Boolean.valueOf(String.valueOf(value));
                    }
                    sb.append(name+"="+append_boolean);
                    break;
                default:

                    break;
            }
        }
        return sb.toString();
    }


    public static int numberFormatInteger(Object value)throws NumberFormatException{
        int append_integer=-1;
        if(value instanceof Integer){
            append_integer=Integer.valueOf(value.toString());
        }else{
            append_integer=Integer.valueOf(String.valueOf(value));
        }
        return append_integer;
    }

    public static double numberFormatDouble(Object value)throws NumberFormatException{
        double append_double=0;
        if (value instanceof Double) {
            append_double = Double.valueOf(value.toString());
        } else {
            append_double = Double.valueOf(String.valueOf(value));
        }
        return append_double;
    }

    public static String numberFormatString(Object value)throws NumberFormatException{
        String append_value=null;
        if (value instanceof String) {
            append_value = value.toString();
        } else {
            append_value = String.valueOf(value);
        }
        return append_value;
    }

    public  static boolean numberFormatBoolean(Object value)throws NumberFormatException{
        boolean append_boolean=false;
        if (value instanceof Boolean) {
            append_boolean = Boolean.valueOf(value.toString());
        } else {
            append_boolean = Boolean.valueOf(String.valueOf(value));
        }
        return append_boolean;
    }

    public static String numberFormatComplex(Object value)throws NumberFormatException{
        String append_complex=null;
        String v=String.valueOf(value);
        Pattern p=Pattern.compile("\\di");
        Matcher m=p.matcher(v);
        if(v.contains("i")){

        }else{
            ;
        }
        return append_complex;
    }

    public static String setParams2(String paramJson) throws IOException, NumberFormatException {
        StringBuffer sb=new StringBuffer();
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> listmap = mapper.readValue(paramJson, List.class);
        for (Map<String, Object> list : listmap) {
            sb.append(",");
            String name = list.get("name").toString();
            String type = list.get("type").toString().toUpperCase();
            Object value = list.get("value");

            switch (type){
                case "LOGICAL":
                    boolean append_boolean=false;
                    sb.append(name+"="+String.valueOf(numberFormatBoolean(value)).toUpperCase()+":boolean");
                    break;
                case "NUMERIC":
                    boolean jdouble=false;
                    if(value instanceof Double){
                        sb.append(name+"="+numberFormatDouble(value)+":double");
                    }
                    if(value instanceof Integer){
                        sb.append(name+"="+numberFormatInteger(value)+":integer");
                    }
                    break;
                case "INTEGER":
                    int append_integer=-1;
                    sb.append(name+"="+numberFormatInteger(value)+":integer2");
                    break;
                case "COMPLEX":
                    break;
                case "CHARACTER":
                    String append_str=null;
                    sb.append(name+"='"+numberFormatString(value)+"'"+":string");
                    break;
                case "RAW":
                    break;
                default:
                    System.out.println("unsupport");
                    break;
            }
        }

        return sb.toString();
    }
}
