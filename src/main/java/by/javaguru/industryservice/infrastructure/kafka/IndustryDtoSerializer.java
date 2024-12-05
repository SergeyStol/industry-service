package by.javaguru.industryservice.infrastructure.kafka;

import by.javaguru.industryservice.features.industry.IndustryDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

/**
 * @author Sergey Stol
 * 2024-12-05
 */
@Slf4j
public class IndustryDtoSerializer implements Serializer<IndustryDto> {
   private final ObjectMapper objectMapper = new ObjectMapper();
   @Override
   public byte[] serialize(String topic, IndustryDto industryDto) {
      try {
         return industryDto != null ? objectMapper.writeValueAsString(industryDto).getBytes(StandardCharsets.UTF_8) : null;
      } catch (JsonProcessingException e) {
         log.error("Can't serialize industryDto={}. Reason: {}", industryDto, e.getMessage());
         throw new RuntimeException(e);
      }
   }

}
