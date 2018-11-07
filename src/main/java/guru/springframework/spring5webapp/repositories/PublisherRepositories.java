package guru.springframework.spring5webapp.repositories;
import guru.springframework.spring5webapp.model.publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepositories extends CrudRepository<publisher, Long> {
}
