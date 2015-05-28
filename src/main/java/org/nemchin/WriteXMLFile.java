package org.nemchin;

/**
 * Created by roman on 28.05.15.
 */
import java.io.FileWriter;
import java.io.IOException;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class WriteXMLFile {
    public static void main(String[] args) {

        try {

            Element company = new Element("company");
            Document doc = new Document(company);
            doc.setRootElement(company);

            Element staff = new Element("staff");
            staff.setAttribute(new Attribute("id", "1"));
            staff.addContent(new Element("firstname").setText("Hikolay"));
            staff.addContent(new Element("lastname").setText("Ivanov"));
            staff.addContent(new Element("nickname").setText("Kolya"));
            staff.addContent(new Element("salary").setText("xxxxx"));

            doc.getRootElement().addContent(staff);

            Element staff2 = new Element("staff");
            staff2.setAttribute(new Attribute("id", "2"));
            staff2.addContent(new Element("firstname").setText("Oleg"));
            staff2.addContent(new Element("lastname").setText("Berestov"));
            staff2.addContent(new Element("nickname").setText("Leha"));
            staff2.addContent(new Element("salary").setText("xxxxxxx"));

            doc.getRootElement().addContent(staff2);

            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("/home/roman/file2.xml"));

            System.out.println("File Saved!");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}