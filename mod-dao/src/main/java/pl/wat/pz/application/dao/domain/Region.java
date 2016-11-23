package pl.wat.pz.application.dao.domain;

import javax.persistence.*;

/**
 * Województwo
 */
@Entity
public class Region {
    @Id
    @Column(name = "id_Region",length = 3)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRegion;

    @Column(length = 20 , unique = true , nullable = false)
    private String name;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
