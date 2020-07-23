package models.features.containers;

import java.util.ArrayList;

public class Containers {

    private Integer container_count;
    private ArrayList<Integer> container_id;
    private String goods_type;

    public Integer getContainer_count() {
        return container_count;
    }

    public void setContainer_count(Integer container_count) {
        this.container_count = container_count;
    }

    public ArrayList<Integer> getContainer_id() {
        return container_id;
    }

    public void setContainer_id(ArrayList<Integer> container_id) {
        this.container_id = container_id;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    @Override
    public String toString() {
        return container_count.toString()+":"+getContainer_count() + "," + container_id+":"+getContainer_id()+","
                +goods_type.toString()+":"+getGoods_type();
    }
}
