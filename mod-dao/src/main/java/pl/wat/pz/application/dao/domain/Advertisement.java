package pl.wat.pz.application.dao.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * Ogłoszenie
 */
@Entity
public class Advertisement {
    @Id
    @Column(name = "id_Advertisement",length = 30)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAdvertisement;

    @Column(nullable = false)
    private String title;

    @Column(name = "date_added",nullable = false)
    @ColumnDefault(value = "sysdate")
    private Timestamp dateAdded;

    @Column(name = "bail_value",length = 15,precision = 2,scale = 13 , nullable = true)
    private double bailValue;

    @Column(name = "charge_per_day",length = 15,precision = 2,scale = 13 , nullable = true)
    private double chargePerDay;

    @Column(length = 255,nullable = true)
    private String description;

    @Column(nullable = true)
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    @Column(length = 30,nullable = false)
    private String city;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Region")
    private Region idRegion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_User")
    private User idUser;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Item_Category")
    private ItemCategory idItemCategory;

    public Advertisement() {
    }

    public Advertisement(String title, Timestamp dateAdded, double bailValue, double chargePerDay, String description, byte[] image, String city, Region idRegion, User idUser, ItemCategory idItemCategory) {
        this.title=title;
        this.dateAdded = dateAdded;
        this.bailValue = bailValue;
        this.chargePerDay = chargePerDay;
        this.description = description;
        this.image = image;
        this.city = city;
        this.idRegion = idRegion;
        this.idUser = idUser;
        this.idItemCategory = idItemCategory;
    }

    public long getIdAdvertisement() {
        return idAdvertisement;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }


    public double getBailValue() {
        return bailValue;
    }

    public void setBailValue(double bailValue) {
        this.bailValue = bailValue;
    }

    public double getChargePerDay() {
        return chargePerDay;
    }

    public void setChargePerDay(double chargePerDay) {
        this.chargePerDay = chargePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Region getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Region idRegion) {
        this.idRegion = idRegion;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdAdvertisement(long idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public ItemCategory getIdItemCategory() {
        return idItemCategory;
    }

    public void setIdItemCategory(ItemCategory idItemCategory) {
        this.idItemCategory = idItemCategory;
    }
}
