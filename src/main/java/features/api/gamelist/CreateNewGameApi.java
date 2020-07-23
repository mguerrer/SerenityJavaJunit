package features.api.gamelist;

import common.CoreConstant;
import io.restassured.response.Response;
import models.features.gamelist.Game;
import common.ApiUtil;
import static net.serenitybdd.rest.SerenityRest.given;

public class CreateNewGameApi {

    public Response createNewGame(Game gameInput) {

        return given().baseUri(CoreConstant.GAMELIST_HOST + CoreConstant.GAMELIST_API)
                .header("Content-Type", "application/json")
                .body(ApiUtil.parseObjectToJSON(gameInput, Game.class))
                .when()
                .post();
    }

}
