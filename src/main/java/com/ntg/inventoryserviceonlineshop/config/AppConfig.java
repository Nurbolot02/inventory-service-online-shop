package com.ntg.inventoryserviceonlineshop.config;

import com.ntg.inventoryserviceonlineshop.model.Inventory;
import com.ntg.inventoryserviceonlineshop.repository.InventoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner createData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = Inventory.builder()
                    .skuCode("IPhone 10")
                    .quantity(0)
                    .build();

            Inventory inventory1 = Inventory.builder()
                    .skuCode("IPhone 14")
                    .quantity(1000)
                    .build();

            Inventory inventory2 = Inventory.builder()
                    .skuCode("Rog phone 7")
                    .quantity(200)
                    .build();

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory2);
        };
    }
}
