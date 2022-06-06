package maktab74.util;

public class RelationCart {

   private int id ;

   private String refrence;

    public RelationCart(int id, String refrence) {
        this.id = id;
        this.refrence = refrence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefrence() {
        return refrence;
    }

    public void setRefrence(String refrence) {
        this.refrence = refrence;
    }
}
