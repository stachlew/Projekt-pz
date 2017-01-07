package pl.wat.pz.application.dao.intermediateClass.Advertisement;


public class AdvertisementForm {



    private String title;
    private double bailValue;
    private double chargePerDay;
    private String description;
    private String city;
    private String region;
    private String category;
    private byte[] image;

    public AdvertisementForm() {
    }

    public AdvertisementForm(String title, double bailValue, double chargePerDay, String description, String city, String region, String category) {
        this.title = title;
        this.bailValue = bailValue;
        this.chargePerDay = chargePerDay;
        this.description = description;
        this.city = city;
        this.region = region;
        this.category = category;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
