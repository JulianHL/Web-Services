package webCarREST;

import java.io.InputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("WebCar")
public class WebCarResource {
	
	private HashMap<String, Car> carMap;
	Iterator <String> iterator;
	
	
	public void fillCarMap() {
		carMap = new HashMap<>();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Car.in");
		Scanner inFile = new Scanner(inputStream);
		
		while(inFile.hasNext()) {
			String vin = inFile.next();
			String desc = inFile.next();
			double price = inFile.nextDouble();
			Car car = new Car(vin, desc, price);
			carMap.put(car.getVin(), car);
		}
		inFile.close();
		
		iterator = carMap.keySet().iterator();
	}

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayHTMLCarInfo() {
		fillCarMap();
		String html = "<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "    <head>\r\n"
				+ "        <meta charset=\"UTF-8\" />\r\n"
				+ "        <title>Car</title>\r\n"
				+ "        <!--BoostTrap CSS -->\r\n"
				+ "        <link\r\n"
				+ "            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n"
				+ "            rel=\"stylesheet\"\r\n"
				+ "            integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n"
				+ "            crossorigin=\"anonymous\" />\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <h1>Print Car Elements of HashMap collection</h1>\r\n"
				+ "        <table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">Cae VIN</th>\r\n"
				+ "                    <th scope=\"col\">Car Desc</th>\r\n"
				+ "                    <th scope=\"col\">Car Price</th>\r\n"
				+ "                    <th scope=\"col\">Car Price with Discount</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>";
		double totalDisc = 0;
		while(iterator.hasNext()) {
			String vin = iterator.next();
			html += "                <tr>\r\n"
					+ "                    <th scope=\"row\">"+vin+"</th>\r\n"
					+ "                    <td>"+carMap.get(vin).getDesc()+"</td>\r\n"
					+ "                    <td>"+carMap.get(vin).getPrice()+"</td>\r\n"
					+ "                    <td>"+carMap.get(vin).discountPrice()+"</td>\r\n"
					+ "                </tr>";
			totalDisc += carMap.get(vin).discountPrice();
		}
		html += "            </tbody>\r\n"
				+ "        </table>"
				+ "        <h1>The Total Car Price after Discount is: "+totalDisc+"</h1>\r\n"
				+ "        <br>\r\n"
				+ "        <h1>Car HashMap Car Info Sorted (Sorted by value discountPrice)</h1>\r\n"
				+ "        <table class=\"table\">\r\n"
				+ "            <thead class=\"table-dark\">\r\n"
				+ "                <tr>\r\n"
				+ "                    <th scope=\"col\">Cae VIN</th>\r\n"
				+ "                    <th scope=\"col\">Car Desc</th>\r\n"
				+ "                    <th scope=\"col\">Car Price</th>\r\n"
				+ "                    <th scope=\"col\">Car Price with Discount</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>";
		iterator = carMap.keySet().stream().sorted(Comparator.comparing( key -> carMap.get(key).discountPrice())).iterator();
		while(iterator.hasNext()) {
			String vin = iterator.next();
			html += "                <tr>\r\n"
					+ "                    <th scope=\"row\">"+vin+"</th>\r\n"
					+ "                    <td>"+carMap.get(vin).getDesc()+"</td>\r\n"
					+ "                    <td>"+carMap.get(vin).getPrice()+"</td>\r\n"
					+ "                    <td>"+carMap.get(vin).discountPrice()+"</td>\r\n"
					+ "                </tr>";
		}
		html+="            </tbody>\r\n"
				+ "        </table>\r\n"
				+ "\r\n"
				+ "        <!--BoostTrap JS-->\r\n"
				+ "        <script\r\n"
				+ "            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "            integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n"
				+ "            crossorigin=\"anonymous\"></script>\r\n"
				+ "    </body>\r\n"
				+ "</html>";
		
		
		
		return html;
		
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String displayTextCarInfo () {
		fillCarMap();
		String result = "";
		double totalDisc = 0;
		
		while(iterator.hasNext()) {
			String vin = iterator.next();
			result += carMap.get(vin) + "\n";
			totalDisc += carMap.get(vin).discountPrice();
		}
		result += "\nThe Total Car Price after Discount is:"+totalDisc+"\n\n";
		
		result += "\nCar HashMap Car Info Sorted (Sorted by value discountPrice):\n";
		iterator = carMap.keySet().stream().sorted(Comparator.comparing( key -> carMap.get(key).discountPrice())).iterator();
		while(iterator.hasNext()) {
			String vin = iterator.next();
			result += carMap.get(vin) + "\n";
		}
		
		return result;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> displayJSONCarInfo (){
		fillCarMap();
		return carMap.values().stream().collect(Collectors.toList());
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchCar/{car_vin}")
	public Car searchJSONCarInfo(@PathParam("car_vin") String car_vin){
		fillCarMap();
		return carMap.get(car_vin);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/TotalCarPriceDiscount")
	public double calculateTotalCarPriceDiscount() {
		
		fillCarMap();
		double result = 0;
		while(iterator.hasNext()) {
			String vin = iterator.next();
			result += carMap.get(vin).discountPrice();
		}
		
		return result;
	}
	
	
}
