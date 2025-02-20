# Start the ZooKeeper service
```shell
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```


# Start the Kafka broker service
```shell
$ bin/kafka-server-start.sh config/server.properties
```


# Create topic
```shell
$ bin/kafka-topics.sh --create --topic learn-topic --bootstrap-server localhost:9092
```

# Read the events
```shell
$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server
``` 