/**
 *
 */
package com.sellme.domain;

/**
 * @author Swapnil Singh
 *
 */
public enum CityOrTown {
    SATNA(84149), INVALID_CITY_OT_TOWN;
    private long cityOrTownCode;

    /**
     * @param cityOrTownCode
     */
    private CityOrTown(long cityOrTownCode) {
        this.cityOrTownCode = cityOrTownCode;
    }

    private CityOrTown() {
    }

    public static CityOrTown getCityOrTownType(long cityOrTownCode) {
        CityOrTown cityOrTown = CityOrTown.INVALID_CITY_OT_TOWN;
        for (CityOrTown cityOrTownType : values()) {
            if (cityOrTownType.cityOrTownCode == cityOrTownCode) {
                cityOrTown = cityOrTownType;
            }
        }
        return cityOrTown;
    }

    public final long getCityOrTownCode() {
        return cityOrTownCode;
    }

}
