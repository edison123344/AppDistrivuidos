package Ezamen.EdisonHuinaizaca.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ezamen.EdisonHuinaizaca.Modelo.Autor;
import Ezamen.EdisonHuinaizaca.Modelo.Registro;
import Ezamen.EdisonHuinaizaca.ON.RegistroRemoto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class RegistrarLibro extends JFrame {

	private JPanel contentPane;
	private JTextField textlibro;
	private JTextField textIdLibro;
	private JTextField textEditorial;
	private JTextField textnombre;
	private JTextField textApellido;
	private RegistroRemoto remotoON;
	private JLabel lblNewLabel_5;
	private JTextField txtIdA;
	private JButton btnNewButton;
	private JTextField textidBuscar;
	private JLabel lblNewLabel_6;
	private JTextArea textlista;
	private JLabel lblNewLabel_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarLibro frame = new RegistrarLibro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Registrar = new JButton("Registrar");
		Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guardar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Registrar.setBounds(52, 205, 89, 23);
		contentPane.add(Registrar);
		
		textlibro = new JTextField();
		textlibro.setBounds(26, 55, 86, 20);
		contentPane.add(textlibro);
		textlibro.setColumns(10);
		
		textIdLibro = new JTextField();
		textIdLibro.setBounds(149, 55, 86, 20);
		contentPane.add(textIdLibro);
		textIdLibro.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Libro");
		lblNewLabel.setBounds(26, 29, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IdLibro");
		lblNewLabel_1.setBounds(146, 30, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Autor");
		lblNewLabel_2.setBounds(36, 96, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Editorial");
		lblNewLabel_3.setBounds(296, 29, 57, 14);
		contentPane.add(lblNewLabel_3);
		
		textEditorial = new JTextField();
		textEditorial.setBounds(289, 55, 86, 20);
		contentPane.add(textEditorial);
		textEditorial.setColumns(10);
		
		textnombre = new JTextField();
		textnombre.setBounds(26, 128, 86, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido Autor");
		lblNewLabel_4.setBounds(149, 96, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		textApellido = new JTextField();
		textApellido.setBounds(149, 128, 86, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		lblNewLabel_5 = new JLabel("id");
		lblNewLabel_5.setBounds(262, 96, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtIdA = new JTextField();
		txtIdA.setBounds(289, 128, 86, 20);
		contentPane.add(txtIdA);
		txtIdA.setColumns(10);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarlibro();
			}

			
		});
		btnNewButton.setBounds(236, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		textidBuscar = new JTextField();
		textidBuscar.setBounds(236, 196, 86, 20);
		contentPane.add(textidBuscar);
		textidBuscar.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Ingrese codigo");
		lblNewLabel_6.setBounds(236, 169, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		textlista = new JTextArea();
		textlista.setBackground(Color.LIGHT_GRAY);
		textlista.setBounds(36, 283, 317, 128);
		contentPane.add(textlista);
		
		lblNewLabel_7 = new JLabel("lista libros");
		lblNewLabel_7.setBounds(26, 258, 115, 14);
		contentPane.add(lblNewLabel_7);
	}
	
	public void guardar()throws Exception {
		Registro registro = new Registro();
		Autor autor =new Autor();
		registro.setId(Integer.parseInt(textIdLibro.getText()));
		registro.setNomLibro(textlibro.getText());
		autor.setApellido(textApellido.getText());
		autor.setNombre(textnombre.getText());
		autor.setCodigo(Integer.parseInt(txtIdA.getText()));
		registro.setAutor(autor);
	try {
		this.remotoON.registrar(registro);
		System.out.print("Insercion OK");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}
	}
	private void buscarlibro() {
		// TODO Auto-generated method stub
		textlista.setText(this.remotoON.getConsulta().toString());
		
	}
	public void intanciarObjetoNegocio() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb-01");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:Examen.EdisonHuinaizaca.ON.RegistroRemoto";  
              
            this.remotoON = (RegistroRemoto) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
}
