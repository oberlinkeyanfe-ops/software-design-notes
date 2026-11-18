# 01. SOLID with everyday examples

One small Java file per principle, using the same images as my LinkedIn post: a restaurant, a power strip, a drink order, a TV remote and a phone charger.

| Principle | Idea | File |
|---|---|---|
| S, Single Responsibility | The cook cooks, the cashier takes payments | [SingleResponsibility.java](src/SingleResponsibility.java) |
| O, Open/Closed | A power strip accepts new devices without rewiring | [OpenClosed.java](src/OpenClosed.java) |
| L, Liskov Substitution | Any drink you get must still be drinkable | [LiskovSubstitution.java](src/LiskovSubstitution.java) |
| I, Interface Segregation | Small remotes instead of one with 80 buttons | [InterfaceSegregation.java](src/InterfaceSegregation.java) |
| D, Dependency Inversion | The charger depends on a standard socket, not on the wall | [DependencyInversion.java](src/DependencyInversion.java) |

## Run

Java 17 or later:

```bash
cd src
java SingleResponsibility.java
java OpenClosed.java
java LiskovSubstitution.java
java InterfaceSegregation.java
java DependencyInversion.java
```

A longer version with "bad design vs good design" and UML diagrams is in my course repository [INF4067](https://github.com/oberlinkeyanfe-ops/INF4067).

---

Version française : un fichier Java par principe SOLID, avec les mêmes exemples que mon post LinkedIn. Chaque fichier se lance directement avec `java NomDuFichier.java` (Java 17 ou plus).
