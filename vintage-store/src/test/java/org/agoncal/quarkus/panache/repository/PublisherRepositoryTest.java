package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;

import static io.smallrye.common.constraint.Assert.assertNotNull;
import static io.smallrye.common.constraint.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class PublisherRepositoryTest {

    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisher(){
        long count = Publisher.count();
        int listAll = Publisher.listAll().size();
        assertEquals(count, listAll);
        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        assertEquals(count + 1, Publisher.count());

        publisher = Publisher.findById(publisher.id);
        publisher = Publisher.findByName(publisher.name).orElseThrow(EntityNotFoundException::new);
        assertEquals("name",publisher.name);
        assertTrue(Publisher.findContainName("name").size() >= 1);

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());
    }
}
