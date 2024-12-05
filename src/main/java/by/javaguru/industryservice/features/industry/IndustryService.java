package by.javaguru.industryservice.features.industry;

import by.javaguru.industryservice.infrastructure.api.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Sergey Stol
 * 2024-11-17
 */
@Service
@Slf4j
@AllArgsConstructor
public class IndustryService {

   private final IndustryRepository repo;
   private final IndustryMapper mapper;
   private final KafkaTemplate<UUID, IndustryDto> kafkaTemplate;

   public IndustryDto getIndustry(Long id) {
      return repo
        .findById(id)
        .map(mapper::toDto)
        .orElseThrow(() -> new NotFoundException("Can't find id industry with id=" + id));
   }

   public IndustryDto addIndustry(NewIndustryDto newIndustryDto) {
      Industry industry = mapper.toIndustry(newIndustryDto);
      Industry savedIndustry = repo.save(industry);
      return mapper.toDto(savedIndustry);
   }

   @KafkaListener(topics = "GET_INDUSTRY_REQUEST")
   public void preparingExperienceListener(ConsumerRecord<UUID, Long> response) {
      UUID requestUUID = response.key();
      Long industryId = response.value();
      log.info("Receive GET_INDUSTRY_REQUEST with requestUUID={} and industryId={}",
        requestUUID, industryId);
      Industry industry = repo.findById(industryId).orElse(new Industry());
      IndustryDto industryDto = mapper.toDto(industry);
      kafkaTemplate.send("GET_INDUSTRY_RESPONSE", requestUUID, industryDto);
      log.info("Sent GET_INDUSTRY_RESPONSE with requestUUID={} and industryDto={}",
        requestUUID, industryDto);
   }
}
