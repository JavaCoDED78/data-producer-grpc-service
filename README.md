# Data generator gRPC microservice

This application produces data and sends it to [Data analyser gRPC service](https://github.com/JavaCoDED78/data-analyser-grpc-service) with gRPC.

### Usage

To start an application you need to pass variables to `.env` file.

You can use example `.env.example` file with some predefined environments.

Application is running on port `8081`.

All insignificant features (checkstyle, build check, dto validation) are not presented.

Application has two endpoints:
* POST `/api/v1/data/send`
#### Example JSON
```json
{
  "sensorId": 1,
  "timestamp": "2023-09-12T12:10:05",
  "measurement": 15.5,
  "measurementType": "TEMPERATURE"
}
```

* POST `/api/v1/data/test/send`
#### Example JSON
```json
{
  "delayInSeconds": 3,
  "measurementTypes": [
    "POWER",
    "VOLTAGE",
    "TEMPERATURE"
  ]
}
```