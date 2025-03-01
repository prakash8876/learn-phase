## Set spring.profiles.active=dev in environment

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
$ bin/kafka-console-consumer.sh --topic learn-topic --from-beginning --bootstrap-server localhost:9092
``` 

# Docker compose
## url docker hub: https://hub.docker.com/r/gvenzl/oracle-free
```yaml
    services:

      # Oracle service (label used to access the service container)
      oracle:

        # Docker Hub image (feel free to change the tag "latest" to any other available one)
        image: gvenzl/oracle-free:latest

        # Provide passwords and other environment variables to container
        env:
          ORACLE_RANDOM_PASSWORD: true
          APP_USER: my_user
          APP_USER_PASSWORD: password_i_should_change

        # Forward Oracle port
        ports:
          - 1521:1521

        # Provide healthcheck script options for startup
        options: >-
          --health-cmd healthcheck.sh
          --health-interval 10s
          --health-timeout 5s
          --health-retries 10
```

```markdown
After your service is created, you can connect to it via the following properties:

Hostname:
oracle (from within another container)
localhost or 127.0.0.1 (from the host directly)
Port: 1521
Service name: FREEPDB1
Database App User: my_user
Database App Password: password_i_should_change
```

# Oracle DB connection
## After booting up docker-compose.yml
Use same information to setup additionally option with service name
> Service name: FREEPDB1

* username: usr
* password: password
* host: localhost
* port: 1521
* SID: not using
* Service name: FREEPDB1