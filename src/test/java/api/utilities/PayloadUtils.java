package api.utilities;

import api.payload.CreateUserRequestBody;
import api.payload.UpdateUserRequestBody;
import com.github.javafaker.Faker;

public class PayloadUtils {
    public static CreateUserRequestBody generateCreateUserRequestBody() {

        Faker faker = new Faker();
        CreateUserRequestBody createUserPayload = new CreateUserRequestBody();
        createUserPayload = new CreateUserRequestBody();
        createUserPayload.setId(faker.idNumber().hashCode());
        createUserPayload.setUsername(faker.name().username());
        createUserPayload.setFirstName(faker.name().firstName());
        createUserPayload.setLastName((faker.name().lastName()));
        createUserPayload.setEmail((faker.internet().safeEmailAddress()));
        createUserPayload.setPassword(faker.internet().password(5, 10));
        createUserPayload.setPassword(faker.phoneNumber().cellPhone());

        return  createUserPayload;
    }
    public static UpdateUserRequestBody generateUpdateUserRequestBody() {
        Faker faker = new Faker();
        UpdateUserRequestBody updateUserPayload = new UpdateUserRequestBody();
        updateUserPayload = new UpdateUserRequestBody();
        updateUserPayload.setId(faker.idNumber().hashCode());
        updateUserPayload.setUsername(faker.name().username());
        updateUserPayload.setFirstName(faker.name().firstName());
        updateUserPayload.setLastName((faker.name().lastName()));
        updateUserPayload.setEmail((faker.internet().safeEmailAddress()));
        updateUserPayload.setPassword(faker.internet().password(5, 10));
        updateUserPayload.setPassword(faker.phoneNumber().cellPhone());

        return updateUserPayload;
    }
}
