package api.endpoints;
import api.payload.CreateUserRequestBody;
import api.payload.UpdateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

/**
 * Created to perform CRUD operations using the user API
 */
public class UserEndpointMethods {

    public static Response postCreateUser(CreateUserRequestBody payload) {

        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.CREATE_USER_URL);
    }

    public static Response getUser(String userName) {

        return given()
                .log().all()
                .pathParam("userName", userName)
                .when()
                .get(Routes.GET_USER_URL);
    }
    public static Response putUpdateUser(UpdateUserRequestBody payload, String userName) {

        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("userName", userName)
                .body(payload)
                .when()
                .put(Routes.UPDATE_USER_URL);
    }
    public static Response deleteUser(String userName) {

        return given()
                .log().all()
                .accept(ContentType.JSON)
                .pathParam("userName", userName)
                .when()
                .delete(Routes.DELETE_USER_URL);
    }

}
