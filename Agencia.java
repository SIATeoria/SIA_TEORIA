import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Agencia extends GestionBaseDatos {
	String cod_agen;
	String nombre;
	String informacion;
	
	public Agencia(String cod_agen, String nombre, String informacion) {
		super();
		this.cod_agen = cod_agen;
		this.nombre = nombre;
		this.informacion = informacion;
	}
	

	public String getCod_agen() {
		return cod_agen;
	}
	public String getNombre() {
		return nombre;
	}
	public String getInformacion() {
		return informacion;
	}

	public static Agencia getAgencia(String codAgen) {
		String cod_agen="";
		String nombre="";
		String informacion="";
		Statement stmt = null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM agencia WHERE cod_agen='"+codAgen+"';" );
	       
	         while ( rs.next() ) {
	        	 cod_agen= rs.getString("cod_agen");
	        	 nombre= rs.getString("nombre");
	        	 informacion= rs.getString("informacion");
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 System.out.println("Opened database successfully");
		 if(cod_agen.length()==0)
			 return null;
		 else {
			 return new Agencia(cod_agen,nombre,informacion);
		 }
	}
	
}
