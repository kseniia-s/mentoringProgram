package module3.enums;

import java.util.Optional;

public enum GeoPoint {
    //    AFGHANISTAN("Afghanistan"),
//    ALBANIA("Albania"),
//    AMERICAN_SAMOA("American Samoa"),
//    ANDORRA("Andorra"),
//    ANGOLA("Angola"),
//    ANGUILLA("Anguilla"),
//    ANTARCTICA("Antarctica"),
//    ARGENTINA("Argentina"),
//    ARMENIA("Armenia"),
//    ARUBA("Aruba"),
//    AUSTRALIA("Australia"),
//    AUSTRIA("Austria"),
//    AZERBAIJAN("Azerbaijan"),
//    BAHAMAS("Bahamas"),
//    BANGLADESH("Bangladesh"),
//    BARBADOS("Barbados"),
//    BELARUS("Belarus"),
//    BELGIUM("Belgium"),
//    BELIZE("Belize"),
//    BENIN("Benin"),
//    BERMUDA("Bermuda"),
//    BOLIVIA("Bolivia"),
//    BOSNIA_AND_HERZEGOVINA("Bosnia and Herzegovina"),
//    BRAZIL("Brazil"),
    BULGARIA("Bulgaria", "42°41′N", "23°19′E"),
    //    BURUNDI("Burundi"),
//    CAMBODIA("Cambodia"),
//    CAMEROON("Cameroon"),
//    CANADA("Canada"),
//    CENTRAL_AFRICAN_REPUBLIC("Central African Republic"),
//    CHILE("Chile"),
    CHINA("China", "35°N", "103°E"),
    //    COLOMBIA("Colombia"),
    COSTA_RICA("Costa Rica", "10°N", "84°W"),
    //    CROATIA("Croatia"),
//    CUBA("Cuba"),
//    CYPRUS("Cyprus"),
//    CZECH_REPUBLIC("Czech Republic"),
//    DOMINICAN_REPUBLIC("Dominican Republic"),
//    ECUADOR("Ecuador"),
//    EGYPT("Egypt"),
//    ESTONIA("Estonia"),
    ETHIOPIA("Ethiopia", "8°N", "38°E"),
    //    FIJI("Fiji"),
//    FINLAND("Finland"),
    FRANCE("France", "48°49′N", "2°29′E"),
    //    GABON("Gabon"),
//    GAMBIA("Gambia"),
//    GEORGIA("Georgia"),
//    GERMANY("Germany"),
//    GHANA("Ghana"),
//    GIBRALTAR("Gibraltar"),
//    GREAT_BRITAIN("Great Britain"),
//    GREECE("Greece"),
//    GUADELOUPE("Guadeloupe"),
//    GUAM("Guam"),
//    GUATEMALA("Guatemala"),
//    GUINEA("Guinea"),
//    GUYANA("Guyana"),
//    HAITI("Haiti"),
//    HUNGARY("Hungary"),
//    INDIA("India"),
//    INDONESIA("Indonesia"),
//    IRAN("Iran"),
//    IRAQ("Iraq"),
//    IRELAND("Ireland"),
    ISRAEL("Israel", "31°N", "35°E"),
    //    ITALY("Italy"),
//    JAMAICA("Jamaica"),
//    JAPAN("Japan"),
//    KAZAKHSTAN("Kazakhstan"),
//    KENYA("Kenya"),
//    NORTH_KOREA("North Korea"),
//    SOUTH_KOREA("South Korea"),
//    KUWAIT("Kuwait"),
//    KYRGYZSTAN("Kyrgyzstan"),
//    LATVIA("Latvia"),
    LEBANON("Lebanon", "33°50′N", "35°50′E"),
    //    LIBERIA("Liberia"),
//    LUXEMBOURG("Luxembourg"),
//    MACEDONIA("Macedonia"),
//    MADAGASCAR("Madagascar"),
//    MALAWI("Malawi"),
//    MALAYSIA("Malaysia"),
//    MALDIVES("Maldives"),
//    MALI("Mali"),
//    MALTA("Malta"),
//    MEXICO("Mexico"),
//    MOLDOVA("Moldova"),
//    MONACO("Monaco"),
//    MONGOLIA("Mongolia"),
//    MONTENEGRO("Montenegro"),
//    MOROCCO("Morocco"),
//    MOZAMBIQUE("Mozambique"),
//    MYANMAR("Myanmar"),
//    NAMIBIA("Namibia"),
//    NAURU("Nauru"),
//    NEPAL("Nepal"),
//    NETHERLANDS("Netherlands"),
//    NEW_ZEALAND("New Zealand"),
//    NICARAGUA("Nicaragua"),
//    NIGER("Niger"),
//    NIGERIA("Nigeria"),
//    NORWAY("Norway"),
//    OMAN("Oman"),
//    PAKISTAN("Pakistan"),
//    PALAU("Palau"),
//    PANAMA("Panama"),
//    PAPUA_NEW_GUINEA("Papua New Guinea"),
//    PARAGUAY("Paraguay"),
//    PERU("Peru"),
    PHILIPPINES("Philippines", "13°N", "122°E"),
    //    POLAND("Poland"),
//    PORTUGAL("Portugal"),
//    ROMANIA("Romania"),
//    RUSSIAN("Russian"),
//    SAMOA("Samoa"),
//    SAUDI_ARABIA("Saudi Arabia"),
//    SERBIA("Serbia"),
//    SEYCHELLES("Seychelles"),
//    SINGAPORE("Singapore"),
    SLOVAKIA("Slovakia", "48°08′N", "17°06′E"),
    //    SLOVENIA("Slovenia"),
    SOMALIA("Somalia", "10°N", "49°E"),
    //    SPAIN("Spain"),
//    SRI_LANKA("Sri Lanka"),
//    SUDAN("Sudan"),
//    SWAZILAND("Swaziland"),
//    SWEDEN("Sweden"),
//    SWITZERLAND("Switzerland"),
//    SYRIA("Syria"),
//    TAIWAN("Taiwan"),
//    TAJIKISTAN("Tajikistan"),
//    TANZANIA("Tanzania"),
//    THAILAND("Thailand"),
//    TIBET("Tibet"),
//    TUNISIA("Tunisia"),
//    TURKEY("Turkey"),
//    TURKMENISTAN("Turkmenistan"),
//    UGANDA("Uganda"),
    UKRAINE("Ukraine", "49°N", "32°E"),
    //    UNITED_ARAB_EMIRATES("United Arab Emirates"),
//    UNITED_KINGDOM("United Kingdom"),
//    UNITED_STATES("United States"),
//    URUGUAY("Uruguay"),
//    UZBEKISTAN("Uzbekistan"),
//    VENEZUELA("Venezuela"),
    VIETNAM("Vietnam", "16°N", "108°E"),
    //    YEMEN("Yemen"),
    YUNNAN("Yunnan", "25°03′N", "101°52′E"),
    //    ZAMBIA("Zambia"),
    ZIMBABWE("Zimbabwe", "20°S", "30°E");

    private final String country;
    private final String latitude;
    private final String longitude;

    GeoPoint(String country, String latitude, String longitude) {
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public static Optional<GeoPoint> getGeoPointByCountryName(String text) {
        for (GeoPoint geoPoint : GeoPoint.values()) {
            if (text.equals(geoPoint.getCountry())) {
                return Optional.of(geoPoint);
            }
        }
        return Optional.empty();
    }
}
