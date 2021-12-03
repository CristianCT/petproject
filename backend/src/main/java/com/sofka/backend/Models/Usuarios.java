package com.sofka.backend.Models;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "usuarios")
public class UsuariosModel implements Serializable {

    @Id
    @NonNull
    private String id;

    private String nombre;
    private 
}
