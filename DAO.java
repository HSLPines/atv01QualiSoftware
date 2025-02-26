class DAO {
    public void salvarUsuario(Usuario usuario) {
        // Simula INSERT no banco
        System.out.println("Usuário salvo: " + usuario.getNome());
    }

    public void salvarVeiculo(Veiculo veiculo) {
        // Simula INSERT no banco
        System.out.println("Veículo salvo: " + veiculo.getPlaca());
    }

    public void salvarCliente(Cliente cliente) {
        // Simula INSERT no banco
        System.out.println("Cliente salvo: " + cliente.getCpf());
    }

    public void salvarAluguel(Aluguel aluguel) {
        // Simula INSERT no banco
        System.out.println("Aluguel salvo: " + aluguel.getIdAluguel());
    }

    public Veiculo buscarVeiculoPorId(int id) {
        // Simula SELECT no banco
        return new Veiculo(id, "Marca", "Modelo", 2020, 2021, "Preto", "ABC1234", 100.0);
    }

    public java.util.List<Veiculo> buscarRelatorioVeiculosPorData(java.util.Date data) {
        // Simula SELECT de veículos alugados/disponíveis
        return new java.util.ArrayList<>(); // Placeholder
    }

    public double buscarReceitaMensal(int mes, int ano) {
        // Simula soma de custo_total no banco
        return 5000.0; // Placeholder
    }
}