package by.javaguru.industryservice.features.industry;

import by.javaguru.industryservice.infrastructure.api.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Sergey Stol
 * 2024-11-17
 */
@Service
@AllArgsConstructor
public class IndustryService {

   private final IndustryRepository repo;
   private final IndustryMapper mapper;

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

}
