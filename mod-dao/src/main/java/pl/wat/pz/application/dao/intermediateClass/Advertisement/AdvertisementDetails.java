package pl.wat.pz.application.dao.intermediateClass.Advertisement;

import pl.wat.pz.application.dao.domain.Advertisement;

import java.sql.Timestamp;

/**
 * Created by DELL on 2016-12-02.
 */
public class AdvertisementDetails {
    private long idAdvertisement;
    private String title;
    private Timestamp dateAdded;
    private double bailValue;
    private double chargePerDay;
    private String description;
    private byte[] image;
    private String city;
    private String username;
    private String regionName;
    private String categoryName;

    public AdvertisementDetails(Advertisement adv,String lang) {
        this.idAdvertisement = adv.getIdAdvertisement();
        this.title = adv.getTitle();
        this.dateAdded = adv.getDateAdded();
        this.bailValue = adv.getBailValue();
        this.chargePerDay = adv.getChargePerDay();
        this.description = adv.getDescription();
        this.image = adv.getImage();
        this.city = adv.getCity();
        this.username = adv.getIdUser().getUsername();
        this.regionName = adv.getIdRegion().getName();
        if(lang.equals("pl")) {
            this.categoryName = adv.getIdItemCategory().getNamePL();
        }else {
            this.categoryName = adv.getIdItemCategory().getNameENG();
        }
    }

    public long getIdAdvertisement() {
        return idAdvertisement;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public double getBailValue() {
        return bailValue;
    }

    public double getChargePerDay() {
        return chargePerDay;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getImage() {
        return image;
    }

    public String getCity() {
        return city;
    }

    public String getUsername() {
        return username;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCategoryName() {
        return categoryName;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setBailValue(double bailValue) {
        this.bailValue = bailValue;
    }

    public void setChargePerDay(double chargePerDay) {
        this.chargePerDay = chargePerDay;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
