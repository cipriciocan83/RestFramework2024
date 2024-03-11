package api.test;

import api.endpoints.UserEndpointMethods;
import api.payload.CreateUserRequestBody;
import api.utilities.DataProviders;
import api.utilities.PayloadUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;

public class DDTests {
//    private CreateUserRequestBody createUserPayload;

    @BeforeClass
    public void setUp() {
//        createUserPayload = PayloadUtils.generateCreateUserRequestBodyFromDataProvider();
    }

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostCreateUser(String userID, String userName, String firstName, String lastName, String email, String password, String phone) {
        CreateUserRequestBody createUserPayload =  new CreateUserRequestBody();
        createUserPayload.setId(Integer.parseInt(userID));
        createUserPayload.setUsername(userName);
        createUserPayload.setFirstName(firstName);
        createUserPayload.setLastName(lastName);
        createUserPayload.setEmail(email);
        createUserPayload.setPassword(password);
        createUserPayload.setPhone(phone);

        Response response = UserEndpointMethods.postCreateUser(createUserPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUsersByNames(String userName) {
        Response response = UserEndpointMethods.deleteUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
