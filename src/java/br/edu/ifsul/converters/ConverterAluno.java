/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Renato
 */
@FacesConverter(value = "converterAluno")
public class ConverterAluno implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent ui, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        try {
            return EntityManagerUtil.getEntityManager().find(Aluno.class, Integer.parseInt(string));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent ui, Object o) {
        if (o == null) {
            return null;
        }
        Aluno obj = (Aluno) o;
        return obj.getId().toString();
    }

}
