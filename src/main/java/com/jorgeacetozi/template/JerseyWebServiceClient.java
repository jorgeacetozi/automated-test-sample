package com.jorgeacetozi.template;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

class JerseyWebServiceClient implements WebServiceClient {
  
  private static final String WEBSERVICE_URL = "http://www.mocky.io/v2/5a9acdf13400006200a39a3a";
  private Client client = ClientBuilder.newClient();

  @Override
  public Product findProduct(int id) {
    return client
        .target(WEBSERVICE_URL)
        .request(MediaType.APPLICATION_JSON)
        .get(Product.class);
  }

}
