import pika
import time
import sys


while True:
    try:
        connection = pika.BlockingConnection(pika.ConnectionParameters(host='amqp-broker'))
        break
    except:
        print("Oczekiwanie na amqp-broker.")
        time.sleep(1)

pomiary = []


channel = connection.channel()
channel.queue_declare(queue='sensor')

def callback(ch, method, properties, body):
    print(" [sensor] Otrzymano %r" % body)
    sys.stdout.flush()
    if len(pomiary) < 10:
        pomiary.append(int(body))
    else:
        channel.basic_publish(exchange='',
                              routing_key='web',
                              body=str(sum(pomiary)/len(pomiary)))
        print(" [web] Wyslano %r" % body)
        pomiary[:] = []

channel.basic_consume(callback,
                      queue='sensor',
                      no_ack=True)

print('Analityk gotowy na wiadomosci.')
channel.start_consuming()