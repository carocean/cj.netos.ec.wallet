package cj.netos.ec.wallet.cmd;

import cj.netos.rabbitmq.RabbitMQException;
import cj.netos.rabbitmq.RetryCommandException;
import cj.netos.rabbitmq.consumer.IConsumerCommand;
import cj.studio.ecm.annotation.CjService;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;

@CjService(name = "/wallet.ports#payment")
public class PaymentCommand implements IConsumerCommand {
    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException {
        System.out.println("--------" + new String(body));
    }
}
