package br.edu.ifsul.converters;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Curso;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Renato
 */
@FacesConverter(value = "converterCurso")
public class ConverterCurso implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent ui, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        try {
            return EntityManagerUtil.getEntityManager().find(Curso.class, Integer.parseInt(string));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent ui, Object o) {
        if (o == null) {
            return null;
        }
        Curso obj = (Curso) o;
        return obj.getId().toString();
    }

}
