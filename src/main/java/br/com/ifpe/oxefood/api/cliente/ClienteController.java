package br.com.ifpe.oxefood.api.cliente;

import org.apache.coyote.BadRequestException;
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

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Serviço responsável por salvar um cliente no sistema.")

    @PostMapping
public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {

	Cliente clienteRequisicao = request.buildCliente();
	StringBuilder erros = new StringBuilder(); 
		
	//O campo nome não pode ser nulo e nem vazio
	if (clienteRequisicao.getNome() == null || clienteRequisicao.getNome().equals("")) {
	    erros.append("O campo Nome é de preenchimento obrigatório. ");
	}
	
	//O campo nome não pode ser maior que 100 caracteres
	...
	
	
	//O campo fone tem que ter mais que 8 caracteres e menos que 20
	if (clienteRequisicao.getFone() != null && (clienteRequisicao.getFone().length() < 8 || clienteRequisicao.getFone().length() > 20)) {
	    erros.append("O campo Fone tem que ter entre 8 e 20 caracteres. ");
	}
	
	if (erros.length() > 0) {
	    throw new BadRequestException(erros.toString());
	}
	
	Cliente clienteSalvo = clienteService.save(clienteRequisicao);
	return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.CREATED);
}

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @Operation(summary = "Serviço responsável por alterar um cliente no sistema.")

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest request) {

        clienteService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Serviço responsável por deletar um cliente no sistema.")

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}
