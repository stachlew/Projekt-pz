package pl.wat.pz.application.dao.intermediateClass.Advertisement;

/**
 * Created by Marian on 2016-12-30.
 */
public class AdvertisementSearchForm {
    private String title;
    private String category;
    private String region;
    private String city;
    private String lang;
    private double chargePerDayFrom;
    private double chargePerDayTo;
    private double bailValueFrom;
    private double bailValueTo;

    public AdvertisementSearchForm() {
    }

    public AdvertisementSearchForm(String title, String category, String region, String city, String lang, double chargePerDayFrom, double chargePerDayTo, double bailValueFrom, double bailValueTo) {
        this.title = title;
        this.category = category;
        this.region = region;
        this.city = city;
        this.lang = lang;
        this.chargePerDayFrom = chargePerDayFrom;
        this.chargePerDayTo = chargePerDayTo;
        this.bailValueFrom = bailValueFrom;
        this.bailValueTo = bailValueTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public double getChargePerDayFrom() {
        return chargePerDayFrom;
    }

    public void setChargePerDayFrom(double chargePerDayFrom) {
        this.chargePerDayFrom = chargePerDayFrom;
    }

    public double getChargePerDayTo() {
        return chargePerDayTo;
    }

    public void setChargePerDayTo(double chargePerDayTo) {
        this.chargePerDayTo = chargePerDayTo;
    }

    public double getBailValueFrom() {
        return bailValueFrom;
    }

    public void setBailValueFrom(double bailValueFrom) {
        this.bailValueFrom = bailValueFrom;
    }

    public double getBailValueTo() {
        return bailValueTo;
    }

    public void setBailValueTo(double bailValueTo) {
        this.bailValueTo = bailValueTo;
    }
}
