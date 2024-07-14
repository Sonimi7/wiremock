package ru.otus.stub.helpers;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class Helper {

//  private static final String URI = "http://localhost:";
//
//  public static String get(int port, String endpoint) throws IOException, ParseException {
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//    HttpGet httpGet = new HttpGet(URI + port + endpoint);
//
//    CloseableHttpResponse response = httpClient.execute(httpGet);
//    String responseBody = EntityUtils.toString(response.getEntity());
//
//    return responseBody;
//  }
}
