package APIClasses;
/*
* Java class for user create end point
* Have /user body parameter as Strings
* the constructor take username and email
* there is a function to return /user post body as string with the give username and email
* */
public class User {
    private String username;
    private String email;
    public User (String username , String email){
        this.username = username;
        this.email = email+"@email.com";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*function to return /user post body as string with the give username and email*/
    public String getUserPostBody (){
        // create a string with username and email as parameters
        String results = String.format("{ \"nickname\": \"%s\", \"email\": \"%s\"}" , username ,email );




        return results;
    }



}
