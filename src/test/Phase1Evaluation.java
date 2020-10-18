/*
package test;

import lib.TestRunner;

public class Phase1Evaluation {
    public static int runTests(boolean printProjectScore) {
        int phaseTests = 18;
        int totalTests = 36;

        System.out.println("BEGIN PROJECT 1 PHASE 1 EVALUATION");
        System.out.println("Total Phase 1 tests: " + phaseTests);
        System.out.println("==========================");
        System.out.println();

        int testsRun = 0;
        int testsPassed = 0;
        boolean allPassed = true;

        TestRunner.TestResults SupermarketResults = TestRunner.runTest(SupermarketTest.class);
        System.out.println(SupermarketResults.toString());
        allPassed = allPassed && SupermarketResults.allPassed();

        testsRun += SupermarketResults.testCount;
        testsPassed += SupermarketResults.successCount;

        TestRunner.TestResults RestaurantResults = TestRunner.runTest(RestaurantTest.class);
        System.out.println(RestaurantResults.toString());
        allPassed = allPassed && RestaurantResults.allPassed();

        testsRun += RestaurantResults.testCount;
        testsPassed += RestaurantResults.successCount;

        if (testsRun < phaseTests) {
            System.out.printf("Note: %d tests were excluded from evaluation.\n", phaseTests - testsRun);
        }

        if (testsPassed == phaseTests) {
            System.out.println("Phase 1 ALL TESTS PASSING!");
        }

        System.out.printf("Phase 1 Tests Passed: [%d / %d]\n", testsPassed, testsRun);
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
