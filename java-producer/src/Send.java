import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Send {

  private final static String QUEUE_NAME = "sensor";

  public static void main(String[] argv) throws Exception {
    Random generator = new Random();
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("amqp-broker");

    while (true) {
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            int pomiar = generator.nextInt(10);
            channel.basicPublish("", QUEUE_NAME, null, Integer.toString(pomiar).getBytes());
            System.out.println(" [" + QUEUE_NAME + "] Wyslano '" + pomiar + "'");

            channel.close();
            connection.close();
        } catch (java.net.ConnectException e) {
            System.out.println("Oczekiwanie na amqp-broker.");
        } finally {
            TimeUnit.MILLISECONDS.sleep(200);
        }
    }
  }
}