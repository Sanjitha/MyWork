import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Client invoked by the application that requires API data
 * @author      Sanjitha Udipi
 */
public class Client {
	/**
	* The main method that initiates the connection to the API
	* using the class @see Server.The specifications that determine
	* the data are initialized in this method.
	*/
	public static void main(String[] args) {
		
		HashMap<String,String> params= new HashMap<String,String>();
		params.put(APIProperties.APIKEY,"19db57c959db7bd6e8283a49ce75998008b7d67b");
		params.put(APIProperties.PROPERTY,"sales");
		params.put(APIProperties.NEIGHBOURHOOD,"soho");
		params.put(APIProperties.LIMIT,"20");
		params.put(APIProperties.ORDER,"price_desc");
		params.put(APIProperties.FORMAT,"json");
		try {
			//Server being called for data with respect to most expensive sales listings 
			JSONArray data = new JSONArray();
			Server s = new Server();
			s.init(params);
			String salesData = s.getData();
			JSONObject obj1 = new JSONObject(salesData);
			data.put(obj1);
			
			//Server being called for data with respect to most expensive rentals listings 
			params.replace(APIProperties.PROPERTY,"rentals");
			s.init(params);
			String rentalData = s.getData();
			JSONObject obj2 = new JSONObject(rentalData);
			data.put(obj2);
			
			//Generating the output from the data from sales and rentals in the given format
			generateOutput(data);
			return;
			
		} catch (Exception e) {
			System.out.println("Exception thrown  :");
			e.printStackTrace();
		}
		
	}
	/**
	* Produces the data from the API in the desired format as follows:
	* [{
	* 'listing_class': 'Sale',
	* 'address': '13 Crosby Street', 
	* 'unit': 'Floor 2', 
	* 'url': 'http://streeteasy.com/nyc/sale/1234567',
	* 'price': 55000000 
	* }]
	*/
	private static void generateOutput(JSONArray data) {
		try {
			JSONArray output = new JSONArray();
			JSONArray list ;
			JSONObject tmp,each,listing,obj;
			String url,type,site;
			for (int i = 0;i < data.length(); i++)    {
				obj = data.getJSONObject(i);
				list = obj.getJSONObject(APIProperties.LISTINGS).getJSONArray(APIProperties.OBJECT);
				type = obj.getString(APIProperties.LISTINGS_TYPE);
				site = obj.getString(APIProperties.SITE);
				for(int j=0;j<list.length();j++) {
					tmp = new JSONObject();
					each = (JSONObject) list.get(j);
					listing = new JSONObject();
					url="";
					if(type.equalsIgnoreCase(APIProperties.SALES)) {
						listing = each.getJSONObject(APIProperties.SALE);
						tmp.put(APIProperties.OUTPUT_LISTINGS_CLASS, APIProperties.OUTPUT_SALE);
						url = generateOutputURL(APIProperties.SALE,site,listing.getInt(APIProperties.ID));

					} else if(type.equalsIgnoreCase(APIProperties.RENTALS)){
						listing = each.getJSONObject(APIProperties.RENTAL);
						tmp.put(APIProperties.OUTPUT_LISTINGS_CLASS, APIProperties.OUTPUT_RENTAL);
						url = generateOutputURL(APIProperties.RENTAL,site,listing.getInt(APIProperties.ID));
					} else {
						throw new Exception("Listings invalid "+type);
					}
						
					tmp.put(APIProperties.OUTPUT_ADDRESS, listing.getString(APIProperties.ADDRESS_STREET));
					tmp.put(APIProperties.OUTPUT_UNIT, listing.getString(APIProperties.ADDRESS_UNIT));
					tmp.put(APIProperties.OUTPUT_PRICE, listing.getInt(APIProperties.PRICE));
					tmp.put(APIProperties.OUTPUT_URL, url);
					output.put(tmp);
				}
			}
			
			writeToFile(output);
		} catch (JSONException e) {
			System.out.println("Exception thrown  :");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception thrown  :");
			e.printStackTrace();
		}
	}
	/**
	* Generates the output url to the displayed for each listing 
	* based on the type,site and id of the listing
	* @param type type of the properties i.e Rental or  Sales
	* @param site of the property
	* @param i id of the listing
	*/
	private static String generateOutputURL(String type, String site, int i) {
		return  APIProperties.OUTPUT_BASE_URL +
                "/"+site +
                "/"+type+
                "/"+i;
	}
	/**
	* Writes the data to the file
	*/
	private static void writeToFile(JSONArray obj) {
		FileWriter file;
		try {
			file = new FileWriter("output.json");
			file.write(obj.toString());
			file.flush();
			file.close();
		}
		catch (IOException e) {
			System.out.println("Exception thrown  :");
			e.printStackTrace();
		}
		return;
	}
}
