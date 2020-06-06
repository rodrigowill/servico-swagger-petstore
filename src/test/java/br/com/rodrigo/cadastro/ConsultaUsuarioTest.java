package br.com.rodrigo.cadastro;

import static io.restassured.RestAssured.given;

import org.junit.Test;

public class ConsultaUsuarioTest {
	
	@Test
	public void testConsultaUsuariosCadastrados_ConsultaRealizadaComSucesso() {
		
		String urlBase = "https://petstore.swagger.io/v2";
		
		given()
		.when()
			.get(urlBase + "/user/ana195412081")
		.then()
			.statusCode(200)
			.log().all();	
		
		given()
		.when()
			.get(urlBase + "/user/rodrigo195412081")
		.then()
			.statusCode(200)
			.log().all();
		
		given()
		.when()
			.get(urlBase + "/user/tatiana195412081")
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
