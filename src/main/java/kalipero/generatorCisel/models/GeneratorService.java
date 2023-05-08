package kalipero.generatorCisel.models;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorService {

    public int generate(GeneratorDTO generator){
        Random rand = new Random();
        int randomCislo = rand.nextInt(generator.getNumber2() - generator.getNumber1() + 1) + generator.getNumber1();
        return randomCislo;
    }
}
