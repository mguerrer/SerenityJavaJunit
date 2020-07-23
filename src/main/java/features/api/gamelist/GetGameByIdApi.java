package features.api.gamelist;

import common.ApiUtil;
import common.CoreConstant;
import io.restassured.response.Response;
import models.features.gamelist.Game;

import static net.serenitybdd.rest.SerenityRest.given;

public class GetGameByIdApi {

    public Response getGameById(Integer gameId) {

        return given().baseUri(CoreConstant.GAMELIST_HOST + CoreConstant.GAMELIST_API)
                .header("Content-Type", "application/json")
                .when()
                .get("/" + gameId);
    }

}
