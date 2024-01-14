package be.svt.test.core.domain.exceptions;

public class PostalCodeException extends IllegalArgumentException {
    public PostalCodeException(int postalCode) {
        super("%d is not a valid postal code, it should be a four-digit number".formatted(postalCode));
    }
}
