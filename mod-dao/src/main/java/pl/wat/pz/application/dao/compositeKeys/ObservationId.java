package pl.wat.pz.application.dao.compositeKeys;

import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.User;

import java.io.Serializable;

/**
 * Created by DELL on 2016-11-23.
 */
public class ObservationId implements Serializable {

    private Advertisement idAdvertisement;
    private User idUser;

    public ObservationId() {
    }

    public ObservationId(Advertisement idAdvertisement, User idUser) {
        this.idAdvertisement = idAdvertisement;
        this.idUser = idUser;
    }

    public Advertisement getIdAdvertisement() {
        return idAdvertisement;
    }

    public User getIdUser() {
        return idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObservationId that = (ObservationId) o;

        if (idAdvertisement != null ? !idAdvertisement.equals(that.idAdvertisement) : that.idAdvertisement != null)
            return false;
        return idUser != null ? idUser.equals(that.idUser) : that.idUser == null;

    }

    @Override
    public int hashCode() {
        int result = idAdvertisement != null ? idAdvertisement.hashCode() : 0;
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        return result;
    }
}
