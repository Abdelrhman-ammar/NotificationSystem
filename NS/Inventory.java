package Not_Sys;

public interface Inventory {
    public void store(Blueprint obj);
    public Blueprint get(int id);
    public Blueprint update(int id);
    public Blueprint delete(int id);
}
