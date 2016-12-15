package pl.wat.pz.application.dao.intermediateClass.Advertisement;

import pl.wat.pz.application.dao.domain.Advertisement;

import java.sql.Timestamp;

/**
 * Created by DELL on 2016-11-30.
 */
public class AdvertisementHeader {
    private Long idAdvertisement;
    private String title;
    private Timestamp dateAdded;
    private String username;
    private String regionName;
    private byte[] image;
    private String categoryNamePL;
    private String categoryNameENG;

    public AdvertisementHeader(Advertisement advertisement) {
        this.idAdvertisement=advertisement.getIdAdvertisement();
        this.title=advertisement.getTitle();
        this.dateAdded=advertisement.getDateAdded();
        this.username=advertisement.getIdUser().getUsername();
        this.regionName=advertisement.getIdRegion().getName();
        this.image=advertisement.getImage();
        this.categoryNamePL=advertisement.getIdItemCategory().getNamePL();
        this.categoryNameENG=advertisement.getIdItemCategory().getNameENG();
    }

    public Long getIdAdvertisement() {
        return idAdvertisement;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public String getUsername() {
        return username;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCategoryNamePL() {
        return categoryNamePL;
    }

    public String getCategoryNameENG() {
        return categoryNameENG;
    }

    public byte[] getImage() {
        return image;
    }
}
