# Section Exercises

## Build

```powershell
New-Item -ItemType Directory -Force build\sections | Out-Null
$sources = Get-ChildItem sections -Recurse -Filter *.java
javac -d build\sections -cp "assignments\assignment-02-simple-java\acm.jar;assignments\assignment-01-karel\karel.jar" $sources
```

## Run

```powershell
java -cp "build\sections;assignments\assignment-01-karel\karel.jar" KarelDefendsDemocracy
java -cp "build\sections;assignments\assignment-02-simple-java\acm.jar" Fibonacci
java -cp "build\sections;assignments\assignment-02-simple-java\acm.jar" RobotFace
java -cp "build\sections;assignments\assignment-02-simple-java\acm.jar" DrawLines
java -cp "build\sections;assignments\assignment-02-simple-java\acm.jar" Hogwarts
java -cp "build\sections;assignments\assignment-02-simple-java\acm.jar" RandomCircles
java -cp "build\sections" Mystery
java -cp "build\sections;assignments\assignment-02-simple-java\acm.jar" BoxDiagram
java -cp "build\sections" FlightPlanner sections\section-08\flights.txt
java -cp "build\sections" EqualityAndArray
```
