package Not_Sys;

import java.util.ArrayList;

public interface operation {
    public void create(ArrayList<ArrayList<String>> arr);
    public void update(int id);
    public void delete(int id);
    public Blueprint read(int id);
}
