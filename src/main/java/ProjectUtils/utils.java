package ProjectUtils;
import lombok.Getter;
import lombok.Setter;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Utils {

    @Setter @Getter private String time_stamp1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

}
