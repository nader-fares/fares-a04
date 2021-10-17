package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Solution44Test {

    @Test
    void productDeserialization() {
        Solution44 app = new Solution44();

        ItemShop shopActual = app.productDeserialization();

        ItemShop shopExpected = new ItemShop();
        shopExpected.products = new ArrayList<>();

        Products p1 = new Products("Widget", 25.0, 5);
        Products p2 = new Products("Thing", 15.0, 5);
        Products p3 = new Products("Doodad", 5.0, 10);
        shopExpected.products.add(p1);
        shopExpected.products.add(p2);
        shopExpected.products.add(p3);

        boolean isSameActual = true;

        for (int i = 0; i < shopExpected.products.size(); i++) {
            if (!shopExpected.products.get(i).name.equals(shopActual.products.get(i).name) ||
                    shopExpected.products.get(i).price != shopActual.products.get(i).price ||
                    shopExpected.products.get(i).quantity != shopActual.products.get(i).quantity) {
                isSameActual = false;
                break;
            }
        }

        boolean isSameExpected = true;
        assertEquals(isSameExpected, isSameActual);  //weak warning is for not simplifying to assertTrue (which is not what's being tested)
    }

    @Test
    void checkForItem() {
        Solution44 app = new Solution44();

        String productName = "Widget";
        ItemShop shop = new ItemShop();
        shop.products = new ArrayList<>();

        Products p1 = new Products("Widget", 25.0, 5);
        Products p2 = new Products("Thing", 15.0, 5);
        Products p3 = new Products("Doodad", 5.0, 10);
        shop.products.add(p1);
        shop.products.add(p2);
        shop.products.add(p3);

        boolean isFoundActual = app.checkForItem(productName, shop);
        boolean isFoundExpected = true;

        assertEquals(isFoundExpected, isFoundActual);   //weak warning is for not simplifying to assertTrue (which is not what's being tested)
    }
}