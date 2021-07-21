import java.sql.ResultSet;
import java.sql.Statement;

public class CuentaBanc extends GestionBaseDatos {
	String nro_cuenta;
	float saldo;
	Agencia agencia; 
	
	public CuentaBanc(String nro_cuenta, float saldo, Agencia agencia) {
		super();
		this.nro_cuenta = nro_cuenta;
		this.saldo = saldo;
		this.agencia = agencia;
	}
	public String getNro_cuenta() {
		return nro_cuenta;
	}
	public float getSaldo() {
		return saldo;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	
	
	public static CuentaBanc getCuentBanc(String nroCuenta) {
		String nro_cuenta="";
		float saldo=0;
		Agencia agencia=null; 
		
		Statement stmt = null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM cuentas_bancarias WHERE nro_cuenta='"+nroCuenta+"';" );
	         while ( rs.next() ) {
	        	 nro_cuenta= rs.getString("nro_cuenta");
	        	 saldo= rs.getFloat("saldo");
	        	 agencia= Agencia.getAgencia(rs.getString("cod_agen"));
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 System.out.println("Opened database successfully");
		 if(nro_cuenta.length()==0)
			 return null;
		 else {
			 return new CuentaBanc(nro_cuenta,saldo,agencia);
		 }
	}
}
