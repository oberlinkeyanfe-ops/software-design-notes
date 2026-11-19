# 03. Creational patterns: Singleton, Factory, Builder

Creational patterns answer one question: who creates the objects, and how? Three of them come up all the time.

| Pattern | Problem it solves | Everyday image | File |
|---|---|---|---|
| Singleton | Exactly one instance should exist | A country has one central bank | [SingletonExample.java](src/SingletonExample.java) |
| Factory | The caller shouldn't know which concrete class to create | The Mobile Money agent picks the operator for you | [FactoryExample.java](src/FactoryExample.java) |
| Builder | An object has many optional parts | Ordering a plate: main dish required, the rest optional | [BuilderExample.java](src/BuilderExample.java) |

## Run

Java 17 or later:

```bash
cd src
java SingletonExample.java
java FactoryExample.java
java BuilderExample.java
```

## When not to use them

- **Singleton** is global state. It makes unit tests harder, because every test shares the same object. Passing one shared instance through the constructor is often enough.
- **Factory** is overkill if there is only one implementation and no plan for more.
- **Builder** is not needed for an object with two or three required fields. A constructor is clearer.

---

Version française : les patterns de création répondent à la question « qui crée les objets, et comment ? ». Singleton (une seule instance, comme la banque centrale), Factory (un seul endroit choisit la classe concrète, comme l'agent Mobile Money qui choisit l'opérateur), Builder (construire un objet étape par étape, comme une commande au restaurant). Chaque fichier se lance avec `java NomDuFichier.java`.
