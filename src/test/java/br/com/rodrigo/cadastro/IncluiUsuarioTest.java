package br.com.rodrigo.cadastro;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import io.restassured.response.Response;

@RunWith(Parameterized.class)
public class IncluiUsuarioTest {
	
	@Parameter
	public int id;
	@Parameter(value=1)
	public String username;
	@Parameter(value=2)
	public String firstName;
	@Parameter(value=3)
	public String lastname;
	@Parameter(value=4)
	public String email;
	@Parameter(value=5)
	public String password;
	@Parameter(value=6)
	public String phone;
	@Parameter(value=7)
	public int userStatus;
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{195412081, "ana195412081", "Ana", "Maia", "anamaria@test.com", "ana", "1199999999", 1},
			{195412082, "rodrigo195412081", "Rodrigo", "Mendes", "rodrigo@test.com", "rodrigo", "11988888888", 1},
			{195412083, "tatiana195412081", "Tatiana", "Vasconcelos", "tatiana@test.com", "tatiana", "11977777777", 1}
		});
	}
	
	@Test
	public void testIncluirUsuario_InclusaoComSucesso() {
		
		String urlBase = "https://petstore.swagger.io/v2";
		
		List<JSONObject> request = new ArrayList<JSONObject>();
		
		JSONObject usuario = new JSONObject();
		usuario.put("id", id);
		usuario.put("username", username);
		usuario.put("firstName", firstName);
		usuario.put("lastname", lastname);
		usuario.put("email", email);
		usuario.put("password", password);
		usuario.put("phone", phone);
		usuario.put("userStatus", userStatus); // Status 1 = Ativo
		
		request.add(usuario);
		
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
