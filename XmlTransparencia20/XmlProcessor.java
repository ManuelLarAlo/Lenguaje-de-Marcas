package XmlTransparencia20;

import java.util.ArrayList;
import java.util.List;

public class XmlProcessor
{
	public Result procesarAlumnos(Alumno[] alumnos)
	{
		List<Alumno> alumnosSinPendientes = this.alumnosSinPendientes(alumnos);
		
		Alumno alumnoConMejorCalificacion = this.alumnoConMejorCalificacion(alumnos);
		
		Alumno alumnoConPeorCalificacion  = this.alumnoConPeorCalificacion(alumnos);		
		
		int edadMediaAlumnado 			  = this.edadMediaAlumnado(alumnos);
		
		float notaMediaAlumnado 		  = this.notaMediaAlumnado(alumnos);
		
		return new Result(alumnosSinPendientes, alumnoConMejorCalificacion, alumnoConPeorCalificacion, edadMediaAlumnado, notaMediaAlumnado);
	}
	
	private List<Alumno> alumnosSinPendientes(Alumno[] alumnos)
	{
		List<Alumno> alumnosSinPendientes = new ArrayList<>();
		
		// Este bucle va a calcular qué alumnos no tienen asignaturas pendientes
		for (int i = 0; i < alumnos.length; i++)
		{
			// Obtenemos el alumno
			Alumno alumno = alumnos[i];

			if (!alumno.isAsignaturasPendientes())
			{
				alumnosSinPendientes.add(alumno);
			}
		}
		return alumnosSinPendientes;
	}
	
	private Alumno alumnoConMejorCalificacion(Alumno[] alumnos)
	{
		Alumno alumnoConMejorCalificacion = alumnos[0] ;
		
		// Este bucle va a calcular qué alumno tiene la calificación más alta
		for (int i = 0; i < alumnos.length; i++)
		{
			// Obtenemos el alumno
			Alumno alumno = alumnos[i];
			
			if (alumno.getCalificacion() > alumnoConMejorCalificacion.getCalificacion())
			{
				alumnoConMejorCalificacion = alumno ;
			}
		}
		return alumnoConMejorCalificacion;
	}
	
	private Alumno alumnoConPeorCalificacion(Alumno[] alumnos)
	{
		Alumno alumnoConPeorCalificacion = alumnos[0];
		
		// Este bucle va a calcular qué alumno tiene la calificación más baja
		for (int i = 0; i < alumnos.length; i++)
		{
			// Obtenemos el alumno
			Alumno alumno = alumnos[i];
			
			if (alumno.getCalificacion() < alumnoConPeorCalificacion.getCalificacion())
			{
				alumnoConPeorCalificacion = alumno ;
			}
		}
		return alumnoConPeorCalificacion;
	}
	
	private int edadMediaAlumnado(Alumno[] alumnos)
	{
		int edadMediaAlumnado = 0;
		int sumaTotalEdades   = 0 ;
		
		// Este bucle va a calcular la edad media del alumnado 
		for (int i = 0; i < alumnos.length; i++)
		{
			// Obtenemos el alumno
			Alumno alumno = alumnos[i];
			
			sumaTotalEdades = sumaTotalEdades + alumno.getEdad() ; 
		}	
		
		edadMediaAlumnado = sumaTotalEdades / alumnos.length ;
		return edadMediaAlumnado;
	}

	private float notaMediaAlumnado(Alumno[] alumnos)
	{
		float notaMediaAlumnado = 0 ;
		float sumaTotalNotas   = 0 ;
		
		// Este bucle va a calcular la nota media del alumnado 
		for (int i = 0; i < alumnos.length; i++)
		{
			// Obtenemos el alumno
			Alumno alumno = alumnos[i];
			
			sumaTotalNotas = sumaTotalNotas + alumno.getCalificacion() ; 
		}	
		
		notaMediaAlumnado = sumaTotalNotas / alumnos.length ;
		return notaMediaAlumnado;
	}
}
