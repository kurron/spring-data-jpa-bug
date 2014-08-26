package org.example

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Version

/**
 * The Parent entity.
 */
@Entity
@Table
class Parent {

    /**
     * Primary key of the entity -- synthetic key and has no business value.
     */
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    @Column( name='id' )
    private Long id;

    /**
     * Version number used for optimistic concurrency management.
     */
    @Version
    @Column( name = 'version', nullable = false )
    private Integer version;

    /**
     * The associated child entity.
     */
    @OneToOne( orphanRemoval = true )
    @Cascade( [CascadeType.ALL] )
    private Child child;

}
