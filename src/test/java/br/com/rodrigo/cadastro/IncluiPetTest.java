package br.com.rodrigo.cadastro;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.junit.Test;

public class IncluiPetTest {
	
	@Test
	public void testIncluirPet_InclusaoComSucesso() {
		
		String urlBase = "https://petstore.swagger.io/v2";
		
		// Informar categorias de Pet
		
		JSONObject dog = new JSONObject();
		dog.put("id", 1956040511);
		dog.put("name", "dog");
	
		JSONObject cat = new JSONObject();
		cat.put("id", 1956040512);
		cat.put("name", "cat");
		
		JSONObject platypus = new JSONObject();
		platypus.put("id", 1956040513);
		platypus.put("name", "platypus");
		
		
		// Informar os dados dos Pets
		
		JSONObject snoopy = new JSONObject();		
		snoopy.put("id", 198701121);
		snoopy.put("categoria", dog);
		snoopy.put("name", "Snoopy");
		snoopy.put("status", "available");
		
		JSONObject bichento = new JSONObject();		
		bichento.put("id", 198701122);
		bichento.put("categoria", cat);
		bichento.put("name", "Bichento");
		bichento.put("status", "available");
		
		JSONObject perry = new JSONObject();		
		perry.put("id", 198701122);
		perry.put("categoria", platypus);
		perry.put("name", "Perry");
		perry.put("status", "available");

		
		// Realizar cadastro
		
		given()
			.contentType("application/json")
			.body(snoopy).
		when()
			.post(urlBase + "/pet").
		then()
			.statusCode(200)
			.log().body();
	
		given()
			.contentType("application/json")
			.body(bichento).
		when()
			.post(urlBase + "/pet").
		then()
			.statusCode(200)
			.log().body();
		
		given()
			.contentType("application/json")
			.body(perry).
		when()
			.post(urlBase + "/pet").
		then()
			.statusCode(200)
			.log().body();
	}
}	

