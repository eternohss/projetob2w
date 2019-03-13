package br.com.b2w.recurso.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class SwapiService {

	private String json_str() throws Exception {
		
		StringBuilder result = new StringBuilder();

		String urlString = "https://swapi.co/api/planets/?format=json";

		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; "
		            + "Windows NT 5.1; en-US; rv:1.8.0.11) ");
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();
		return result.toString();
	}

	private JSONArray montaObjeto() throws Exception {

		String json_str;

		json_str = json_str();

		JSONObject my_obj = new JSONObject(json_str);

		JSONArray jsonArray = my_obj.getJSONArray("results");

		return jsonArray;
	}

	public int quantidadeAparicao(String planetaNome) {

		JSONArray montaObjeto = null;
		try {
			montaObjeto = this.montaObjeto();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int quantidadePlanetas = montaObjeto.length();

		int quantidadeAparicoes = 0;
		
		for (int i = 0; i < quantidadePlanetas; i++) {
			
			try {
				
				JSONObject jsonObject = montaObjeto.getJSONObject(i);
				
				if(jsonObject.getString("name").equals(planetaNome)){
					JSONArray jsonArray = jsonObject.getJSONArray("films");
					quantidadeAparicoes = jsonArray.length();
				}
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return quantidadeAparicoes;
	}
	
	public List<String> listaPlanetas() {
		

		JSONArray montaObjeto = null;
		try {
			montaObjeto = this.montaObjeto();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int quantidadePlanetas = montaObjeto.length();
		
		List planetasNomes = new ArrayList<>();
		
		for (int i = 0; i < quantidadePlanetas; i++) {
			
			try {
				
				JSONObject jsonObject = montaObjeto.getJSONObject(i);
							
				planetasNomes.add(jsonObject.getString("name"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return planetasNomes;
	}

}
