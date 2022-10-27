package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import org.launchcode.techjobs.oo.Job;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1 instanceof Job);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job1.getName(),"Product tester");
        assertEquals(job1.getEmployer().getValue(), "ACME");
        assertEquals(job1.getLocation().getValue(), "Desert");
        assertEquals(job1.getPositionType().getValue(), "Quality control");
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job();
        char lastChar = job.toString().charAt(job.toString().length()-1);
        char firstChar = job.toString().charAt(0);
        assertEquals(lastChar, '\n');
        assertEquals(firstChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobData = "\nID: " + job1.getId() +
                "\nName: " + job1.getName() +
                "\nEmployer: " + job1.getEmployer() +
                "\nLocation: " + job1.getLocation() +
                "\nPosition Type: " + job1.getPositionType() +
                "\nCore Competency: " + job1.getCoreCompetency() +
                "\n";
        assertEquals(jobData, job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType(), new CoreCompetency("Persistence"));
        String jobData = "\n" +
                "ID: " + job.getId() +
                "\nName: " + job.getName() +
                "\nEmployer: " + job.getEmployer() +
                "\nLocation: " + job.getLocation() +
                "\nPosition Type: " + job.getPositionType() +
                "\nCore Competency: " + job.getCoreCompetency() +
                "\n";
        assertEquals(jobData, job.toString());
    }

}
