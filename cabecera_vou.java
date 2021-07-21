import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class cabecera_vou extends GestionBaseDatos {
	String nro_voucher;
	String fecha;
	String anuncio;
	String hora;
	String forma_pago;
	String cod_cli;
	String cod_agb;
	String rubro;
	public cabecera_vou(String nro_voucher, String fecha, String anuncio, String hora, String forma_pago,
			String cod_cli, String cod_agb, String rubro) {
		super();
		this.nro_voucher = nro_voucher;
		this.fecha = fecha;
		this.anuncio = anuncio;
		this.hora = hora;
		this.forma_pago = forma_pago;
		this.cod_cli = cod_cli;
		this.cod_agb = cod_agb;
		this.rubro = rubro;
	}
	
	public void ingresarDatos() {
		PreparedStatement stmt = null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.prepareStatement("INSERT INTO cabecera_vou(fecha, nro_vou, anuncio, hora, forma_pago, rubro, cod_agb, cod_cli) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			 
			 stmt.setString(1,this.fecha );
			 stmt.setString(2,this.nro_voucher );
			 stmt.setString(3,this.anuncio );
			 stmt.setString(4, this.hora);
			 stmt.setString(5, this.forma_pago);
			 stmt.setString(6, this.rubro);
			 stmt.setString(7, this.cod_agb);
			 stmt.setString(8, this.cod_cli);
			 
			 System.out.println(stmt);
			 stmt.executeUpdate();
			 /*
			 String cad= "INSERT INTO cabecera_vou(fecha, nro_vou, anuncio, hora, forma_pago, rubro, cod_agb, cod_cli)"
		         		+ "	VALUES ('"+this.fecha+"','"+this.nro_voucher+"','"+this.anuncio+"','"+ this.hora+
		         		"','"+this.forma_pago +"','"+ this.rubro+"','"+ this.cod_agb+"','"+this.cod_cli +"');";
			 
	         stmt.executeUpdate(cad);*/
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		
	}
	
	public static String getNrovou() { //recupera el ultimo numero de voucher en la base de datos
		Statement stmt = null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT MAX(nro_vou) FROM cabecera_vou;" );
	         while ( rs.next() ) {
	        	 if (rs.getString("max")==null)
	        		 return "0";
	        	 else
	        		 return rs.getString("max");
	         }
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		return null;
	}

	@Override
	public String toString() {
		return "cabecera_vou [nro_voucher=" + nro_voucher + ", fecha=" + fecha + ", anuncio=" + anuncio + ", hora="
				+ hora + ", forma_pago=" + forma_pago + ", cod_cli=" + cod_cli + ", cod_agb=" + cod_agb + ", rubro="
				+ rubro + "]";
	}
	
	
}