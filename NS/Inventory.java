package Not_Sys;

import java.util.List;

public interface Inventory {
    public boolean store(Blueprint obj);

    public Blueprint get(int id , String table);

    public boolean update(int id,Blueprint b);

    public boolean delete(int id, String table);
}
