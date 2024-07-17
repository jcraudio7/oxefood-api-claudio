package br.com.ifpe.oxefood.api.fabricante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import br.com.ifpe.oxefood.modelo.fabricante.Fabricante;
import br.com.ifpe.oxefood.modelo.fabricante.FabricanteService;

@RestController
@RequestMapping("/api/fabricante")
@CrossOrigin
public class FabricanteController {
    @Autowired
   private FabricanteService fabricanteService;

   @PostMapping
   public ResponseEntity<Fabricante> save(@RequestBody FabricanteRequest request) {

       Fabricante fabricante = fabricanteService.save(request.build());
       return new ResponseEntity<Fabricante>(fabricante, HttpStatus.CREATED);
   }

     @GetMapping
    public List<Fabricante> listarTodos() {
       return FabricanteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Fabricante obterPorID(@PathVariable Long id) {
        return fabricanteService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> update(@PathVariable("id") Long id, @RequestBody FabricanteRequest request) {

       fabricanteService.update(id, request.build());
       return ResponseEntity.ok().build();
 }
@DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       fabricanteService.delete(id);
       return ResponseEntity.ok().build();
   }


}

