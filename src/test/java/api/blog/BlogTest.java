package api.blog;

import common.BaseTest;
import common.db.blog.BlogSimple;
import features.api.blog.Authen;
import features.api.blog.UserInfo;
import io.restassured.response.Response;
import models.features.blog.Blog;
import models.features.blog.Token;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class BlogTest extends BaseTest {

    private Authen authenApi = new Authen();
    private UserInfo userInfoApi = new UserInfo();
    private models.features.blog.UserInfo userInfoModel = new models.features.blog.UserInfo();
    private models.features.blog.Authen authenModel = new models.features.blog.Authen();
    private BlogSimple blogSimple = new BlogSimple();
    private Blog blogModel = new Blog();
    private features.api.blog.Blog blogApi = new features.api.blog.Blog();

    @Test
    public void create_new_blog(){

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

        String token = actualResponse.getToken();

        String title = "Test Automation using Serenity";
        String content = "A lot of things man";
        blogModel.setTitle(title);
        blogModel.setContent(content);
        Response responseBlog = blogApi.createBlog(blogModel,token);
        Blog responseBlogActual = responseBlog.as(Blog.class);
        softAssertImpl.assertThat("Verify status code is 200",responseBlog.getStatusCode(), 200);
        softAssertImpl.assertThat("Verify title is correct",responseBlogActual.getTitle(),title);
        softAssertImpl.assertThat("Verify content is correct", responseBlogActual.getContent(), content);
        softAssertImpl.assertThat("Verify id is not null",responseBlogActual.getId().toString().isEmpty(),false);

        //Clear db

        blogSimple.clearUserInfoByUsername(username);
        blogSimple.clearBlogByTitle(title);
        softAssertImpl.assertAll();

    }

}
