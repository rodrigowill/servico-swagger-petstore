package br.com.rodrigo.cadastro;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder.Body;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsuarioInclusaoTests {
	
	String urlBase = "https://petstore.swagger.io/v2";
	
	@Test
	public void testIncluirUsuario_InclusaoComSucesso() {
		
		List<JSONObject> request = new ArrayList<JSONObject>();
		
		// Informando os dados do usuário Ana
		JSONObject ana = new JSONObject();
		ana.put("id", "1");
		ana.put("username", "anamaria");
		ana.put("firstName", "Ana");
		ana.put("lastname", "Maria");
		ana.put("email", "anamaria@test.com");
		ana.put("password", "maria");
		ana.put("phone", "1199999999");
		ana.put("userStatus", "1"); // Status 1 = Ativo
		request.add(ana);
		
		// Informando os dados do usuário Rodrigo
		JSONObject rodrigo = new JSONObject();
		rodrigo.put("id", "1");
		rodrigo.put("username", "rodrigomendes");
		rodrigo.put("firstName", "Rodrigo");
		rodrigo.put("lastname", "Mendes");
		rodrigo.put("email", "rodrigo@test.com");
		rodrigo.put("password", "rodrigo");
		rodrigo.put("phone", "1199999999");
		rodrigo.put("userStatus", "1"); // Status 1 = Ativo
		request.add(rodrigo);
		
		System.out.println(request);
		
		Response res=
			given()
				.contentType("application/json")
				.body(request).
			when()
				.post(urlBase + "/user/createWithList").
			then()
				.statusCode(200)
				.log().body()
				.extract().response();
		
		String jsonStringResponse = res.asString();
		Assert.assertEquals(jsonStringResponse.contains("ok"), true);		
	}
	
	@Test
	public void testConsultaUsuario_UsuarioConcultadoComSucesso() {

		given()
		.when()
			.get(urlBase + "/user/anamaria")
		.then()
			.statusCode(200);		
	}

}
