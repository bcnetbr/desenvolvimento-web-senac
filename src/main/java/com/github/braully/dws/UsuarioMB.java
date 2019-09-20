/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aluno
 */
@Scope("view")
@Component
public class UsuarioMB {
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    @Autowired
    GrupoDAO grupoDAO;
    
    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void salvarUsuario(){
        
        for (String id : gruposSelecionados) {
            Grupo g = grupoDAO.findById(Long.parseLong(id)).get();
            usuario.adicionaGrupo(g);
        }
        
        usuarioDAO.save(usuario);
        FacesContext . getCurrentInstance(). addMessage( null , new FacesMessage ("Usuário salvo com sucesso"));
        usuario = new Usuario();
    }
    List<Grupo> listaGrupos;
    
    public List<Grupo> getListaGrupos() {
        if (listaGrupos == null) {
            listaGrupos = new ArrayList<>();
            for (Grupo g : grupoDAO.findAll()) {
                listaGrupos.add(g);
            }
        }
        return listaGrupos;
    }
    
    String[] gruposSelecionados;
    public String[] getGruposSelecionados(){
        return gruposSelecionados;
    }

    public void setGruposSelecionados(String[] gruposSelecionados) {
        this.gruposSelecionados = gruposSelecionados;
    }
    
}
