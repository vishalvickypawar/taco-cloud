package tacos;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@UserDefinedType("ingredient")
public class IngredientUDT {
	
	private String name;
	private Ingredient.Type type;

}
