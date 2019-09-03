#List and Search in a Product Catalog
This application was developed using Spring Boot for backend, React for frontend and MySql as database.

To run application you need to have docker and docker-compose installed.

Run command from the root directory:
```bash
docker-compose up
```
 And visit [http://localhost:3000](http://localhost:3000) to see the application in action.

##Set Up
All configuration based on Environment variables, so if you want to adjust it to your own needs, please check **docker-compose.yml**.

###Initial data
Application has initial data preset.
It writes to the database during the first docker-compose run.
Data itself was taken from the [https://data.world/crowdflower/wearable-technology-database](https://data.world/crowdflower/wearable-technology-database)

##Run tests

###Frontend
```bash
cd frontend && npm i && npm test
```

###Backend (Java 12 should be used)
```bash
./gradlew test
```


