package ca.com.skip.util.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ca.com.skip.api.model.Product;

public class ProductSerializer extends JsonSerializer<Product> {
	
	@Override
	public void serialize(final Product value, final JsonGenerator jsGenerator, final SerializerProvider serProvider) throws IOException {
		
		jsGenerator.writeStartObject();
		jsGenerator.writeNumberField("id", value.getId());
		jsGenerator.writeNumberField("storeId", value.getStore().getId());
		jsGenerator.writeStringField("name", value.getName());
		jsGenerator.writeStringField("description", value.getDescription());
		jsGenerator.writeNumberField("price", value.getPrice());
		jsGenerator.writeEndObject();
		
	}
	
}
