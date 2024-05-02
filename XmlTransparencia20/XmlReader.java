package XmlTransparencia20;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReader
{
	public Alumno[] readXml(DocumentBuilder documentBuilder)
	{
		Alumno[] alumnos = null ;
		
		try
		{
			// Parse and store the XML in the instance of Document
			Document document = documentBuilder.parse(new File("Alumnos_entrada.xml"));
			
			// Create a root element
			Element rootElement = document.getDocumentElement();
			
			NodeList nodeListAlumnos = rootElement.getElementsByTagName("alumno");
			
			alumnos = new Alumno[nodeListAlumnos.getLength()];
			
			for (int i = 0; i < nodeListAlumnos.getLength(); i++)
			{
				// Get the first element of the list
				Element nodeAlumno = (Element) nodeListAlumnos.item(i);

				// Get text from node values
				String nombre 			   = String.valueOf(nodeAlumno.getAttributes().getNamedItem("nombre").getTextContent());
				int edad 				   = Integer.parseInt(nodeAlumno.getAttributes().getNamedItem("edad").getTextContent());
				Float calificacion 	   	   = Float.valueOf(nodeAlumno.getElementsByTagName("calificacion").item(0).getTextContent());
				boolean unidadesPendientes = Boolean.parseBoolean(nodeAlumno.getElementsByTagName("unidadesPendientes").item(0).getTextContent());
				
				alumnos[i] 				   = new Alumno(nombre, edad, calificacion, unidadesPendientes);
			}
		}
		catch (SAXException saxException) 
		{
			saxException.printStackTrace();
		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
		}
		
		return alumnos ;
	}
}
