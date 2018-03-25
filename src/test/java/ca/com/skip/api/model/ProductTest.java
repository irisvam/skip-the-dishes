package ca.com.skip.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import ca.com.skip.util.serializer.ProductDeserializer;
import ca.com.skip.util.serializer.ProductSerializer;

public class ProductTest {
	
	@Test
	public void testSerializer() {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addSerializer(Product.class, new ProductSerializer());
		mapper.registerModule(module);
		
		final Product product = new Product();
		
		final Store store = new Store();
		
		store.setId(4l);
		
		product.setId(1l);
		product.setName("pizza");
		product.setDescription("muzzarela");
		product.setStore(store);
		product.setPrice(2.33);
		
		try {
			
			final String json = mapper.writeValueAsString(product);
			
			assertEquals("{\"id\":1,\"storeId\":4,\"name\":\"pizza\",\"description\":\"muzzarela\",\"price\":2.33}", json);
			
		} catch (final JsonProcessingException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testDeserializer() {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addDeserializer(Product.class, new ProductDeserializer());
		mapper.registerModule(module);
		
		try {
			
			final Product product = mapper.readValue("{\"id\":3,\"storeId\":8,\"name\":\"soup\",\"description\":\"tomato\",\"price\":1.99}",
					Product.class);
			
			assertEquals(3, product.getId());
			assertEquals(8, product.getIdStore());
			assertEquals("soup", product.getName());
			assertEquals("tomato", product.getDescription());
			assertEquals(1.99, product.getPrice(), 0.5);
			
		} catch (final IOException e) {
			
			fail(e.getMessage());
		}
		
	}
	
}
