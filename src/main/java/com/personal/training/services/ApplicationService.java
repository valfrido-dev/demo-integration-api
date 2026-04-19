package com.personal.training.services;

import com.personal.training.consumer.dto.CepDTO;
import com.personal.training.consumer.dto.CidadeDTO;
import com.personal.training.consumer.service.CepConsumerService;
import com.personal.training.consumer.service.CidadesConsumerService;
import com.personal.training.endpoints.dto.ApplicationResponse;
import com.personal.training.exceptions.CepNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {

    private final CepConsumerService cepConsumerService;
    private final CidadesConsumerService cidadesConsumerService;


    public List<ApplicationResponse> listAll() {
        var ceps = cepConsumerService.listCeps();
        var cidades = cidadesConsumerService.listCidades();
        return this.processarRespostaCepCidadeInfo(ceps, cidades);
    }

    public ApplicationResponse getCepInfo(long cep) {
        var resultCep = this.findCep(cep);
        if (resultCep.isPresent()) {
            var cidades = cidadesConsumerService.listCidades();
            var cidade = this.getCidade(resultCep.get(), cidades);
            return this.getSerializeResponse(resultCep.get(),cidade);
        } else {
            throw new CepNotFoundException(cep);
        }
    }

    private List<ApplicationResponse> processarRespostaCepCidadeInfo(
            List<CepDTO> ceps, List<CidadeDTO> cidades) {
        return ceps.stream().map( cep -> {
           var cidade = this.getCidade(cep, cidades);
           return this.getSerializeResponse(cep, cidade);
        }).toList();
    }

    private Optional<CidadeDTO> getCidade(CepDTO cep, List<CidadeDTO> cidades) {
        return cidades.stream().filter(municipio ->
                        municipio.getNome().equalsIgnoreCase(cep.getMunicipio()) &&
                                municipio.getEstado().equalsIgnoreCase(cep.getEstado()))
                .findFirst();
    }

    private Optional<CepDTO> findCep(long cep) {
        var ceps = cepConsumerService.listCeps();
        return ceps.stream().filter(cepDTO -> cepDTO.getNumero() == cep).findFirst();
    }

    private ApplicationResponse getSerializeResponse(
            CepDTO cep,
            Optional<CidadeDTO> cidade) {
        return new ApplicationResponse(
                cep.getNumero(),
                cep.getEndereco(),
                cep.getMunicipio(),
                cep.getEstado(),
                cidade.map(
                        cidadeDTO -> Long.toString(cidadeDTO.getPopulacao()))
                        .orElse(("Informações sobre a população não localizada.")));
    }

}
