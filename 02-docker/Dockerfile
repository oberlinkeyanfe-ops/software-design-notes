# The "furniture" of the apartment: a Python runtime, the dependencies, the code.
# The "foundations" (the kernel) come from the host machine.
FROM python:3.12-slim

WORKDIR /app

COPY app/requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY app/ .

EXPOSE 5000
CMD ["python", "app.py"]
