package ca.com.skip.util.serializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import ca.com.skip.api.model.Order;
import ca.com.skip.api.model.OrderItem;
import ca.com.skip.api.model.Product;

public class OrderDeserializer extends JsonDeserializer<Order> {
	
	@Override
	public Order deserialize(final JsonParser jsParser, final DeserializationContext desContext) throws IOException, JsonProcessingException {
		
		final ObjectCodec objectCodec = jsParser.getCodec();
		final JsonNode jsonNode = objectCodec.readTree(jsParser);
		
		final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		final Order order = new Order();
		
		try {
			
			order.setId(jsonNode.get("id").asLong());
			order.setDate(formatter.parse(jsonNode.get("date").asText()));
			order.setIdCustomer(jsonNode.get("customerId").asLong());
			order.setDeliveryAddress(jsonNode.get("deliveryAddress").asText());
			order.setContact(jsonNode.get("contact").asText());
			order.setIdStore(jsonNode.get("storeId").asLong());
			
			final List<OrderItem> orderItems = new ArrayList<>();
			
			final JsonNode itemValue = jsonNode.findValue("orderItems");
			
			Iterator<JsonNode> iter = itemValue.elements();
			
			while (iter.hasNext()) {
				
				JsonNode jsonNodeItem = iter.next();
				
				final OrderItem item = new OrderItem();
				final Product product = new Product();
				
				item.setId(jsonNodeItem.get("id").asLong());
				item.setIdOrder(jsonNodeItem.get("orderId").asLong());
				item.setIdProduct(jsonNodeItem.get("productId").asLong());
				
				product.setId(jsonNodeItem.get("product").get("id").asLong());
				product.setIdStore(jsonNodeItem.get("product").get("storeId").asLong());
				product.setName(jsonNodeItem.get("product").get("name").asText());
				product.setDescription(jsonNodeItem.get("product").get("description").asText());
				product.setPrice(jsonNodeItem.get("product").get("price").asDouble());
				
				item.setProduct(product);
				item.setPrice(jsonNodeItem.get("price").asDouble());
				item.setQuantity(jsonNodeItem.get("quantity").asLong());
				item.setTotal(jsonNodeItem.get("total").asDouble());
				
				orderItems.add(item);
			}
			
			order.setOrderItems(orderItems);
			order.setTotal(jsonNode.get("total").asDouble());
			order.setStatus(jsonNode.get("status").asText());
			order.setLastUpdate(formatter.parse(jsonNode.get("lastUpdate").asText()));
			
		} catch (final ParseException e) {
			
			e.printStackTrace();
		}
		
		return order;
	}
	
}
