package XmlTransparencia20;

/**
 * Esta clase representa un alumno
 */
public class Alumno
{
	/** Atributo - Nombre del alumno */
	private String nombre;
	
	/** Atributo - Edad del alumno */
    private int edad;
    
    /** Atributo - Calificación del alumno */
    private float calificacion;
    
    /** Atributo - Asignaturas pendientes del alumno */
    private boolean asignaturasPendientes;
    
    /**
     * @param nombre Nombre del alumno
     * @param edad Edad del alumno
     * @param calificacion Calificación del alumno
     * @param asignaturasPendientes Asignaturas pendientes del alumno
     */
    public Alumno(String nombre, int edad, float calificacion, boolean asignaturasPendientes)
    {
 		this.nombre 		  	   = nombre;
 		this.edad 			  	   = edad;
 		this.calificacion 	  	   = calificacion;
 		this.asignaturasPendientes = asignaturasPendientes;
 	}

	/**
	 * @return the nombre
	 */
	public String getNombre()
	{
		return this.nombre;
	}

	/**
	 * @return the edad
	 */
	public int getEdad()
	{
		return this.edad;
	}

	/**
	 * @return the calificacion
	 */
	public float getCalificacion()
	{
		return this.calificacion;
	}

	/**
	 * @return the asignaturasPendientes
	 */
	public boolean isAsignaturasPendientes()
	{
		return this.asignaturasPendientes;
	}
}
