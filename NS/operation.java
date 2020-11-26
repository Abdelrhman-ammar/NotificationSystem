package Not_Sys;

import java.util.ArrayList;

public interface operation {
    public boolean create(ArrayList<ArrayList<String>> arr);
    public boolean update(int id, Blueprint obj);
    public boolean delete(int id);
    public Blueprint read(int id);
}
