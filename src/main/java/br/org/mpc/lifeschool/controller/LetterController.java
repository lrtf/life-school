package br.org.mpc.lifeschool.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.org.mpc.lifeschool.controller.dto.LetterDto;
import br.org.mpc.lifeschool.controller.form.LetterForm;
import br.org.mpc.lifeschool.modelo.Letter;
import br.org.mpc.lifeschool.repository.LetterRepository;
import br.org.mpc.lifeschool.repository.SchoolRepository;

@RestController
@RequestMapping("/letters")
public class LetterController {
	
	@Autowired
	private LetterRepository letterRepository;
	@Autowired
	private SchoolRepository schoolRepository;

	
	@GetMapping
	public Page<LetterDto> lista(@RequestParam(required = false) String sender, @RequestParam int page,
									@RequestParam int qtd){
		
		Pageable paginacao = PageRequest.of(page, qtd);
		
		if(sender == null) {
			Page<Letter> letters = letterRepository.findAll(paginacao);
			return LetterDto.converter(letters);
		}else {
			Page<Letter> letters = letterRepository.findBySender(sender, paginacao);
			return LetterDto.converter(letters);
		}
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LetterDto> cadastrar(@RequestBody LetterForm form, UriComponentsBuilder uriComponentsBuilder){
		Letter letter = form.converter(schoolRepository);
		letterRepository.save(letter);
		
		URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(letter.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new LetterDto(letter));
	}

}
