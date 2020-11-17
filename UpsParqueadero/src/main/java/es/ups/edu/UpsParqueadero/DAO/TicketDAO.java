package es.ups.edu.UpsParqueadero.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;

import es.ups.edu.UpsParqueadero.Modelo.Ticket;

public class TicketDAO {
	@Inject
	private Connection c = null;
	private Statement stmt = null;
	private PreparedStatement prest = null;

	public boolean inser(Ticket entity) {
		try {
			stmt = c.createStatement();
			String sql = "INSERT INTO Ticket VALUES (codigo,fechaIngreso,fechaSalida,tiempo,valor)" + "(?,?,?,?,?)";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return false;
		}
		System.out.println("Records created successfully");
		return true;
	}

	public boolean update(Ticket entity) {
		try {

			stmt = c.createStatement();

			String sql = "UPDATE vehiculo SET tiempo=?, fechaIngreso=? , fechaSalida=?" 
			+ "WHERE codigo=?";

			prest = c.prepareStatement(sql);

			prest.setDate(1, entity.getFecha_Ingreso());
			prest.setDate(2, entity.getFecha_Salida());
			prest.setInt(3, entity.getTiempo());
			prest.setInt(4, entity.getCodigo());
			if (prest.executeUpdate() > 0) {

				System.err.println("Los datos han sido modificados con éxito" + "Operación Exitosa");
				return true;
			} else {

				System.err.println("No se ha podido realizar la actualización de los datos\n"
						+ "Inténtelo nuevamente.Error en la operación");
				return false;
			}

		} catch (SQLException e) {

			System.err.println("No se ha podido realizar la actualización de los datos\n" + "Inténtelo nuevamente.\n"
					+ "Error en la operación");
			return false;

		} finally {

			if (c != null) {

				try {

					c.close();

				} catch (SQLException e) {

					System.err.println("Error al intentar cerrar la conexión. Error en la operación");
					return false;
				}

			}

		}

	}

	public Ticket read(int id) {
		try {
			PreparedStatement pstm = c.prepareCall("SELECT * FROM Ticket where codigo = " + id);
			ResultSet rset = pstm.executeQuery();
			while (rset.next()) {
				rset.getString(1);

			}

		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}

		return null;

	}

	public boolean delite(int id) {
		boolean resultado = false;

		try {
			stmt = c.createStatement();
			String sql = "Delete from Ticket where id = " + id;
			stmt.executeUpdate(sql);
			int valor = stmt.executeUpdate(sql);
			if (valor > 0) {
				resultado = true;
			}

		} catch (Exception e) {
			System.err.println("Error al eliminar" + e.getMessage());
		}
		return resultado;
	}
}
