class Usuario {
    private int idUsuario;
    private String nome;
    private String login;
    private String senha;
    private String perfil; // "comum" ou "administrador"

    public Usuario(int id, String nome, String login, String senha, String perfil) {
        this.idUsuario = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    // Getters e setters
    public int getIdUsuario() { return idUsuario; }
    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public String getPerfil() { return perfil; }

    public static boolean validarLoginUnico(String login) {
        // Simula validação no banco: retorna true se login não existe
        return true; // Placeholder
    }
}

class Veiculo {
    private int idVeiculo;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private String cor;
    private String placa;
    private double custoDia;

    public Veiculo(int id, String marca, String modelo, int anoFab, int anoMod, String cor, String placa, double custoDia) {
        this.idVeiculo = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFab;
        this.anoModelo = anoMod;
        this.cor = cor;
        this.placa = placa;
        this.custoDia = custoDia;
    }

    public int getIdVeiculo() { return idVeiculo; }
    public double getCustoDia() { return custoDia; }
    public String getPlaca() { return placa; }

    public static boolean validarPlacaUnica(String placa) {
        // Simula validação no banco
        return true; // Placeholder
    }
}

class Cliente {
    private int idCliente;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    public Cliente(int id, String cpf, String nome, String telefone, String email, String logradouro, String numero, String bairro, String cep, String cidade, String uf) {
        this.idCliente = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public int getIdCliente() { return idCliente; }
    public String getCpf() { return cpf; }

    public static boolean validarCpfEmailUnicos(String cpf, String email) {
        // Simula validação no banco
        return true; // Placeholder
    }
}

class Aluguel {
    private int idAluguel;
    private int idVeiculo;
    private int idCliente;
    private java.util.Date dataRetirada;
    private java.util.Date dataPrevistaRetorno;
    private java.util.Date dataEfetivaRetorno;
    private double custoTotal;

    public Aluguel(int id, int idVeiculo, int idCliente, java.util.Date dataRet, java.util.Date dataPrev) {
        this.idAluguel = id;
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.dataRetirada = dataRet;
        this.dataPrevistaRetorno = dataPrev;
        this.dataEfetivaRetorno = null;
        this.custoTotal = 0.0;
    }

    public void setDataEfetivaRetorno(java.util.Date dataEfetiva) {
        this.dataEfetivaRetorno = dataEfetiva;
    }

    public double calcularCustoTotal(double custoDiaVeiculo) {
        if (dataEfetivaRetorno != null) {
            long diffInMillies = dataEfetivaRetorno.getTime() - dataRetirada.getTime();
            int dias = (int) (diffInMillies / (1000 * 60 * 60 * 24));
            custoTotal = dias * custoDiaVeiculo;
            return custoTotal;
        }
        return 0.0;
    }

    public int getIdAluguel() { return idAluguel; }
    public double getCustoTotal() { return custoTotal; }
}