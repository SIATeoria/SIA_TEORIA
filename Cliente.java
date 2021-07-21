import java.sql.ResultSet;
import java.sql.Statement;

public class Cliente extends GestionBaseDatos {
	private String cod_cli;
	private String ruc;
	private String nombre;
	private String dni;
	private String tipo_persona;
	private CuentaBanc cuenta;
	public Cliente(String cod_cli, String ruc, String nombre, String dni, String tipo_persona, CuentaBanc cuenta) {
		super();
		this.cod_cli = cod_cli;
		this.ruc = ruc;
		this.nombre = nombre;
		this.dni = dni;
		this.tipo_persona = tipo_persona;
		this.cuenta = cuenta;
	}

	public String getCod_cli() {
		return cod_cli;
	}
	public String getRuc() {
		return ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public String getTipo_persona() {
		return tipo_persona;
	}
	public CuentaBanc getCuenta() {
		return cuenta;
	}




	public static Cliente getCliente(String nroCuenta) {  //busca el cliente en base a su numero de cuenta 
		Cliente aux;
		Statement stmt = null;
		String cod_cliTemp="";
		String nombre="";
		String ruc="";
		String dni="";
		String tipo_persona="";
		CuentaBanc cuentatemp=null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM cliente WHERE nro_cuenta='" +nroCuenta+"';" );
	         while ( rs.next() ) {
	        	 cod_cliTemp = rs.getString("cod_cli");
	        	 nombre = rs.getString("nombre");
	        	 ruc= rs.getString("ruc");
	        	 dni= rs.getString("dni");
	        	 tipo_persona= rs.getString("tipo_persona");
	        	 cuentatemp= CuentaBanc.getCuentBanc(rs.getString("nro_cuenta"));
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 System.out.println("Opened database successfully");
		 if(cod_cliTemp.length()==0)
			 return null;
		 else {
			 return new Cliente(cod_cliTemp,ruc, nombre,dni,tipo_persona,cuentatemp);
		 }
	}
	
	
	public static Cliente getClienteCod(String codCli) { //busca el cliente en base a su codigo de cliente
		Cliente aux;
		Statement stmt = null;
		String cod_cliTemp="";
		String nombre="";
		String ruc="";
		String dni="";
		String tipo_persona="";
		CuentaBanc cuentatemp=null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM cliente WHERE cod_cli='" +codCli+"';" );
	         while ( rs.next() ) {
	        	 cod_cliTemp = rs.getString("cod_cli");
	        	 nombre = rs.getString("nombre");
	        	 ruc= rs.getString("ruc");
	        	 dni= rs.getString("dni");
	        	 tipo_persona= rs.getString("tipo_persona");
	        	 cuentatemp= CuentaBanc.getCuentBanc(rs.getString("nro_cuenta"));
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		 System.out.println("Opened database successfully");
		 if(cod_cliTemp.length()==0)
			 return null;
		 else {
			 return new Cliente(cod_cliTemp,ruc, nombre,dni,tipo_persona,cuentatemp);
		 }
	}
	
}
