/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author andra
 */
public class UserLog {
    public void handleUser(User us, String xmlName){
    
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File f = new File(xmlName);
            Document xml = builder.parse(f);
            xml.normalize();
            
            Element users = xml.getDocumentElement();
            Element user = xml.createElement("user");
            
            Element name = xml.createElement("name");
            name.setTextContent(us.getName());
            
            Element age = xml.createElement("age");
            age.setTextContent(Integer.toString(us.age));
            
            Element status = xml.createElement("status");
            status.setTextContent(us.getStatus().toString());
            
            user.appendChild(name);
            user.appendChild(age);
            user.appendChild(status);
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(xml);
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
   
}
