package actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class PeopleHealthIndicator implements HealthIndicator {

    private  final String message_key ="PeopleService";
    @Override
    public Health health() {
        if(!isRunningServicePeopleService()){
            return Health.down().withDetail(message_key,"Aviable").build();
        }
        return null;
    }

    private Boolean isRunningServicePeopleService(){
        Boolean isRunning=false;
        return isRunning;
    }
}
