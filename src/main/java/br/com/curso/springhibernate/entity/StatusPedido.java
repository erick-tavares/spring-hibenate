package br.com.curso.springhibernate.entity;

public enum StatusPedido {

    AGUARDANDO_PAGAMENTO("Aguardando pagamento",1),
    PAGO("Pago", 2),
    ENVIADO("Enviado",3),
    ENTREGUE("Entrrgue",4),
    CANCELADO("Cancelado",4);

    private String descricao;
    private int codigo;

    private StatusPedido (String descricao, int codigo){
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusPedido valueOf(int code){
        for(StatusPedido status : StatusPedido.values()){
            if(status.getCodigo() == code){
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido");
    }
}
