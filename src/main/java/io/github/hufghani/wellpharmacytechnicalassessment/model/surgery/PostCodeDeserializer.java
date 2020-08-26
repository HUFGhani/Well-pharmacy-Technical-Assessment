package io.github.hufghani.wellpharmacytechnicalassessment.model.surgery;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

public class PostCodeDeserializer extends StdDeserializer<PostCode> {

  public PostCodeDeserializer() {
    this(null);
  }

  protected PostCodeDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public PostCode deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode jsonNode = p.getCodec().readTree(p);
    return new PostCode(jsonNode.asText());
  }
}
