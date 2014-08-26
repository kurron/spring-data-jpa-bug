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

        and: 'a saved parent with a child'
        def originalChild = new Child( name: 'original' )
        def originalParent = new Parent( name: 'original', child: originalChild )
        def savedOriginalParent = repository.saveAndFlush( originalParent )

        when: 'we replace the original child with another one'
        def loadedParent = repository.findOne( savedOriginalParent.id )
        def newChild = new Child( name: 'replacement', id: originalChild.id, version: originalChild.version )
        loadedParent.child = newChild
        repository.saveAndFlush( loadedParent )

        then: 'the updated parent contains the new child'
        def updatedParent = repository.findOne( loadedParent.id )
        updatedParent.child.name == newChild.name

    }
}
