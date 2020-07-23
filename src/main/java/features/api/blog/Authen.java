package features.api.blog;

import common.ApiUtil;
import common.CoreConstant;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class Authen {

    public Response authenUser(models.features.blog.Authen authen){

        return given().baseUri(CoreConstant.BLOG_HOST + CoreConstant.BLOG_API_AUTHEN)
                .header("Content-Type", "application/json")
                .body(ApiUtil.parseObjectToJSON(authen, models.features.blog.Authen.class))
                .when()
                .post();

    }

    }

