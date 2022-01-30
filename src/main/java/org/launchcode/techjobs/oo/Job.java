package org.launchcode.techjobs.oo;

import java.util.HashMap;
import java.util.Objects;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id=nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        JobField[] fields = new JobField[]{this.employer, this.location, this.positionType, this.coreCompetency};
        int nullCheck = 0;
        for (Object field: fields){
            if (field == null){
                nullCheck++;
            }
        }

        if(nullCheck > 0){
            return "OOPS! This job does not seem to exist.";
        }

        String aName = this.name;
        String aEmployer = this.employer.toString();
        String aLocation = this.location.toString();
        String aPositionType = this.positionType.toString();
        String aCoreCompetency = this.coreCompetency.toString();

        return "\nID: " + this.id +
                "\nName: " + checkFieldStringForData(aName) +
                "\nEmployer: " + checkFieldStringForData(aEmployer) +
                "\nLocation: " + checkFieldStringForData(aLocation) +
                "\nPosition Type: " + checkFieldStringForData(aPositionType) +
                "\nCore Competency: "+ checkFieldStringForData(aCoreCompetency) + "\n";
    }

    public static String checkFieldStringForData (String inputString){
        if(inputString == null || inputString.equals("")){
            inputString = "Data not available";
        }
        return inputString;
    }
}
