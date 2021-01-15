package br.com.curso.springhibernate.config;

import br.com.curso.springhibernate.entity.*;
import br.com.curso.springhibernate.repository.CategoriaRepository;
import br.com.curso.springhibernate.repository.PedidoRepository;
import br.com.curso.springhibernate.repository.ProdutoRepository;
import br.com.curso.springhibernate.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario("Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario("Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido p1 = new Pedido(Instant.parse("2019-06-20T19:53:07Z"), u1, StatusPedido.PAGO);
        Pedido p2 = new Pedido(Instant.parse("2019-07-21T03:42:10Z"), u2, StatusPedido.PAGO);
        Pedido p3 = new Pedido(Instant.parse("2019-07-22T15:21:22Z"), u1, StatusPedido.PAGO);

        Categoria cat1 = new Categoria("Electronics");
        Categoria cat2 = new Categoria("Books");
        Categoria cat3 = new Categoria("Computers");

        Produto pro1 = new Produto("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto pro2 = new Produto("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto pro3 = new Produto("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto pro4 = new Produto("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto pro5 = new Produto("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        usuarioRepository.saveAll(Arrays.asList(u1,u2));
        pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));
        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        produtoRepository.saveAll(Arrays.asList(pro1,pro2,pro3,pro4,pro5));

        pro1.getCategoriaSet().add(cat2);
        pro2.getCategoriaSet().add(cat1);
        pro2.getCategoriaSet().add(cat3);
        pro3.getCategoriaSet().add(cat3);
        pro4.getCategoriaSet().add(cat3);
        pro5.getCategoriaSet().add(cat2);

        produtoRepository.saveAll(Arrays.asList(pro1,pro2,pro3,pro4,pro5));

    }
}
