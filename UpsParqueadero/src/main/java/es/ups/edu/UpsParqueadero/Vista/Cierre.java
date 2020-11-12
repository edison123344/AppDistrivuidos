package es.ups.edu.UpsParqueadero.Vista;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

public class Cierre {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Cierre window = new Cierre();
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
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.setBounds(39, 204, 75, 25);
		btnCalcular.setText("Calcular");
		
		Button btnGuardar = new Button(shell, SWT.NONE);
		btnGuardar.setBounds(335, 204, 75, 25);
		btnGuardar.setText("Guardar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(68, 31, 290, 156);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

	}

}
