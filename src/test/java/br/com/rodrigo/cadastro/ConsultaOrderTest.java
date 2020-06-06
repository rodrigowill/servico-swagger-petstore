package br.com.rodrigo.cadastro;

import static io.restassured.RestAssured.given;

import org.junit.Test;

public class ConsultaOrderTest {
	
	@Test
	public void testConsultarOrdem_ConsultaComSucesso() {
		
		String urlBase = "https://petstore.swagger.io/v2";
		
		given()
			.contentType("application/json").
		when()
			.get(urlBase + "/store/order/1").
		then()
			.statusCode(200)
			.log().body(); 
		
		given()
			.contentType("application/json").
		when()
			.get(urlBase + "/store/order/2").
		then()
			.statusCode(200)
			.log().body(); 
		
		given()
			.contentType("application/json").
		when()
			.get(urlBase + "/store/order/3").
		then()
			.statusCode(200)
			.log().body(); 
	}

}
