package placelab.utils;

import org.json.JSONObject;

public class AuthenticationRequest {
    private static String email;
    private static String password;
    public JSONObject requestBody;

    public AuthenticationRequest() {
        email = GlobalValues.EMAIL;
        password = GlobalValues.PASSWORD;
        createMainBody();
    }

    public AuthenticationRequest(final String emailFake, final String passwordFake) {
        email = emailFake;
        password = passwordFake;
        createMainBody();
    }

    private void createMainBody() {
        JSONObject data = new JSONObject();
        data.put("email", email);
        data.put("password", password);
        requestBody = data;
    }
}
