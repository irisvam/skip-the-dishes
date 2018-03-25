package ca.com.skip.util.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import ca.com.skip.api.model.Store;

public class StoreDeserializer extends JsonDeserializer<Store> {
	
	@Override
	public Store deserialize(final JsonParser jsParser, final DeserializationContext desContext) throws IOException, JsonProcessingException {
		
		final ObjectCodec objectCodec = jsParser.getCodec();
		final JsonNode jsonNode = objectCodec.readTree(jsParser);
		
		final Store store = new Store();
		
		store.setId(jsonNode.get("id").asLong());
		store.setName(jsonNode.get("name").asText());
		store.setAddress(jsonNode.get("address").asText());
		store.setIdCousine(jsonNode.get("cousineId").asLong());
		
		return store;
	}
	
}
