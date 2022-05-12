package reslover;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import entity.Application;
import org.springframework.stereotype.Component;
import repository.ApplicationRepository;


@Component
public class Query implements GraphQLQueryResolver {
    private ApplicationRepository applicationRepository;

    public Query(ApplicationRepository applicationRepository){
        this.applicationRepository=applicationRepository;
    }
    public Iterable<Application> findAllApplications(){
        return applicationRepository.findAll();
    }
    public long countApplication(){
        return  applicationRepository.count();
    }
}
