# Assignment 01 - Karel the Robot

Run these commands from this directory.

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "karel.jar" *.java
```

## Run

Pass the matching class and world file when starting a program. For example:

```powershell
java -cp "build;karel.jar" CheckerboardKarel code=CheckerboardKarel world=worlds\CheckerboardKarel.w
```
