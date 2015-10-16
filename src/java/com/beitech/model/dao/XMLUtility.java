package com.beitech.model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Yesid
 */
public class XMLUtility {

    protected final String URL;
    ResourceBundle property;
    private InputStream inputStream;
    
    
    public XMLUtility() {
        this.property = DAOFactory.getInstance().getProperty();
        this.URL = property.getString("XML_URL");
    }
    
    public Document connet(){
    
        Document document = null;
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            URL url = new URL(URL);
            inputStream = url.openStream();
            document = db.parse(inputStream);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(XMLUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return document;
    }
    
    public void close(){
        if(inputStream!=null){
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(XMLUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}