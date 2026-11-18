"""A tiny web app used to show what a container packages: code + dependencies."""

import platform
import sys

from flask import Flask

app = Flask(__name__)


@app.get("/")
def home():
    return {
        "message": "Hello from inside a container",
        "python": sys.version.split()[0],
        "system": platform.system(),
        "kernel": platform.release(),
    }


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
