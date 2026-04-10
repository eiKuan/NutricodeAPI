/* PARA DAR IMPORT NOS DADOS DO EXERCICIOS DB
package com.tg.nutricode.infra.dataLoader;

//METODO UTILIZANDO URL DO GITHUB

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tg.nutricode.entity.Exercicio;
import com.tg.nutricode.service.ExercicioService;

@Configuration // Indica que essa classe contém configurações do Spring (beans)
public class DataLoader {
    @Bean
    CommandLineRunner loadData(ExercicioService service) {
        return args -> {

            if (service.count() > 0) {
                System.out.println("Banco já possui dados. Não será feito import.");
                return;
            }

            try {
                System.out.println("Baixando JSON do GitHub...");

                InputStream input = new URL(
                    "https://raw.githubusercontent.com/joao-gugel/exercicios-bd-ptbr/main/exercises/exercises-ptbr-full-translation.json"
                ).openStream();

                ObjectMapper mapper = new ObjectMapper();

                List<Exercicio> exercises = Arrays.asList(
                        mapper.readValue(input, Exercicio[].class)
                );

                service.saveAll(exercises);

                System.out.println("Dados inseridos com sucesso!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
  


  /* METODO USANDO EXERCISES.JSON EM RESOURCES NO MAIN

     @Bean // Diz ao Spring para gerenciar esse método como um bean
    CommandLineRunner loadData(ExercicioService service) {
        return args -> { // Executa automaticamente quando a aplicação inicia

            // Evita inserir dados duplicados no banco
            if (service.count() > 0) {
                System.out.println("Banco já possui dados. Não será feito import.");
                return;
            }

            try {
                // Lê o arquivo JSON dentro da pasta resources
                InputStream input = getClass()
                        .getResourceAsStream("/exercises.json");

                // Se não encontrar o arquivo, lança erro
                if (input == null) {
                    throw new RuntimeException("JSON não encontrado!");
                }

                // Converte JSON para objetos Java
                ObjectMapper mapper = new ObjectMapper();

                // Converte o JSON em um array de Exercicio e depois em lista
                List<Exercicio> exercises = Arrays.asList(
                        mapper.readValue(input, Exercicio[].class)
                );

                // Salva todos no banco
                service.saveAll(exercises);

                System.out.println("Dados inseridos com sucesso!");

            } catch (Exception e) {
                e.printStackTrace(); // Mostra erro no console
            }
        };
    }
}
*/