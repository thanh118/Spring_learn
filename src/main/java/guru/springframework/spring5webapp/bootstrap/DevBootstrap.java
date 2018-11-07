package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepositories;
import guru.springframework.spring5webapp.repositories.BookRespositories;
import guru.springframework.spring5webapp.repositories.PublisherRepositories;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepositories authorRepositories;
    private BookRespositories bookRespositories;
    private PublisherRepositories publisherRepositories;

    public DevBootstrap(AuthorRepositories authorRepositories, BookRespositories bookRespositories, PublisherRepositories publisherRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRespositories = bookRespositories;
        this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        publisher publisher = new publisher();
        publisher.setName("foo");
        publisher.setAddress("aaaa");
        publisherRepositories.save(publisher);
        //eric
        Author eric = new Author("Eric ", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getbooks().add(ddd);
        ddd.getauthors().add(eric);

        authorRepositories.save(eric);
        bookRespositories.save(ddd);
        //Rod
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getbooks().add(noEJB);
        noEJB.getauthors().add(rod);

        authorRepositories.save(rod);
        bookRespositories.save(noEJB);
    }
}
