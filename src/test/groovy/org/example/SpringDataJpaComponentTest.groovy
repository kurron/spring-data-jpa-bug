package org.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * A component test to showcase the issue when switching between Spring Data JPA versions.
 */
@ContextConfiguration( classes = TestConfiguration )
class SpringDataJpaComponentTest extends Specification {

    @Autowired
    JpaParentRepository repository

    def 'show case the failure'() {

        given: 'valid repository'
        assert repository

        when:
        int b = 0

        then:
        false
    }
}
