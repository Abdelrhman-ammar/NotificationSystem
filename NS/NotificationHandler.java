package Not_Sys;

import javax.management.Notification;
import java.util.ArrayList;

public class NotificationHandler implements operation,Blueprint{
    private int id;
    private static int idCounter=0;

    @Override
    public int generateId() {
        return idCounter++;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId() {
    this.id = generateId();
    }

    @Override
    public String getHeader() {
        return null;
    }

    @Override
    public void setHeader(String header) {
        header=header;
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public void setContent(String content) {

    }

    @Override
    public boolean create(ArrayList<ArrayList<String>> arr) {
        try {
            Blueprint Notify = new NotificationHandler();
            Inventory inventory = new MYSQLInventory();
            Notify.setId();
            Blueprint temp = inventory.get(Integer.parseInt(arr.get(0).get(0)));
            String Header = temp.getHeader();
            String Content = temp.getContent();
            for (int i = 0; i < arr.get(1).size(); i++) {
                Content = Content.replaceFirst("$", arr.get(1).get(i));
            }
            Notify.setContent(Content);
            Notify.setHeader(Header);
            if(!inventory.store(Notify))
            {
                throw new Exception("Error: Can't Store Notification DB Error");
            }
        }
        catch(Exception Error)
        {
            System.out.println(Error.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(int id, Blueprint obj) {

        try{
            Inventory inventory = new MYSQLInventory();
            Blueprint OldMsg = inventory.get(id);
            if(OldMsg == null){
                throw new Exception("Error:This Message you want Edit Doesn't Exist");
            }
            if(!inventory.delete(id)){
                throw new Exception("Error: Can't update Message DB Error.");
            }
            OldMsg.setContent(obj.getContent());
            OldMsg.setHeader(obj.getHeader());
            inventory.store(OldMsg);
            if(!inventory.store(OldMsg)){
                throw new Exception("Error: Can't update Message DB Error.");
            }
        }
        catch(Exception Error)
        {
            System.out.println(Error.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Inventory inventory = new MYSQLInventory();
            inventory.delete(id);
            if (!inventory.delete(id)) {
                throw new Exception("Error: Can't Delete Message DB Error.");
            }
        }
        catch(Exception Error)
        {
            System.out.println(Error.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Blueprint read(int id) {
        try {
            Inventory inventory = new MYSQLInventory();
            Blueprint Msg = inventory.get(id);
            if(Msg != null)
            {
                return Msg;
            }
            else
            {
                throw new Exception("Error: Can't Read Message DB Error.");
            }

        }
        catch(Exception Error)
        {
            System.out.println(Error.getMessage());
        }
        return new NotificationHandler();

    }
}
