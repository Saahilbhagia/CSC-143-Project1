del /s *.class
javac -cp ".;lib\*" -sourcepath . test/Phase1Evaluation.java
if ERRORLEVEL 1 goto End

java -cp ".;lib\*" test.Phase1Evaluation
:End
