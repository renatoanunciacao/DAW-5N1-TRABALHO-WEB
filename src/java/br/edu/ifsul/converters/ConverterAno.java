/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Renato
 */
@FacesConverter(value = "converterAno")
public class ConverterAno implements Serializable,Converter{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    @Override
    public Object getAsObject(FacesContext fc, UIComponent ui, String string) {
        try {
            sdf.setLenient(true);
            Calendar retorno = Calendar.getInstance();
            retorno.setTime(sdf.parse(string));
            return retorno;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent ui, Object o) {
        if (o == null) {
            return null;
        }
        Calendar obj = (Calendar) o;
        return sdf.format(obj.getTime());
    }
    
}
