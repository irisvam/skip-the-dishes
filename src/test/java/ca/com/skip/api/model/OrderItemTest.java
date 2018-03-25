package ca.com.skip.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import ca.com.skip.util.serializer.OrderItemSerializer;

public class OrderItemTest {
	
	@Test
	public void testSerializer() {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addSerializer(OrderItem.class, new OrderItemSerializer());
		mapper.registerModule(module);
		
		final OrderItem item = new OrderItem();
		
		final Product product = new Product();
		
		final Store store = new Store();
		store.setId(4l);
		
		product.setId(1l);
		product.setName("pizza");
		product.setDescription("muzzarela");
		product.setPrice(2.33);
		product.setStore(store);
		
		final Order order = new Order();
		order.setId(8l);
		
		item.setId(3l);
		item.setPrice(10.32);
		item.setQuantity(2);
		item.setTotal(20.64);
		item.setProduct(product);
		item.setOrder(order);
		
		try {
			
			final String json = mapper.writeValueAsString(item);
			
			System.out.println(json);
			
			assertEquals(
					"{\"id\":3,\"orderId\":8,\"productId\":1,\"product\":{\"id\":1,\"storeId\":4,\"name\":\"pizza\",\"description\":\"muzzarela\",\"price\":2.33},\"price\":10.32,\"quantity\":2,\"total\":20.64}",
					json);
			
		} catch (final JsonProcessingException e) {
			
			fail(e.getMessage());
		}
		
	}
	
}
