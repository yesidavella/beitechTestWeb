package com.beitech.model.dao;

import com.beitech.model.ReferenceForm;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Yesid
 */
public class ReferenceXML extends XMLUtility implements ReferenceDao {

    @Override
    public ReferenceForm getReferenceById(String reference) {

        ReferenceForm referenceForm = null;

        Document document = connet();
        NodeList cubeNodeList = document.getElementsByTagName("Cube");

        for (int i = 0; i < cubeNodeList.getLength(); i++) {

            Node cubeNode = cubeNodeList.item(i);
            boolean match = hasNodeAttNameAndValue("currency", reference, cubeNode);

            if (match) {
                referenceForm = new ReferenceForm();
                referenceForm.setReference(getAttributeValue("currency", cubeNode));
                referenceForm.setRate(Double.valueOf(getAttributeValue("rate", cubeNode)));
                
                i = cubeNodeList.getLength();
            }
        }

        close();
        return referenceForm;
    }

    private boolean hasNodeAttNameAndValue(String name, String value, Node cubeNode) {

        NamedNodeMap attributes = cubeNode.getAttributes();

        for (int j = 0; j < attributes.getLength(); j++) {

            String attName = attributes.item(j).getNodeName();
            String attValue = attributes.item(j).getNodeValue();

            if (attName.equalsIgnoreCase(name) && attValue.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    private String getAttributeValue(String name, Node cubeNode) {

        NamedNodeMap attributes = cubeNode.getAttributes();

        for (int j = 0; j < attributes.getLength(); j++) {

            String attName = attributes.item(j).getNodeName();

            if (attName.equalsIgnoreCase(name)) {
                return attributes.item(j).getNodeValue();
            }
        }
        return null;
    }

    @Override
    public boolean updateReference(ReferenceForm referenceForm) {
        throw new UnsupportedOperationException("Not supported yet for the class "+Class.class.getName()); //To change body of generated methods, choose Tools | Templates.
    }
}