package API.REST.FULL.Validation;

import API.REST.FULL.Models.People;
import API.REST.FULL.Util.ResourceNotFound;
import org.springframework.stereotype.Component;

@Component
public class PeopleValidate implements PeopleValidation {

    private void MessagePeople(String message)throws ResourceNotFound{
        throw new ResourceNotFound(message);
    }

    @Override
    public void ValidationPeople(People people) throws ResourceNotFound {
        if (people.getName()==null){
            this.MessagePeople("El Nombre De La Persona Es Obligatorio,Intente Nuevamente");
        }
        if (people.getLastName()==null){
            this.MessagePeople("El Apellido De La Persona Es Obligatorio,Intente Nuevamente");
        }
        if (people.getEmail()==null){
            this.MessagePeople("El Email De La Persona Es Obligatorio,Intente Nuevamente");
        }
        if (people.getDireccion()==null){
            this.MessagePeople("ELa Direccion De La Persona Es Obligatorio,Intente Nuevamente");
        }
        if (people.getFechaNacimiento()==null){
            this.MessagePeople("La Fecha De Nacimiento De La Persona Es Obligatorio,Intente Nuevamente");

        }
        if (people.getOrigen()==null){
            this.MessagePeople("El Origen De La Persona Es Obligatorio,Intente Nuevamente");

        }
        if (people.getTelefono()==0){
            this.MessagePeople("El Telefono De La Persona Es Obligatorio,Intente Nuevamente");

        }
    }
}
