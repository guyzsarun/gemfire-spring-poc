# TanzuGemfire-SpringBoot-POC

## Installation

Clone the repo from Github

```
git clone  https://github.com/guyzsarun/gemfire-spring-poc.git
```

Update api secret in `application.properties` ( Refer to `example.application.properties` )<br>
Movie API from [RapidAPI](https://rapidapi.com/apidojo/api/imdb8/)

```
api.rapid.host=
api.rapid.key=
```

### API

SpringBoot backend available at http://localhost:8081/api/movie <br>
Swagger documentation available at http://localhost:8081/docs.html

## Project Structure

    ├── gemfire-backend               # SpringBoot Application
    ├── gemfire-cluster               # Gemfire Cluster on Kubernetes
    │
    └── README.md

## Usage

Create storage region

```sh
create region --name=movie --type=REPLICATE_HEAP_LRU --entry-idle-time-expiration=3600 --enable-statistics
```

## Notes
