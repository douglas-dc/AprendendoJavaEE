package br.com.douglasdc.aprendendojavaee.data;

import br.com.douglasdc.aprendendojavaee.enumerado.chamado.Tipo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rai.martins
 */
@Entity
public class Usuario implements Serializable{
    private final long SerialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 64, nullable = false, unique = true)
    private String login;
    @Column(length = 64, nullable = false)
    private String senha;
    @Column(length = 64, nullable = false)
    private String nome;
    @Column(nullable = false)
    private boolean ativo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_registo", nullable = false, updatable = false)
    private Date date;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private Tipo tipo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", nome=" + nome + ", ativo=" + ativo + ", date=" + date + ", tipo=" + tipo + '}';
    }
    
    
    
}
