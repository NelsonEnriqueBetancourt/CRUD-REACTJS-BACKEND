package API.REST.FULL.Service;

import API.REST.FULL.Models.People;
import API.REST.FULL.Repository.PeopleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepositorio peopleRepositorio;


    public List<People>getList(){
        return peopleRepositorio.findAll();
    }

    public People getPeople(Integer id){
        return peopleRepositorio.findById(id).get();
    }

    public void SavePeople(People people){
        peopleRepositorio.save(people);
    }

    public void DeletePeople(Integer id){
        peopleRepositorio.deleteById(id);
    }
}
