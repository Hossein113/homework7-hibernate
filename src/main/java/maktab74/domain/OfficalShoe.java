package maktab74.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = OfficalShoe.TABLE_NAME)
public class OfficalShoe extends Shoes {

    public static final String TABLE_NAME = "OFFICAL_SHOES_table";
    public static final String FOLLOWING_LAYER_TYPE = "following_layer_type";

    @Column(name = FOLLOWING_LAYER_TYPE)
    private String followingLayerType;

    public OfficalShoe(int id, String name, String madeIn, int price, int number, int size, String material, String color, String followingLayerType) {
        super(id, name, madeIn, price, number, size, material, color);
        this.followingLayerType = followingLayerType;
    }

    public OfficalShoe(String name, String madeIn, int price, int number, int size, String material, String color, String followingLayerType) {
        super(name, madeIn, price, number, size, material, color);
        this.followingLayerType = followingLayerType;
    }

    public String getFollowingLayerType() {
        return followingLayerType;
    }

    public void setFollowingLayerType(String followingLayerType) {
        this.followingLayerType = followingLayerType;
    }

    @Override
    public String toString() {
        return "OfficalShoe{" +
                "followingLayerType='" + followingLayerType + '\'' +
                "} " + super.toString();
    }
}
