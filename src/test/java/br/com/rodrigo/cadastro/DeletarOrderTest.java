package br.com.rodrigo.cadastro;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import io.restassured.http.ContentType;

public class DeletarOrderTest {
	
	@Test
	public void testDeletarOrdem_DelecaoComSucesso() {	
		String urlBase = "https://petstore.swagger.io/v2";
		
		given()
			.contentType("application/json").
		when()
			.delete(urlBase + "/store/order/1").
		then()
			.statusCode(200)
			.log().body(); 
		
		given()
			.contentType("application/json").
		when()
			.delete(urlBase + "/store/order/2").
		then()
			.statusCode(200)
			.log().body(); 
		
		given()
			.contentType("application/json").
		when()
			.delete(urlBase + "/store/order/3").
		then()
			.statusCode(200)
			.log().body(); 
	}
}
