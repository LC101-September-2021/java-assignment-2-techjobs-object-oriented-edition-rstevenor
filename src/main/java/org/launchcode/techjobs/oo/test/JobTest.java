package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
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
    public void testSettingJobId() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test1.getId() == test2.getId());
        assertTrue(test1.getId() + 1 == test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test1.getName() instanceof String);
        assertEquals(test1.getName(), "Product tester");
        assertTrue(test1.getEmployer() instanceof Employer);
        assertEquals(test1.getEmployer().getValue(), "ACME");
        assertTrue(test1.getLocation() instanceof Location);
        assertEquals(test1.getLocation().getValue(), "Desert");
        assertTrue(test1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(test1.getCoreCompetency().getValue(), "Persistence");
        assertTrue(test1.getPositionType() instanceof PositionType);
        assertEquals(test1.getPositionType().getValue(), "Quality control");
    }
//
    @Test
    public void testJobsForEquality() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test1.equals(test2));
    }
//
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(test1.toString().charAt(0), '\n');
        assertEquals(test1.toString().charAt(test1.toString().length() - 1), '\n');

    }
//
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(test1.toString(), "\nID: 5\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n");

    }
//
    @Test
    public void testToStringHandlesEmptyField() {
        Job test3 = new Job("Missing", new Employer(), new Location("Top Secret"), new PositionType("Test Subject"), new CoreCompetency("Discretion"));
        Job test4 = new Job("Job", new Employer(""), new Location("STL"), new PositionType("Employed"), new CoreCompetency("Working"));
        String jobPost1 = test3.toString();
        String jobPost2 = test4.toString();

        Assert.assertEquals(jobPost1, "\nID: 3\n" +
                "Name: Missing\n" +
                "Employer: Data not available\n" +
                "Location: Top Secret\n" +
                "Position Type: Test Subject\n" +
                "Core Competency: Discretion\n");

        Assert.assertEquals(jobPost2, "\nID: 4\n" +
                "Name: Job\n" +
                "Employer: Data not available\n" +
                "Location: STL\n" +
                "Position Type: Employed\n" +
                "Core Competency: Working\n");
    }
//
    @Test
    public void testJobToStringAlertsWhenJobDoesNotExist() {
        Job test5 = new Job();
        assertEquals(test5.toString(), "OOPS! This job does not seem to exist.");
    }


}
