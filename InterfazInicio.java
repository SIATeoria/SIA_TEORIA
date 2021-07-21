import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class InterfazInicio extends JFrame implements ActionListener {
	 	
		public static Agente_bancario Kiosko;
		public static Agencia agen;
		public static String monto;
		
		public static Agente_bancario getAgenciaBancario() {
			return Kiosko;
		}
		public static Agencia getAgentte() {
			return agen;
		}	
		
		public static String getMonto() {
			return monto;
		}
		

		public static void setMonto(String Monto) {
			monto = Monto;
		}
		
		
		
		
		private JLabel label1,label7;
		private JButton BT1, BT2;
		String a,b;
		
				
		public InterfazInicio() {
			agen = new Agencia("000001", "BCP" ,"agente multinaciolnal" );
			float comi = 5.0f;
			Kiosko = new Agente_bancario("000002","Av. Independencia 1234 " , comi , agen );
			/*setLayout(new BorderLayout());
			setContentPane(new JLabel(new ImageIcon("fondex.jpg")));
			setSize(500,300);
			*/
			
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			//ImageIcon imagen = new ImageIcon("fondex.jpg"); 
			
			
			this.getContentPane().setBackground(Color.decode("#B0C6EA"));
			setLayout(null);
			
			
			label1 = new JLabel("BIENVENIDO ELIGA UNA OPCION");
						
			label1.setFont(new Font("Arial", Font.PLAIN, 34));
			label1.setBounds(90,100,550,45);
			add(label1);
							
			BT1 = new JButton("DEPOSITAR");
			BT1.setBounds(200,230,300,90);
			BT1.setFont(new Font("Arial", Font.PLAIN, 24));
			add(BT1);
			BT1.addActionListener(this);
			
			BT2 = new JButton("PAGAR SERVICIO");
			BT2.setFont(new Font("Arial", Font.PLAIN, 24));
			BT2.setBounds(200,375,300,90);
			add(BT2);
			BT2.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == BT1) {
				InterfazDepositarInicio inicio2 = new InterfazDepositarInicio();
				inicio2.setSize(750, 750);
				//login1.setBounds(0,0,300,250);
				inicio2.setLocationRelativeTo(null);
				inicio2.setResizable(false);
				inicio2.setVisible(true);
				this.setVisible(false);
			}
			if(e.getSource()==BT2) {
				InterfazPagarInicio inicio2 = new  InterfazPagarInicio();
				inicio2.setSize(750, 750);
				//login1.setBounds(0,0,300,250);
				inicio2.setLocationRelativeTo(null);
				inicio2.setResizable(false);
				inicio2.setVisible(true);
				this.setVisible(false);
			}
		}
}

class InterfazDepositarInicio extends JFrame implements ActionListener {
		
		private JLabel label1,label2,label3,label4;
		private JTextField t1,t2,t3;
		private JButton BT1, BT2;
		String a,b;
		public InterfazDepositarInicio() {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.getContentPane().setBackground(Color.decode("#B0C6EA"));
			setLayout(null);
			label1 = new JLabel("INGRESE LOS DATOS DE LA PERSONA");
			label1.setFont(new Font("Arial", Font.PLAIN, 34));
			label1.setBounds(40,100,650,45);
			add(label1);
			
			setLayout(null);
			label2 = new JLabel(" A QUIEN QUIERE DEPOSITAR ");
			label2.setFont(new Font("Arial", Font.PLAIN, 34));
			label2.setBounds(90,150,550,45);
			add(label2);
			
			setLayout(null);
			label3 = new JLabel("NUMERO DE LA TARJETA  : ");
			label3.setFont(new Font("Arial", Font.PLAIN, 18));
			label3.setBounds(100,250,250,30);
			add(label3);
			t2 = new JTextField();
			t2.setBounds(400,250,200,30);
			add(t2);
			
			setLayout(null);
			label4 = new JLabel("MONTO A DEPOSITAR        : ");
			label4.setFont(new Font("Arial", Font.PLAIN, 18));
			label4.setBounds(100,300,250,30);
			add(label4);
			t3 = new JTextField();
			t3.setBounds(400,300,200,30);
			add(t3);
			
					
			BT1 = new JButton("CANCELAR");
			BT1.setBounds(100,430,200,70);
			BT1.setFont(new Font("Arial", Font.PLAIN, 18));
			add(BT1);
			BT1.addActionListener(this);
			
			BT2 = new JButton("ACEPTAR");
			BT2.setFont(new Font("Arial", Font.PLAIN, 18));
			BT2.setBounds(400,430,200,70);
			add(BT2);
			BT2.addActionListener(this);
			
	
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == BT1) {
				InterfazInicio ventanaMenuPrincipal = new InterfazInicio();
				ventanaMenuPrincipal.setSize(750, 750);
				//login1.setBounds(0,0,300,250);
				ventanaMenuPrincipal.setLocationRelativeTo(null);
				ventanaMenuPrincipal.setResizable(false);
				ventanaMenuPrincipal.setVisible(true);
				this.setVisible(false);
				
			}
			if(e.getSource()==BT2) {
				String numeroCuenta=t2.getText();
				String Monto =t3.getText();
				InterfazInicio.setMonto(Monto);
				Cliente beneficiario = Cliente.getCliente(numeroCuenta); 
				
				if(beneficiario!=null) {
					InterfazDepositarMuestraDatos ventanaDeposito2 = new InterfazDepositarMuestraDatos(beneficiario);
					ventanaDeposito2.setSize(750, 750);
					ventanaDeposito2.setLocationRelativeTo(null);
					ventanaDeposito2.setResizable(false);
					ventanaDeposito2.setVisible(true);
					this.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null,"Error: no existe el numero de cuenta");
			}
		}
}
	


class InterfazDepositarMuestraDatos extends JFrame implements ActionListener {
	
	private JLabel label1,label2,label3,label4,label5;
	private JTextField t1,t2,t3;
	private JButton BT1, BT2;
	String a,b;
	Cliente aux;
	
	public InterfazDepositarMuestraDatos(Cliente temp) {
		this.aux = temp;
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#B0C6EA"));
		
		setLayout(null);
		label1 = new JLabel("DATOS DE LA PERSONA");
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(150,100,650,45);
		add(label1);
		
		setLayout(null);
		label2 = new JLabel(" A QUIEN QUIERE DEPOSITAR ");
		label2.setFont(new Font("Arial", Font.PLAIN, 34));
		label2.setBounds(120,150,550,45);
		add(label2);
		
		setLayout(null);
		label3 = new JLabel("NOMBRE DE LA PERSONA : ");
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(100,250,250,30);
		add(label3);
		String PersonName = temp.getNombre() ;
		t1 = new JTextField(PersonName);
		t1.setEditable(false);
		t1.setBounds(400,250,200,30);
		add(t1);
		
		setLayout(null);
		label4 = new JLabel("DNI DE LA PERSONA          : ");
		label4.setFont(new Font("Arial", Font.PLAIN, 18));
		label4.setBounds(100,300,250,30);
		add(label4);
		String PersonDNI = temp.getDni();
		t2 = new JTextField(PersonDNI);
		t2.setEditable(false);
		t2.setBounds(400,300,200,30);
		add(t2);
		
		setLayout(null);
		label5 = new JLabel("NUMERO DE TARJETA        : ");
		label5.setFont(new Font("Arial", Font.PLAIN, 18));
		label5.setBounds(100,350,250,30);
		add(label5);
		CuentaBanc tempCuenta = temp.getCuenta();
		String PersonBancNumber = tempCuenta.getNro_cuenta();
		t3 = new JTextField(PersonBancNumber);
		t3.setEditable(false);
		t3.setBounds(400,350,200,30);
		add(t3);
		
				
		BT1 = new JButton("CANCELAR");
		BT1.setBounds(100,430,200,70);
		BT1.setFont(new Font("Arial", Font.PLAIN, 18));
		add(BT1);
		BT1.addActionListener(this);
			
		BT2 = new JButton("ACEPTAR");
		BT2.setFont(new Font("Arial", Font.PLAIN, 18));
		BT2.setBounds(400,430,200,70);
		add(BT2);
		BT2.addActionListener(this);
		

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BT1) {
			
			InterfazDepositarInicio inicio2 = new InterfazDepositarInicio();
			inicio2.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			inicio2.setLocationRelativeTo(null);
			inicio2.setResizable(false);
			inicio2.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==BT2) {
			InterfazDepositarIngreseTarjeta inicio3 = new InterfazDepositarIngreseTarjeta(aux);
			inicio3.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			inicio3.setLocationRelativeTo(null);
			inicio3.setResizable(false);
			inicio3.setVisible(true);
			this.setVisible(false);
			
		}
	}
}

class InterfazDepositarIngreseTarjeta extends JFrame implements ActionListener {
	
	private JLabel label1,label2,label3,label4;
	private JTextField t1,t2,t3;
	private JButton BT1, BT2;
	String a,b;
	Cliente depositante , beneficiario;
	public InterfazDepositarIngreseTarjeta(Cliente temp) {
		this.beneficiario = temp;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#B0C6EA"));
		setLayout(null);
		label1 = new JLabel("INGRESE LOS DATOS DE SU TARJETA");
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(40,150,650,45);
		add(label1);
		
		setLayout(null);
		label3 = new JLabel("NUMERO DE LA TARJETA  : ");
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(100,250,250,30);
		add(label3);
		t2 = new JTextField();
		t2.setBounds(400,250,200,30);
		add(t2);
		
		setLayout(null);
		label4 = new JLabel("DNI           : ");
		label4.setFont(new Font("Arial", Font.PLAIN, 18));
		label4.setBounds(100,300,250,30);
		add(label4);
		t3 = new JTextField();
		t3.setBounds(400,300,200,30);
		add(t3);
		
				
		BT1 = new JButton("CANCELAR");
		BT1.setBounds(100,430,200,70);
		BT1.setFont(new Font("Arial", Font.PLAIN, 18));
		add(BT1);
		BT1.addActionListener(this);
		
		BT2 = new JButton("ACEPTAR");
		BT2.setFont(new Font("Arial", Font.PLAIN, 18));
		BT2.setBounds(400,430,200,70);
		add(BT2);
		BT2.addActionListener(this);
		

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BT1) {
			InterfazInicio ventanaMenuPrincipal = new InterfazInicio();
			ventanaMenuPrincipal.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			ventanaMenuPrincipal.setLocationRelativeTo(null);
			ventanaMenuPrincipal.setResizable(false);
			ventanaMenuPrincipal.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==BT2) {
			String numeroCuenta=t2.getText();
			String Dni =t3.getText();
			
			Cliente depositante = Cliente.getCliente(numeroCuenta);
			if(depositante!=null) {
				InterfazDeMuestraVoucherDepositar ventanaDeposito2 = new InterfazDeMuestraVoucherDepositar(depositante, beneficiario);
				ventanaDeposito2.setSize(750, 750);
				ventanaDeposito2.setLocationRelativeTo(null);
				ventanaDeposito2.setResizable(false);
				ventanaDeposito2.setVisible(true);
				this.setVisible(false);
			}else
				JOptionPane.showMessageDialog(null,"Error: no existe el numero de cuenta");
		}
	}
}

class InterfazDeMuestraVoucherDepositar extends JFrame implements ActionListener {
	
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17,label18,label19,label20;
	private JTextField t1,t2,t3;
	private JButton BT1, BT2;
	Cliente depositante , beneficiario;
	String a,b;
	
	public InterfazDeMuestraVoucherDepositar(Cliente deposi , Cliente benef) {
		depositante = deposi;
		beneficiario = benef;
		Agente_bancario aggentba = InterfazInicio.getAgenciaBancario();
		Agencia agentte = InterfazInicio.getAgentte();
		int cantidadProdcutos = 6;
		int pivote = 0;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#B0C6EA"));
		setLayout(null);
		label1 = new JLabel("VOUCHER DE AGENTE");
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(120,80,650,45);
		add(label1);
		
		String nameAgen = agentte.getNombre();
		label1 = new JLabel(nameAgen);
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(200,80,650,45);
		add(label1);
		
		setLayout(null);
		label2 = new JLabel("PARA MAYOR INFORMACION:");
		label2.setFont(new Font("Arial", Font.PLAIN, 18));
		label2.setBounds(60,150,650,45);
		add(label2);
		
		setLayout(null);
		String infoagentte = agentte.getInformacion();
		label3 = new JLabel(infoagentte);
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(60,170,650,45);
		add(label3);
		
		setLayout(null);
		label2 = new JLabel(nameAgen);
		label2.setFont(new Font("Arial", Font.PLAIN, 18));
		label2.setBounds(60,230,650,45);
		add(label2);
		
		setLayout(null);
		String nameAgenBan = aggentba.getDireccion();
		label3 = new JLabel(nameAgenBan);
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(60,250,650,45);
		add(label3);
		
		
		String nameOperador = "120610";
		Operador pedro = Operador.getOperador(nameOperador);
		
		setLayout(null);
		label4 = new JLabel("Nombre Operador : ");
		label4.setFont(new Font("Arial", Font.PLAIN, 18));
		label4.setBounds(60,270,650,45);
		add(label4);
		
		setLayout(null);
		label5 = new JLabel(pedro.getNombre());
		label5.setFont(new Font("Arial", Font.PLAIN, 18));
		label5.setBounds(220,270,650,45);
		add(label5);
		
		setLayout(null);
		label6 = new JLabel("Codigo  Voucher   : ");
		label6.setFont(new Font("Arial", Font.PLAIN, 18));
		label6.setBounds(60,290,650,45);
		add(label6);
		
		String cad= cabecera_vou.getNrovou().replace(" ", "");
		Integer nrovou= Integer.parseInt(cad)+1;
		
		setLayout(null);
		label7 = new JLabel(nrovou.toString());
		label7.setFont(new Font("Arial", Font.PLAIN, 18));
		label7.setBounds(220,290,650,45);
		add(label7);
		
		setLayout(null);
		label8 = new JLabel("Nombre                 : ");
		label8.setFont(new Font("Arial", Font.PLAIN, 18));
		label8.setBounds(60,310,650,45);
		add(label8);
		
		setLayout(null);
		label9 = new JLabel(beneficiario.getNombre());//el que envia
		label9.setFont(new Font("Arial", Font.PLAIN, 18));
		label9.setBounds(220,310,650,45);
		add(label9);
		
		setLayout(null);
		label10 = new JLabel("Nro Operacion    	  : ");
		label10.setFont(new Font("Arial", Font.PLAIN, 18));
		label10.setBounds(60,330,650,45);
		add(label10);
		
		setLayout(null);
		label11 = new JLabel("1916");
		label11.setFont(new Font("Arial", Font.PLAIN, 18));
		label11.setBounds(220,330,650,45);
		add(label11);
		
		setLayout(null);
		label10 = new JLabel("Fecha : ");
		label10.setFont(new Font("Arial", Font.PLAIN, 18));
		label10.setBounds(510,230,650,45);
		add(label10);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		SimpleDateFormat hor = new SimpleDateFormat("HH:mm");
		LocalTime horaActtual = LocalTime.now();
		LocalDate dateActual  = LocalDate.now();
		
		Date dates = new Date();
		//String hora = sdf.format(horaActtual);
		String dat = sdf.format(dates);
		String hora = hor.format(dates);
		setLayout(null); 
		
		label11 = new JLabel(dat);
		label11.setFont(new Font("Arial", Font.PLAIN, 18));
		label11.setBounds(575,230,650,45);
		add(label11);
		
		setLayout(null);
		label10 = new JLabel("Hora   : ");
		label10.setFont(new Font("Arial", Font.PLAIN, 18));
		label10.setBounds(510,250,650,45);
		add(label10);
		
		setLayout(null);
		label11 = new JLabel(hora);
		label11.setFont(new Font("Arial", Font.PLAIN, 18));
		label11.setBounds(575,250,650,45);
		add(label11);
		
	
		setLayout(null);
		label12 = new JLabel("=======================DEPOSITO=======================");
		label12.setFont(new Font("Arial", Font.PLAIN, 18));
		label12.setBounds(60,380,650,45);
		add(label12);
		
		setLayout(null);
		label12 = new JLabel("A LA CUENTA NUMERO     :");
		label12.setFont(new Font("Arial", Font.PLAIN, 18));
		label12.setBounds(120,410,650,45);
		add(label12);
		
		setLayout(null);
		CuentaBanc benfCuen = beneficiario.getCuenta();
		label12 = new JLabel(benfCuen.getNro_cuenta());
		label12.setFont(new Font("Arial", Font.PLAIN, 18));
		label12.setBounds(380,410,650,45);
		add(label12);
		
		setLayout(null);
		label12 = new JLabel("NOMBRE                              :");
		label12.setFont(new Font("Arial", Font.PLAIN, 18));
		label12.setBounds(120,430,650,45);
		add(label12);
		
		setLayout(null);
		label12 = new JLabel(beneficiario.getNombre());
		label12.setFont(new Font("Arial", Font.PLAIN, 18));
		label12.setBounds(380,430,650,45);
		add(label12);
		
		setLayout(null);
		label12 = new JLabel("MONTO DEPOSITADO       S/");
		label12.setFont(new Font("Arial", Font.PLAIN, 18));
		label12.setBounds(120,450,650,45);
		add(label12);
		
		setLayout(null);
		label12 = new JLabel(InterfazInicio.getMonto());
		label12.setFont(new Font("Arial", Font.PLAIN, 18));
		label12.setBounds(380,450,650,45);
		add(label12);
	
			
		setLayout(null);
		label15 = new JLabel("=======================================================");
		label15.setFont(new Font("Arial", Font.PLAIN, 18));
		label15.setBounds(60,480,650,45);
		add(label15);
	
		
				
		BT1 = new JButton("IMPRIMIR");
		BT1.setBounds(100,550,200,70);
		BT1.setFont(new Font("Arial", Font.PLAIN, 18));
		add(BT1);
		BT1.addActionListener(this);
		
		BT2 = new JButton("ACEPTAR");
		BT2.setFont(new Font("Arial", Font.PLAIN, 18));
		BT2.setBounds(400,550,200,70);
		add(BT2);
		BT2.addActionListener(this);
		
		cabecera_vou cv= new cabecera_vou(nrovou.toString(),dat,"Paga tus compras rapidamente en nuestra cajas rapidas",hora,"credito",deposi.getCod_cli(),aggentba.getCod_agb(),"transferencia");
		cv.ingresarDatos();
		//detalle_vou det=new detalle_vou(InterfazInicio.getMonto(),nrovou.toString());
		//det.ingresarDatos();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BT1) {
			
			JOptionPane.showMessageDialog(null,"SE ESTA IMPRIMIENDO EL VOUCHER");
		}
		if(e.getSource()==BT2) {
			InterfazInicio ventanaDeposito2 = new InterfazInicio();
			InterfazInicio.setMonto("0");
			ventanaDeposito2.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			ventanaDeposito2.setLocationRelativeTo(null);
			ventanaDeposito2.setResizable(false);
			ventanaDeposito2.setVisible(true);
			this.setVisible(false);
		}
	}
}
//=====================================================================================
//-----------------------------INTERFAZ PAGO SERVICIO
//=====================================================================================

class InterfazPagarInicio extends JFrame implements ActionListener {
	
	private JLabel label1,label2,label3,label4;
	private JTextField t1,t2,t3;
	private JButton BT1, BT2;
	String a,b;
	public InterfazPagarInicio() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#B0C6EA"));
		setLayout(null);
		label1 = new JLabel("INGRESE LOS DATOS DEL");
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(130,100,650,45);
		add(label1);
		
		setLayout(null);
		label2 = new JLabel(" CUAL QUIERE PAGAR ");
		label2.setFont(new Font("Arial", Font.PLAIN, 34));
		label2.setBounds(140,150,550,45);
		add(label2);
		
		setLayout(null);
		label4 = new JLabel("CONTRATO/CONEXION: ");
		label4.setFont(new Font("Arial", Font.PLAIN, 18));
		label4.setBounds(100,250,250,30);
		add(label4);
		t3 = new JTextField();
		t3.setBounds(400,250,200,30);
		add(t3);
		
				
		BT1 = new JButton("CANCELAR");
		BT1.setBounds(100,430,200,70);
		BT1.setFont(new Font("Arial", Font.PLAIN, 18));
		add(BT1);
		BT1.addActionListener(this);
		
		BT2 = new JButton("ACEPTAR");
		BT2.setFont(new Font("Arial", Font.PLAIN, 18));
		BT2.setBounds(400,430,200,70);
		add(BT2);
		BT2.addActionListener(this);
		

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BT1) {
			InterfazInicio ventanaMenuPrincipal = new InterfazInicio();
			ventanaMenuPrincipal.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			ventanaMenuPrincipal.setLocationRelativeTo(null);
			ventanaMenuPrincipal.setResizable(false);
			ventanaMenuPrincipal.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==BT2) {
			
			String contrato = t3.getText();
			Contrato_conexion contrex =   Contrato_conexion.getCont_conex(contrato);
			if(contrex!=null) {
				InterfazPagarMuestraDatos ventanaPagar2 = new InterfazPagarMuestraDatos(contrex);
				ventanaPagar2.setSize(750, 750);
				//login1.setBounds(0,0,300,250);
				ventanaPagar2.setLocationRelativeTo(null);
				ventanaPagar2.setResizable(false);
				ventanaPagar2.setVisible(true);
				this.setVisible(false);
			}else
				JOptionPane.showMessageDialog(null,"Error: No existe el numero de cuenta");
		}
	}
}

class InterfazPagarMuestraDatos extends JFrame implements ActionListener {
	
	private JLabel label1,label2,label3,label4,label5;
	private JTextField t1,t2,t3;
	private JButton BT1, BT2;
	Contrato_conexion contrato;
	String a,b;
	
	public InterfazPagarMuestraDatos(Contrato_conexion contratos) {
		contrato = contratos;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#B0C6EA"));
		setLayout(null);
		label1 = new JLabel("DATOS DEL SERVICIO");
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(150,100,650,45);
		add(label1);
		
		setLayout(null);
		label2 = new JLabel(" QUE QUIERE PAGAR ");
		label2.setFont(new Font("Arial", Font.PLAIN, 34));
		label2.setBounds(120,150,550,45);
		add(label2);
		
		Cliente empre = contrato.getEmpresa();
		setLayout(null);
		label3 = new JLabel("NOMBRE DE LA EMPRESA : ");
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(100,250,250,30);
		add(label3);

		t1 = new JTextField(empre.getNombre());
		t1.setEditable(false);
		t1.setBounds(400,250,200,30);
		add(t1);
		
		float monte = 0; 
		ArrayList<Servicio> aux = contrato.getListaServicios();
		int siz = aux.size();
		for (int i = 0; i < siz; i++) {
			
			monte = monte + aux.get(i).getMonto();
			//464652
		}
		String montess =Float.toString(monte);
		InterfazInicio.setMonto(montess);
		
		setLayout(null);
		label4 = new JLabel("MONTO A PAGAR         : ");
		label4.setFont(new Font("Arial", Font.PLAIN, 18));
		label4.setBounds(100,300,250,30);
		add(label4);
		
		t2 = new JTextField(montess);
		t2.setEditable(false);
		t2.setBounds(400,300,200,30);
		add(t2);
		
		setLayout(null);
		label5 = new JLabel("CONEXION        : ");
		label5.setFont(new Font("Arial", Font.PLAIN, 18));
		label5.setBounds(100,350,250,30);
		add(label5);
		t3 = new JTextField(contrato.getCod_conex());
		t3.setBounds(400,350,200,30);
		add(t3);
		
				
		BT1 = new JButton("CANCELAR");
		BT1.setBounds(100,430,200,70);
		BT1.setFont(new Font("Arial", Font.PLAIN, 18));
		add(BT1);
		BT1.addActionListener(this);
			
		BT2 = new JButton("ACEPTAR");
		BT2.setFont(new Font("Arial", Font.PLAIN, 18));
		BT2.setBounds(400,430,200,70);
		add(BT2);
		BT2.addActionListener(this);
		

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BT1) {
		
			InterfazDepositarInicio inicio2 = new InterfazDepositarInicio();
			inicio2.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			inicio2.setLocationRelativeTo(null);
			inicio2.setResizable(false);
			inicio2.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==BT2) {
			InterfazPagarIngreseTarjeta inicio3 = new InterfazPagarIngreseTarjeta(contrato);
			inicio3.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			inicio3.setLocationRelativeTo(null);
			inicio3.setResizable(false);
			inicio3.setVisible(true);
			this.setVisible(false);
			
		}
	
	}
}

class InterfazPagarIngreseTarjeta extends JFrame implements ActionListener {
	
	private JLabel label1,label2,label3,label4;
	private JTextField t1,t2,t3;
	private JButton BT1, BT2;
	String a,b;
	Contrato_conexion contrato;
	
	public InterfazPagarIngreseTarjeta(Contrato_conexion contratos) {
		contrato = contratos;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#B0C6EA"));
		setLayout(null);
		label1 = new JLabel("INGRESE LOS DATOS DE SU TARJETA");
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(40,150,650,45);
		add(label1);
		
		setLayout(null);
		label3 = new JLabel("NUMERO DE LA TARJETA  : ");
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(100,250,250,30);
		add(label3);
		t2 = new JTextField();
		t2.setBounds(400,250,200,30);
		add(t2);
		
		setLayout(null);
		label4 = new JLabel("DNI CLIENTE           : ");
		label4.setFont(new Font("Arial", Font.PLAIN, 18));
		label4.setBounds(100,300,250,30);
		add(label4);
		t3 = new JTextField();
		t3.setBounds(400,300,200,30);
		add(t3);
		
				
		BT1 = new JButton("CANCELAR");
		BT1.setBounds(100,430,200,70);
		BT1.setFont(new Font("Arial", Font.PLAIN, 18));
		add(BT1);
		BT1.addActionListener(this);
		
		BT2 = new JButton("ACEPTAR");
		BT2.setFont(new Font("Arial", Font.PLAIN, 18));
		BT2.setBounds(400,430,200,70);
		add(BT2);
		BT2.addActionListener(this);
		

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BT1) {
			InterfazInicio ventanaMenuPrincipal = new InterfazInicio();
			ventanaMenuPrincipal.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			ventanaMenuPrincipal.setLocationRelativeTo(null);
			ventanaMenuPrincipal.setResizable(false);
			ventanaMenuPrincipal.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==BT2) {
			String numeroCuenta=t2.getText();
			Cliente depositante = Cliente.getCliente(numeroCuenta); 
			if(depositante!=null) {
				InterfazDeMuestraVoucherPagar ventanaDeposito2 = new InterfazDeMuestraVoucherPagar(depositante , contrato);
				ventanaDeposito2.setSize(750, 750);
				//login1.setBounds(0,0,300,250);
				ventanaDeposito2.setLocationRelativeTo(null);
				ventanaDeposito2.setResizable(false);
				ventanaDeposito2.setVisible(true);
				this.setVisible(false);
			}else
				JOptionPane.showMessageDialog(null,"Error: No existe el numero de cuenta");
		}
	}
}

class InterfazDeMuestraVoucherPagar extends JFrame implements ActionListener {
	
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16,label17,label18,label19,label20;
	private JTextField t1,t2,t3;
	private JButton BT1, BT2;
	String a,b;
	Cliente depo;
	Contrato_conexion contrato;
	public InterfazDeMuestraVoucherPagar(Cliente depos,Contrato_conexion contr) {
		depo = depos ;
		contrato = contr;
		Cliente empr = contr.getEmpresa();
		Agente_bancario aggentba = InterfazInicio.getAgenciaBancario();
		Agencia agentte = InterfazInicio.getAgentte();
		int cantidadProdcutos = 6;
		int pivote = 0;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#B0C6EA"));
		setLayout(null);
		label1 = new JLabel("VOUCHER DE ");
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(120,20,650,45);
		add(label1);
		
		label1 = new JLabel(agentte.getNombre());
		label1.setFont(new Font("Arial", Font.PLAIN, 34));
		label1.setBounds(360,20,650,45);
		add(label1);
		
		setLayout(null);
		label2 = new JLabel("PARA MAYOR INFORMACION:");
		label2.setFont(new Font("Arial", Font.PLAIN, 18));
		label2.setBounds(60,70,650,45);
		add(label2);
		
		setLayout(null);
		label3 = new JLabel(agentte.getInformacion());
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(60,90,650,45);
		add(label3);
		
		
		
		setLayout(null);
		label3 = new JLabel("DIRECCION :  ");
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(60,110,650,45);
		add(label3);
		
		setLayout(null);
		label3 = new JLabel(aggentba.getDireccion());
		label3.setFont(new Font("Arial", Font.PLAIN, 18));
		label3.setBounds(180,110,650,45);
		add(label3);
		
		

		String nameOperador = "120610";
		Operador pedro = Operador.getOperador(nameOperador);
		
		setLayout(null);
		label2 = new JLabel("Operador : ");
		label2.setFont(new Font("Arial", Font.PLAIN, 18));
		label2.setBounds(60,140,650,45);
		add(label2);
		
		setLayout(null);
		label2 = new JLabel(pedro.getNombre());
		label2.setFont(new Font("Arial", Font.PLAIN, 18));
		label2.setBounds(220,140,650,45);
		add(label2);
		
		setLayout(null);
		label6 = new JLabel("Codigo  Voucher   : ");
		label6.setFont(new Font("Arial", Font.PLAIN, 18));
		label6.setBounds(60,160,650,45);
		add(label6); 
		
		setLayout(null);
		String cad= cabecera_vou.getNrovou().replace(" ", "");
		Integer nrovou= Integer.parseInt(cad)+1;
		
		label7 = new JLabel(nrovou.toString());
		label7.setFont(new Font("Arial", Font.PLAIN, 18));
		label7.setBounds(220,160,650,45);
		add(label7);
		
		setLayout(null);
		label8 = new JLabel("Nombre Empresa  : ");
		label8.setFont(new Font("Arial", Font.PLAIN, 18));
		label8.setBounds(60,180,650,45);
		add(label8);
		
		setLayout(null);
		label9 = new JLabel(empr.getNombre());
		label9.setFont(new Font("Arial", Font.PLAIN, 18));
		label9.setBounds(220,180,650,45);
		add(label9);
		
		setLayout(null);
		label8 = new JLabel("Cliente  : ");
		label8.setFont(new Font("Arial", Font.PLAIN, 18));
		label8.setBounds(60,200,650,45);
		add(label8);
		
		setLayout(null);
		label9 = new JLabel(depo.getNombre());
		label9.setFont(new Font("Arial", Font.PLAIN, 18));
		label9.setBounds(220,200,650,45);
		add(label9);
				
		setLayout(null);
		label8 = new JLabel("RUC                    	  : ");
		label8.setFont(new Font("Arial", Font.PLAIN, 18));
		label8.setBounds(60,240,650,45);
		add(label8);
		
		setLayout(null);
		label9 = new JLabel(empr.getRuc());
		label9.setFont(new Font("Arial", Font.PLAIN, 18));
		label9.setBounds(220,240,650,45);
		add(label9);
		
		setLayout(null);
		label10 = new JLabel("Conexión             	  : ");
		label10.setFont(new Font("Arial", Font.PLAIN, 18));
		label10.setBounds(60,260,650,45);
		add(label10);
		
		setLayout(null);
		label11 = new JLabel(contrato.getCod_conex());
		label11.setFont(new Font("Arial", Font.PLAIN, 18));
		label11.setBounds(220,260,650,45);
		add(label11);
		
		setLayout(null);
		label10 = new JLabel("Rubro           	         : ");
		label10.setFont(new Font("Arial", Font.PLAIN, 18));
		label10.setBounds(60,280,650,45);
		add(label10);
		
		setLayout(null);
		label11 = new JLabel("Pago Institucion");
		label11.setFont(new Font("Arial", Font.PLAIN, 18));
		label11.setBounds(220,280,650,45);
		add(label11);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		SimpleDateFormat hor = new SimpleDateFormat("HH:mm");
		
		Date dates = new Date();
		
		String dat = sdf.format(dates);
		String hora = hor.format(dates);
		
		setLayout(null);
		label10 = new JLabel("Fecha : ");
		label10.setFont(new Font("Arial", Font.PLAIN, 18));
		label10.setBounds(510,70,650,45);
		add(label10);
		
		setLayout(null);
		label11 = new JLabel(dat);
		label11.setFont(new Font("Arial", Font.PLAIN, 18));
		label11.setBounds(575,70,650,45);
		add(label11);
		
		setLayout(null);
		label10 = new JLabel("Hora   : ");
		label10.setFont(new Font("Arial", Font.PLAIN, 18));
		label10.setBounds(510,90,650,45);
		add(label10);
		
		setLayout(null);
		label11 = new JLabel(hora);
		label11.setFont(new Font("Arial", Font.PLAIN, 18));
		label11.setBounds(575,90,650,45);
		add(label11);
		
		setLayout(null);
		label12 = new JLabel("=COD=======CONCEPTO======IMPORTE=");
		label12.setFont(new Font("Arial", Font.PLAIN, 18));
		label12.setBounds(60,310,650,45);
		add(label12);
		

		
		
		Float monte = 0f; 
		ArrayList<Servicio> aux = contrato.getListaServicios();
		float aPagar = 0 ;
		int siz = aux.size();
		int ejeY =  335;
		cantidadProdcutos = aux.size();
		String montess =Float.toString(monte);
		
		InterfazInicio.setMonto(montess);
		
		for (int i = 0; i < siz; i++) {
			monte = monte + aux.get(i).getMonto();
			setLayout(null);
			label13 = new JLabel(aux.get(i).getCod_serv());
			label13.setFont(new Font("Arial", Font.PLAIN, 18));
			label13.setBounds(70,ejeY,650,45);
			add(label13);
			
			
			setLayout(null);
			label14 = new JLabel(aux.get(i).getDescripcion());
			label14.setFont(new Font("Arial", Font.PLAIN, 18));
			label14.setBounds(165,ejeY,650,45);
			add(label14);
			
			float montoAux = aux.get(i).getMonto();
			String stringMonto=Float.toString(montoAux);  
			setLayout(null);
			label14 = new JLabel(stringMonto);
			label14.setFont(new Font("Arial", Font.PLAIN, 18));
			label14.setBounds(375,ejeY,650,45);
			add(label14);
			
			pivote += 1;
			ejeY =  ejeY + 20;
			aPagar = aPagar + montoAux;
		}
		
			/*while (pivote  < cantidadProdcutos) {
			setLayout(null);
			label13 = new JLabel("416153");
			label13.setFont(new Font("Arial", Font.PLAIN, 18));
			label13.setBounds(70,ejeY,650,45);
			add(label13);
			
			
			setLayout(null);
			label14 = new JLabel("Pago de un Producto");
			label14.setFont(new Font("Arial", Font.PLAIN, 18));
			label14.setBounds(165,ejeY,650,45);
			add(label14);
			
			setLayout(null);
			label14 = new JLabel("490.00");
			label14.setFont(new Font("Arial", Font.PLAIN, 18));
			label14.setBounds(375,ejeY,650,45);
			add(label14);
			
			pivote += 1;
			ejeY =  ejeY + 20;
		
		
		}*/
		
		setLayout(null);
		label15 = new JLabel("=======================================================");
		label15.setFont(new Font("Arial", Font.PLAIN, 18));
		label15.setBounds(60,470,650,45);
		add(label15);
		
		setLayout(null);
		label16 = new JLabel("Periodo       : ");
		label16.setFont(new Font("Arial", Font.PLAIN, 18));
		label16.setBounds(490,310,650,45);
		add(label16);
		
		setLayout(null);
		label17 = new JLabel("14/05");
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(600,310,650,45);
		add(label17);
		
		setLayout(null);
		label16 = new JLabel("A pagar       : ");
		label16.setFont(new Font("Arial", Font.PLAIN, 18));
		label16.setBounds(490,335,650,45);
		add(label16);
		
		String stringAPagar=Float.toString(aPagar);  
		setLayout(null);
		label17 = new JLabel(stringAPagar);
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(600,335,650,45);
		add(label17);
		
		setLayout(null);
		label16 = new JLabel("Mora           : ");
		label16.setFont(new Font("Arial", Font.PLAIN, 18));
		label16.setBounds(490,355,650,45);
		add(label16);
		
		setLayout(null);
		label17 = new JLabel("0.00");
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(600,355,650,45);
		add(label17);
		
		setLayout(null);
		label16 = new JLabel("Recargo      : ");
		label16.setFont(new Font("Arial", Font.PLAIN, 18));
		label16.setBounds(490,375,650,45);
		add(label16);
		
		setLayout(null);
		label17 = new JLabel("0.00");
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(600,375,650,45);
		add(label17);
		
		setLayout(null);
		label16 = new JLabel("Descuento  : ");
		label16.setFont(new Font("Arial", Font.PLAIN, 18));
		label16.setBounds(490,395,650,45);
		add(label16);
		
		setLayout(null);
		label17 = new JLabel("0.00");
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(600,395,650,45);
		add(label17);
		
		setLayout(null);
		label17 = new JLabel("-----------------------------");
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(490,415,650,45);
		add(label17);
		
		setLayout(null);
		label16 = new JLabel("Total a pagar:");
		label16.setFont(new Font("Arial", Font.PLAIN, 18));
		label16.setBounds(480,435,650,45);
		add(label16);
		
		setLayout(null);
		label17 = new JLabel(monte.toString());
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(600,435,650,45);
		add(label17);
		
		setLayout(null);
		label16 = new JLabel("Forma de Pago:");
		label16.setFont(new Font("Arial", Font.PLAIN, 18));
		label16.setBounds(60,495,650,45);
		add(label16);
		
		setLayout(null);
		label17 = new JLabel("Efectivo");
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(200,495,650,45);
		add(label17);
		
		setLayout(null);
		label16 = new JLabel("Valor Total:");
		label16.setFont(new Font("Arial", Font.PLAIN, 18));
		label16.setBounds(60,515,650,45);
		add(label16);
		
		setLayout(null);
		label17 = new JLabel(monte.toString());
		label17.setFont(new Font("Arial", Font.PLAIN, 18));
		label17.setBounds(200,515,650,45);
		add(label17);
	
		
	
		
		/*setLayout(null);
		label6 = new JLabel("Operador : ");
		label6.setFont(new Font("Arial", Font.PLAIN, 18));
		label6.setBounds(100,250,250,30);
		add(label6);
		
		
		t2 = new JTextField();
		t2.setBounds(400,250,200,30);
		add(t2);
		
		setLayout(null);
		label4 = new JLabel("DNI           : ");
		label4.setFont(new Font("Arial", Font.PLAIN, 18));
		label4.setBounds(100,300,250,30);
		add(label4);
		t3 = new JTextField();
		t3.setBounds(400,300,200,30);
		add(t3);*/
		
				
		BT1 = new JButton("IMPRIMIR");
		BT1.setBounds(100,600,200,70);
		BT1.setFont(new Font("Arial", Font.PLAIN, 18));
		add(BT1);
		BT1.addActionListener(this);
		
		BT2 = new JButton("ACEPTAR");
		BT2.setFont(new Font("Arial", Font.PLAIN, 18));
		BT2.setBounds(400,600 	,200,70);
		add(BT2);
		BT2.addActionListener(this);
		
		
		
		
		cabecera_vou cv= new cabecera_vou(nrovou.toString(),dat,"Paga tus compras rapidamente en nuestra cajas rapidas",hora,"credito",depos.getCod_cli(),aggentba.getCod_agb(),"Pago institucion");
		cv.ingresarDatos();
		
		for (int i = 0; i < siz; i++) {
			float montoAux = aux.get(i).getMonto(); 
			detalle_vou det=new detalle_vou(montoAux,nrovou.toString(),aux.get(i).getCod_serv());
			//det.ingresarDatos();
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BT1) {
			
			/*InterfazInicio ventanaMenuPrincipal = new InterfazInicio();
			ventanaMenuPrincipal.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			ventanaMenuPrincipal.setLocationRelativeTo(null);
			ventanaMenuPrincipal.setResizable(false);
			ventanaMenuPrincipal.setVisible(true);
			this.setVisible(false);*/
			JOptionPane.showMessageDialog(null,"SE ESTA IMPRIMIENDO EL VOUCHER");
		}
		if(e.getSource()==BT2) {
			InterfazInicio ventanaDeposito2 = new InterfazInicio();
			ventanaDeposito2.setSize(750, 750);
			//login1.setBounds(0,0,300,250);
			ventanaDeposito2.setLocationRelativeTo(null);
			ventanaDeposito2.setResizable(false);
			ventanaDeposito2.setVisible(true);
			this.setVisible(false);
		}
	}
}