package APIClasses;
/*
 * Java class for connect end point
 * Have /connect body parameter as Strings
 * the constructor take userToken
 * there is a function to return /connect post body as string with the UserToken
 * */
public class Connect {
    private String userToken ;

    public  Connect (String userToken){
        this.userToken = userToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    //function to return /connect post body as string with the UserToken
    public String getConnectPostBody (){
        // create a string with userToken as parameter
        String results = String.format("{ \"userToken\": \"%s\"}" , userToken  );

        return results;
    }
}
