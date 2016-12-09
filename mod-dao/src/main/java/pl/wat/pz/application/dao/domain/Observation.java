package pl.wat.pz.application.dao.domain;

import pl.wat.pz.application.dao.compositeKeys.ObservationId;

import javax.persistence.*;

/**
 * Obserwowane
 */
@Entity
@IdClass(ObservationId.class)
public class Observation {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_advertisement")
    private Advertisement idAdvertisement;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User idUser;

    public Observation() {
    }

    public Observation(Advertisement idAdvertisement, User idUser) {
        this.idAdvertisement = idAdvertisement;
        this.idUser = idUser;
    }

    public void setIdAdvertisement(Advertisement idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Advertisement getIdAdvertisement() {
        return idAdvertisement;
    }

    public User getIdUser() {
        return idUser;
    }

}
