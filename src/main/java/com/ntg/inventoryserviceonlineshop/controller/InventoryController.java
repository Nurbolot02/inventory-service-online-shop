package com.ntg.inventoryserviceonlineshop.controller;

import com.ntg.inventoryserviceonlineshop.dto.InventoryRequestDTO;
import com.ntg.inventoryserviceonlineshop.dto.InventoryResponseDTO;
import com.ntg.inventoryserviceonlineshop.service.abstracts.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @SneakyThrows
    public List<InventoryResponseDTO> gatInventoryBySkuCode(@RequestParam(required = false) List<String> skuCode) {
        Thread.sleep(10000);
        return inventoryService.findBySkuCode(skuCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@Validated @RequestBody InventoryRequestDTO inventoryRequestDTO) {
        inventoryService.save(inventoryRequestDTO);
    }
}
