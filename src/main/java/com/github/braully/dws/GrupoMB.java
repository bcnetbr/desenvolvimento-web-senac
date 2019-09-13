/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aluno
 */
@Scope("view")
@Component
public class GrupoMB {
    
    @Autowired
    GrupoDAO grupoDAO;
    
   Grupo grupo = new Grupo();

    public Grupo getGrupo() {
        return grupo;
    }
    
    public void salvarGrupo(){
        grupoDAO.save(grupo);
        grupo = new Grupo();
    }
    
}
