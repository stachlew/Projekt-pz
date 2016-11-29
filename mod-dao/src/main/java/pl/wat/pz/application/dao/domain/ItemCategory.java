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

    @Column(name = "name_pl",length = 20,nullable = false,unique = true)
    private String namePL;

    @Column(name = "name_eng",length = 20,nullable = false,unique = true)
    private String nameENG;


    public ItemCategory() {
    }

    public ItemCategory(String namePL, String nameENG) {
        this.namePL = namePL;
        this.nameENG = nameENG;
    }

    public long getIdItemCategory() {
        return idItemCategory;
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
