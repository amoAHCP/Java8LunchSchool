package ch.trivadis.com.lesson4;

/**
 * Created by Andy Moncsek on 07.06.16.
 */
public class Address {
    private final AddressType addressType;
    private final String street;
    private final String city;

    private Address(String city, String street,AddressType addressType ) {
        this.addressType = addressType;
        this.street = street;
        this.city = city;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public interface AddressTypeBuilder {
        Address addressType(AddressType type);
    }

    public interface StreetBuilder{
        AddressTypeBuilder street(String street);
    }

    public interface CityBuilder {
        StreetBuilder city(String city);
    }

    public static CityBuilder build() {
        return city -> street -> addressType -> new Address(city,street,addressType);
    }


    public enum AddressType {
        PRIVATE, WORK

    }

    @Override
    public String toString() {
        return "Address{" +
                "addressType=" + addressType +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
