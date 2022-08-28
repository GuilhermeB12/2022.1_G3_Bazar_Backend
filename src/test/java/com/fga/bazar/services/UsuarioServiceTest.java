package com.fga.bazar.services;

import com.fga.bazar.Factory.ProdutoFactory;
import com.fga.bazar.Factory.UsuarioFactory;

import com.fga.bazar.models.Usuario;
import com.fga.bazar.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService userService;
    @Mock
    private UsuarioRepository usuarioRep;

    private int idUser;
    private int id2;
    private String nome;
    private String email;
    private String senha;
    private Usuario user;


    @BeforeEach
    void setUp() throws Exception {
        this.idUser = 30;
        this.id2 = 1000000000;
        this.nome = "Gui Brito";
        this.user = UsuarioFactory.criarUsuario();



        Mockito.when(this.usuarioRep.save(ArgumentMatchers.any()))
                .thenReturn(user);

        Mockito.when(this.usuarioRep.findById(idUser))
                .thenReturn(Optional.of(user));

        Mockito.when(this.usuarioRep.findById(id2))
                .thenReturn(Optional.empty());


    }
   @Test
    public void verificarSeNEhNulo() {
        var usuario = UsuarioFactory.criarUsuario();
        var r = this.userService.atualizarDados(this.idUser, usuario);

        Assertions.assertNotNull(r);

    }

    @Test
    public void verificarSeSalvou() {
        var usuario = UsuarioFactory.criarUsuario();
        this.userService.atualizarDados(this.idUser, usuario);

        Mockito.verify(this.usuarioRep, Mockito.times(1))
                .save(this.user);

    }






}
