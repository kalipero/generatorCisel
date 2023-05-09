package kalipero.generatorCisel.controllers;

import kalipero.generatorCisel.models.GeneratorDTO;
import kalipero.generatorCisel.models.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller                  // vykresluje HTML na straně serveru
@RequestMapping("generator") // vrací odkaz na šablonu generator.html
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @GetMapping              // reagujeme na GET akci (pouze výpis)
    public String generatorNumbers(@ModelAttribute GeneratorDTO generatorDTO){
        return "generator";
    }
    @PostMapping             // reagujeme na požadavky typu POST, zavolá se, když uživatel odešle formulář, vracíme šablonu result
    public String generate(@ModelAttribute GeneratorDTO generatorDTO, Model model){
        int result = generatorService.generate(generatorDTO);
        model.addAttribute("result", result);
        return "result";          /* hondoty zadane uživatelem se uloži do parametru generatorDTO typu GeneratorDTO
                                     parametr model typu Model slouží k předán výsledku pohledu*/
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(){
        return "invalid-form";
    }
}
