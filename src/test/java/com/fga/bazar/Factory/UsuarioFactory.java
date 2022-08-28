package com.fga.bazar.Factory;


import com.fga.bazar.models.Usuario;

public class UsuarioFactory {

    public static Usuario criarUsuario() {
        var usuario = new Usuario(1,"Guilherme Brito", "Guilhermebrito@gmail.com", "guilherme20");


        return usuario;
    }

}
