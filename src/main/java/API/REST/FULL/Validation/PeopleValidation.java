package API.REST.FULL.Validation;

import API.REST.FULL.Models.People;
import API.REST.FULL.Util.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface PeopleValidation {

    void ValidationPeople(People people)throws ResourceNotFound;

}
