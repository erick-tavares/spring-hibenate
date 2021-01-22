package br.com.curso.springhibernate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
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
    private Set<ItemPedido> itensPedido = new HashSet<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

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

    public Set<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public double getTotal(){
        double soma = 0.0;
        for (ItemPedido item : itensPedido){
            soma += item.getSubTotal();
        }
        return soma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(data, pedido.data) && Objects.equals(usuario, pedido.usuario) && status == pedido.status && Objects.equals(itensPedido, pedido.itensPedido) && Objects.equals(pagamento, pedido.pagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, usuario, status, itensPedido, pagamento);
    }
}
