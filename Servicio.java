import java.sql.ResultSet;
import java.sql.Statement;

public class Servicio extends GestionBaseDatos{
	String cod_serv;
	String descripcion;
	float monto;
	//String rubro;
	Contrato_conexion contratoConex;


	
	public String getCod_serv() {
		return cod_serv;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getMonto() {
		return monto;
	}

	public Contrato_conexion getContratoConex() {
		return contratoConex;
	}

	public Servicio(String cod_serv, String descripcion, float monto,  Contrato_conexion contratoConex) {
		super();
		this.cod_serv = cod_serv;
		this.descripcion = descripcion;
		this.monto = monto;
		//this.rubro = rubro;
		this.contratoConex = contratoConex;
	}

	public static Servicio getServicio(String codServ) {
		String cod_serv="";
		String descripcion="";
		float monto=0;
		//String rubro="";
		Contrato_conexion contratoConex=null;
		Statement stmt = null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM servicio WHERE cod_serv="+codServ+";" );
	         while ( rs.next() ) {
	        	 cod_serv= rs.getString("cod_serv");
	        	 descripcion= rs.getString("descripcion");
	        	 monto= rs.getFloat("monto");
	        	 //rubro= rs.getString("rubro");
	        	 contratoConex= Contrato_conexion.getCont_conex(rs.getString("cod_conex"));
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 System.out.println("Opened database successfully");
		 if(cod_serv.length()==0)
			 return null;
		 else {
			 return new Servicio(cod_serv,descripcion,monto,contratoConex);
		 }
	}
}
