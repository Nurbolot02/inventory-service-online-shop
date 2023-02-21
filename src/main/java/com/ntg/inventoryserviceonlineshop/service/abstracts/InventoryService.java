package com.ntg.inventoryserviceonlineshop.service.abstracts;


import com.ntg.inventoryserviceonlineshop.dto.InventoryRequestDTO;
import com.ntg.inventoryserviceonlineshop.dto.InventoryResponseDTO;

import java.util.List;

public interface InventoryService {
    void save(InventoryRequestDTO inventoryRequestDTO);
    List<InventoryResponseDTO> findBySkuCode(List<String> skuCode);
    List<InventoryResponseDTO> getAllInventories();
}
