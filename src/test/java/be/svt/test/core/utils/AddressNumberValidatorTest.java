package be.svt.test.core.utils;

import org.junit.jupiter.api.Test;

import static be.svt.test.core.utils.AddressNumberValidator.isValidAddressNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class AddressNumberValidatorTest {

    @Test
    public void isValidAddressNumber_returnsTrue_whenAddressIsValid() {
        assertThat(isValidAddressNumber("1")).isTrue();
        assertThat(isValidAddressNumber("26")).isTrue();
        assertThat(isValidAddressNumber("26A")).isTrue();
        assertThat(isValidAddressNumber("999Z")).isTrue();
    }

    @Test
    public void isValidAddressNumber_returnsFalse_whenAddressIsInvalid() {
        assertThat(isValidAddressNumber("0")).isFalse();
        assertThat(isValidAddressNumber("26AB")).isFalse();
        assertThat(isValidAddressNumber("A26")).isFalse();
        assertThat(isValidAddressNumber("999@")).isFalse();
    }
}
