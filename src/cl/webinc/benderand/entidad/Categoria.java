
package cl.webinc.benderand.entidad;
									
public class Categoria
{
	private String id_categoria = "";
	private String nombre_categoria = "";
	
	
	public Categoria(String id_categoria, String nombre_categoria)
	{
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
		
	}
	public Categoria(){}
	public String getId_categoria() 
	{
		return id_categoria;
	}
	public String getNombre_categoria() 
	{
		return nombre_categoria;
	}
	public void setId_categoria(String id_categoria) 
	{
		this.id_categoria = id_categoria;
	}
	public void setNombre_categoria(String nombre_categoria) 
	{
		this.nombre_categoria = nombre_categoria;
	}
	
}