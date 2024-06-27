package lorenzofoschetti.u5d9.services;

import lorenzofoschetti.u5d9.entities.Author;
import lorenzofoschetti.u5d9.exceptions.BadRequestException;
import lorenzofoschetti.u5d9.payloads.NewAuthorPayload;
import lorenzofoschetti.u5d9.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuthorServices {

    @Autowired
    private AuthorRepository authorRepository;

    public Page<Author> getAuthorsList(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return authorRepository.findAll(pageable);
    }

    public Author save(NewAuthorPayload body) {

        this.authorRepository.findByEmail(body.email()).ifPresent(
              
                user -> {
                    throw new BadRequestException("L'email " + body.email() + " è già in uso!");
                }
        );


        Author newAuthor = new Author(body.name(), body.surname(), body.email(), body.dataDiNascita());

        newAuthor.setAvatar("https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());


        return authorRepository.save(newAuthor);
    }
}
