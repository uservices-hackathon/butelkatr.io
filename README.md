# Bottling service

Having received the wort it's time to bottle the beer.
After some time we're updating the presenting service.

## Requirements

- Working Zookeeper

## How to run it

```
./gradlew bootRun
```

### I don't want Zikpin

Just run it in `dev` mode

```
./gradlew bootRun -Dspring.profiles.active=dev
```

## Authors

The code is ported from https://github.com/uservices-hackathon. 
The authors of the code are:
- Marcin Grzejszczak (marcingrzejszczak)
- Tomasz Szymanski (szimano)