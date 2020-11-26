package Not_Sys;

public class MYSQLInventory implements DBInventory{
    @Override
    public Blueprint get(int id) {
        return null;
    }

    @Override
    public boolean update(int id) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public boolean store(Blueprint obj) {
        return true;
    }
}
