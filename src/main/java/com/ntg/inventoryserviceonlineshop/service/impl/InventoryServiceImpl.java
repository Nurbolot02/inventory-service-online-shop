package com.ntg.inventoryserviceonlineshop.service.impl;

import com.ntg.inventoryserviceonlineshop.dto.InventoryRequestDTO;
import com.ntg.inventoryserviceonlineshop.dto.InventoryResponseDTO;
import com.ntg.inventoryserviceonlineshop.model.Inventory;
import com.ntg.inventoryserviceonlineshop.repository.InventoryRepository;
import com.ntg.inventoryserviceonlineshop.service.abstracts.InventoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ModelMapper modelMapper;
    @Override
    public void save(InventoryRequestDTO inventoryRequestDTO) {
        Inventory inventory = modelMapper.map(inventoryRequestDTO, Inventory.class);
        inventoryRepository.save(inventory);

    }
    public List<InventoryResponseDTO> findBySkuCode(List<String> skuCode) {
        if (skuCode == null) {
            return inventoryRepository.findAll().stream()
                    .map(inventory -> modelMapper.map(inventory, InventoryResponseDTO.class))
                    .toList();
        }
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory -> modelMapper.map(inventory, InventoryResponseDTO.class))
                .toList();
    }

    @Override
    public List<InventoryResponseDTO> getAllInventories() {
        return inventoryRepository.findAll().stream()
                .map(inventory -> modelMapper.map(inventory, InventoryResponseDTO.class))
                .toList();
    }
}
