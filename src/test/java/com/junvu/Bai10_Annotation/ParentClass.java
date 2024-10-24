package com.junvu.Bai10_Annotation;

import org.testng.annotations.*;

public class ParentClass {

    @BeforeSuite
    public void beforeSuiteP() {
        System.out.println("Before Suite in ParentClass");
    }

    @AfterSuite
    public void afterSuiteP() {
        System.out.println("After Suite in ParentClass");
    }

    @BeforeTest
    public void beforeTestP() {
        System.out.println("Before Test in ParentClass");
    }

    @AfterTest
    public void afterTestP() {
        System.out.println("After Test in ParentClass");
    }

    @BeforeClass
    public void beforeClassP() {
        System.out.println("Before ParentClass");
    }

    @AfterClass
    public void afterClassP() {
        System.out.println("After ParentClass");
    }

    @BeforeGroups(groups = { "testOne" })
    public void beforeGroupOneP() {
        System.out.println("Before Group testOne in ParentClass");
    }

    @AfterGroups(groups = { "testOne" })
    public void afterGroupOneP() {
        System.out.println("After Group testOne in ParentClass");
    }

    @BeforeGroups(groups = { "testTwo" })
    public void beforeGroupTwoP() {
        System.out.println("Before Group testTwo in ParentClass");
    }

    @AfterGroups(groups = { "testTwo" })
    public void afterGroupTwoP() {
        System.out.println("After Group testTwo in ParentClass");
    }

    @BeforeMethod
    public void beforeMethodP() {
        System.out.println("Before Method in ParentClass");
    }

    @AfterMethod
    public void afterMethodP() {
        System.out.println("After Method in ParentClass");
    }

    @Test(groups = { "testOne" })
    public void testOneMethodP() {
        System.out.println("Test method 1 in ParentClass");
    }

    @Test(groups = { "testTwo" })
    public void testTwoMethodP() {
        System.out.println("Test method 2 in ParentClass");
    }

}
