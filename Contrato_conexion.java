import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Contrato_conexion extends GestionBaseDatos {
	String cod_conex;
	String descripcion;
	Cliente empresa;
	ArrayList <Servicio> listaServicios;
	
	
	
	public Contrato_conexion(String cod_conex, String descripcion, Cliente empresa,
			ArrayList<Servicio> listaServicios) {
		super();
		this.cod_conex = cod_conex;
		this.descripcion = descripcion;
		this.empresa = empresa;
		this.listaServicios = listaServicios;
	}
	
	public String getCod_conex() {
		return cod_conex;
	}
	public String getDescripcion() {
		return descripcion;
	}

	
	public ArrayList<Servicio> getListaServicios() {
		return listaServicios;
	}

	public Cliente getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Cliente empresa) {
		this.empresa = empresa;
	}

	public static Contrato_conexion getCont_conex(String cod_conex) {
		Contrato_conexion aux;
		String cod_conexTemp="";
		String descripcion="";
		Statement stmt = null;
		Cliente emp=null;
		ArrayList <Servicio> listemp= new ArrayList <Servicio>();
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM contrato_conexion WHERE cod_conex='"+cod_conex+"';" );
	         while ( rs.next() ) {
	        	 cod_conexTemp= rs.getString("cod_conex");
	        	 descripcion= rs.getString("descripcion");
	        	 
	        	 emp = Cliente.getClienteCod(rs.getString("cod_cli"));
	        	 listemp =  getLista_serv(cod_conex);
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 System.out.println("Opened database successfully");
		 if(cod_conexTemp.length()==0)
			 return null;
		 else {
			 
			 return new Contrato_conexion(cod_conexTemp,descripcion,emp,listemp);
		 }
	}
	
	private static ArrayList <Servicio> getLista_serv(String cod_conex) {
		Statement stmt = null;
		String cod_serv="";
		String descripcion="";
		ArrayList <Servicio> listemp=new ArrayList <Servicio>();
		float monto=0;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM servicio WHERE cod_conex='"+cod_conex+"';" );
	         while ( rs.next() ) {
	        	 cod_serv= rs.getString("cod_serv");
	        	 descripcion= rs.getString("descripcion");
	        	 monto= rs.getFloat("monto");
	        	 listemp.add(new Servicio(cod_serv,descripcion,monto,null));
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 return listemp;
		 
	}
}
