package views;

public abstract class Person { // Abstract class cannot be instantiated
    public String username;
    public String password;

    public abstract void setUsername(String Username);// Abstract methods's parameter needs a String argument and does
                                                      // not return anything,

    public abstract void setPassword(String Password); // Abstract methods's parameter needs a String argument and does
                                                       // not return anything,

    public abstract String getUsername();// Abstract methods's parameter does not need arguments and returns a String.

    public abstract String getPassword(); // Abstract methods's parameter does not need arguments and returns a String.

    public abstract String toString(); // Abstract methods's parameter does not need arguments and returns a String.
}