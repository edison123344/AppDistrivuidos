package clienteON;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import clienteModelo.Libro;





public class HttpConeccion {

	private static final String USER_AGENT = "Mozilla/5.0";

	//private static final String GET_URL = "http://localhost:8090/Fereteria/ws/Provedores/listarProvedores";

	private static final String POST_URL = "http://localhost:8090/Biblioteca/ws/biblioteca/reserva";

	private static final String POST_PARAMS = "userName=Pankaj";

	/*public static void main(String[] args) throws IOException {

		//sendGET();
		//System.out.println("GET DONE");
		sendPOST();
		System.out.println("POST DONE");
	}
*/
	public static String  sendGET() throws IOException {
		URL obj = new URL("http://localhost:8090/Biblioteca/ws/biblioteca/listarLibros");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			return response.toString();
		} else {
			return "GET request not worked";
		}

	}

	public static String sendPOST(Libro pr) throws IOException {
	
		 try {

		       URL url = new URL(POST_URL);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setDoOutput(true);
		        conn.setRequestMethod("POST");
		        conn.setRequestProperty("Content-Type", "application/json");
		    //    pr.getFereteria();
		       // String input = null;
		       String input = "{\"autor\":{\"id\":1,\"nombre\":\"juan\"},\"categoria\":\"quimica\",\"estado\":\"disponible\",\"id\":1,"
		       		+ "\"nombre\":\""+pr.getNombre()+"\""
		       		+ ",\"numero\":1}";
		        		//+ "\"nombre\":\""+pr.getNombre()+"}";
		        //		+ "\"nombreProducto\":\""+pr.getNombreProducto()+"\","
		        //		+ "\"stok\":"+pr.getStok()+"}";
              System.out.println(input);
		       ///{"autor":{"id":1,"nombre":"juan"},"categoria":"quimica","estado":"disponible","id":1,"nombre":"quimica","numero":1}
		       OutputStream os = conn.getOutputStream();
		        os.write(input.getBytes());
		        os.flush();
		       
		       /* if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
		            throw new RuntimeException("Failed : HTTP error code : "
		                + conn.getResponseCode());
		        }*/

		        BufferedReader br = new BufferedReader(new InputStreamReader(
		                (conn.getInputStream())));

		        String output;
		       
		        while ((output = br.readLine()) != null) {
		           return output;
		        }

		        conn.disconnect();

		     } catch (MalformedURLException e) {

		        e.printStackTrace();

		      } catch (IOException e) {

		        e.printStackTrace();
		        return null;
	            }
		   return null;
}
	
	public static String  categoriaGET(String categoria) throws IOException {
		URL obj = new URL("http://localhost:8090/Biblioteca/ws/biblioteca/listarCategoria?categoria="+categoria);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			return response.toString();
		} else {
			return "GET request not worked";
		}

	}

}