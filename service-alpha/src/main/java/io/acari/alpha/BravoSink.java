package io.acari.alpha;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BravoSink {

    String INPUT = "bravoInput";

    @Input(BravoSink.INPUT)
    SubscribableChannel input();

}
