package io.acari.alpha;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CharlieSink {

    String INPUT = "charlieInput";

    @Input(CharlieSink.INPUT)
    SubscribableChannel input();

}
