package by.javaguru.industryservice.infrastructure.kafka;

import by.javaguru.industryservice.features.industry.IndustryDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.UUIDSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Sergey Stol
 * 2024-12-05
 */
@Configuration
public class KafkaConfig {
   // UUID : IndustryDto PRODUCER ********************************************************
   @Bean
   public ProducerFactory<UUID, IndustryDto> uuidIndustryDtoProducerFactory() {
      Map<String, Object> configProps = new HashMap<>();
      configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, UUIDSerializer.class);
      configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, IndustryDtoSerializer.class);
      configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
      return new DefaultKafkaProducerFactory<>(configProps);
   }

   @Bean
   public KafkaTemplate<UUID, IndustryDto> uuidIndustryDtoKafkaTemplate() {
      return new KafkaTemplate<>(uuidIndustryDtoProducerFactory());
   }
}