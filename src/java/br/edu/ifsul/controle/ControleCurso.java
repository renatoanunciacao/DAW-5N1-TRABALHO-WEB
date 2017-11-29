/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CursoDAO;
import br.edu.ifsul.dao.DisciplinaDAO;
import br.edu.ifsul.dao.InstituicaoDAO;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import br.edu.ifsul.util.Util;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Renato
 */
@ManagedBean(name = "controleCurso")
@SessionScoped
public class ControleCurso {

    private CursoDAO<Curso> dao;
    private Curso objeto;
    private InstituicaoDAO<Instituicao> daoInstituicao;
    private Boolean passou;
    private Disciplina disciplina;
    private DisciplinaDAO<Disciplina> daoDisciplina;

    public ControleCurso() {
        dao = new CursoDAO<>();
        daoInstituicao = new InstituicaoDAO<>();
        daoDisciplina = new DisciplinaDAO<>();
    }
    
    public void adicionarDisciplina(){
        disciplina.setCurso(objeto);
        objeto.getDisciplinas().add(disciplina);
    }
    
    public void novaDisciplina() {
        disciplina = new Disciplina();
        passou = true;
    }

    public void editDisciplina(int index) {
        disciplina = objeto.getDisciplinas().get(index);
        objeto.removerDisciplina(index);
    }

    public void removerDisciplina(int index){
        objeto.getDisciplinas().remove(index);
    }
    
    public String listar() {
        return "/privado/curso/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Curso();
        return "formulario?faces-redirect=true";
    }

    public String salvar() {
        boolean persistiu;
        if (objeto.getId() == null) {
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu) {
            Util.mensagemInformacao(dao.getMensagem());
            return "listar?faces-redirect=true";
        } else {
            Util.mensagemErro(dao.getMensagem());
            return "formulario?faces-redirect=true";
        }
    }

    public String cancelar() {
        return "listar?faces-redirect=true";
    }

    public void editar(Integer id) {
        objeto = dao.localizar(id);
    }

    public void remover(Integer id) {
        objeto = dao.localizar(id);
        if (dao.remover(objeto)) {
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public CursoDAO<Curso> getDao() {
        return dao;
    }

    public void setDao(CursoDAO<Curso> dao) {
        this.dao = dao;
    }

    public Curso getObjeto() {
        return objeto;
    }

    public void setObjeto(Curso objeto) {
        this.objeto = objeto;
    }

    public InstituicaoDAO<Instituicao> getDaoInstituicao() {
        return daoInstituicao;
    }

    public void setDaoInstituicao(InstituicaoDAO<Instituicao> daoInstituicao) {
        this.daoInstituicao = daoInstituicao;
    }

    public Boolean getPassou() {
        return passou;
    }

    public void setPassou(Boolean passou) {
        this.passou = passou;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaDAO<Disciplina> getDaoDisciplina() {
        return daoDisciplina;
    }

    public void setDaoDisciplina(DisciplinaDAO<Disciplina> daoDisciplina) {
        this.daoDisciplina = daoDisciplina;
    }

}
