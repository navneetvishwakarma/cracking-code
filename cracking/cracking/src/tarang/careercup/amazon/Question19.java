package tarang.careercup.amazon;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**

 Write a Program
 You will create an employee class with the following properties:ID (int), FName(string), LName(string).
 (Functionality) to track an employee's manager and subordinates.
 Add a method that displays the names of all subordinates for a given employee.
 Calculate the complexity. Do not use multiple classes.

 * @author tdesai
 */
public class Question19 {

}

class Employee {
    private static int id_seq;
    private Integer ID;
    private String firstName;
    private String lastName;
    private Set<Integer> managers;
    private Set<Integer> subordinates;

    Employee(String firstName, String lastName) {
        ID = ++id_seq;
        this.firstName = firstName;
        this.lastName = lastName;
        managers = new HashSet<Integer>();
        subordinates = new HashSet<Integer>();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Integer> getManagers() {
        return managers;
    }

    public void addManager(Integer id) {
        managers.add(id);
    }

    public Set<Integer> getSubordinates() {
        return subordinates;
    }

    public void addSubordinate(Integer id) {
        subordinates.add(id);
    }
}