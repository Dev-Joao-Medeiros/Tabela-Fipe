package br.com.alura.TabelaFipe.service;

import java.util.List;

public interface IConverteDados {
    <T> T obeterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
