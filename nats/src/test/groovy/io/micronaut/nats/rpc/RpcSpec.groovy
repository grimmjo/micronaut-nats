package io.micronaut.nats.rpc

import io.micronaut.context.ApplicationContext
import io.micronaut.nats.AbstractNatsTest
import reactor.core.publisher.Mono

/**
 *
 * @author jgrimm
 */
class RpcSpec extends AbstractNatsTest {

    void "test rpc call"() {
        ApplicationContext context = startContext()
        Publisher producer = context.getBean(Publisher)

        expect:
        Mono.from(producer.rpcCall("hello")).block() == "HELLO"
        Mono.from(producer.rpcCall(null)).block() == null

        cleanup:
        context.close()
    }
}
