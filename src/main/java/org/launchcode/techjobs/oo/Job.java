package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

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
    public Job() {
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

        String idLine;
        String nameLine;
        String employerLine;
        String locationLine;
        String positionTypeLine;
        String coreCompetencyLine;
        int notNullCheck = 0;
        String oops = "";

        if (name == null) {
            nameLine = "Data not available";
            notNullCheck++;
        } else {
            nameLine = name;
        }

        if (employer == null || employer.getValue() == null) {
            employerLine = "Data not available";
            notNullCheck++;
        } else {
            employerLine = employer.getValue();
        }
        if (location == null || location.getValue() == null) {
            locationLine = "Data not available";
            notNullCheck++;
        } else {
            locationLine = location.getValue();
        }
        if (positionType == null || positionType.getValue() == null) {
            positionTypeLine = "Data not available";
            notNullCheck++;
        } else {
            positionTypeLine = positionType.getValue();
        }

        if (coreCompetency == null || coreCompetency.getValue() == null) {
            coreCompetencyLine = "Data not available";
            notNullCheck++;
        } else {
            coreCompetencyLine = coreCompetency.getValue();
        }
        if(notNullCheck == 5){
            oops = "OOPS! This job does not seem to exist.";
        }


       String jobTemplate =  "\n" +
                "ID: " + getId() +
                "\nName: " + nameLine +
                "\nEmployer: " + employerLine +
                "\nLocation: " + locationLine +
                "\nPosition Type: " + positionTypeLine +
                "\nCore Competency: " + coreCompetencyLine + "\n";

        if (oops.equals("")){
            return jobTemplate;
        }
        else{
            return oops;
        }
    }
}
