package lorenzofoschetti.u5d9.controllers;

import lorenzofoschetti.u5d9.entities.Author;
import lorenzofoschetti.u5d9.payloads.NewAuthorPayload;
import lorenzofoschetti.u5d9.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    @Autowired
    private AuthorServices authorService;

    @GetMapping
    private Page<Author> getAllAuthors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return this.authorService.getAuthorsList(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    private Author saveAuthor(@RequestBody @Validated NewAuthorPayload body, BindingResult validationResult) {

        if (validationResult.hasErrors()) {
            System.out.println(validationResult.getAllErrors());
            //throw new BadRequestException(validationResult.getAllErrors());
        }
        return authorService.save(body);
    }
}
