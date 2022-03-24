package pack.prjC.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class ApiService {

	public void getApi(Model model) {
		String key = "QWmRBRgQFVjPLxlHE0NTfMfwlmHMGKmPqTeI1D%2BPhZO2gQzZpIR0ycYZCtH%2BN7p8W7amKDhwRqHFzjCfSU%2Fvzw%3D%3D";
		String result = "";
		
		try {
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/14710001/FoodNtrIrdntInfoService/getFoodNtrItdntList1");
			urlBuilder.append("?"+URLEncoder.encode("serviceKey","UTF-8") + "=" + key);
			urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Context-type", "application-json");
			System.out.println("Response code : "+conn.getResponseCode());
			
			BufferedReader br;
			
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line;
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			conn.disconnect();
			
			/*
			 * JSONParser josnParser = new JSONParser(); JSONPObject jsonpObject =
			 * (JSONPObject)JSONParser.parse(sb);
			 */
			
			model.addAttribute("result", result);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}
}
