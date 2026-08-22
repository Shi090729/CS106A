# Assignment 01 - Karel the Robot

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "karel.jar" *.java
```

## Run

```powershell
java -cp "build;karel.jar" CheckerboardKarel code=CheckerboardKarel world=worlds\CheckerboardKarel.w
```
