package cliente;

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String endereço;
    private boolean habilitado;
    private boolean carroAlugado;

    public Cliente(int id, String nome, String cpf, String endereço) throws Exception{
        this.id = id;
        this.nome = nome;
        this.endereço = endereço;
        setCpf(cpf);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if(!cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) throw new Exception("CPF Formato Inválido");
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}
