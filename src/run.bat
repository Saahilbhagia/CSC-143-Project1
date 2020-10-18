del /s *.class
javac -cp ".;lib\*" -sourcepath . test/Project1Evaluation.java
if ERRORLEVEL 1 goto End

java -cp ".;lib\*" test.Project1Evaluation
:End
