/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AlunoDAO;
import br.edu.ifsul.dao.CursoDAO;
import br.edu.ifsul.dao.DisciplinaDAO;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.util.Util;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Renato
 */
@ManagedBean(name = "controleDisciplina")
@SessionScoped
public class ControleDisciplina {

    private DisciplinaDAO<Disciplina> dao;
    private Disciplina objeto;
    private AlunoDAO<Aluno> daoAluno;
    private Aluno aluno;
    private CursoDAO<Curso> daoCurso;
    private Curso curso;
    private Boolean  passou = false;
    

    public ControleDisciplina() {
        dao = new DisciplinaDAO<>();
        daoAluno = new AlunoDAO<>();
        daoCurso = new CursoDAO<>();
    }

    public void adicionarAluno() {
        System.out.println("chegou aqui");
        objeto.getAlunosdadisciplina().add(aluno);
    }
    
    public void novoAluno(){
       // aluno = new Aluno();
        passou = true;
    }

    public void editAluno(int index){
        aluno = objeto.getAlunosdadisciplina().get(index);        
    }
    public void removerAluno(int index) {
        objeto.getAlunosdadisciplina().remove(index);
    }

    public String listar() {
        return "/privado/disciplina/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Disciplina();
    }

    public void salvar() {
        boolean persistiu;
        if (objeto.getId() == null) {
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu) {
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
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

    public DisciplinaDAO<Disciplina> getDao() {
        return dao;
    }

    public void setDao(DisciplinaDAO<Disciplina> dao) {
        this.dao = dao;
    }

    public Disciplina getObjeto() {
        return objeto;
    }

    public void setObjeto(Disciplina objeto) {
        this.objeto = objeto;
    }

    public AlunoDAO<Aluno> getDaoAluno() {
        return daoAluno;
    }

    public void setDaoAluno(AlunoDAO<Aluno> daoAluno) {
        this.daoAluno = daoAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public CursoDAO<Curso> getDaoCurso() {
        return daoCurso;
    }

    public void setDaoCurso(CursoDAO<Curso> daoCurso) {
        this.daoCurso = daoCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Boolean getPassou() {
        return passou;
    }

    public void setPassou(Boolean passou) {
        this.passou = passou;
    }

}
