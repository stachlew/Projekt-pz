package pl.wat.pz.application.dao.intermediateClass.Advertisement;

/**
 * Created by Marian on 2016-12-30.
 */
public class AdvertisementSearchForm {
    private String title;
    private String category;
    private String region;
    private String city;
    private String chargePerDayFrom;
    private String chargePerDayTo;
    private String bailValueFrom;
    private String bailValueTo;

    public AdvertisementSearchForm() {
    }

    public AdvertisementSearchForm(String title, String category, String region, String city, String chargePerDayFrom, String chargePerDayTo, String bailValueFrom, String bailValueTo) {
        this.title = title;
        this.category = category;
        this.region = region;
        this.city = city;
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


    public String getChargePerDayFrom() {
        return chargePerDayFrom;
    }

    public void setChargePerDayFrom(String chargePerDayFrom) {
        this.chargePerDayFrom = chargePerDayFrom;
    }

    public String getChargePerDayTo() {
        return chargePerDayTo;
    }

    public void setChargePerDayTo(String chargePerDayTo) {
        this.chargePerDayTo = chargePerDayTo;
    }

    public String getBailValueFrom() {
        return bailValueFrom;
    }

    public void setBailValueFrom(String bailValueFrom) {
        this.bailValueFrom = bailValueFrom;
    }

    public String getBailValueTo() {
        return bailValueTo;
    }

    public void setBailValueTo(String bailValueTo) {
        this.bailValueTo = bailValueTo;
    }
}
