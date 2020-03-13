# spring-boot-demo

To run the program:
1. Clone the repo to your local machine;
2. Open IntelliJ and import pom.xml (import ptoject);
3. Download Dock for desktop;
4. Create a Docker container with postgres installed by running: 
    - `docker run --name your_container_name -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine`
    - `docker exec -it your_container_name bin/bash`
    - `CREATE DATABASE demodb`
    - `\c demodb`
 5. Run the Application inside src/main/java/com/example/eventsgbackend
