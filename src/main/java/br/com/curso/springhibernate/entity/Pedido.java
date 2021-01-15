package br.com.curso.springhibernate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm:ss", timezone = "GMT")
    private Instant data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private StatusPedido status;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> ttensPedido = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Instant data, Usuario usuario, StatusPedido status) {
        this.data = data;
        this.usuario = usuario;
        this.status = status;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Set<ItemPedido> getTtensPedido() {
        return ttensPedido;
    }
}
