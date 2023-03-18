package api;

import api.pojos.BoardPojo;
import api.utils.Generator;
import api.services.RestWrapper;
import api.services.responces.BoardResponse;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Runner {
    private static RestWrapper api;
    private static BoardPojo board;

    @BeforeAll
    public static void login() {
        api = new RestWrapper(Generator.getAuth());
    }

    @BeforeEach
    public void precondition(){
        board = Generator.generateBoardPojo();
        board.setId(
                api.postBoardRequest.createBoard(board).getId());
    }

    @AfterEach
    public void cleanUp(){
        api.simpleBoardRequests.deleteBoard(board);
    }

    @Test
    public void getBoardByID() {
        BoardResponse getResponse = api.simpleBoardRequests.getBoard(board);
        AssertionsForClassTypes
                .assertThat(getResponse)
                .isNotNull().extracting(BoardPojo::getId)
                .isEqualTo(board.getId());
    }

    @Test
    public void createBoardTest() {
        BoardResponse boardPojo = api.postBoardRequest.createBoard(Generator.generateBoardPojo());
        Assertions
                .assertThat(boardPojo)
                .isNotNull().extracting(BoardPojo::getId)
                .isEqualTo(boardPojo.getId());
        api.simpleBoardRequests.deleteBoard(boardPojo);
    }

    @Test()
    public void deleteBoardByID() {
        AssertionsForClassTypes
                .assertThat(api.simpleBoardRequests.deleteBoard(board))
                .isEqualTo(200);
    }
}
