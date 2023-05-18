package views;

public class User extends Person {
    private String username, password, phoneNumber;
    private int beds, roomSize;
    private boolean signed;

    // true if roomSize is more than 250 sq ft
    // "-Room has free Wifi\n-Concierge service\n-Breakfast and dinner\n-Executive
    // Double Beds\n-Weekly cleaning services\n-Cool Air Conditioning\n-Room size:
    // 268 sq ft\n\n\n Only $150 Per Night"

    public User(String username, String password, String phoneNumber) { // Overloaded constructor's parameter needs
                                                                        // 3 String arguments and does not
                                                                        // return anything; calls the overloaded
                                                                        // constructor that has 12 parameters
                                                                        // and initializes 3 field variables.
        this(username, password, phoneNumber, 0, 0, false);
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User(String username, String password, String phoneNumber, int beds, int roomSize, boolean signed) {
        // Overloaded constructor's parameter needs 3 String arguments, 3 int arguments,
        // 3 boolean arguments, and does not return anything; initializes all field
        // variables.
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.beds = beds;
        this.roomSize = roomSize;
        this.signed = signed;
    }

    public int getTotal() { // Public method's parameter does not need arguments and returns an int;
                            // calculates the individual payments for the user.
        return 150;

    }

    @Override
    public String getUsername() { // Public method's parameter does not need arguments and returns the field
                                  // variable username.
        return username;
    }

    @Override
    public void setUsername(String username) { // Public method's parameter needs a String argument and does not return
                                               // anything; sets the field variable based on argument.
        this.username = username;
    }

    @Override
    public String getPassword() { // Public method's parameter does not need arguments and returns the field
                                  // variable password.
        return password;
    }

    @Override
    public void setPassword(String password) { // Public method's parameter needs a String argument and does not return
                                               // anything; sets the field variable based on argument.
        this.password = password;
    }

    public String getPhoneNumber() { // Public method's parameter does not need arguments and returns the field
                                     // variable phoneNumber.
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { // Public method's parameter needs a String argument and does not
                                                     // return anything; sets the field variable based on argument.
        this.phoneNumber = phoneNumber;
    }

    public void setBeds(int beds) { // Public method's parameter does not need arguments and returns the field
        // variable beds.
        this.beds = beds;
    }

    public int getBeds() { // Public method's parameter does not need arguments and returns the field
        // variable beds.
        return beds;
    }

    public int getRoomSize() { // Public method's parameter does not need arguments and returns the field
        // variable baths.
        return roomSize;
    }

    public void setRoomSize(int roomSize) { // Public method's parameter does not need arguments and returns the field
        // variable baths.
        this.roomSize = roomSize;
    }

    public boolean isAccept() { // Public method's parameter does not need arguments and returns the field
                                // variable accept.
        return signed;
    }

    public void setAccept(boolean signed) { // Public method's parameter needs a boolean argument and does not return
                                            // anything; sets the field variable based on argument.
        this.signed = signed;
    }

    @Override
    public String toString() { // Public method's parameter does not need arguments and return a String;
                               // returns a String representation of all field variables.
        return username + " " + password + " " + phoneNumber + " " + beds + " " + roomSize + " " + signed;
    }
}