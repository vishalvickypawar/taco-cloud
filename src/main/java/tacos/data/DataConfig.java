package tacos.data;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tacos.Ingredient;
import tacos.Ingredient.Type;

@Configuration
public class DataConfig {
    @Bean
    ApplicationRunner dataLoader(IngredientRepository repository) {
		return args -> {
			repository.save(new Ingredient("FLTO","Flour Tortilla",Type.WRAP));
			repository.save(new Ingredient("COTO","Corn Tortilla",Type.WRAP));
			repository.save(new Ingredient("GRBF","Ground Beef",Type.PROTEIN));
			repository.save(new Ingredient("CARN","Carnitas",Type.PROTEIN));
			repository.save(new Ingredient("TMTO","Diced Tomatoes",Type.VEGGIES));
			repository.save(new Ingredient("LETC","Lettuce",Type.VEGGIES));
			repository.save(new Ingredient("CHED","Cheddar",Type.CHEESE));
			repository.save(new Ingredient("JACK","Monterrey Jack",Type.CHEESE));
			repository.save(new Ingredient("SLSA","Salsa",Type.SAUCE));
			repository.save(new Ingredient("SRCR","Sour Cream",Type.SAUCE));
		};
	}
}
