package ca.com.skip.util.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ca.com.skip.api.model.OrderItem;

public class OrderItemSerializer extends JsonSerializer<OrderItem> {
	
	@Override
	public void serialize(final OrderItem value, final JsonGenerator jsGenerator, final SerializerProvider serProvider) throws IOException {
		
		jsGenerator.writeStartObject();
		jsGenerator.writeNumberField("id", value.getId());
		jsGenerator.writeNumberField("orderId", value.getOrder().getId());
		jsGenerator.writeNumberField("productId", value.getProduct().getId());
		jsGenerator.writeObjectField("product", value.getProduct());
		jsGenerator.writeNumberField("price", value.getPrice());
		jsGenerator.writeNumberField("quantity", value.getQuantity());
		jsGenerator.writeNumberField("total", value.getTotal());
		jsGenerator.writeEndObject();
		
	}
	
}
