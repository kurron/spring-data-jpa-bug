package org.example

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Version

/**
 * The Child entity, should always be associated with a Parent.
 */
@Entity
@Table
class Child {

    /**
     * Primary key of the entity -- synthetic key and has no business value.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = 'id', nullable = false )
    private Long theId;

    /**
     * Version number used for optimistic concurrency management.
     */
    @Version
    @Column( name = 'version', nullable = false )
    private Integer theVersion;

    /**
     * The name of the child.
     */
    @Column( name = 'name' )
    private String theName;

}
