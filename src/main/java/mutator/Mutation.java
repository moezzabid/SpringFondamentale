package mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import entity.Application;
import exception.ResourceNotFoundException;
import repository.ApplicationRepository;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {
    private ApplicationRepository applicationRepository ;

    public Mutation(ApplicationRepository applicationRepository){
        this.applicationRepository=applicationRepository;
    }
    public Application newApplication(String name ,String owner,String description){
        Application app= new Application(name,owner,description);
        applicationRepository.save(app);
        return app ;
    }

    public void delete(Long id){
        applicationRepository.deleteById(id);
    }
    public  Application updateApplication(Long id,String newOwner){
        Optional<Application> app =Optional.of(applicationRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("id non trouve")

        ));
        Application application=app.get();
        application.setOwner(newOwner);
        applicationRepository.save(application);
        return application ;
    }


}
