import java.sql.ResultSet;
import java.sql.Statement;

public class Agente_bancario extends GestionBaseDatos{
	String cod_agb;
	String direccion;
	float comision;
	Agencia agencia;
	
	public Agente_bancario(String cod_agb, String direccion, float comision, Agencia agencia) {
		super();
		this.cod_agb = cod_agb;
		this.direccion = direccion;
		this.comision = comision;
		this.agencia = agencia;
	}
	public String getCod_agb() {
		return cod_agb;
	}
	public String getDireccion() {
		return direccion;
	}
	public float getComision() {
		return comision;
	}
	public Agencia getAgencia() {
		return agencia;
	}

	public static Agente_bancario getAgente(String codAgen) {
		String cod_agb="";
		String direccion="";
		float comision=0;
		Agencia agencia=null;
		Statement stmt = null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM agente_bancario WHERE cod_agb='"+codAgen+"';" );
	         while ( rs.next() ) {
	        	 cod_agb= rs.getString("cod_agb");
	        	 direccion= rs.getString("direccion");
	        	 comision= rs.getFloat("comision");
	        	 agencia= Agencia.getAgencia(rs.getString("cod_agen"));
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 System.out.println("Opened database successfully");
		 if(cod_agb.length()==0)
			 return null;
		 else {
			 return new Agente_bancario(cod_agb,direccion,comision,agencia);
		 }
	}
	
}
