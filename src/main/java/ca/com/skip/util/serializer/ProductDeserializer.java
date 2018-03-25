package ca.com.skip.util.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import ca.com.skip.api.model.Product;

public class ProductDeserializer extends JsonDeserializer<Product> {
	
	@Override
	public Product deserialize(final JsonParser jsParser, final DeserializationContext desContext) throws IOException, JsonProcessingException {
		
		final ObjectCodec objectCodec = jsParser.getCodec();
		final JsonNode jsonNode = objectCodec.readTree(jsParser);
		
		final Product product = new Product();
		
		product.setId(jsonNode.get("id").asLong());
		product.setIdStore(jsonNode.get("storeId").asLong());
		product.setName(jsonNode.get("name").asText());
		product.setDescription(jsonNode.get("description").asText());
		product.setPrice(jsonNode.get("price").asDouble());
		
		return product;
	}
	
}
