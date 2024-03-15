package JAVA.JAVA2;

public class Main2 {
    public boolean checkItemInList(String item, String[] list){
        for(int i = 0; i < list.length; i++){
            if(list[i].equals(item)){
                return true;
            }
        }
        return false;
    }
}
