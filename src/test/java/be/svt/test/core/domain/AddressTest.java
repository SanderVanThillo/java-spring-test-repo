package be.svt.test.core.domain;

import be.svt.test.core.domain.exceptions.AddressNumberException;
import be.svt.test.core.domain.exceptions.PostalCodeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AddressTest {
    public Address testAddress = new Address("Gaston Geenslaan", "11", 3000, "Leuven");

    @Test
    public void Address_isSuccessfullyCreated_whenValidValuesUsed() {
        Address address = new Address("Gaston Geenslaan", "11", 3000, "Leuven");

        assertThat(address).isNotNull();
        assertThat(address).isInstanceOf(Address.class);
    }

    @Test
    public void Address_throwsAddressNumberException_whenAddressNumberIsInvalid() {
        assertThatThrownBy(() -> new Address("Gaston Geenslaan", "A11", 3000, "Leuven"))
                .isInstanceOf(AddressNumberException.class)
                .hasMessage("A11 is not a valid address number. The address number should be a number (excluding 0) possibly followed by 1 letter");

        assertThatThrownBy(() -> testAddress.setNumber("10AZ"))
                .isInstanceOf(AddressNumberException.class)
                .hasMessage("10AZ is not a valid address number. The address number should be a number (excluding 0) possibly followed by 1 letter");
    }

    @Test
    public void Address_throwsPostalCodeException_whenPostalCodeIsInvalid() {
        assertThatThrownBy(() -> new Address("Gaston Geenslaan", "11", 999, "Leuven"))
                .isInstanceOf(PostalCodeException.class)
                .hasMessage("999 is not a valid postal code, it should be a four-digit number");

        assertThatThrownBy(() -> testAddress.setPostalCode(10000))
                .isInstanceOf(PostalCodeException.class)
                .hasMessage("10000 is not a valid postal code, it should be a four-digit number");
    }

    @Test
    public void getFormattedAddress_returnAddressInformationInAFormattedWay() {
        String formattedAddress = testAddress.getFormattedAddress();

        assertThat(formattedAddress).isEqualTo("""
                Gaston Geenslaan 11
                3000 Leuven
                """);
    }
}
