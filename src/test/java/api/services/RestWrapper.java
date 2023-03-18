package api.services;

import api.pojos.AuthPojo;
import api.services.requests.SimpleBoardRequests;
import api.services.requests.PostBoardRequest;

public class RestWrapper {
    public SimpleBoardRequests simpleBoardRequests;
    public PostBoardRequest postBoardRequest;

    public RestWrapper(AuthPojo auth) {
        simpleBoardRequests = new SimpleBoardRequests(auth);
        postBoardRequest = new PostBoardRequest(auth);
    }
}
