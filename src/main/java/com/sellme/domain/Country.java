/**
 *
 */
package com.sellme.domain;

/**
 * @author Swapnil Singh
 *
 */
public enum Country {
    INDIA(84), INVALID_COUNTRY;
    private int countryCode;

    /**
     * @param countryCode
     */
    private Country(int countryCode) {
        this.countryCode = countryCode;
    }

    private Country() {
    }

    public static Country getCountryType(int countryCode) {
        Country country = Country.INVALID_COUNTRY;
        for (Country countryType : values()) {
            if (countryType.countryCode == countryCode) {
                country = countryType;
            }
        }
        return country;
    }

    public final int getCountryCode() {
        return countryCode;
    }
}
