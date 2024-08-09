import APIClasses.Connect;
import APIClasses.Play;
import APIClasses.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.http.Status;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class FiveRowTest {
    JsonPath jsonPath ;
    File urlPathFile = new File("src/main/resources/EndPoints.json");
    String baseEndPoint ;
    String userPath;
    String connectPath;
    String playPath;
    String userName;
    String email;
    String userToken;
    String gameToken;
    String positionX;
    String positionY;
    String playerID;
    User user;
    Connect connect;
    Play play;
    RequestSpecBuilder requestBuilder = new RequestSpecBuilder() ;
    RequestSpecification requestSpecification;
    @BeforeTest
    public void apiInit(){
        // read Endpoints from Json file
         jsonPath = new JsonPath(urlPathFile);
         baseEndPoint = jsonPath.getString("baseURL");
         userPath =  jsonPath.getString("user");
        connectPath =  jsonPath.getString("connect");
        playPath =  jsonPath.getString("play");

        // generate and random userName and email using system time
        // remove special characters from random string
        userName = (java.time.Clock.systemUTC().instant()).toString();
        userName = userName.replaceAll("[^a-zA-Z0-9]", "");
        email = (java.time.Clock.systemUTC().instant()).toString();
        email = email.replaceAll("[^a-zA-Z0-9]", "");
        // Init /user endPoint
        user = new User(userName , email);
        //Create a request builder.
        requestBuilder.addHeader("accept" , "application/json")
                .addHeader("Content-Type" , "application/json")
                .setBaseUri(baseEndPoint);
        requestSpecification = requestBuilder.build();
    }

    @Test (priority = 0)
    public void  createNewUser(){
        Response response = given()
                .spec(requestSpecification)
                .body(user.getUserPostBody())
                .log().all()
                .when()
                .post(userPath)
                .then()
                .assertThat()
                .log().body()
                .statusCode(201)
                .extract()
                .response();

        JsonPath jsonPath = new JsonPath(response.asString());
        userToken = jsonPath.getString("userToken");
        playerID = jsonPath.getString("userId");

    }
    @Test (priority = 1 , dependsOnMethods = "createNewUser")
    public void  connectToGame() throws InterruptedException {
        //init connect
        connect = new Connect(userToken);
        Thread.sleep(30000); // to avoid IP block

        Response response = given()
                .spec(requestSpecification)
                .body(connect.getConnectPostBody())
                .log().all()
                .when()
                .post(connectPath)
                .then()
                .assertThat()
                .log().body()
                .statusCode(201)
                .extract()
                .response();


        JsonPath jsonPath = new JsonPath(response.asString());
        gameToken = jsonPath.getString("gameToken");


    }

    @Test (priority = 2 , dependsOnMethods = "connectToGame")
    public void  playGame() throws InterruptedException {
        //init play
      play = new Play(userToken , gameToken);
      int i = 0;
        Response response;

        do{
            Thread.sleep(30000); // wait for 30 second for the second player to play or to join
            response =   given()
                .spec(requestSpecification)
                .body(play.getPlayPostBody())
                .log().all()
                .when()
                .post(playPath)
                .then()
                .log().body()
                .log().status()
                .extract()
                .response();
            i++;
        }

        while(response.getStatusCode()!= 201 && i < 6);

        JsonPath jsonPath = new JsonPath(response.asString());
        Assert.assertEquals(playerID , jsonPath.getString("coordinates[0].playerId"));




    }




}
