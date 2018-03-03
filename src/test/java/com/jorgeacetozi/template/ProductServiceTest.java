package com.jorgeacetozi.template;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
  
  @InjectMocks
  private ProductService productService = new DefaultProductService();
  
  @Mock
  private WebServiceClient webservice;
  
  @Captor
  private ArgumentCaptor<Integer> captor;
  
  @Test
  public void shouldReturnMacbook() {
    final Product webServiceResponse = new Product("macbook");
    doReturn(webServiceResponse).when(webservice).findProduct(1);
    
    Product response = productService.find(1);
    verify(webservice, times(1)).findProduct(captor.capture());
    
    final Integer id = captor.getValue();
    
    Assert.assertThat(response.getName(), Matchers.is(webServiceResponse.getName()));
    Assert.assertThat(id, Matchers.is(1));
  }
  
}
