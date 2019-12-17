package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class AutorBean {

    private Autor autor = new Autor();

    public Autor getAutor(){
        return autor;
    }

    public List<Autor> getAutores() {
        return new DAO<Autor>(Autor.class).listaTodos();
    }

    public String gravar() {
        System.out.println("Gravando autor " + this.autor.getNome());

        if (this.autor.getId() == null) {
            new DAO<Autor>(Autor.class).adicionar(this.autor);
        } else {
            new DAO<Autor>(Autor.class).atualiza(this.autor);
        }

        this.autor = new Autor();

        return "livro?faces-redirect=true";
    }

    public void carregar(Autor autor) {
        System.out.println("Carregando autor");
        this.autor = autor;
    }

    public void remover(Autor autor) {
        System.out.println("Removendo autor");
        new DAO<Autor>(Autor.class).remove(autor);
    }
}
