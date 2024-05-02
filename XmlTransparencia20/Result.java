package XmlTransparencia20;

import java.util.List;

public class Result
{
	private List<Alumno> alumnosSinPendientes;
	
	private Alumno alumnoConMejorCalificacion;
	
	private Alumno alumnoConPeorCalificacion;
	
	private int edadMediaAlumnado ;
	
	private float notaMediaAlumnado ;

	public Result(List<Alumno> alumnosSinPendientes, Alumno alumnoConMejorCalificacion, Alumno alumnoConPeorCalificacion, int edadMediaAlumnado, float notaMediaAlumnado)
	{
		this.alumnosSinPendientes 		= alumnosSinPendientes;
		this.alumnoConMejorCalificacion = alumnoConMejorCalificacion;
		this.alumnoConPeorCalificacion  = alumnoConPeorCalificacion;
		this.edadMediaAlumnado 			= edadMediaAlumnado;
		this.notaMediaAlumnado 			= notaMediaAlumnado;
	}

	public List<Alumno> getAlumnosSinPendientes()
	{
		return this.alumnosSinPendientes;
	}

	public Alumno getAlumnoConMejorCalificacion()
	{
		return this.alumnoConMejorCalificacion;
	}

	public Alumno getAlumnoConPeorCalificacion()
	{
		return this.alumnoConPeorCalificacion;
	}

	public int getEdadMediaAlumnado()
	{
		return this.edadMediaAlumnado;
	}

	public float getNotaMediaAlumnado()
	{
		return this.notaMediaAlumnado;
	}
}
