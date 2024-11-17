package by.javaguru.industryservice.features.industry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sergey Stol
 * 2024-11-17
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "industries")
@Getter
@Setter
public class Industry {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   // TODO: is name unique?
   @Column(name = "name", nullable = false)
   private String name;

}
