package com.generation.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tb_postagens")
@Getter
@Setter
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 5, max = 100)
    private String titulo;
    @NotBlank
    @Size(min = 5, max = 1000)
    private String texto;
    @UpdateTimestamp
    private LocalDate data;

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;
}
