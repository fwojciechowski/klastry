FROM python:2-alpine

WORKDIR /usr/src/app

RUN pip install --no-cache-dir pika

COPY src .

CMD [ "python", "./app.py" ]