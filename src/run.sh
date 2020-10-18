#!/bin/bash
set -e

find . -type f -name '*.class' -delete
javac -cp *:lib/*:. -sourcepath . test/Project1Evaluation.java
java -cp *:lib/*:. test.Project1Evaluation
