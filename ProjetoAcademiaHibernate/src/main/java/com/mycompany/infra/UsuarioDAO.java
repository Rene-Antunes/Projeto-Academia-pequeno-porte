/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infra;

import com.mycompany.models.Usuario;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;



/**
 *
 * @author renea
 */
public class UsuarioDAO extends DAO<Usuario>{

    public UsuarioDAO() {
        super(Usuario.class);
  
    }

    
   public List<Usuario> selectAll(){
        
        String jpql = "Select u from Usuario as u";
        Query query = getEm().createQuery(jpql);
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    
    } 
    private List<Usuario> retornarListaComBaseNaConsulta(Query query){
        List<Usuario> usuarios;
        try {
            usuarios =  query.getResultList();
        } catch (NoResultException e) {
            usuarios = new ArrayList<>();
       
        }
      return usuarios;
    
    }
   
    public boolean obterUsuarioLogin(Usuario usuario){
    
        String jpql = " select u from Usuario as u "
                + "where u.login = :pUsuario and u.senha = :pSenha";
        
        Query query = getEm().createQuery(jpql);
        query.setParameter("pUsuario", usuario.getLogin());
        query.setParameter("pSenha", usuario.getSenha());
                    
        return !retornarListaComBaseNaConsulta(query).isEmpty();
    
    }

    public Usuario alterarUsuarioId(Usuario user) {
        try {
            getEm().getTransaction().begin();
            if (user.getId() == null) {
                getEm().persist(user);
                
            }else{
            getEm().merge(user);
            }
            getEm().getTransaction().commit();
                        
        } catch (Exception e) {
            getEm().getTransaction().rollback();
        } finally {
            getEm().close();
        }
        
        return user;
    }

    public Usuario removerUsario(Usuario userId) {
            
        Usuario usuario = null;
        
        try {
            usuario = getEm().find(Usuario.class, userId.getId());
            getEm().getTransaction().begin();
            getEm().remove(usuario);
            getEm().getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
           getEm().getTransaction().rollback();
        } finally {
            getEm().close();
        }
        
        return usuario;
    }

    public List<Usuario> getUsuarioPorNome(Usuario user) {
        List<Usuario> users = null;
        Query query = null;
        
        try {
            String jpql = " select u from Usuario as u "
                    + "where u.nome LIKE :pUsuario ";
            
            query = getEm().createQuery(jpql);
            query = query.setParameter("pUsuario", user + "%");
            users = query.getResultList();
            
              if (query.getResultList().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                }
            
        } catch (HeadlessException e) {
            System.err.println(e);
        } finally {
            getEm().close();
        }
        
        return users;
    }
    

    
    
   
    
    
}
