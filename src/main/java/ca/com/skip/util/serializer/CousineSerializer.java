package ca.com.skip.util.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ca.com.skip.api.model.Cousine;

public class CousineSerializer extends JsonSerializer<Cousine> {
	
	@Override
	public void serialize(final Cousine value, final JsonGenerator jsGenerator, final SerializerProvider serProvider) throws IOException {
		
		jsGenerator.writeStartObject();
		jsGenerator.writeNumberField("id", value.getId());
		jsGenerator.writeStringField("name", value.getName());
		jsGenerator.writeEndObject();
		
	}
	
}
