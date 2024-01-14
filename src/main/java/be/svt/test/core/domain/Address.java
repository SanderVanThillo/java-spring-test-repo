package be.svt.test.core.domain;

import be.svt.test.core.domain.exceptions.AddressNumberException;
import be.svt.test.core.domain.exceptions.PostalCodeException;

import java.util.Objects;

import static be.svt.test.core.utils.AddressNumberValidator.isValidAddressNumber;

public class Address {
    private String street;
    private String number;
    private int postalCode;
    private String town;

    public Address(String street, String number, int postalCode, String town) {
        setStreet(street);
        setNumber(number);
        setPostalCode(postalCode);
        setTown(town);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (!isValidAddressNumber(number)) {
            throw new AddressNumberException(number);
        }
        this.number = number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        if (postalCode < 1000 || postalCode > 9999) {
            throw new PostalCodeException(postalCode);
        }
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getFormattedAddress() {
        return """
                %s %s
                %d %s
                """.formatted(street, number, postalCode, town);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return postalCode == address.postalCode && Objects.equals(street, address.street) && Objects.equals(number, address.number) && Objects.equals(town, address.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, postalCode, town);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", postalCode=" + postalCode +
                ", town='" + town + '\'' +
                '}';
    }
}
