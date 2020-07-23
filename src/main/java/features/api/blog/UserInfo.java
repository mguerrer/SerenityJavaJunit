package features.api.blog;

import common.ApiUtil;
import common.CoreConstant;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class UserInfo {

    public Response createUser(models.features.blog.UserInfo userInfo){

        return given().baseUri(CoreConstant.BLOG_HOST + CoreConstant.BLOG_API_USERINFO)
                .header("Content-Type", "application/json")
                .body(ApiUtil.parseObjectToJSON(userInfo, models.features.blog.UserInfo.class))
                .when()
                .post();

    }

}
