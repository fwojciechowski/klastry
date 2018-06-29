const amqp = require('amqplib/callback_api');
const express = require('express');
const path = require('path');
const app = express();

x = 0;
y = 0;

app.use(express.static(path.join(__dirname, 'www')));

app.get('/get_value', (req, res) => res.send(JSON.stringify({x: x, y: y})));

app.listen(3000, () => console.log('Webinterface wystartowal, dostepny pod http://localhost:3000.'));

amqpListener();

function amqpListener () {
  amqp.connect('amqp://amqp-broker', function(err, conn) {
    if (!conn) {
      console.log("Oczekiwanie na amqp-broker.");
      setTimeout(amqpListener, 1000);
      return;
    }

    conn.createChannel(function(err, ch) {
    let q = 'web';

    ch.assertQueue(q, {durable: false});

    console.log("webinterface czeka na wiadomosci.", q);
    ch.consume(q, function(msg) {
      console.log(" [web] Otrzymano %s", msg.content.toString());
      x = (new Date()).getTime();
      y = +msg.content.toString();
    }, {noAck: true});
    });
  });
}



