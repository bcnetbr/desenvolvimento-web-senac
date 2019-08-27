/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@Controller
public class ContatoServico 
{
    List<SolicitacaoContato>solicitacoes = new ArrayList<>();
    
    @RequestMapping("/processar-form-contato")
    public String recebeDadosParaContato(@RequestParam Map<String, String> todosParametros)
    {
        System.out.println("entrei no método: /processar-form-contato");
        System.out.println(todosParametros);
        SolicitacaoContato novaSolicitacao = new SolicitacaoContato();
        novaSolicitacao.nome = todosParametros.get("nome");
        novaSolicitacao.email = todosParametros.get("email");
        novaSolicitacao.duvida = todosParametros.get("duvida");
        
        
        System.out.println("Solicitações anteriores: " + solicitacoes);
        System.out.println("Nova solicitção recebida: " + novaSolicitacao);
        
        solicitacoes.add(novaSolicitacao);
        
        return "redirect:/Principal.html";
   
    }
    @RequestMapping("/todas-solicitacoes")
    @ResponseBody
    public String gereTelaTelaSolContatos()
    {
        String html = "<!DOCTYPE html>\n" 
                      +"<html>\n" 
                      +     "<head>\n" 
                      +         "<title>TODO supply a title</title>\n" 
                      +         "<meta charset=\"UTF-8\">\n"
                      +         "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                      +         "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">/n"
                      +     "</head>\n" 
                      +     "<body>\n"
                      +         "<table style='border: 1px solid; border-collapse: collapse;'>\n"
                      +             "<tr style='border: 1px solid; border-collapse: collapse;'>\n"
                      +                 "<td style='border: 1px solid; border-collapse: collapse;'><b><i>Nome</b></i></td>\n"    
                      +                 "<td style='border: 1px solid; border-collapse: collapse;'><b><i>E-mail<b><i></td>\n"
                      +                 "<td style='border: 1px solid; border-collapse: collapse;'><b><i>Dúvida<b><i></td>\n"  
                      
                      +             "</tr>";
                      for(SolicitacaoContato sol: solicitacoes)
                      {
                          String linhaTabela = "<tr style='border: 1px solid; border-collapse: collapse;'>";
                          
                          //Nome
                          linhaTabela +="<td style='border: 1px solid; border-collapse: collapse;'>";
                          linhaTabela +=sol.nome;
                          linhaTabela +="</td>";
                          
                          //E-mail
                          linhaTabela +="<td style='border: 1px solid; border-collapse: collapse;'>";
                          linhaTabela +=sol.email;
                          linhaTabela +="</td>";
                          
                          //Dúvida
                          linhaTabela +="<td style='border: 1px solid; border-collapse: collapse;'>";
                          linhaTabela +=sol.duvida;
                          linhaTabela +="</td>";
                          
                          linhaTabela += "</tr>";
                          html+= linhaTabela;
                          
                      }
                      html+= "</table>\n"
                      
                      +      "<a href=Principal.html>Voltar</a>"
                              
                      +     "</body>\n"   
                      +  "</html>\n";
        
        return html;
    }
}
