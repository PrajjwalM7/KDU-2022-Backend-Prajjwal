package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springboot.dto.CountryDTO;
import springboot.repository.CountryRepository;
import springboot.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public CountryDTO getByCode(@PathVariable String code) {
        return countryService.findByCountryCode(code);
    }
}
