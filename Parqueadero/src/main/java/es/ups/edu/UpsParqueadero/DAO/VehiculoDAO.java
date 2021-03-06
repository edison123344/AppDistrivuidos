package es.ups.edu.UpsParqueadero.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Inject;

import es.ups.edu.UpsParqueadero.Modelo.Vehiculo;

public class VehiculoDAO {
	@Inject
	private Connection c = null;
	private Statement stmt = null;
	private PreparedStatement prest = null;

	public boolean insert(Vehiculo entity) {
		try {
			stmt = c.createStatement();
			String sql = "INSERT INTO vehiculo VALUES (placa,marca,color)" + "(?,?<?)";
			stmt.executeUpdate(sql);
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return false;
		}
		System.out.println("Records created successfully");
		return true;
	}

	public boolean update(Vehiculo entity) {

		try {

			stmt = c.createStatement();

			String sql = "UPDATE vehiculo SET marca=?, color=? " + "WHERE placa=?";

			prest = c.prepareStatement(sql);

			prest.setString(1, entity.getPlaca());
			prest.setString(2, entity.getMarca());
			prest.setString(3, entity.getColor());

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

	public Vehiculo read(int id) {

		try {
			PreparedStatement pstm = c.prepareCall("SELECT * FROM vehiculo where placa = " + id);
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
			String sql = "Delete from vehiculo where placa = " + id;
			stmt.executeUpdate(sql);
			int valor = stmt.executeUpdate(sql);
			if (valor > 0) {
				resultado = true;
			}
			c.close();

		} catch (Exception e) {
			System.err.println("Error al eliminar" + e.getMessage());
		}
		return resultado;

	}
}
