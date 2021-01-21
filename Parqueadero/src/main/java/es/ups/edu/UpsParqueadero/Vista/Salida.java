package es.ups.edu.UpsParqueadero.Vista;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

public class Salida {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Label lblTotalAPagar;
	private Label lblTotalHoras;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Salida window = new Salida();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(46, 35, 105, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(46, 84, 105, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(46, 127, 105, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(46, 177, 105, 21);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(228, 127, 114, 21);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(228, 177, 114, 21);
		
		Button btnCobrar = new Button(shell, SWT.NONE);
		btnCobrar.setBounds(60, 214, 75, 25);
		btnCobrar.setText("Cobrar");
		
		Button btnLimpiar = new Button(shell, SWT.NONE);
		btnLimpiar.setBounds(240, 214, 75, 25);
		btnLimpiar.setText("Limpiar");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(46, 10, 55, 15);
		label.setText("#");
		
		Label lblPlaca = new Label(shell, SWT.NONE);
		lblPlaca.setBounds(46, 63, 55, 15);
		lblPlaca.setText("Placa");
		
		Label lblFechaYHora = new Label(shell, SWT.NONE);
		lblFechaYHora.setBounds(228, 108, 114, 15);
		lblFechaYHora.setText("Fecha y Hora Salida");
		
		Label lblFechaYHora_1 = new Label(shell, SWT.NONE);
		lblFechaYHora_1.setBounds(46, 111, 123, 15);
		lblFechaYHora_1.setText("Fecha y Hora Ingraso");
		
		lblTotalAPagar = new Label(shell, SWT.NONE);
		lblTotalAPagar.setBounds(46, 156, 75, 15);
		lblTotalAPagar.setText("Total a pagar");
		
		lblTotalHoras = new Label(shell, SWT.NONE);
		lblTotalHoras.setBounds(228, 156, 68, 15);
		lblTotalHoras.setText("Total Horas");

	}

}
