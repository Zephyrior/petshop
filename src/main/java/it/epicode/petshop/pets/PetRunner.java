package it.epicode.petshop.pets;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PetRunner implements CommandLineRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private PetRepository petRepository;

    @Override
    public void run(String... args) throws Exception {

        if (petRepository.count() == 0) {
            for (int i = 0; i < 100; i++) {
                Pet pet = new Pet();
                pet.setName(faker.name().name());
                pet.setType(faker.animal().name());
                pet.setDescription(faker.lorem().word());
                pet.setYearOfBirth(faker.number().numberBetween(2000, 2050));
                petRepository.save(pet);
            }
        }
    }
}
