# Assignment 02 - Simple Java Programs

Run these commands from this directory.

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar" *.java
```

## Run

Replace `Pyramid` with `ProgramHierarchy`, `Target`, `PythagoreanTheorem`, `FindRange`, or `Hailstone` to run another program.

```powershell
java -cp "build;acm.jar" Pyramid
```
