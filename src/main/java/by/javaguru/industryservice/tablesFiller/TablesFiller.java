package by.javaguru.industryservice.tablesFiller;

import by.javaguru.industryservice.features.industry.IndustryService;
import by.javaguru.industryservice.features.industry.NewIndustryDto;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author Sergey Stol
 * 2024-11-17
 */
@Component
@Profile("with-filler")
@AllArgsConstructor
public class TablesFiller {

   private final IndustryService industryService;

   @PostConstruct
   void postConstruct() {
      industryService.addIndustry(new NewIndustryDto("Industry1"));
      industryService.addIndustry(new NewIndustryDto("Industry2"));
      industryService.addIndustry(new NewIndustryDto("Industry3"));
      industryService.addIndustry(new NewIndustryDto("Industry4"));
      industryService.addIndustry(new NewIndustryDto("Industry5"));
   }
}
