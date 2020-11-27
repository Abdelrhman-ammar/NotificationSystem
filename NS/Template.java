package Not_Sys;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.PublicKey;

@Entity
@Table(name = "template")
public class Template extends Blueprint {


    public Template() {
        super();
    }

    public Template(String header, String content, String language) {
        super(header, content, language);
    }

    public String helpFormat() {
        return "Format Of Template Should Be:\nDear $ , " +
                "your booking of the $ is confirmed. thanks for using our store.\n" +
                "$ -> Refer To Parameter";
    }

    @Override
    public String toString() {
        return "Template " + id + "\n" + header + "\n" + content + "\n" + language+'\n';
    }
}
