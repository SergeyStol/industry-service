package by.javaguru.industryservice.features.industry;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sergey Stol
 * 2024-11-17
 */
@RestController
@RequestMapping("/v1.0/industries")
@AllArgsConstructor
public class IndustryController {

   private final IndustryService service;

   // 200, 400, 404
   @GetMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public IndustryDto getIndustry(@PathVariable Long id) {
      return service.getIndustry(id);
   }

   // TODO: is 409 CONFLICT could be?
   // POST /v1.0/industries  -> 201 CREATED
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public IndustryDto addIndustry(@RequestBody NewIndustryDto newIndustryDto) {
      return service.addIndustry(newIndustryDto);
   }
}
