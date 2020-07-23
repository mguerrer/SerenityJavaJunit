package api.containers;

import common.ApiUtil;
import models.features.containers.Containers;
import org.junit.Test;

import java.util.ArrayList;

public class ContainersTest {


    private Containers containers = new Containers();
    private ArrayList<Integer> container_id_list = new ArrayList<Integer>();
    private String container_json = "";

    @Test
    public void test_container(){

        containers.setContainer_count(5);
        containers.setContainer_id(container_id_list);
        containers.setGoods_type("general");

        container_json = ApiUtil.parseObjectToJSON(containers, Containers.class).replaceAll("\n","")
                .replaceAll(" ","").replace("\"","\\\"");
        System.out.print(container_json);

    }
}
