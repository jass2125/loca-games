/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.locagames.core.observer;

import org.apache.commons.mail.EmailException;

/**
 *
 * @author Anderson Souza
 */
public interface Observable {

    public void notificarObservadores() throws EmailException;

    public void deleteObserver(Observer observer);

    public void addObserver(Observer observer);

}
