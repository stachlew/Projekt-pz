package pl.wat.pz.application.dao.domain;

import javax.persistence.*;

/**
 * Created by DELL on 2016-11-23.
 */
@Entity
@Table(name = "message_state")
public class MessageState {

    @Id
    @Column(name = "id_message_state",length = 4)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMessageState;

    @Column(name = "name_pl",length = 40,nullable = false)
    private String namePL;

    @Column(name = "name_eng",length = 40,nullable = false)
    private String nameENG;

    public MessageState() {
    }

    public MessageState(String namePL, String nameENG) {
        this.namePL = namePL;
        this.nameENG = nameENG;
    }

    public long getIdMessageState() {
        return idMessageState;
    }

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    public String getNameENG() {
        return nameENG;
    }

    public void setNameENG(String nameENG) {
        this.nameENG = nameENG;
    }
}
