package api.services.requests;

import api.pojos.AuthPojo;
import api.pojos.BoardPojo;
import api.services.responces.BoardResponse;
import api.services.ServiceApi;

import static io.restassured.RestAssured.given;

public class SimpleBoardRequests extends ServiceApi {
    /**
     * @return bathPath
     */
    @Override
    public String getBasePath() {
        return "/1/boards/{id}";
    }

    public SimpleBoardRequests(AuthPojo auth) {
        super(auth);
    }

    /**
     * getBoard         method sends get request to the webSite
     * @param board     the board we are expecting to get from website
     * @return          site response in GetBoardResponse format
     */
    public BoardResponse getBoard(BoardPojo board) {
        return given()
                .spec(super.getRequestSpecification())
                .pathParam("id", board.getId())
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getObject("", BoardResponse.class);
    }

    /**
     * deleteBoard  method deletes a board
     * @param board we are expecting to delete
     * @return      status code
     */
    public int deleteBoard(BoardPojo board) {
        return given()
                .spec(super.getRequestSpecification())
                .pathParam("id", board.getId())
                .when().delete()
                .then().extract().statusCode();
    }
}
