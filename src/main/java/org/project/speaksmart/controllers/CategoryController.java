package org.project.speaksmart.controllers;

import org.project.speaksmart.models.Categories;
import org.project.speaksmart.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController // indicamos que esta clase va a ser un controlador, concretamente un controlador que va a estar devolviendo soluciones APIRest, contenido JSON donde devuelve la info para ser consumida
@RequestMapping("/api/categories")   // el get point (URL) el cual va a estar atendiendo este controlador
public class CategoryController {

    @Autowired   //con esto conseguimos que el repositorio que se autocablee y nos ahorramos muchas acciones de configuración
    private CategoriesRepository categoriesRepository;   // indicamos que repositorio va a ser utilizado y gracias a la inversión de
    // dependencias agregamos todas las funciones de JPA, más arriba lo hemos autocableado para que sepamos que vamos a hacer uso
    // de él.


    // ahora empezamos a realizar las funciones de nuestro controlador que en este caso es un controlador CRUD

    // procedemos a obtener info con un GetMapping
    @GetMapping
    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();   // Solicitamos un listado de todas las categoríasUn JDBC es un conector que nos sirve para realizar operaciones de lectura o escritura y se utiliza cuando estamos trabajando con una orientación hacia SQL. Básicamente, interactuamos con nuestro programa mediante instrucciones SQL.
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoriesById(@PathVariable Long id) { // te voy a devolver una respuesta de tipo Categories, @PathVarible indica que nos va retornar una variable a través de la ruta
        Optional<Categories> categories = categoriesRepository.findById(id);   // el optional es porque puede devolver un valor nulo

        return categories.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        // retornamos la info en categories lo mapeamos si devuelve un valor está ok, creamos una función lamda vacía porque no
        // va a devolver nada y devolvemos el valor vacío
    }
    //ahora vamos a crear con un PostMapping
    @PostMapping
    public ResponseEntity<Categories> createCategories(@RequestBody Categories categories){  //@RequestBody es para obtener los datos que están viajando en el cuerpo de la petición
        Categories savedCategories = categoriesRepository.save(categories);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategories);  // en el status indicamos el estado de la petición
        // como el 500 que ha ocurrido un error en el servidor, hay diferentes códigos, luego utilizamos la clase HttpStatus
        // que la instanciamos de forma estática y nos devuelve el código que realmente indica que ha pasado y evitamos los
        // magic numbers

    }

    // ahora hacemos el borrado

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategories(@PathVariable Long id) {
       /* if(categoriesRepository.existsById(id)) {
            categoriesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        } */

        // usamos el patrón de guarda que genera un código más limpio y más fácil de entender
        if(!categoriesRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        categoriesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategories(@PathVariable Long id, @RequestBody Categories updateCategories) {
        if(!categoriesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updateCategories.setId(id);
        Categories savedCategories = categoriesRepository.save(updateCategories);

        return ResponseEntity.ok(savedCategories);
    }
}
