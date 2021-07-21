import java.sql.ResultSet;
import java.sql.Statement;


public class Operador extends GestionBaseDatos {
	
	String cod_operador;
	String nombre;
	
	public Operador(String cod_operador, String nombre) {
		super();
		this.cod_operador = cod_operador;
		this.nombre = nombre;
	}
	
	public String getCod_operador() {
		return cod_operador;
	}
	public String getNombre() {
		return nombre;
	}

	public static Operador getOperador(String codOperador) {
		String cod_operador="";
		String nombre="";
		Statement stmt = null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM operador WHERE cod_operad='"+codOperador+"';" );
	         while ( rs.next() ) {
	        	 cod_operador= rs.getString("cod_operad");
	        	 nombre= rs.getString("nombre");
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 System.out.println("Opened database successfully");
		 if(cod_operador.length()==0)
			 return null;
		 else {
			 return new Operador(cod_operador,nombre);
		 }
	}
}


