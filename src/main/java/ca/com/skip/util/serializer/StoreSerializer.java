package ca.com.skip.util.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ca.com.skip.api.model.Store;

public class StoreSerializer extends JsonSerializer<Store> {
	
	@Override
	public void serialize(final Store value, final JsonGenerator jsGenerator, final SerializerProvider serProvider) throws IOException {
		
		jsGenerator.writeStartObject();
		jsGenerator.writeNumberField("id", value.getId());
		jsGenerator.writeStringField("name", value.getName());
		jsGenerator.writeStringField("address", value.getAddress());
		jsGenerator.writeNumberField("cousineId", value.getCousine().getId());
		jsGenerator.writeEndObject();
	}
	
}
