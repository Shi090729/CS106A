# Assignment 06 - NameSurfer

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar" *.java
```

## Run

```powershell
java -cp "build;acm.jar" NameSurfer
```
