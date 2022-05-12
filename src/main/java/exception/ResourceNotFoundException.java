package exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException implements GraphQLError {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }


    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public List<Object> getPath() {
        return null;
    }

    @Override
    public Map<String, Object> toSpecification() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return null;
    }
}




