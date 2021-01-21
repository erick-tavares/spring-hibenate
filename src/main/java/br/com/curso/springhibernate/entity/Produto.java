package br.com.curso.springhibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private String imgUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "produto_categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categoriaSet = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itensPedido = new HashSet<>();

    public Produto() {}

    public Produto(String nome, String descricao, double preco, String imgUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Categoria> getCategoriaSet() {
        return categoriaSet;
    }

    @JsonIgnore
    public Set<Pedido> getPedido() {
        Set<Pedido> pedidos = new HashSet<>();
        for(ItemPedido item : itensPedido){
            pedidos.add(item.getPedido());
        }
        return pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Double.compare(produto.preco, preco) == 0 && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao) && Objects.equals(imgUrl, produto.imgUrl) && Objects.equals(categoriaSet, produto.categoriaSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, preco, imgUrl, categoriaSet);
    }
}

