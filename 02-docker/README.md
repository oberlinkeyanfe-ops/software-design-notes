# 02. Docker: virtual machine vs container

The idea from my LinkedIn post:

- A **virtual machine** is a whole house: its own foundations, plumbing and electricity, which means a full operating system. Heavy, slow to start.
- A **container** is an apartment in a building: it shares the foundations (the host kernel) but brings its own furniture (your app and its dependencies). Light, starts in seconds.

```
   Virtual machines                     Containers
+--------+ +--------+            +--------+ +--------+
|  App A | |  App B |            |  App A | |  App B |
|  Libs  | |  Libs  |            |  Libs  | |  Libs  |
| Guest  | | Guest  |            +--------+ +--------+
|   OS   | |   OS   |            |   Container engine  |
+--------+ +--------+            +---------------------+
|     Hypervisor      |          |   Host OS (kernel)  |
+---------------------+          +---------------------+
|      Hardware       |          |      Hardware       |
+---------------------+          +---------------------+
```

## Try it

This folder has a tiny Flask app and a Dockerfile.

```bash
docker build -t hello-container .
docker run --rm -p 5000:5000 hello-container
```

Open `http://localhost:5000`. The response shows the Python version and the kernel the app sees. Run the same image on another machine and you get the same Python and the same libraries, whatever is installed on that machine. That is the "it works on my machine" problem solved.

Look at the [Dockerfile](Dockerfile): each line adds a layer (base image, dependencies, code). The kernel is never in the image, it comes from the host.

---

Version française : une petite application Flask et un Dockerfile pour voir concrètement ce qu'un conteneur embarque (l'application et ses dépendances) et ce qu'il partage avec la machine hôte (le noyau). Lancer avec `docker build -t hello-container .` puis `docker run --rm -p 5000:5000 hello-container`, et ouvrir `http://localhost:5000`.
