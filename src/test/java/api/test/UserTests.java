package api.test;
import api.endpoints.UserEndpointMethods;
import api.payload.CreateUserRequestBody;
import api.payload.UpdateUserRequestBody;
import api.utilities.PayloadUtils;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {
    CreateUserRequestBody createUserPayload;
    UpdateUserRequestBody updateUserPayload;
    Logger logger;

    @BeforeClass
    public void setupData() {

        // Initiate the logs
        logger = LogManager.getLogger(this.getClass());

        createUserPayload = PayloadUtils.generateCreateUserRequestBody();
        updateUserPayload = PayloadUtils.generateUpdateUserRequestBody();
    }
    @Test(priority = 1)
    public void createUserTest() {
        logger.info("******* Creating user **********");

        Response response = UserEndpointMethods.postCreateUser(createUserPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("****** User information is displayed *******");
    }
    @Test(priority =  2)
    public void getUserByUsernameTest() {
        Response response = UserEndpointMethods.getUser(createUserPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void updateUserTest() {
        logger.info("******* Updating user **********");

        Response response = UserEndpointMethods.putUpdateUser(updateUserPayload, createUserPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("******* User is updated **********");
    }

    @Test(priority =  4)
    public void deleteUserTest() {
        logger.info("******* Deleting user **********");

        Response response = UserEndpointMethods.deleteUser(createUserPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("******* User is user **********");
    }
}
