package ca.com.skip.api.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

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
		item.setQuantity(2);
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
		order.setStore(store);
		order.setOrderItems(orderItems);
		order.setTotal(590.55);
		order.setStatus("delivered");
		order.setLastUpdate(formatter.parse("2018-03-25T17:59:27.831-0300"));
		
		try {
			
			final String json = mapper.writeValueAsString(order);
			
			System.out.println(json);
			
			assertEquals(
					"{\"id\":8,\"date\":\"2018-03-25T17:59:27.831-0300\",\"customerId\":234,\"deliveryAddress\":\"fifth avenue\",\"contact\":\"company@gmail.com\",\"orderId\":4,\"orderItems\":[{\"id\":3,\"orderId\":8,\"productId\":1,\"product\":{\"id\":1,\"storeId\":4,\"name\":\"pizza\",\"description\":\"muzzarela\",\"price\":2.33},\"price\":10.32,\"quantity\":2,\"total\":20.64},{\"id\":3,\"orderId\":8,\"productId\":1,\"product\":{\"id\":1,\"storeId\":4,\"name\":\"pizza\",\"description\":\"muzzarela\",\"price\":2.33},\"price\":10.32,\"quantity\":2,\"total\":20.64}],\"total\":590.55,\"status\":\"delivered\",\"lastUpdate\":\"2018-03-25T17:59:27.831-0300\"}",
					json);
			
		} catch (final JsonProcessingException e) {
			
			fail(e.getMessage());
		}
		
	}
	
}
