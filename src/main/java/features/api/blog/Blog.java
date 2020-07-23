package features.api.blog;

import common.ApiUtil;
import common.CoreConstant;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class Blog {

    public Response createBlog(models.features.blog.Blog blog, String token){


        return given().baseUri(CoreConstant.BLOG_HOST + CoreConstant.BLOG_API_BLOG)
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer " + token)
                .body(ApiUtil.parseObjectToJSON(blog, models.features.blog.Blog.class))
                .when()
                .post();

    }
}
