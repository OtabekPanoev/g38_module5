````shell
cd src/main/resources/
java -jar seeder.jar
````

````shell
cd src/main/resources/
java -jar demo_for_httclient-0.0.1-SNAPSHOT.jar
````


```java
import java.util.Date;
import java.util.UUID;

class Post {
    UUID id;
    String title;
    String body;
    Date createdAt;
}
```

### APIs
username : user
password : password
* BASE_URL = http://localhost:8080
* (GET) - /current-time
* (GET) - /posts/
* (DELETE , requires auth) - /post/delete/{id}
* (UPDATE , requires auth) - /post/update/
* (POST) - /post/create/
* (GET) - /timeout/request/
* (GET) - /file/upload/?file=filename