/**
 * Created by yjw on 17-6-12.
 */

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class testwritexml {
    public static void main(String[] args){
        StaxWriter configFile=new StaxWriter();
        configFile.setFile("config2.xml");
        try {
            configFile.saveConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
