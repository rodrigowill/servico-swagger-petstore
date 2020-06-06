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

public class IncluiUsuarioTest {
	
	@Test
	public void testIncluirUsuario_InclusaoComSucesso() {
		
		String urlBase = "https://petstore.swagger.io/v2";
		
		List<JSONObject> request = new ArrayList<JSONObject>();
		
		// Informando os dados do usuário Ana
		JSONObject ana = new JSONObject();
		ana.put("id", "195412081");
		ana.put("username", "ana195412081");
		ana.put("firstName", "Ana");
		ana.put("lastname", "Maia");
		ana.put("email", "anamaria@test.com");
		ana.put("password", "ana");
		ana.put("phone", "1199999999");
		ana.put("userStatus", "1"); // Status 1 = Ativo
		request.add(ana);
		
		// Informando os dados do usuário Rodrigo
		JSONObject rodrigo = new JSONObject();
		rodrigo.put("id", "195412082");
		rodrigo.put("username", "rodrigo195412081");
		rodrigo.put("firstName", "Rodrigo");
		rodrigo.put("lastname", "Mendes");
		rodrigo.put("email", "rodrigo@test.com");
		rodrigo.put("password", "rodrigo");
		rodrigo.put("phone", "11988888888");
		rodrigo.put("userStatus", "1"); // Status 1 = Ativo
		request.add(rodrigo);
		
		// Informando os dados do usuário Tatiana
		JSONObject tatiana = new JSONObject();
		tatiana.put("id", "195412083");
		tatiana.put("username", "tatiana195412081");
		tatiana.put("firstName", "Tatiana");
		tatiana.put("lastname", "Vasconcelos");
		tatiana.put("email", "tatiana@test.com");
		tatiana.put("password", "tatiana");
		tatiana.put("phone", "11977777777");
		tatiana.put("userStatus", "1"); // Status 1 = Ativo
		request.add(tatiana);
		
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
	


}
