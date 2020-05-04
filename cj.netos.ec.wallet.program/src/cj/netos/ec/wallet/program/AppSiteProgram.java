package cj.netos.ec.wallet.program;

import cj.netos.ec.wallet.services.DefaultConsumer;
import cj.netos.rabbitmq.IConsumer;
import cj.netos.rabbitmq.IRabbitMQConsumer;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.gateway.socket.Destination;
import cj.studio.gateway.socket.app.GatewayAppSiteProgram;
import cj.studio.gateway.socket.app.ProgramAdapterType;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

@CjService(name = "$.cj.studio.gateway.app", isExoteric = true)
public class AppSiteProgram extends GatewayAppSiteProgram {

    @Override
    protected void onstart(Destination dest, String assembliesHome, ProgramAdapterType type) throws CircuitException {
        IRabbitMQConsumer rabbitMQ = (IRabbitMQConsumer) site.getService("rabbitMQConsumer");
        rabbitMQ.open(assembliesHome);
        rabbitMQ.acceptConsumer(new DefaultConsumer());
    }
}
