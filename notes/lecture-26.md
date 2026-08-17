# Lecture 26 - Standard Java, Packages, and JAR Files

## Course Content

### From ACM startup to main

Lecture 26 explains what sits underneath the ACM teaching environment. A conventional Java application begins in `public static void main(String[] args)`, and `main` can create objects or call methods just as the ACM framework eventually calls `run`. The teaching libraries hide that startup sequence early in the course, but understanding it makes ordinary Java programs much less mysterious.

The ACM framework has hidden the ordinary Java entry point while the course focused on programming ideas. The lecture exposes the relationship between `main`, object construction, and the framework's call to `run`, so a student can move from a Karel or graphics assignment to a conventional Java application.

### Packages, imports, and the classpath

Packages organize classes into namespaces. An import lets the source use a class by its short name, but the compiler and runtime still need to locate the class through the classpath. A JAR file is a packaged collection of compiled classes and resources. It is not magic source code; it is a distribution format that allows another project to use a library without copying its implementation files into the project.

A package gives a class a namespace and affects the directory structure in which the compiler expects to find it. `import` changes how a name is written in source; it does not itself install the class. The classpath is the search path used to locate compiled classes and libraries.

### What a JAR contains

The lecture connects this to reproducible builds. A program should document which libraries it needs and how to compile and run it. If compilation succeeds only because an IDE silently supplies a JAR, the project is not yet portable. The same concern applies to resources such as images, sound files, and data files: the program must use paths that work from the documented launch directory.

A JAR bundles compiled class files and other resources into one distributable archive. It is useful when sharing a program because users need the library's compiled implementation, not its source tree, but the program still needs a documented launch command and resource locations.

### Portable builds and resources

The standard Java libraries also provide many capabilities that were introduced through ACM wrappers. As programs become more general, it is useful to recognize when a standard API is sufficient and when a course-specific class is still the clearest teaching tool.

The practical goal is reproducibility: another person should be able to compile and run the program outside the author's IDE. Relative paths, included data files, and library versions all become part of the program's interface to its environment.

## My Takeaways

Learning `main`, packages, and the classpath makes the boundary between “my code” and “the environment” visible. I can now explain why a program compiles in one directory and fails in another instead of treating the IDE as part of the language.

A JAR is also a project responsibility. If a reader cannot reproduce the build from the README, the code is not really finished, even if it runs on the author's machine.


For future projects I would test one clean command-line build before relying on IDE launch settings.
