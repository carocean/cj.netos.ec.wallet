package cj.netos.ec.wallet.cmd;

import cj.netos.rabbitmq.RabbitMQException;
import cj.netos.rabbitmq.RetryCommandException;
import cj.netos.rabbitmq.consumer.IConsumerCommand;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import org.apache.curator.framework.CuratorFramework;

@CjService(name = "/wallet.ports#gathering")
public class GatheringCommand implements IConsumerCommand {
    @CjServiceRef(refByName = "curator.framework")
    CuratorFramework framework;

    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException {
//        InterProcessReadWriteLock lock = new InterProcessReadWriteLock(framework, "/test");
//        lock.readLock().acquire();
        System.out.println("--------" + new String(body));
    }
}
