package com.excelr.DemoService.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.DemoService.entity.AmazonProducts;
import com.excelr.DemoService.repository.AmazonProductRepository;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AmazonProductService {

	@Autowired
	AmazonProductRepository amazonproductrepo;

	public List<AmazonProducts> addAmazonproductsFromJSONFIle() {
		ObjectMapper mapper=new ObjectMapper();
		TypeReference<List<AmazonProducts>> typeReference = new TypeReference<List<AmazonProducts>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/products.json");
        List<AmazonProducts> products=null;
        try {
			products = mapper.readValue(inputStream,typeReference);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return amazonproductrepo.saveAll(products);
		
	}
	
}
