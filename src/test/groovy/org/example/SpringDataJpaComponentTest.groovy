package org.example

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * A component test to showcase the issue when switching between Spring Data JPA versions.
 */
@ContextConfiguration( classes = TestConfiguration )
class SpringDataJpaComponentTest extends Specification {

    def 'show case the failure'() {

        given:
        int a = 0

        when:
        int b = 0

        then:
        false
    }
}
