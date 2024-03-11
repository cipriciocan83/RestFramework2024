package api.endpoints;

/*
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/
public class Routes {

    /**
     *  User model routes
     */
    public static final String BASE_URL = "https://petstore.swagger.io";
    public static final String CREATE_USER_ENDPOINT = "/v2/user";
    public static final String GET_USER_ENDPOINT = "/v2/user/{userName}";
    public static final String UPDATE_USER_ENDPOINT = "/v2/user/{userName}";
    public static final String DELETE_USER_ENDPOINT = "/v2/user/{userName}";
    public static final String CREATE_USER_URL = BASE_URL + CREATE_USER_ENDPOINT;
    public static final String GET_USER_URL = BASE_URL + GET_USER_ENDPOINT;
    public static final String UPDATE_USER_URL = BASE_URL + UPDATE_USER_ENDPOINT;
    public static final String DELETE_USER_URL = BASE_URL + DELETE_USER_ENDPOINT;

}
