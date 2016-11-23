package pl.wat.pz.application.dao.domain;

import javax.persistence.*;

/**
 * Created by DELL on 2016-11-23.
 */
@Entity
public class MessageState {

    @Id
    @Column(name = "id_message_state",length = 4)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMessageState;

    @Column(length = 40,nullable = false)
    private String name;

    public MessageState() {
    }

    public MessageState(String name) {
        this.name = name;
    }


    public long getIdMessageState() {
        return idMessageState;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
