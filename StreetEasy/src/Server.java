import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
/**
 * Server acts as an interface that facilitates 
 * the interaction between the client and the Streeteasy API
 * The interface is used to provide information about the following property types:
 * <ul>
 * <li>Rentals
 * <li>Sales
 * </ul>
 * @author      Sanjitha Udipi
 */

public class Server {
	/**
	 * The parameters required to initiate the call to the API. 
	 */
	private HashMap<String,String> params= new HashMap<String,String>();
	
	/**
	 * The url that would be generated from the field params. 
	 */
	private String url = "";
	
	/**
	* Checks for valid parameters passed by the client
	* and Initiates a test connection to Street Easy server to make sure the server is up and running
	* @param input parameters passed by the client
	*/
	public void init(HashMap<String,String> input) {
		try {
			for(Map.Entry<String, String> param : input.entrySet()) {
				params.put(param.getKey(),param.getValue());
			}	
			URLConnection connection = new URL(APIProperties.BASE_URL).openConnection();
		    connection.connect();
		    System.out.println("Connection to URL " + APIProperties.BASE_URL + " available.");			
		}
		catch (MalformedURLException e) {
			System.out.println("Bad URL " + APIProperties.BASE_URL);	
		}catch (IOException e) {
			System.out.println("Connection to URL " + APIProperties.BASE_URL+" failed.");	
		}catch(Exception e) {
			System.out.println("Exception thrown  :");
			e.printStackTrace();
		}
	}
	/**
	* Generates the url based on the parameters passed to query the API.
	*/
	private void generateURL() {
		url = APIProperties.BASE_URL +
                "/"+params.get(APIProperties.PROPERTY) +
                "/search?criteria=" +
                "area="+params.get(APIProperties.NEIGHBOURHOOD)+"&" +
                "limit="+params.get(APIProperties.LIMIT)+"&" +
                "order="+params.get(APIProperties.ORDER)+"&" +
                "key="+params.get(APIProperties.APIKEY)+"&" +
                "format="+params.get(APIProperties.FORMAT);
	}
	/**
	* Makes a HTTP call to STreetEasy using @HttpURLConnection.
	* Fetches the data from StreetEasy using GET
	* @return <code>String</code> containing the data from API.
	*/	
	public String getData() {
		generateURL();
		URL obj = null;
		try {
			obj = new URL(url);
		
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
	
			int responseCode = con.getResponseCode();
		 
			System.out.println("Sending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
	
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			con.disconnect();
	
			return response.toString();
		}
		catch (MalformedURLException e) {
			System.out.println("Bad URL " + url);	
		}catch (ProtocolException e) {
			System.out.println("Protocol Error :");	
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Exception thrown  :");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("Exception thrown  :");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
