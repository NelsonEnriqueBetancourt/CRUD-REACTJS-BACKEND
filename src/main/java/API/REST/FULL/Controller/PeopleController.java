package API.REST.FULL.Controller;

import API.REST.FULL.Models.People;
import API.REST.FULL.Service.PeopleService;
import API.REST.FULL.Util.ResourceNotFound;
import API.REST.FULL.Validation.PeopleValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/rest/")
@CrossOrigin("*")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private PeopleValidate peopleValidate;


    @RequestMapping(value = "List",method = RequestMethod.GET)
    public ResponseEntity<List<People>>getList(){
        Map<String ,Object>response=new HashMap<>();
        List list = peopleService.getList();
        if (list.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(list);
        }
    }

    @RequestMapping(value = "People/{id}",method = RequestMethod.GET)
    public ResponseEntity<?>getPeopleId(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            this.peopleService.getPeople(id);
            response.put("Mensaje","La Persona Esta En Tu Lista de Contactos ".concat("Exito"));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","La Persona No Esta En Esta Lista ".concat("Intente Nuevamente"));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "Update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?>UpdatePeolple(@RequestBody People people,@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            People updatePeople = peopleService.getPeople(id);
            peopleService.SavePeople(people);
            response.put("Mensaje", "Se Actualizaron Los Cambios Del Contacto ".concat("Con Exito"));
            return ResponseEntity.ok(response);
        } catch (DataAccessException exception) {
            response.put("Mensaje", "No se Actualizaron Los Datos Del Contacto ".concat("Intente Nuevamente"));
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "Save",method = RequestMethod.POST)
    public ResponseEntity<?>SavePeople(@RequestBody People people)throws ResourceNotFound{
        Map<String,Object>response=new HashMap<>();
        this.peopleValidate.ValidationPeople(people);
        this.peopleService.SavePeople(people);
        response.put("Mensaje","La Persona Ha Sido Registrada ".concat("Con Exito"));
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "Delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeletePeople(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            peopleService.DeletePeople(id);
            response.put("Mensaje", "Se Elimino  Los Datos Del Contacto ".concat("Con Exito"));
            return ResponseEntity.ok(response);
        } catch (DataAccessException exception) {
            response.put("Mensaje", "No se Elimino Los Datos Del Contacto ".concat("Intente Nuevamente"));
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
