package com.github.zarathustra.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.Objects;

@CompoundIndexes({
        @CompoundIndex(name = "primary_index", collection = "person", def = "{'name': 1, 'surname': 1}")
})
@Document(collection = "person")
public class Person {
    @Id
    private String id;

    private String name;

    private String surname;

    private long   age;


    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }


    /**
     * @return the age
     */
    public long getAge() {
        return this.age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(final long age) {
        this.age = age;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(final String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", this.id)
                .add("name", this.name)
                .add("surname", this.surname)
                .add("age", this.age)
                .toString();
    }

}
