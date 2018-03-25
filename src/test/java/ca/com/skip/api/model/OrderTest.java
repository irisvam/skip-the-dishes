package ca.com.skip.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import ca.com.skip.util.serializer.OrderDeserializer;
import ca.com.skip.util.serializer.OrderSerializer;

public class OrderTest {
	
	@Test
	public void testSerializer() throws ParseException {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addSerializer(Order.class, new OrderSerializer());
		mapper.registerModule(module);
		
		final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		final Order order = new Order();
		
		final Customer customer = new Customer();
		customer.setId(234l);
		
		final List<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		final OrderItem item = new OrderItem();
		
		final Product product = new Product();
		
		final Store store = new Store();
		store.setId(4l);
		
		product.setId(1l);
		product.setName("pizza");
		product.setDescription("muzzarela");
		product.setPrice(2.33);
		product.setStore(store);
		
		item.setId(3l);
		item.setPrice(10.32);
		item.setQuantity(2l);
		item.setTotal(20.64);
		item.setProduct(product);
		item.setOrder(order);
		
		orderItems.add(item);
		orderItems.add(item);
		
		order.setId(8l);
		order.setDate(formatter.parse("2018-03-25T17:59:27.831-0300"));
		order.setCustomer(customer);
		order.setDeliveryAddress("fifth avenue");
		order.setContact("company@gmail.com");
		order.setIdStore(4l);
		order.setStore(store);
		order.setOrderItems(orderItems);
		order.setTotal(590.55);
		order.setStatus("delivered");
		order.setLastUpdate(formatter.parse("2018-03-25T17:59:27.831-0300"));
		
		try {
			
			final String json = mapper.writeValueAsString(order);
			
			assertEquals(
					"{\"id\":8,\"date\":\"2018-03-25T17:59:27.831-0300\",\"customerId\":234,\"deliveryAddress\":\"fifth avenue\",\"contact\":\"company@gmail.com\",\"storeId\":4,\"orderItems\":[{\"id\":3,\"orderId\":8,\"productId\":1,\"product\":{\"id\":1,\"storeId\":4,\"name\":\"pizza\",\"description\":\"muzzarela\",\"price\":2.33},\"price\":10.32,\"quantity\":2,\"total\":20.64},{\"id\":3,\"orderId\":8,\"productId\":1,\"product\":{\"id\":1,\"storeId\":4,\"name\":\"pizza\",\"description\":\"muzzarela\",\"price\":2.33},\"price\":10.32,\"quantity\":2,\"total\":20.64}],\"total\":590.55,\"status\":\"delivered\",\"lastUpdate\":\"2018-03-25T17:59:27.831-0300\"}",
					json);
			
		} catch (final JsonProcessingException e) {
			
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testDeserializer() {
		
		final ObjectMapper mapper = new ObjectMapper();
		final SimpleModule module = new SimpleModule();
		module.addDeserializer(Order.class, new OrderDeserializer());
		mapper.registerModule(module);
		
		final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		try {
			
			final Order item = mapper.readValue(
					"{\"id\":7,\"date\":\"2018-03-25T17:59:27.831-0300\",\"customerId\":324,\"deliveryAddress\":\"donore avenue\",\"contact\":\"cp-8979\",\"storeId\":8,\"orderItems\":[{\"id\":6,\"orderId\":7,\"productId\":3,\"product\":{\"id\":3,\"storeId\":8,\"name\":\"soup\",\"description\":\"tomato\",\"price\":1.99},\"price\":1.98,\"quantity\":2,\"total\":2.98},{\"id\":3,\"orderId\":8,\"productId\":1,\"product\":{\"id\":1,\"storeId\":4,\"name\":\"pizza\",\"description\":\"muzzarela\",\"price\":2.33},\"price\":10.32,\"quantity\":2,\"total\":20.64}],\"total\":9.99,\"status\":\"travel\",\"lastUpdate\":\"2018-03-25T17:59:27.831-0300\"}",
					Order.class);
			
			
			assertEquals(7, item.getId());
			assertEquals("2018-03-25T17:59:27.831-0300", formatter.format(item.getDate()));
			assertEquals(324, item.getIdCustomer());
			assertEquals("donore avenue", item.getDeliveryAddress());
			assertEquals("cp-8979", item.getContact());
			assertEquals(8, item.getIdStore());
			assertEquals(2, item.getOrderItems().size());
			assertEquals(6, item.getOrderItems().get(0).getId());
			assertEquals(7, item.getOrderItems().get(0).getIdOrder());
			assertEquals(3, item.getOrderItems().get(0).getIdProduct());
			assertEquals(3, item.getOrderItems().get(0).getProduct().getId());
			assertEquals(8, item.getOrderItems().get(0).getProduct().getIdStore());
			assertEquals("soup", item.getOrderItems().get(0).getProduct().getName());
			assertEquals("tomato", item.getOrderItems().get(0).getProduct().getDescription());
			assertEquals(1.99, item.getOrderItems().get(0).getProduct().getPrice(), 0.5);
			assertEquals(1.98, item.getOrderItems().get(0).getPrice(), 0.5);
			assertEquals(2, item.getOrderItems().get(0).getQuantity());
			assertEquals(2.98, item.getOrderItems().get(0).getTotal(), 0.5);
			assertEquals(9.99, item.getTotal(), 0.5);
			assertEquals("travel", item.getStatus());
			assertEquals("2018-03-25T17:59:27.831-0300", formatter.format(item.getLastUpdate()));
			
		} catch (final IOException e) {
			
			fail(e.getMessage());
		}
		
	}
	
}
