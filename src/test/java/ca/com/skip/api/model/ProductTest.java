package ca.com.skip.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

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
	
}
