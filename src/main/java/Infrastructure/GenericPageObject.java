package Infrastructure;

import lombok.*;

import java.util.Properties;


@Data
@NoArgsConstructor
@Builder
public class GenericPageObject {
	
	
	@Setter @Getter public static WebDriverWrapper driverWrapper;

	@Setter @Getter public static Properties prop = null;
	

}
