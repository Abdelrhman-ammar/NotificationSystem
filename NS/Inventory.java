package Not_Sys;

public interface Inventory {
    public boolean store(Blueprint obj);
    public Blueprint get(int id);
    public boolean update(int id);
    public boolean delete(int id);
}
