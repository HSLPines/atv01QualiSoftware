class Controladora {
    private DAO dao;
    private Usuario usuarioAtual;

    public Controladora() {
        this.dao = new DAO();
    }

    public boolean autenticarUsuario(String login, String senha) {
        // Simula busca no banco e autenticação
        usuarioAtual = new Usuario(1, "Admin", login, senha, "administrador");
        return true;
    }

    public void gerenciarUsuarios(String nome, String login, String senha, String perfil, String operacao) {
        if (!"administrador".equals(usuarioAtual.getPerfil())) {
            System.out.println("Acesso negado: apenas administradores");
            return;
        }
        if ("cadastrar".equals(operacao)) {
            if (Usuario.validarLoginUnico(login)) {
                Usuario usuario = new Usuario(0, nome, login, senha, perfil);
                dao.salvarUsuario(usuario);
            } else {
                System.out.println("Erro: Login já existe");
            }
        }
    }

    public void gerenciarVeiculos(String marca, String modelo, int anoFab, int anoMod, String cor, String placa, double custoDia, String operacao) {
        if ("excluir".equals(operacao) && !"administrador".equals(usuarioAtual.getPerfil())) {
            System.out.println("Acesso negado: apenas administradores podem excluir");
            return;
        }
        if ("cadastrar".equals(operacao)) {
            if (Veiculo.validarPlacaUnica(placa)) {
                Veiculo veiculo = new Veiculo(0, marca, modelo, anoFab, anoMod, cor, placa, custoDia);
                dao.salvarVeiculo(veiculo);
            } else {
                System.out.println("Erro: Placa já existe");
            }
        }
    }

    public void gerenciarClientes(String cpf, String nome, String telefone, String email, String logradouro, String numero, String bairro, String cep, String cidade, String uf, String operacao) {
        if ("excluir".equals(operacao) && !"administrador".equals(usuarioAtual.getPerfil())) {
            System.out.println("Acesso negado: apenas administradores podem excluir");
            return;
        }
        if ("cadastrar".equals(operacao)) {
            if (Cliente.validarCpfEmailUnicos(cpf, email)) {
                Cliente cliente = new Cliente(0, cpf, nome, telefone, email, logradouro, numero, bairro, cep, cidade, uf);
                dao.salvarCliente(cliente);
            } else {
                System.out.println("Erro: CPF ou email já existe");
            }
        }
    }

    public void gerenciarAlugueis(int idVeiculo, int idCliente, java.util.Date dataRet, java.util.Date dataPrev, java.util.Date dataEfetiva, String operacao) {
        if ("excluir".equals(operacao) && !"administrador".equals(usuarioAtual.getPerfil())) {
            System.out.println("Acesso negado: apenas administradores podem excluir");
            return;
        }
        if ("cadastrar".equals(operacao)) {
            Aluguel aluguel = new Aluguel(0, idVeiculo, idCliente, dataRet, dataPrev);
            dao.salvarAluguel(aluguel);
        } else if ("finalizar".equals(operacao)) {
            Aluguel aluguel = new Aluguel(0, idVeiculo, idCliente, dataRet, dataPrev); // Simula busca existente
            Veiculo veiculo = dao.buscarVeiculoPorId(idVeiculo);
            aluguel.setDataEfetivaRetorno(dataEfetiva);
            double custo = aluguel.calcularCustoTotal(veiculo.getCustoDia());
            System.out.println("Custo total: " + custo);
            // Atualizar no banco (simulado)
        }
    }

    public String gerarRelatorios(String tipo, Object parametro) {
        if ("veiculosPorData".equals(tipo)) {
            java.util.List<Veiculo> veiculos = dao.buscarRelatorioVeiculosPorData((java.util.Date) parametro);
            return "Veículos na data " + parametro + ": " + veiculos.size();
        } else if ("receitaMensal".equals(tipo)) {
            String[] partes = ((String) parametro).split("/");
            int mes = Integer.parseInt(partes[0]);
            int ano = Integer.parseInt(partes[1]);
            double receita = dao.buscarReceitaMensal(mes, ano);
            return "Receita de " + parametro + ": " + receita;
        }
        return "Relatório inválido";
    }
}