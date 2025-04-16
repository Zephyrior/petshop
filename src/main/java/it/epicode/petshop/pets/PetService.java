package it.epicode.petshop.pets;

import it.epicode.petshop.common.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public CommonResponse savePet(@Valid PetRequest request) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(request, pet);

        petRepository.save(pet);

        return new CommonResponse(pet.getId());
    }
}
