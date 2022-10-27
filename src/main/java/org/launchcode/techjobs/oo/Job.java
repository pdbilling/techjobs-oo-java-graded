package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job <jobObject> {

    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
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
        return Objects.hash(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String noData = "Data not available";
        String empty = "";
        String aName;
        String aEmployer;
        String aLocation;
        String aPositionType;
        String aCoreCompetency;
        if(name == null){
            name = noData;
        }
        if(employer == null || employer.getValue() == empty){
            aEmployer = noData;
        } else { aEmployer = employer.getValue(); }
        if(location == null || location.getValue() == empty){
            aLocation = noData;
        } else { aLocation = location.getValue(); }
        if(positionType == null || positionType.getValue() == empty){
            aPositionType = noData;
        } else { aPositionType = positionType.getValue(); }
        if(coreCompetency == null || coreCompetency.getValue() == empty){
            aCoreCompetency = noData;
        } else { aCoreCompetency = coreCompetency.getValue(); }
        String labels = "\nID: " + id +
                "\nName: " + name +
                "\nEmployer: " + aEmployer +
                "\nLocation: " + aLocation +
                "\nPosition Type: " + aPositionType +
                "\nCore Competency: " + aCoreCompetency +
                "\n";
        return labels;
    }
}
