/*
package test;

import lib.TestRunner;

public class Phase2Evaluation {
    public static int runTests(boolean printProjectScore) {
        int phaseTests = 18;
        int totalTests = 36;

        System.out.println("BEGIN PROJECT 1 PHASE 2 EVALUATION");
        System.out.println("Total Phase 2 tests: " + phaseTests);
        System.out.println("==========================");
        System.out.println();

        int testsRun = 0;
        int testsPassed = 0;
        boolean allPassed = true;

        TestRunner.TestResults HomeResults = TestRunner.runTest(HomeTest.class);
        System.out.println(HomeResults.toString());
        allPassed = allPassed && HomeResults.allPassed();

        testsRun += HomeResults.testCount;
        testsPassed += HomeResults.successCount;

        TestRunner.TestResults HotelResults = TestRunner.runTest(HotelTest.class);
        System.out.println(HotelResults.toString());
        allPassed = allPassed && HotelResults.allPassed();

        testsRun += HotelResults.testCount;
        testsPassed += HotelResults.successCount;

        TestRunner.TestResults WorldResults = TestRunner.runTest(WorldTest.class);
        System.out.println(WorldResults.toString());
        allPassed = allPassed && WorldResults.allPassed();

        testsRun += WorldResults.testCount;
        testsPassed += WorldResults.successCount;

        if (testsRun < phaseTests) {
            System.out.printf("Note: %d tests were excluded from evaluation.\n", phaseTests - testsRun);
        }

        if (testsPassed == phaseTests) {
            System.out.println("Phase 2 ALL TESTS PASSING!");
        }

        System.out.printf("Phase 2 Tests Passed: [%d / %d]\n", testsPassed, testsRun);
        if (printProjectScore)
            System.out.printf("Overall Project Score: %d%%\n", Math.round(Math.floor(((double)(testsPassed) / (double)(totalTests)) * 100)));
        else
            System.out.println();

        return testsPassed;
    }

    public static void main(String[] args) {
        runTests(true);
    }
}
*/
