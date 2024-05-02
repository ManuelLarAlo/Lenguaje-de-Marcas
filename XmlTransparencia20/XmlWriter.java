package XmlTransparencia20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlWriter
{
	public void writeXml(DocumentBuilder documentBuilder, Result result)
	{
		try
		{	
			Document document = documentBuilder.newDocument();
			
			FileOutputStream output = new FileOutputStream("Alumnos_salida.xml");
			
			Element rootElement = document.createElement("salida");
			
			this.alumnosSinPendientes(result, document, rootElement);
			
			// Create child element 'alumnos con mejor nota'
			Element alumnoMejorNotaElement = document.createElement("alumno_con_mejor_calificacion");
			alumnoMejorNotaElement.setTextContent(result.getAlumnoConMejorCalificacion().getNombre());
			rootElement.appendChild(alumnoMejorNotaElement);
			
			// Create child element 'alumnos con peor nota'
			Element alumnoPeorNotaElement = document.createElement("alumno_con_peor_calificacion");
			alumnoPeorNotaElement.setTextContent(result.getAlumnoConPeorCalificacion().getNombre());
			rootElement.appendChild(alumnoPeorNotaElement);
			
			// Edad media del alumnado
			Element edadMediaAlumnado = document.createElement("edad_media_alumnado");
			edadMediaAlumnado.setTextContent(String.valueOf(result.getEdadMediaAlumnado()));
			rootElement.appendChild(edadMediaAlumnado);
			
			// Nota media del alumnado
			Element notaMediaAlumnado = document.createElement("nota_media_alumnado");
			notaMediaAlumnado.setTextContent(String.valueOf(result.getNotaMediaAlumnado()));
			rootElement.appendChild(notaMediaAlumnado);
	
			document.appendChild(rootElement);
			
			this.writeXmlInternal(document, output);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (TransformerException e)
		{
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	private void alumnosSinPendientes(Result result, Document document, Element rootElement)
	{
		// Create child element 'alumnos sin pendientes'
		Element alumnosSinPendientesElement = document.createElement("alumnos_sin_pendientes");
		
		List<Alumno> alumnosSinPendientes = result.getAlumnosSinPendientes() ;
		
//			for (int i=0 ; i < alumnosSinPendientes.size() ; i++)
//			{
//				Alumno alumno = alumnosSinPendientes.get(i) ;
//			}
		
		for (Alumno alumno : alumnosSinPendientes)
		{
			Element alumnoSinPendientesElement = document.createElement("alumno");
			alumnoSinPendientesElement.setTextContent(alumno.getNombre());
			alumnosSinPendientesElement.appendChild(alumnoSinPendientesElement) ;
			
		}
		
		rootElement.appendChild(alumnosSinPendientesElement);
	}
	
	private void writeXmlInternal(Document document, OutputStream output) throws TransformerException 
	{
		// Create a new factory of documents builder
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		
		// Create a new instance of transformer
		Transformer transformer = transformerFactory.newTransformer();
		
		// Pretty print
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		
		// This is the source information that it would be store ...
		DOMSource xmlAsObject = new DOMSource(document);
		
		// ... here, in the stream result
		StreamResult xmlAsFile = new StreamResult(output);
		
		// Transform objects to file
		transformer.transform(xmlAsObject, xmlAsFile);
	}
}
