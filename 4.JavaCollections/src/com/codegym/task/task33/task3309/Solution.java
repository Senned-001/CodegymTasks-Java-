package com.codegym.task.task33.task3309;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

/*
Comments inside XML

*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, document);

        document.getDocumentElement().normalize();

        NodeList list = document.getElementsByTagName(tagName);

        if (list.getLength()==0) {
        } else {
            for (int i = 0; i < list.getLength(); i++) {
                list.item(i).getParentNode().insertBefore(document.createComment(comment), list.item(i));
            }
        }
        //Output the document(formatting)
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");    // this allows you make \n
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.transform(source, result);


        return writer.toString();
    }

    public static void main(String[] args) {

    }
}