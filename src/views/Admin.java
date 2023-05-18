package views;

public class Admin extends Person {
    private String username;
    private String password;

    public Admin() { // Default constructor's parameter does not need arguments and does not return
                     // anything; calls the overloaded constructor with 2 arguments.
        this("", "");
    }

    public Admin(String username, String password) { // Overloaded constructor's parameter needs 2 String arguments
                                                     // and does not return anything; initializes the field
                                                     // variables username and password.
        this.username = username;
        this.password = password;
    }

    @Override
    public void setUsername(String Username) { // Public method's parameter needs a String argument and does not return
                                               // anything; sets the field variable based on argument.
        this.username = Username;

    }

    @Override
    public void setPassword(String Password) { // Public method's parameter needs a String argument and does not return
                                               // anything; sets the field variable based on argument.
        this.password = Password;
    }

    @Override
    public String getUsername() { // Public method's parameter does not need arguments and returns the field
                                  // variable username.
        return username;
    }

    @Override
    public String getPassword() { // Public method's parameter does not need arguments and returns the field
                                  // variable password.
        return password;
    }

    @Override
    public String toString() { // Public method's parameter does not need arguments and returns a String
                               // representation of all field variables.
        return username + " " + password;
    }
}