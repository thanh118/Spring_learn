package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepositories;
import guru.springframework.spring5webapp.repositories.BookRespositories;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepositories authorRepositories;
    private BookRespositories bookRespositories;

    public DevBootstrap(AuthorRepositories authorRepositories, BookRespositories bookRespositories){
        this.authorRepositories= authorRepositories;
        this.bookRespositories = bookRespositories;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //eric
        Author eric = new Author("Eric ", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getbooks().add(ddd);
        ddd.getauthors().add(eric);

        authorRepositories.save(eric);
        bookRespositories.save(ddd);
        //Rod
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
        rod.getbooks().add(noEJB);
        noEJB.getauthors().add(rod);

        authorRepositories.save(rod);
        bookRespositories.save(noEJB);
    }
}
