package it.epicode.petshop.pets;


import it.epicode.petshop.common.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse savePet(@RequestBody @Valid PetRequest request) {
        return petService.savePet(request);
    }
}
