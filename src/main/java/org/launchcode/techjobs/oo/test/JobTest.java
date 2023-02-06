package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.launchcode.techjobs.oo.*;


import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //Test that the value of the field is correct
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());

        //Test that the class of the field is correct
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //gets the beginning newline
        assertEquals(job6.toString().charAt(0),'\n');
        // gets the end newline by subtracting one from it
        assertEquals(job6.toString().charAt(job6.toString().length() -1),'\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

//        assertTrue(job7.toString().contains("Employer: ACME"));
//        assertTrue(job7.toString().contains("Location: Desert"));
//        assertTrue(job7.toString().contains("Position Type: Quality control"));
//        assertTrue(job7.toString().contains("Core Competency: Persistence"));
        assertEquals("ID: " + job7.getId() + "\nName: Product tester" + "\nEmployer: ACME" + "\nLocation: Desert" + "\nPosition Type: Quality control" + "\nCore Competency: Persistence" + "\n", job7.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job8 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        System.out.println(job8.toString());
//        assertTrue(job8.toString().contains("ID: " + job8.getId()));
//        assertTrue(job8.toString().contains("Name: Product tester"));
//        assertTrue(job8.toString().contains("Employer: Data not available"));
//        assertTrue(job8.toString().contains("Location: Desert"));
//        assertTrue(job8.toString().contains("Position Type: Quality control"));
//        assertTrue(job8.toString().contains("Core Competency: Persistence"));
        assertEquals("ID: " + job8.getId() + "\nName: Product tester" + "\nEmployer: Data not available" + "\nLocation: Desert" + "\nPosition Type: Quality control" + "\nCore Competency: Persistence" + "\n", job8.toString());

    }



}
