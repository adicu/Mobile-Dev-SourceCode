package me.donyu.nuggetfinder;

public class Professor {
    
    private String firstName;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String nugget;
    
    public String getNugget() {
        return nugget;
    }

    public void setNugget(String nugget) {
        this.nugget = nugget;
    }

    public Professor(String firstName, String lastName, String nugget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nugget = nugget;
    }
    
    public String checkSearch(String searchQuery) {
        String fullName = firstName + lastName;
        if (fullName.contains(searchQuery)) {
            return this.nugget;
        } else {
            return null;
        }
    }

}
