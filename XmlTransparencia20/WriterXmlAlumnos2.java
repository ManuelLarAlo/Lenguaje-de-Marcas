package XmlTransparencia20;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class WriterXmlAlumnos2 
{
	public static void main(String[] args)
	{
		// Create a new factory of documents builder
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		// Create a new instance of document builder
		try
		{
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			XmlReader xmlReader 	  = new XmlReader() ;
			Alumno[] alumnos    	  = xmlReader.readXml(documentBuilder) ;
			
			XmlProcessor xmlProcessor = new XmlProcessor() ;
			Result result 			  = xmlProcessor.procesarAlumnos(alumnos);
			
			XmlWriter xmlWriter		  = new XmlWriter() ;
			xmlWriter.writeXml(documentBuilder, result) ;
		}
		catch (ParserConfigurationException parserConfigurationException)
		{
			parserConfigurationException.printStackTrace();
		}	
	}
}






