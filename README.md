# TanzuGemfire-SpringBoot-POC

## Installation

Clone the repo from Github

```
git clone  https://github.com/guyzsarun/gemfire-spring-poc.git
```

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
