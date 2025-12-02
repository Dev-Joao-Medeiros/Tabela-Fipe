package br.com.alura.TabelaFipe.principal;

import br.com.alura.TabelaFipe.model.Dados;
import br.com.alura.TabelaFipe.model.Modelos;
import br.com.alura.TabelaFipe.model.Veiculo;
import br.com.alura.TabelaFipe.service.ConsumoApi;
import br.com.alura.TabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibiMenu(){
        var menu = """
                === OPÇÕES ===
                Carro
                Moto
                Caminhão
                
                Digite uma das opções acima para consultar:  
                """;

        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("carr")){
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")){
            endereco = URL_BASE + "motos/marcas";
        }else{
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);
        System.out.println("Informe o codigo da marca que deseja consultar: ");
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obeterDados(json, Modelos.class);
        System.out.println("\nModelos da marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite uma parte do nome do carro que você deeja: ");
        var nomeVeiculo =leitura.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos Filtadros: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite o codigo do modelo para a busca dos valores: ");
        var codigoModelo = leitura.nextLine();
        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);

        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json =consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obeterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtadros com avaliações");
        veiculos.forEach(System.out::println);
    }
}
