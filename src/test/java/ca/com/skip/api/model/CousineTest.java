package ca.com.skip.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import ca.com.skip.util.serializer.CousineSerializer;

public class CousineTest {
	
	@Test
	public void testSerializer() {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addSerializer(Cousine.class, new CousineSerializer());
		mapper.registerModule(module);
		
		final Cousine cousine = new Cousine();
		
		cousine.setId(1l);
		cousine.setName("chinese");
		
		try {
			
			final String json = mapper.writeValueAsString(cousine);
			
			assertEquals("{\"id\":1,\"name\":\"chinese\"}", json);
			
		} catch (final JsonProcessingException e) {
			
			fail(e.getMessage());
		}
		
	}
	
}
