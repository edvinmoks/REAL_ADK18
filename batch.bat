@echo off
title Konkordans
set CLASSPATH=.
:start
javac tBuild.java
java tBuild
@echo running Konkordans with search word dddc
javac tKonkordans.java
java tKonkordans dddc
@echo Press key to run again
pause
goto start