package com.jorgeacetozi.template;

class DefaultProductService implements ProductService {

  private WebServiceClient webservice;

  @Override
  public Product find(int id) {
    return webservice.findProduct(id);
  }

}
