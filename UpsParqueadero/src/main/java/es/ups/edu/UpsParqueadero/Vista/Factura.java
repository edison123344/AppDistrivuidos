package es.ups.edu.UpsParqueadero.Vista;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class Factura {

	protected Shell shell;
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Factura window = new Factura();
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
		shell.setSize(469, 368);
		shell.setText("SWT Application");
		
		Button btnImprimir = new Button(shell, SWT.NONE);
		btnImprimir.setBounds(71, 276, 75, 25);
		btnImprimir.setText("Imprimir");
		
		Button btnLimpiar = new Button(shell, SWT.NONE);
		btnLimpiar.setBounds(291, 276, 75, 25);
		btnLimpiar.setText("Limpiar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(59, 174, 307, 77);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(59, 78, 87, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(59, 34, 87, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(275, 34, 91, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(59, 127, 87, 21);
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setBounds(59, 10, 55, 15);
		lblId.setText("ID");
		
		Label lblFechaYHora = new Label(shell, SWT.NONE);
		lblFechaYHora.setBounds(275, 13, 75, 15);
		lblFechaYHora.setText("Fecha y Hora");
		
		Label lblNombre = new Label(shell, SWT.NONE);
		lblNombre.setBounds(59, 57, 55, 15);
		lblNombre.setText("Nombre");
		
		Label lblApellido = new Label(shell, SWT.NONE);
		lblApellido.setBounds(59, 105, 55, 15);
		lblApellido.setText("Apellido");
		
		Label lblDetalleFactura = new Label(shell, SWT.NONE);
		lblDetalleFactura.setBounds(158, 153, 87, 15);
		lblDetalleFactura.setText("Detalle factura");

	}
}
