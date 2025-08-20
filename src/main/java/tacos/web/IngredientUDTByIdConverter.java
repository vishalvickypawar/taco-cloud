package tacos.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.IngredientUDT;
import tacos.data.IngredientRepository;

@Component
public class IngredientUDTByIdConverter implements Converter<String, IngredientUDT> {
	
	private IngredientRepository ingredientRepository;
	
	public IngredientUDTByIdConverter(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	@Override
	public IngredientUDT convert(String id) {
		Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
		if(ingredient!=null)  {
			new IngredientUDT(ingredient.getName(), ingredient.getType());
		}
		return null;
	}
	
}
