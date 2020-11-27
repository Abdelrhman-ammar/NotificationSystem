package Not_Sys;

import java.util.ArrayList;

public class TemplateOperation implements operation {
    @Override
    public boolean create(ArrayList<ArrayList<String>> arr) {
        try {
            Blueprint temp = new Template();
            Inventory inventory = new MYSQLInventory();
            temp.setHeader(arr.get(0).get(0));
            temp.setContent(arr.get(0).get(1));
            temp.setLanguage(arr.get(0).get(2));
            if (!inventory.store(temp)) {
                throw new Exception("Error: Can't Store Template DB Error.");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(int id, Blueprint obj) {
        try {
            Inventory inventory = new MYSQLInventory();
            if (!inventory.update(id, obj)) {
                throw new Exception("Error: Can't update Template DB Error.");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Inventory inventory = new MYSQLInventory();
            if (!inventory.delete(id, "template")) {
                System.out.println("returned false;");
                throw new Exception();
            }
        } catch (Exception error) {
            return false;
        }
        return true;
    }

    @Override
    public Blueprint read(int id) {
        Blueprint temp = null;
        try {
            Inventory inventory = new MYSQLInventory();
             temp = inventory.get(id, "template");
            if (temp == null) {
                String error = "Error: This Template Doesn't Exist";
                throw new Exception(error);
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return temp;
    }
}
