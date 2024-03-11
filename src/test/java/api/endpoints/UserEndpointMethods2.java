package api.endpoints;

import api.payload.CreateUserRequestBody;
import api.payload.UpdateUserRequestBody;
import api.utilities.Utils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

/**
 * Created to perform CRUD operations using the user API
 */
public class UserEndpointMethods2 {

    public static Response postCreateUser(CreateUserRequestBody payload) {

        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Utils.getUrlFromPropertiesFile("post_create_user_url"));
    }

    public static Response getUser(String userName) {

        return given()
                .log().all()
                .pathParam("username", userName)
                .when()
                .get(Utils.getUrlFromPropertiesFile("get_user_url"));
    }
    public static Response putUpdateUser(UpdateUserRequestBody payload, String userName) {

        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(Utils.getUrlFromPropertiesFile("update_user_url"));
    }
    public static Response deleteUser(String userName) {

        return given()
                .log().all()
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .when()
                .delete(Utils.getUrlFromPropertiesFile("delete_user_url"));
    }

}
