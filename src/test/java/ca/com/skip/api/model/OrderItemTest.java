package ca.com.skip.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import ca.com.skip.util.serializer.OrderItemDeserializer;
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
		item.setQuantity(2l);
		item.setTotal(20.64);
		item.setProduct(product);
		item.setOrder(order);
		
		try {
			
			final String json = mapper.writeValueAsString(item);
			
			assertEquals(
					"{\"id\":3,\"orderId\":8,\"productId\":1,\"product\":{\"id\":1,\"storeId\":4,\"name\":\"pizza\",\"description\":\"muzzarela\",\"price\":2.33},\"price\":10.32,\"quantity\":2,\"total\":20.64}",
					json);
			
		} catch (final JsonProcessingException e) {
			
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testDeserializer() {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addDeserializer(OrderItem.class, new OrderItemDeserializer());
		mapper.registerModule(module);
		
		try {
			
			final OrderItem item = mapper.readValue(
					"{\"id\":6,\"orderId\":7,\"productId\":3,\"product\":{\"id\":3,\"storeId\":8,\"name\":\"soup\",\"description\":\"tomato\",\"price\":1.99},\"price\":1.98,\"quantity\":2,\"total\":2.98}",
					OrderItem.class);
			
			assertEquals(6, item.getId());
			assertEquals(7, item.getIdOrder());
			assertEquals(3, item.getIdProduct());
			assertEquals(3, item.getProduct().getId());
			assertEquals(8, item.getProduct().getIdStore());
			assertEquals("soup", item.getProduct().getName());
			assertEquals("tomato", item.getProduct().getDescription());
			assertEquals(1.99, item.getProduct().getPrice(), 0.5);
			assertEquals(1.98, item.getPrice(), 0.5);
			assertEquals(2, item.getQuantity());
			assertEquals(2.98, item.getTotal(), 0.5);
			
		} catch (final IOException e) {
			
			fail(e.getMessage());
		}
		
	}
}
