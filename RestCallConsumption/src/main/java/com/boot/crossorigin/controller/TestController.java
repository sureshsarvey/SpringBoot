package com.boot.crossorigin.controller;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Test2")
public class TestController {
	
	@GetMapping("/test2")
	public ResponseEntity<Object> test2()
	{
		 /*org.springframework.http.HttpHeaders header=new org.springframework.http.HttpHeaders();
       	header.setContentType(MediaType.APPLICATION_JSON);
     	 HttpEntity<String> entity = new HttpEntity<String>(header);
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> response1 = template.exchange("http://192.168.1.155:8999/Test1/test1", HttpMethod.GET, entity, String.class);*/
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		HttpGet httpPost = new HttpGet("http://192.168.1.155:8999/Test1/test1");
		httpClient = HttpClients.createDefault();
		String json = "test";
		try {
			httpResponse = httpClient.execute(httpPost);
			json = EntityUtils.toString(httpResponse.getEntity());
			return ResponseEntity.ok().body(json);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (httpResponse != null && httpClient != null) {
				try {
					httpResponse.close();
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	

}
