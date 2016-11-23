package pl.wat.pz.application.dao.domain;

import javax.persistence.*;

/**
 * Kategoria przedmiotu
 */
@Entity
@Table(name = "item_category")
public class ItemCategory {
    @Id
    @Column(name = "id_item_category",length = 3)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idItemCategory;

    @Column(length = 20,nullable = false,unique = true)
    private String name;

    public ItemCategory() {
    }

    public ItemCategory(String name) {
        this.name = name;
    }

    public long getIdItemCategory() {
        return idItemCategory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
