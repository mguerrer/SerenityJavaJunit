package api.blog;

import common.BaseTest;
import common.db.blog.BlogSimple;
import features.api.blog.UserInfo;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

@RunWith(SerenityRunner.class)
public class UserInfoTest extends BaseTest {

    private UserInfo userInfoApi = new UserInfo();
    private models.features.blog.UserInfo userInfoModel = new models.features.blog.UserInfo();
    private BlogSimple blogSimple = new BlogSimple();

    @Test
    public void test_create_new_user_success_case(){

        String username = "cuongld@coccoc.com";
        userInfoModel.setFullname("Le Dinh Cuong");
        userInfoModel.setUsername(username);
        userInfoModel.setPassword("cuongld");
        Response response = userInfoApi.createUser(userInfoModel);
        softAssertImpl.assertThat("Verify status code is 200", response.getStatusCode(), 200);
        //Clear db

        blogSimple.clearUserInfoByUsername(username);
        softAssertImpl.assertAll();

    }

}
