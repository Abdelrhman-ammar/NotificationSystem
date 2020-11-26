package Not_Sys;

import java.util.ArrayList;

public class TemplateOperation implements operation {
    @Override
    public void create(ArrayList<ArrayList<String>> arr) {
        Blueprint temp = new Template();
        Inventory inventory = new MYSQLInventory();
        temp.setId();
        temp.setHeader(arr.get(0).get(0));
        temp.setContent(arr.get(0).get(1));
        inventory.store(temp);
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Blueprint read(int id) {
        try {
            Inventory inventory = new MYSQLInventory();
            Blueprint temp = inventory.get(id);
            if(temp == null){
                String error = "Error: This Temp Doesn't Exist";
                throw new Exception(error);
            }
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
        return new Template();
    }
}
