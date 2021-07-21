import java.sql.ResultSet;
import java.sql.Statement;

public class detalle_vou extends GestionBaseDatos {
	float monto;
	String nro_vou;
	String cod_serv;
	
	
	
	

	public detalle_vou(float monto, String nro_vou, String cod_serv) {
		super();
		this.monto = monto;
		this.nro_vou = nro_vou;
		this.cod_serv = cod_serv;
	}





	public void ingresarDatos() {
		Statement stmt = null;
		 try {
			 c.setAutoCommit(false);
			 stmt = c.createStatement();
			 stmt.executeUpdate( "INSERT INTO detalle_vou(monto,nro_vou, cod_serv)"
	         		+ "	VALUES ('"+this.monto+ "','"+this.nro_vou+"','"+this.cod_serv+"');" );
		 }catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	     }
		
	}
}
