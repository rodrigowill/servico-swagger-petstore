package br.com.rodrigo.cadastro;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class IncluiOrderTest {

	@Parameter
	public int id;
	@Parameter(value=1)
	public int petId;
	@Parameter(value=2)
	public int quantity;
	@Parameter(value=3)
	public String shipDate;
	@Parameter(value=4)
	public String status;
	@Parameter(value=5)
	public boolean complete;
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		
		Date data = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		return Arrays.asList(new Object[][] {
			{1, 198701122, 1, df.format(data), "placed", true},
			{2, 198701121, 1, df.format(data), "placed", true},
			{3, 198701123, 1, df.format(data), "placed", true}
		});
	}
	
	@Test
	public void testIncluirOrdem_InclusaoComSucesso() {	

		String urlBase = "https://petstore.swagger.io/v2";
		
		JSONObject order = new JSONObject();
		order.put("id", id);
		order.put("petId", petId);
		order.put("quantity", quantity);
		order.put("shipDate", shipDate);
		order.put("status", status);
		order.put("complete", complete);
		
		given()
			.contentType("application/json")
			.body(order).
		when()
			.post(urlBase + "/store/order").
		then()
			.statusCode(200)
			.log().body();
		
	}
	
}
