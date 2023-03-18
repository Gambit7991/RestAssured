package api.services.requests;

import api.pojos.AuthPojo;
import api.pojos.BoardPojo;
import api.services.responces.BoardResponse;
import api.services.ServiceApi;

import static io.restassured.RestAssured.given;

public class PostBoardRequest extends ServiceApi {
    public PostBoardRequest(AuthPojo auth) {
        super(auth);
    }

    @Override
    public String getBasePath() {
        return "/1/boards";
    }

    /**
     *
     * @param board we expect to create
     * @return      board have created
     */
    public BoardResponse createBoard(BoardPojo board) {
        return given()
                .spec(super.getRequestSpecification())
                .queryParam("name", board.getName())
                .when().post()
                .then().statusCode(200)
                .extract().jsonPath().getObject("", BoardResponse.class);
    }
}
