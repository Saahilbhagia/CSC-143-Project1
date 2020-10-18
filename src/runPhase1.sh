#!/bin/bash
set -e

find . -type f -name '*.class' -delete
javac -cp *:lib/*:. -sourcepath . test/Phase1Evaluation.java
java -cp *:lib/*:. test.Phase1Evaluation
