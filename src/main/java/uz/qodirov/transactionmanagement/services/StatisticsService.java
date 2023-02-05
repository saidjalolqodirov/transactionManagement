package uz.qodirov.transactionmanagement.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.carrier.CarrierScoreSumDTO;
import uz.qodirov.transactionmanagement.dto.carrier.CarriersForStatistics;
import uz.qodirov.transactionmanagement.dto.product.ProductStatisticsDTO;
import uz.qodirov.transactionmanagement.dto.product.ProductStatisticsResponseDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionStatisticsDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionStatisticsResponseDTO;
import uz.qodirov.transactionmanagement.mapper.CarrierMapper;
import uz.qodirov.transactionmanagement.mapper.RegionMapper;
import uz.qodirov.transactionmanagement.repository.CarrierRepository;
import uz.qodirov.transactionmanagement.repository.RegionRepository;
import uz.qodirov.transactionmanagement.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:43 PM
 */
@Service
@RequiredArgsConstructor
public class StatisticsService implements BaseService {

    private final CarrierRepository carrierRepository;

    private final RegionRepository regionRepository;

    private final RegionMapper regionMapper;

    private final CarrierMapper carrierMapper;

    private final TransactionRepository transactionRepository;

    public ResponseEntity<?> deliveryRegionsPerNT() {
        List<RegionStatisticsDTO> regionStatisticsDTOList = transactionRepository.deliveryRegionsPerNT();
        List<RegionStatisticsResponseDTO> responseDTOS = new ArrayList<>();
        for (RegionStatisticsDTO statisticsDTO : regionStatisticsDTOList) {
            responseDTOS.add(new RegionStatisticsResponseDTO(statisticsDTO.getTransactionCount(), regionMapper.toDto(regionRepository.findById(statisticsDTO.getRegionId()).get())));
        }
        List<RegionStatisticsResponseDTO> dtoList = responseDTOS.stream().sorted(Comparator.comparing(RegionStatisticsResponseDTO::getTransactionNumber)).toList();
        return ResponseEntity.ok(dtoList);
    }

    public ResponseEntity<?> scorePerCarrier(Integer minimumScore) {
        List<CarrierScoreSumDTO> carrierScoreSumDTOS = transactionRepository.getSumScore();
        List<CarriersForStatistics> carriersForStatistics = new ArrayList<>();
        for (CarrierScoreSumDTO carrierScoreSumDTO : carrierScoreSumDTOS) {
            if (carrierScoreSumDTO.getSumScore() >= minimumScore) {
                carriersForStatistics.add(new CarriersForStatistics(carrierMapper.toDto(carrierRepository.findById(carrierScoreSumDTO.getCarrierId()).get()), carrierScoreSumDTO.getSumScore()));
            }
        }
        List<CarriersForStatistics> statisticsList = carriersForStatistics.stream().sorted(Comparator.comparing(o -> o.getCarrierDTO().getCarrierName())).toList();
        return ResponseEntity.ok(statisticsList);
    }

    public ResponseEntity<?> nTPerProduct() {
        List<ProductStatisticsDTO> productStatisticsDTOS = transactionRepository.nTPerProduct();
        List<ProductStatisticsResponseDTO> responseDTOS = new ArrayList<>();
        for (ProductStatisticsDTO statisticsDTO : productStatisticsDTOS) {
            responseDTOS.add(new ProductStatisticsResponseDTO(statisticsDTO.getProductId(), statisticsDTO.getTransactionCount()));
        }
        List<ProductStatisticsResponseDTO> dtoList = responseDTOS.stream().sorted(Comparator.comparing(ProductStatisticsResponseDTO::getProductId)).toList();
        return ResponseEntity.ok(dtoList);
    }
}
