package Not_Sys;

import javax.management.Notification;
import java.util.ArrayList;

public class NotificationHandler implements operation,Blueprint{
    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId() {

    }

    @Override
    public String getHeader() {
        return null;
    }

    @Override
    public void setHeader(String header) {

    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public void setContent(String content) {

    }

    @Override
    public void create(ArrayList<ArrayList<String>> arr) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Blueprint read(int id) {
        return new NotificationHandler();
    }
}
