package APIClasses;
/*
 * Java class for Play end point
 * Have /play body parameter as Strings
 * the constructor take userToken and gameToken
 * for positionX and positionY there is a default value of 0 , 0
 * there is a function to return /user post body as string with the give userToken , gameToken , positionX and positionY
 * */
public class Play {
    private String userToken;
    private String gameToken;
    private int positionX = 0;
    private int positionY = 0 ;

    public Play(String userToken, String gameToken) {
        this.userToken = userToken;
        this.gameToken = gameToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getGameToken() {
        return gameToken;
    }

    public void setGameToken(String gameToken) {
        this.gameToken = gameToken;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getPlayPostBody (){
        // create a string with username and email as parameters
        String results = String.format("{ \"userToken\": \"%s\"\n" +
                ", \"gameToken\": \"%s\", \"positionX\": %d, \"positionY\": %d}" , userToken ,gameToken ,positionX , positionY );




        return results;
    }
}
