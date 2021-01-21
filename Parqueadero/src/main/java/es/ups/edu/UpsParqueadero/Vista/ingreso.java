package es.ups.edu.UpsParqueadero.Vista;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class ingreso {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ingreso window = new ingreso();
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
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(41, 226, 75, 25);
		btnNewButton.setText("Limpiar");
		
		Button btnGuardar = new Button(shell, SWT.NONE);
		btnGuardar.setBounds(257, 226, 75, 25);
		btnGuardar.setText("Guardar");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(25, 181, 130, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(230, 181, 130, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(25, 134, 130, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(25, 86, 130, 21);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(25, 42, 130, 21);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(227, 130, 75, 25);
		btnNewButton_1.setText("Buscar");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(25, 21, 55, 15);
		label.setText("#");
		
		Label lblFechaYHora = new Label(shell, SWT.NONE);
		lblFechaYHora.setBounds(25, 69, 75, 15);
		lblFechaYHora.setText("Fecha y Hora");
		
		Label lblPlaca = new Label(shell, SWT.NONE);
		lblPlaca.setBounds(25, 113, 55, 15);
		lblPlaca.setText("Placa");
		
		Label lblMarca = new Label(shell, SWT.NONE);
		lblMarca.setBounds(25, 161, 55, 15);
		lblMarca.setText("Marca");
		
		Label lblColor = new Label(shell, SWT.NONE);
		lblColor.setBounds(230, 161, 55, 15);
		lblColor.setText("Color");

	}
}
