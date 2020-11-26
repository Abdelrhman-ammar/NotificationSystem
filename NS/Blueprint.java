package Not_Sys;

import java.util.ArrayList;

public interface Blueprint{
    public String header = null;
    public String content = null;
    public int id = 0;

    public int generateId();

    public int getId();

    public void setId();

    public String getHeader();

    public void setHeader(String header);

    public String getContent();

    public void setContent(String content);
}
