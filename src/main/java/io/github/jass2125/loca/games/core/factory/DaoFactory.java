/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.loca.games.core.factory;

import io.github.jass2125.loca.games.core.dao.GameDao;
import io.github.jass2125.loca.games.core.dao.LocationDao;
import io.github.jass2125.loca.games.core.dao.UserDao;

/**
 * @author Anderson Souza 
 * @since 15:49:40, 24-Feb-2016
 */
public class DaoFactory {
    
    public static IDao createDao(int op) {
        switch(op){
            case 1:
                return new GameDao();
            case 2:
                return new UserDao();
            case 3:
                return new LocationDao();
        }
        return null;
    }        

}