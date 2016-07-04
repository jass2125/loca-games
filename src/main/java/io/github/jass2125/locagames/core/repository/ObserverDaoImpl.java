/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.locagames.core.repository;

import io.github.jass2125.locagames.core.negocio.Cliente;
import io.github.jass2125.locagames.core.fabricas.FabricaDeConexoes;
import io.github.jass2125.locagames.excecoes.PersistenciaException;
import io.github.jass2125.locagames.observer.Observer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Anderson Souza
 */
public class ObserverDaoImpl implements ObserverDao<Observer> {

    private FabricaDeConexoes fabricaDeConexoes;

    public ObserverDaoImpl() {
    }

    @Override
    public void adicionaObservador(String cpf, Long idGame) throws PersistenciaException {
        try (Connection connection = fabricaDeConexoes.getConexao()) {
            String sql = "insert into observers(idUser, idGame) values(?, ?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, cpf);
                preparedStatement.setLong(2, idGame);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new PersistenciaException();
        }
    }

    @Override
    public Set<Observer> getListaDeObservadores(Long idGame) throws PersistenciaException {
        Set<Observer> listObservers;
        try (Connection connection = fabricaDeConexoes.getConexao()) {
            String sql = "select distinct user.name, user.email, user.cpf from user inner join game inner join observers where user.cpf = observers.idUser and ? = observers.idGame;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, idGame);
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    listObservers = new HashSet<>();
                    Cliente user = null;
                    while (rs.next()) {
                        user = new Cliente();
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        String cpf = rs.getString("cpf");
                        user = new Cliente(name, cpf, email);
                        listObservers.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException();
        }
        return listObservers;
    }

    @Override
    public void deleteObservador(Long idGame) throws PersistenciaException {
        try (Connection connection = fabricaDeConexoes.getConexao()) {
            String sql = "delete from observers where idGame = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, idGame);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new PersistenciaException();
        }
    }

}