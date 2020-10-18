del /s *.class
javac -cp ".;lib\*" -sourcepath . test/Phase2Evaluation.java
if ERRORLEVEL 1 goto End

java -cp ".;lib\*" test.Phase2Evaluation
:End
