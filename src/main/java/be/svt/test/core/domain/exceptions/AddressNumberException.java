package be.svt.test.core.domain.exceptions;

public class AddressNumberException extends IllegalArgumentException {
    public AddressNumberException(String AddressNumber) {
        super("%s is not a valid address number. The address number should be a number (excluding 0) possibly followed by 1 letter".formatted(AddressNumber));
    }
}
