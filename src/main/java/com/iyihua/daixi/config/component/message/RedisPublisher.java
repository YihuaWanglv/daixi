package com.iyihua.daixi.config.component.message;

import org.springframework.data.redis.listener.ChannelTopic;

public interface RedisPublisher {

	public void publish(ChannelTopic topic, RedisMessage message);
}
