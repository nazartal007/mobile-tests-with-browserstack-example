package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic("nazartal_niab7h", "ErnFSD1AGueVsyCwqYTC")
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}