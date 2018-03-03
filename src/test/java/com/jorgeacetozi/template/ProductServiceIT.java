package com.jorgeacetozi.template;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductServiceIT {
  
  private WebServiceClient webservice;
  
  @Before
  public void setup() {
    webservice = new JerseyWebServiceClient();
  }
  
  @Test
  public void shouldFindProduct() {
    Product product = webservice.findProduct(1);
    Assert.assertThat(product.getName(), Matchers.is("macbook"));
  }

}
