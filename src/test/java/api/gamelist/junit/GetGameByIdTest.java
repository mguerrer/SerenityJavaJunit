package api.gamelist.junit;

import common.BaseTest;
import features.api.gamelist.GetGameByIdApi;
import io.restassured.response.Response;
import models.features.gamelist.Game;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GetGameByIdTest extends BaseTest {

    GetGameByIdApi getGameByIdApi = new GetGameByIdApi();


    @Test
    public void test_get_game_by_id(){

        Response response = getGameByIdApi.getGameById(1);
        Game actual = response.as(Game.class);

        softAssertImpl.assertThat("Verify response status is 200",response.statusCode(), 200);
        softAssertImpl.assertThat("Verify game id must be 1",actual.getId(),1);
        softAssertImpl.assertAll();


    }
}
