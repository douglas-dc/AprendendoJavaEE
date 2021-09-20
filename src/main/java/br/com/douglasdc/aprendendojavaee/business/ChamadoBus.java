package br.com.douglasdc.aprendendojavaee.business;

import br.com.douglasdc.aprendendojavaee.data.Chamado;
import br.com.douglasdc.aprendendojavaee.enumerado.chamado.Status;
import br.com.douglasdc.aprendendojavaee.enumerado.chamado.Tipo;
import br.com.douglasdc.aprendendojavaee.infra.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChamadoBus {
    
    public Long inserir(Chamado chamado) {
        chamado.setDataRegistro(new Date());
        chamado.setStatus(Status.NOVO);
        chamado.setTipo(Tipo.SOLICITACAO);
        chamado.setUsuario(UsuarioBus.selecionarAluno());
        chamado.setUsuarioStatus(UsuarioBus.selecionarAluno());

        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(chamado);
        t.commit();
        return chamado.getId();
    }

    public void alterar(Chamado chamado) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.merge(chamado);
        t.commit();
    }

    public void excluir(long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Chamado c = selecionar(id);

        Transaction t = s.beginTransaction();
        s.delete(c);
        t.commit();
    }

    public Chamado selecionar(long id) {
        return (Chamado) HibernateUtil.getSessionFactory()
                .openSession()
                .get(Chamado.class, id);
    }

    public List<Chamado> listar() {
        return (List<Chamado>) HibernateUtil.getSessionFactory()
                .openSession()
                .createQuery("from Chamado")
                .list();
    }
}
