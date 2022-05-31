package ec.edu.ups.beans;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Edisson
 */

//Activates CDI build-in beans
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class HolaJSF implements Serializable{
    private static final long serialVersionUID = 1L;
    private String saludo = "Hola desde JSF 2.3";
    
    public String getSaludo(){
        return saludo;
    }

}
