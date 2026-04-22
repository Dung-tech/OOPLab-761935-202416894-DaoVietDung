package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    public static final int MAX_NUMBERS_ITEMS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Thêm media vào Store
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media is already in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
        }
    }

    // Xóa media khỏi Store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media is not in the store.");
        }
    }

    // Getter để kiểm tra số lượng (dùng cho test)
    public int getQtyInStore() {
        return itemsInStore.size();
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}