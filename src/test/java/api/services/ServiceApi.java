package api.services;

import api.pojos.AuthPojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

@Data
public abstract class ServiceApi {
    private final RequestSpecification requestSpecification;

    /**
     * @return RequestSpecification basePath
     */
    public abstract String getBasePath();

    /**
     * @param auth contains key and token to authorize on the webSite
     */
    public ServiceApi(AuthPojo auth) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com")
                .setBasePath(getBasePath())
                .addQueryParam("key", auth.KEY())
                .addQueryParam("token", auth.TOKEN())
                .setContentType(ContentType.JSON)
                .build();
    }
}
