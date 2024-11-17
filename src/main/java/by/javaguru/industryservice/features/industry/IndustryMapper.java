package by.javaguru.industryservice.features.industry;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  componentModel = MappingConstants.ComponentModel.SPRING
)
public interface IndustryMapper {
   IndustryDto toDto(Industry industry);
   Industry toIndustry(NewIndustryDto newIndustryDto);
}