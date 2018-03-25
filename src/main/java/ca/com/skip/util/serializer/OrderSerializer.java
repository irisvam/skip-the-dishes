package ca.com.skip.util.serializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ca.com.skip.api.model.Order;

public class OrderSerializer extends JsonSerializer<Order> {
	
	@Override
	public void serialize(final Order value, final JsonGenerator jsGenerator, final SerializerProvider serProvider) throws IOException {
		
		jsGenerator.writeStartObject();
		jsGenerator.writeNumberField("id", value.getId());
		
		final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		jsGenerator.writeStringField("date", formatter.format(value.getDate()));
		jsGenerator.writeNumberField("customerId", value.getCustomer().getId());
		jsGenerator.writeStringField("deliveryAddress", value.getDeliveryAddress());
		jsGenerator.writeStringField("contact", value.getContact());
		jsGenerator.writeNumberField("orderId", value.getStore().getId());
		
		jsGenerator.writeObjectField("orderItems", value.getOrderItems());
		
		jsGenerator.writeNumberField("total", value.getTotal());
		jsGenerator.writeStringField("status", value.getStatus());
		jsGenerator.writeStringField("lastUpdate", formatter.format(value.getLastUpdate()));
		jsGenerator.writeEndObject();
		
	}
	
}
