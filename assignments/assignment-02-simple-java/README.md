# Assignment 02 - Simple Java Programs

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar" *.java
```

## Run

```powershell
java -cp "build;acm.jar" Pyramid
```
