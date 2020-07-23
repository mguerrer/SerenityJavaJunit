package api.blog;

import common.BaseTest;
import common.db.blog.BlogSimple;
import features.api.blog.Authen;
import features.api.blog.UserInfo;
import io.restassured.response.Response;
import models.features.blog.Token;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AuthenTest extends BaseTest {

    private Authen authenApi = new Authen();
    private UserInfo userInfoApi = new UserInfo();
    private models.features.blog.UserInfo userInfoModel = new models.features.blog.UserInfo();
    private models.features.blog.Authen authenModel = new models.features.blog.Authen();
    private BlogSimple blogSimple = new BlogSimple();


    @Test
    public void authen_user_credential_success(){

        String username = RandomStringUtils.randomAlphabetic(8) + "@coccoc.com";
        String password = RandomStringUtils.randomAlphabetic(4);
        userInfoModel.setFullname(RandomStringUtils.randomAlphabetic(4) + " " + RandomStringUtils.randomAlphabetic(5));
        userInfoModel.setUsername(username);
        userInfoModel.setPassword(password);
        userInfoApi.createUser(userInfoModel);

        authenModel.setUsername(username);
        authenModel.setPassword(password);

        Response response = authenApi.authenUser(authenModel);
        Token actualResponse = response.as(Token.class);
        softAssertImpl.assertThat("Verify token is not null", actualResponse.getToken().isEmpty(),false);

        blogSimple.clearUserInfoByUsername(username);
        softAssertImpl.assertAll();

    }

}
