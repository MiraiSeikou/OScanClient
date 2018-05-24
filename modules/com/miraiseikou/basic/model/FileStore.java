/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.model;

import com.miraiseikou.core.Component;
import com.miraiseikou.util.Collector;
import java.sql.Timestamp;

/**
 * Classe que representa o HD da máquina que está sendo monitorada
 * Herda da classe Component
 * @author TheHeftier
 */
public class FileStore extends Component {
    /**
     * Atributo que representa uma referência ao campo Id do banco de dados
     */
    private int Id;
    /**
     * Atributo que representa uma referência ao campo Total do banco de dados
     */
    private long Total;
    /**
     * Atributo que representa uma referência ao campo Available do banco de dados
     */
    private long Available;
    /**
     * Atributo que representa uma referência ao campo Momentum do banco de dados
     */
    private Timestamp Momentum;
    
    /**
     * Construtor de FileStore
     * Chama a super classe para enviar a rota definida
     * @param route representa a rota que será utilizada na API REST
     */
    public FileStore(String route) {
        super(route);
    }
    
    /**
     * @return o Id de FileStore
     */
    public int getId() {
        return Id;
    }

    /**
     * @param id define o Id de FileStore
     */
    public void setId(int id) {
        this.Id = id;
    }

    /**
     * @return retorna Total de FileStore
     */
    public long getTotal() {
        return Total;
    }

    /**
     * @param Total define o Total de FileStore
     */
    public void setTotal(long Total) {
        this.Total = Total;
    }

    /**
     * @return retorna o Available de FileStore
     */
    public long getAvailable() {
        return Available;
    }

    /**
     * @param Available define o Available de FileStore
     */
    public void setAvailable(long Available) {
        this.Available = Available;
    }

    /**
     * @return retorna o Momentum de FileStore
     */
    public Timestamp getMomentum() {
        return Momentum;
    }

    /**
     * @param Momentum define Momentum de FileStore
     */
    public void setMomentum(Timestamp Momentum) {
        this.Momentum = Momentum;
    }

    /**
     * Implementação do método collect
     * Método responsável pela coleta dos dados
     */
    @Override
    public void collect() {
        Available = Collector.getInstance().getHDAvailable();
        Total = Collector.getInstance().getHDTotal();
        Momentum = new Timestamp(System.currentTimeMillis());
    }
}
