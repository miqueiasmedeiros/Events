package com.unipds.unipds.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_conference")
    private Integer id;
    @Column(name = "name", length = 100, nullable = false)
    private String nome;
    @Column(name = "address", length = 255, nullable = false)
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
