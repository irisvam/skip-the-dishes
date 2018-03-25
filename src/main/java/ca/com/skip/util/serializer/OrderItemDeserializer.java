package ca.com.skip.util.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import ca.com.skip.api.model.OrderItem;
import ca.com.skip.api.model.Product;

public class OrderItemDeserializer extends JsonDeserializer<OrderItem> {
	
	@Override
	public OrderItem deserialize(final JsonParser jsParser, final DeserializationContext desContext) throws IOException, JsonProcessingException {
		
		final ObjectCodec objectCodec = jsParser.getCodec();
		final JsonNode jsonNode = objectCodec.readTree(jsParser);
		
		final OrderItem item = new OrderItem();
		final Product product = new Product();
		
		item.setId(jsonNode.get("id").asLong());
		item.setIdOrder(jsonNode.get("orderId").asLong());
		item.setIdProduct(jsonNode.get("productId").asLong());
		
		product.setId(jsonNode.get("product").get("id").asLong());
		product.setIdStore(jsonNode.get("product").get("storeId").asLong());
		product.setName(jsonNode.get("product").get("name").asText());
		product.setDescription(jsonNode.get("product").get("description").asText());
		product.setPrice(jsonNode.get("product").get("price").asDouble());
		
		item.setProduct(product);
		item.setPrice(jsonNode.get("price").asDouble());
		item.setQuantity(jsonNode.get("quantity").asLong());
		item.setTotal(jsonNode.get("total").asDouble());
		
		return item;
	}
	
}
