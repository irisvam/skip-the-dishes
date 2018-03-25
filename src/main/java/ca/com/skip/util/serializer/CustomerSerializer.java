package ca.com.skip.util.serializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ca.com.skip.api.model.Customer;

public class CustomerSerializer extends JsonSerializer<Customer> {
	
	@Override
	public void serialize(final Customer value, final JsonGenerator jsGenerator, final SerializerProvider serProvider) throws IOException {
		
		jsGenerator.writeStartObject();
		jsGenerator.writeNumberField("id", value.getId());
		jsGenerator.writeStringField("email", value.getEmail());
		jsGenerator.writeStringField("name", value.getName());
		jsGenerator.writeStringField("address", value.getAddress());
		
		final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		jsGenerator.writeStringField("creation", formatter.format(value.getCreation()));
		jsGenerator.writeStringField("password", value.getPassword());
		jsGenerator.writeEndObject();
		
	}
	
}
