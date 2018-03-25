package ca.com.skip.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import ca.com.skip.util.serializer.StoreDeserializer;
import ca.com.skip.util.serializer.StoreSerializer;

public class StoreTest {
	
	@Test
	public void testSerializer() {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addSerializer(Store.class, new StoreSerializer());
		mapper.registerModule(module);
		
		final Store store = new Store();
		
		final Cousine cousine = new Cousine();
		
		cousine.setId(3l);
		
		store.setId(4l);
		store.setName("liz restaurant");
		store.setAddress("downtown");
		store.setCousine(cousine);
		
		try {
			
			final String json = mapper.writeValueAsString(store);
			
			assertEquals("{\"id\":4,\"name\":\"liz restaurant\",\"address\":\"downtown\",\"cousineId\":3}", json);
			
		} catch (final JsonProcessingException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testDeserializer() {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addDeserializer(Store.class, new StoreDeserializer());
		mapper.registerModule(module);
		
		try {
			
			final Store store = mapper.readValue("{\"id\":3,\"name\":\"chinese fast\",\"address\":\"chinatown\",\"cousineId\":2}", Store.class);
			
			assertEquals(3, store.getId());
			assertEquals("chinese fast", store.getName());
			assertEquals("chinatown", store.getAddress());
			assertEquals(2, store.getIdCousine());
			
		} catch (final IOException e) {
			
			fail(e.getMessage());
		}
	}
	
}
