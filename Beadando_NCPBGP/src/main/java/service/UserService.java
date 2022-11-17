package service;

import layout.UserLayout;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONArray;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserService {
    public JSONArray getXMl(String xmlName){
        JSONArray users = new JSONArray();
        try {
            ArrayList<ArrayList> usersArray = new ArrayList<>();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(xmlName);
            Document xml = db.parse(file);
            xml.normalize();
            Element rootElement = xml.getDocumentElement();
            
            
            NodeList nodes = rootElement.getChildNodes();
            Node node;
            
            for (int i = 0; i < nodes.getLength(); i++) {
                node = nodes.item(i);
                ArrayList<String> NODES = new ArrayList<>();
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    NodeList childNodesofTag = node.getChildNodes();
                    for (int j = 0; j < childNodesofTag.getLength(); j++) {
                        if (childNodesofTag.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            NODES.add(childNodesofTag.item(j).getTextContent());
                        }
                    }
                    usersArray.add(NODES);
                }
            }
            for (int i = 0; i < usersArray.size(); i++) {
                ArrayList<String> tmp = new ArrayList<>();
                for (int j = 0; j < usersArray.get(i).size(); j++) {
                    tmp.add(usersArray.get(i).get(j).toString());
                }
                users.put(new UserLayout(tmp).toJson());
            }
        } 
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return users;
    }    
}
