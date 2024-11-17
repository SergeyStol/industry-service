package by.javaguru.industryservice.infrastructure.api;

/**
 * @author Sergey Stol
 * 2024-11-17
 */
public class NotFoundException extends RuntimeException {
   public NotFoundException(String message) {
      super(message);
   }

   public NotFoundException(String message, Throwable cause) {
      super(message, cause);
   }
}
